package com.Model.Utils;

public class LinkParser {

    private final String ACCESS_TOKEN = "access_token=";
    private final String USER_ID = "&user_id=";
    private final String EXPIRES_IN = "&expires_in=";

    private String data;

    public LinkParser(String data) {
        this.data = data;
    }

    public String getAccessToken() {
        String token = this.data.substring(this.data.lastIndexOf(ACCESS_TOKEN)
                , this.data.indexOf(EXPIRES_IN));
        return token.replace(ACCESS_TOKEN, "");
    }

    public String getUserID() {
        String user = this.data.substring(this.data.lastIndexOf(USER_ID)
                , this.data.length());
        return user.replace(USER_ID, "");
    }

}
