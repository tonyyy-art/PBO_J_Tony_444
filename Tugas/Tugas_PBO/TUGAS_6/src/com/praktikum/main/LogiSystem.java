package com.praktikum.main;

import javafx.application.Application;
import javafx.stage.Stage;
import com.praktikum.gui.MainApp;
import com.praktikum.users.test;

public class LogiSystem extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        test.testData();
        primaryStage.setTitle("Lost & Found Kampus");
        primaryStage.setScene(MainApp.scene);
        primaryStage.show();
        
    }

}
