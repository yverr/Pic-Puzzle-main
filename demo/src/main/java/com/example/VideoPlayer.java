package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.layout.StackPane;

import java.io.File;

public class VideoPlayer extends Application {
    
    public static void playVideo() {
        launch();  
    }

    @Override
    public void start(Stage primaryStage) {
        String videoPath = new File("demo\\src\\resources\\tracks\\Rick Astley - Never Gonna Give You Up 1.mp4").toURI().toString();
        
        Media media = new Media(videoPath);
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);

        mediaView.setPreserveRatio(true);
        mediaView.fitWidthProperty().bind(primaryStage.widthProperty());
        mediaView.fitHeightProperty().bind(primaryStage.heightProperty());

        StackPane root = new StackPane(mediaView);
        Scene scene = new Scene(root);

        scene.setOnKeyPressed(event -> {
        if (event.getCode() == KeyCode.ESCAPE) {
            primaryStage.close();
        }
        });

        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setMaximized(true);

        primaryStage.setTitle("Rickroll");
        primaryStage.setScene(scene);
        primaryStage.show();

        mediaPlayer.play();
    }

}
