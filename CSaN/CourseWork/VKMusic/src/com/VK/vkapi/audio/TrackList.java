package com.VK.vkapi.audio;

import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class TrackList extends ArrayList <Track>{

    public TrackList(JSONArray jsonArray) {
        for (Object trackObject : jsonArray) {
            this.add(new Track((JSONObject)trackObject));
        }
    }
}