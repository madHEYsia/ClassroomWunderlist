package com.ClassroomWunderlist.main.windows.home;

import com.ClassroomWunderlist.database.logIn.userLoggedIn;
import com.ClassroomWunderlist.main.template.loginHome;
import com.ClassroomWunderlist.main.template.profile;
import com.ClassroomWunderlist.main.functions.getMotherboardSN;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class main extends Application {
    public static Stage window;

    public static void main(String args[])
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window=primaryStage;
        window.setTitle("Classroom Wunderlist");

        String userID = getMotherboardSN.getMotherboardSN();
        String[] status = userLoggedIn.userLoggedIn(userID);

        if (!status[0].equals("success"))
            window.setScene(loginHome.homeView());
        else
            window.setScene(profile.main(status[1], status[2], status[3]));

        window.getIcons().add(new Image(getClass().getResourceAsStream("../../resources/images/ClassroomWunderlist.png")));

        window.setMinWidth(850);
        window.setMinHeight(550);
        window.show();
        window.setOnCloseRequest(e->{System.exit(0);});

    }
}