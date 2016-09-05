package com.Model.VK.audio;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class TrackList extends ArrayList <Track>{

    public TrackList(JSONArray jsonArray) {
        for (Object trackObject : jsonArray) {
            this.add(new Track((JSONObject)trackObject));
        }
    }
}