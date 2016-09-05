package com.Model.VK.audio;

import org.json.simple.JSONObject;

public class Track {

    private String artist, title, url;
    private int duration, genre;

    public Track(JSONObject jsonObject) {

        artist = jsonObject.get("artist").toString().replace("/", "&").replace("\\", "&");
        title = jsonObject.get("title").toString().replace("/", "&").replace("\\", "&");
        url = jsonObject.get("url").toString();
        duration = Integer.parseInt(jsonObject.get("duration").toString());
        try {
            genre = Integer.parseInt(jsonObject.get("genre").toString());
        } catch (NullPointerException ex) {
        }
    }

    public String getArtist() {

        return artist;
    }

    public String getTitle() {

        return title;
    }

    public String getUrl() {

        return url;
    }

    public String getDuration(int duration) {

        int minutes = (duration / 60);
        int sec = duration - (minutes * 60);

        if (sec / 10 <= 1) {
            return Integer.toString(minutes) + ":0" + Integer.toString(sec);
        } else {
            return Integer.toString(minutes) + ":" + Integer.toString(sec);
        }
    }

    @Override
    public String toString() {
        return artist + " - " + title + " (" + getDuration(duration) + ")";
    }
}
