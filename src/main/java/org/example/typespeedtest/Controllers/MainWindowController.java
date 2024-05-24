package org.example.typespeedtest.Controllers;

import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.shape.*;
import org.example.typespeedtest.*;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.SplittableRandom;

public class MainWindowController implements Initializable{
   
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


   @Override
   public void initialize(URL url, ResourceBundle resourceBundle) {

      if(!Game.getPlayer().isPlayerLoggedIn()){
         setVisibilityIFNotLoggedIn();
      }else {
         try {
            setUpLabels();
         } catch (IOException e) {
            MyAlert a = new MyAlert(Alert.AlertType.INFORMATION);
            a.showAlert(e.getCause().getMessage());
            e.printStackTrace();
         }
      }
   }

   private void setUpLabels() throws IOException {
      userAverageAccuracyLabel.setText(calculateAvgAccuracy());
      userAverageWPMLabel.setText(calculateAvgWPM());
      userWordCountLabel.setText(calculateWordCount());
   }

   private String calculateWordCount() throws IOException {
      String s = "";
      List<Integer> l = FileHandling.getOnlyCharsTyped();
      double help = 0;
      for(double i : l){
         help += i;
      }
      if (l.size() > 0) {
         double avg = help / l.size();
         s += avg;
         return s;
      }
      return s + 0;
   }

   private String calculateAvgAccuracy() throws IOException {
      String s = "";
      List<Integer> l = FileHandling.getOnlyAccuracy();
      int help = 0;
      for(int i : l){
         help += i;
      }
      if(l.size() > 0){
         int avg = help / l.size();
         s += avg;
         return s;
      }
      return s + 0;
   }

   private String calculateAvgWPM() throws IOException {
      String s = "";
      List<Double> l = FileHandling.getOnlyWPM();
      double help = 0;
      for(double i : l){
         help += i;
      }
      if(l.size() > 0){
         double avg = help / l.size();
         s += avg;
         return s;
      }
      return s + 0;
   }

   private void setVisibilityIFNotLoggedIn(){
      usernameLabel.setVisible(false);

      userAverageAccuracyLabel.setVisible(false);
      userAverageWPMLabel.setVisible(false);
      userWordCountLabel.setVisible(false);

      averageAccuracyCircle.setVisible(false);
      averageWPMCircle.setVisible(false);
      totalWordCountCircle.setVisible(false);

      averageAccuracyLabel.setVisible(false);
      averageWPMLabel.setVisible(false);
      wordCountLabel.setVisible(false);
   }
}
