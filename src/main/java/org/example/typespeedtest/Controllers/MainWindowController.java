package org.example.typespeedtest.Controllers;

import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.shape.*;
import org.example.typespeedtest.*;

public class MainWindowController {
   
   @FXML
   private Label welcomeLabel;
   
   @FXML
   private Label usernameLabel;
   
   @FXML
   private Label userWordCountLabel;
   
   @FXML
   private Label userAverageWPMLabel;
   
   @FXML
   private Label userAverageAccuracyLabel;
   
   @FXML
   private Label wordCountLabel;
   
   @FXML
   private Label averageWPMLabel;
   
   @FXML
   private Label averageAccuracyLabel;
   
   @FXML
   private Circle totalWordCountCircle;
   
   @FXML
   private Circle averageWPMCircle;
   
   @FXML
   private Circle averageAccuracyCircle;
   
   @FXML
   private Button playButton1;
   
   @FXML
   private Button statsButton;
   
   
   public void onPlayButtonClicked() {
      Main.changeScene("test-window.fxml");
   }
   
   public void onStatsButtonClicked() {
      if(Game.getPlayer().isPlayerLoggedIn()){
         Main.changeScene("stats-window.fxml");
      }else {
         MyAlert a = new MyAlert(Alert.AlertType.WARNING);
         a.showAlert("Stats are not saved when you are playing as guest");
      }
      
      
      
   }
   
   
}
