package org.example.typespeedtest;

import javafx.scene.control.*;

public class MyAlert{
   
   
    Alert.AlertType alertType;
    public MyAlert(Alert.AlertType alertType){
       this.alertType = alertType;
    }
   public void showAlert(String message){
      Alert alert = new Alert(alertType);
      alert.setContentText(message);
      alert.show();
   }
   
}
