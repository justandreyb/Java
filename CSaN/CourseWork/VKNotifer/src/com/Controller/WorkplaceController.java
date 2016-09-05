package com.Controller;

import com.Model.VK.QueryToVK;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class WorkplaceController {


    public volatile ImageView accountNameImage;
    public volatile Label accountNameLabel;

    QueryToVK queryToVK;
    String accessToken;
    String userID;

    public WorkplaceController(String formData) {

        queryToVK = new QueryToVK(formData);
        this.accessToken = queryToVK.getAccessToken();
        this.userID = queryToVK.getUserID();

    }

    public void setImage() throws IOException, ParseException {

        ImageView image = new ImageView(queryToVK.getUserAvatar());
        accountNameImage = new ImageView();
        accountNameImage = image;

    }

    public void setName() throws IOException, ParseException {

        String name = queryToVK.getUserName();
        accountNameLabel = new Label(name);

        //Scene scene = new Scene();
    }


}
