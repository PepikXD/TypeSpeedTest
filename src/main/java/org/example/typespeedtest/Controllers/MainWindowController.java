package org.example.typespeedtest.Controllers;

import javafx.event.*;
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
   private Button playButton;
   
   @FXML
   private Button statsButton;
   
   public void onPlayButtonClicked(ActionEvent actionEvent) {
      Main.changeScene("test-window.fxml");
   }
   
   
}
