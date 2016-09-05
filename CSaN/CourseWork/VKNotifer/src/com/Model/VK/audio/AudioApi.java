package com.Model.VK.audio;

import com.Model.VK.VkApi;
import com.Model.VK.QueryToVK;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class AudioApi extends VkApi {

    public QueryToVK queryToVK;

    public AudioApi(String formData) throws IOException {

        super();
        queryToVK = new QueryToVK(formData);
    }

    public String getAllMyAudioJson() throws IOException {

        return queryToVK.submitQuery("audio.get", "");
    }
    
    public TrackList getTrackList() throws IOException, ParseException {

        JSONParser jsonParser = new JSONParser();
        Object current = jsonParser.parse(getAllMyAudioJson());
        JSONObject currentObject = (JSONObject) current;
        JSONArray currentArray = (JSONArray) currentObject.get("response");
        JSONObject fields = (JSONObject) currentArray.get(0);

//        (JSONArray)((JSONObject) JSONValue.parse(getAllMyAudioJson())).get("response")
        return new TrackList (currentArray);
    }
}
