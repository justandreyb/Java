package com.Model.VK;

import java.io.IOException;

public class VkApi {

    private static final String API_VERSION = "5.21";
    private static final String APP_ID = "5476183";

    private static final String AUTH_URL = "https://oauth.vk.com/authorize"
            + "?client_id={APP_ID}"
            + "&scope={PERMISSIONS}"
            + "&redirect_uri={REDIRECT_URI}"
            + "&display={DISPLAY}"
            + "&v={API_VERSION}"
            + "&response_type=token";

    public VkApi() throws IOException {
    }

    public String getAuthRequest() throws IOException {
        return AUTH_URL
                .replace("{APP_ID}", APP_ID)
                .replace("{PERMISSIONS}", "audio")
                .replace("{REDIRECT_URI}", "https://oauth.vk.com/blank.html")
                .replace("{DISPLAY}", "page")
                .replace("{API_VERSION}", API_VERSION);
    }

}