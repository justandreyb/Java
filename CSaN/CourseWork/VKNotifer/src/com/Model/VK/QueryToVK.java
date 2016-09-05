package com.Model.VK;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collection;

import com.Model.Utils.LinkParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class QueryToVK {

    public static final String VK_API_PREFIX = "https://api.vk.com/method/";
    private static final String APP_ID = "5476183";
    private static final String API_VERSION = "5.52";

    protected String userID;
    protected String accessToken;

    public QueryToVK(String formData) {

        LinkParser linkParser = new LinkParser(formData);
        accessToken = linkParser.getAccessToken();
        userID = linkParser.getUserID();
    }

    @Override
    public String toString() {
        return "applicationId: " + APP_ID + "; userId: " + userID + "; accessToken: " + accessToken;
    }

    public String generateQuery(String methodName, String parameters) {
        return VK_API_PREFIX + methodName + "?" +
                "user_ids=" + userID +
                "&v=" + API_VERSION + "&fields=" +
                parameters +
                "&access_token=" + accessToken;
    }

    public String generateQueryWithoutAccessToken(String methodName, String parameters) {
        return VK_API_PREFIX + methodName + "?" +
                "user_ids=" + userID +
                "&v=" + API_VERSION + "&fields=" +
                parameters;
    }

    private static String getPage(String page) throws IOException {

        URL url = new URL(page);
        URLConnection urlConnection = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                urlConnection.getInputStream(), "UTF-8"));
        String inputLine;
        StringBuilder result = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            result.append(inputLine);
        }
        in.close();

        return result.toString();
    }

    public String submitQuery(String methodName, String parameters) throws IOException {
        return getPage(generateQuery(methodName, parameters));
    }

    public Collection getAllUsersInformation() throws IOException, ParseException {
        String request = getPage(generateQuery("users.get",
                "photo_id, " +
                "sex, " +
                "bdate, " +
                "city, " +
                "country, " +
                "photo_50, " +
                "photo_max, " +
                "photo_max_orig, " +
                "online, " +
                "has_mobile, " +
                "last_seen, " +
                "nickname, " +
                "can_see_all_posts, " +
                "can_see_audio, " +
                "screen_name, " +
                "maiden_name, "
        ));

        JSONParser jsonParser = new JSONParser();
        Object current = jsonParser.parse(request);
        JSONObject currentObject = (JSONObject) current;
        JSONArray currentArray = (JSONArray) currentObject.get("response");
        JSONObject fields = (JSONObject) currentArray.get(0);


        return fields.values();

    }

    public String getUserAvatar() throws IOException, ParseException {

        String request = getPage(generateQueryWithoutAccessToken("users.get", "photo_50"));

        JSONParser jsonParser = new JSONParser();
        Object current = jsonParser.parse(request);
        JSONObject currentObject = (JSONObject) current;
        JSONArray currentArray = (JSONArray) currentObject.get("response");
        JSONObject fields = (JSONObject) currentArray.get(0);

        return (String) fields.get("photo_50");

    }

    public String getUserName() throws IOException, ParseException {

        String request = getPage(generateQueryWithoutAccessToken("users.get", ""));
        System.out.println(request);

        JSONParser jsonParser = new JSONParser();
        Object current = jsonParser.parse(request);
        JSONObject currentObject = (JSONObject) current;
        JSONArray currentArray = (JSONArray) currentObject.get("response");
        JSONObject fields = (JSONObject) currentArray.get(0);

        return fields.get("first_name") + " " + fields.get("last_name");
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getUserID() {
        return userID;
    }
}
