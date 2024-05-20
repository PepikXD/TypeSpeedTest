package org.example.typespeedtest.Controllers;

import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import org.example.typespeedtest.*;

import java.net.*;
import java.util.*;

public class TestFinishedWindowController implements Initializable {
   
   @FXML
   private Label userWPMLabel;
   
   @FXML
   private Label userAccuracyLabel;
   
   @FXML
   private Label userNetSpeedLabel;
   
   @FXML
   private Label WPMLabel;
   
   @FXML
   private Label accuracyLabel;
   
   @FXML
   private Label netSpeedLabel;
   
   @FXML
   private Button playAgainButton;
   
   @FXML
   private Button endButton;
   
   @FXML
   private Circle WPMCircle;
   
   @FXML
   private Circle accuracyCircle;
   
   @FXML
   private Circle netSpeedCircle;
   
   @FXML
   private Text timesOperatorText;
   
   @FXML
   private Text equalesOperatorText;
   
   
   @Override
   public void initialize(URL url, ResourceBundle resourceBundle) {
      setUpLabels();
      System.out.println(Game.getPlayer().getUserResults());
   }
   
   private void setUpLabels() {
      userWPMLabel.setText(String.valueOf(Game.getPlayer().getUserResults().wpm()));
      userAccuracyLabel.setText(String.valueOf(Game.getPlayer().getUserResults().prctAccuracy()));
      userNetSpeedLabel.setText(String.valueOf(Game.getPlayer().getUserResults().netSpeed()));
   }
}
