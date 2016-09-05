package com.VK.vkapi.audio;

import java.io.IOException;
import com.VK.vkapi.VkApi;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class AudioApi extends VkApi {

    public AudioApi(int applicationId, String formData) {
        super(applicationId, formData);
    }
    
    public AudioApi (VkApi api) {
        super (api);
    }

    public String getAllMyAudioJson() throws IOException {
        return submitQuery("audio.get", "");
    }
    
    public TrackList getTrackList() throws IOException {
        return new TrackList ((JSONArray)((JSONObject)JSONValue.parse(getAllMyAudioJson())).get("response"));
    }
}
