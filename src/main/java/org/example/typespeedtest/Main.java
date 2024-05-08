package org.example.typespeedtest;

import javafx.application.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.stage.*;

import java.io.*;
import java.util.*;

public class Main extends Application {
   
   private static Stage stg;
   
   /**
    * changes scenes to new scene based on fxml entered
    * @param fxml fxml file name
    */
   public static void changeScene(String fxml){
      try {
         Parent root = FXMLLoader.load(Objects.requireNonNull(Main.class.getResource(fxml)));
         stg.setScene(new Scene(root));
         stg.centerOnScreen();
      } catch (IOException e) {
         e.printStackTrace();
      }
      
   }
   
   @Override
   public void start(Stage stage) throws Exception {
      stg = stage;
      Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login-popup.fxml")));
      Scene scene = new Scene(root);
      stage.setScene(scene);
      stage.setTitle("SpeedTest");
      stage.setResizable(false);
      stage.centerOnScreen();
      stage.show();
      stage.setOnCloseRequest(new EventHandler <WindowEvent>() {
         @Override
         public void handle(WindowEvent windowEvent) {
            System.exit(0);
         }
      });
   }
   public static void main(String[] args) {
      launch(args);
   }
}