package org.example.typespeedtest.Controllers;

import javafx.application.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.shape.*;
import org.example.typespeedtest.*;

import java.io.*;
import java.net.*;
import java.util.*;

public class TestWindowController implements Initializable{
   @FXML
   private TextField userInputTextField;
   @FXML
   private Circle timeCircle;
   @FXML
   private Label timeLabel;
   @FXML
   private Label textSampleLabel;
   @FXML
   private Label textSampleLabelComeUp;
   
   private List<String> sampleText;
   private int currentLine = 0;
   private static int charsTyped = 0;
   private static int correctCharsTyped = 0;
   private boolean isFirstTyped = true;
   private static final int startTime = 3;
   private int currentTime = startTime;
   
   
   @Override
   public void initialize(URL url, ResourceBundle resourceBundle) {
      try {
         sampleText = FileHandling.loadText();
      } catch (IOException e) {
         MyAlert a = new MyAlert(Alert.AlertType.ERROR);
         a.showAlert(e.getMessage());
      }
      textSampleLabel.setText(sampleText.get(0));
      textSampleLabelComeUp.setText(sampleText.get(1));
   }
   
   /**
    * Starts countdown
    */
   private void startCountDown(){
      countDownHandle();
   }
   
   /**
    * Starts countdown if it is the first char typed
    * Checks if correct and switches labels if is end of word
    */
   public void textEnterHandle(){
      if(isFirstTyped){
         startCountDown();
         isFirstTyped = false;
      }
      if(isEndOfWord()){
         checkCorrect(userInputTextField.getText());
         switchLabels();
      }
   }
   
   /**
    * Support method to update timer in UI thread
    */
   private void updateTimer(){
      currentTime--;
      Platform.runLater(() -> timeLabel.setText(String.valueOf(currentTime)));
   }
   
   /**
    * counts down entered time
    * Note: will go into negative
    */
   private void countDownHandle(){
      Timer timer = new Timer();
      timer.scheduleAtFixedRate(new TimerTask() {
         @Override
         public void run() {
            if(isTimerFinished()){
               timer.cancel();
               try {
                  endHandel();
               } catch (IOException e) {
                  e.printStackTrace();
               }
            }
            updateTimer();
         }
      },0,1000);
   }
   
   private void endHandel() throws IOException {
      setUpCalculatedValues();
      showEndScreen();
      if (Game.getPlayer().isPlayerLoggedIn()){
         saveData();
      }
   }
   
   private void saveData() throws IOException {
      FileHandling.writeData();
   }
   
   private boolean isTimerFinished(){
      return currentTime == 0;
   }
   
   private void showEndScreen() {
      Platform.runLater(() -> Main.changeScene("test-finished-window.fxml"));
   }
   
   private void setUpCalculatedValues(){
      Game.getPlayer().setUserResults();
      
   }
   
   /**
    * Switches labels to next words from sampleText
    * If there is no more words, list will cycle again from start
    * When switching to new word, 1 from user will reset to ""
    */
   private void switchLabels() {
      if(!textSampleLabel.getText().equals(sampleText.get(sampleText.size()-1))){
         currentLine++;
      }
      userInputTextField.setText("");
      textSampleLabel.setText(sampleText.get(currentLine));
      if(currentLine == sampleText.size() - 1){
         currentLine = 0;
         textSampleLabelComeUp.setText(sampleText.get(currentLine));
         return;
      }
      textSampleLabelComeUp.setText(sampleText.get(currentLine + 1));
   }
   
   /**
    * compares char by char sample 1 to user input and checks if same
    * @param enteredText 1 from textField
    */
   private void checkCorrect(String enteredText){
      char[] enteredChars = enteredText.toCharArray();
      char[] textChars = textSampleLabel.getText().toCharArray();
      for (int i = 0; i < enteredText.length(); i++) {
         if (enteredChars[i] == textChars[i]) {
            correctCharsTyped++;
         }
      }
      charsTyped += enteredChars.length;
   }
   
   /**
    * checks if user typed same amount of word as displayed 1
    * @return is it end of word
    */
   private boolean isEndOfWord(){
      return userInputTextField.getText().length() == textSampleLabel.getText().length();
   }
   
   public static int getCharsTyped() {
      return charsTyped;
   }
   
   public static int getCorrectCharsTyped() {
      return correctCharsTyped;
   }
   
   public static int getStartTime() {
      return startTime;
   }
}


