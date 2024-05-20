package org.example.typespeedtest.Controllers;

import javafx.application.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
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
         e.printStackTrace();
      }
      textSampleLabel.setText(sampleText.get(0));
      textSampleLabelComeUp.setText(sampleText.get(1));
   }
   
   private final List<KeyCode> IgnoredKeyCodes = Arrays.asList(
           KeyCode.UP, KeyCode.DOWN, KeyCode.LEFT, KeyCode.RIGHT,
           KeyCode.ENTER, KeyCode.CONTROL, KeyCode.SHIFT,
           KeyCode.BACK_SPACE, KeyCode.TAB, KeyCode.WINDOWS,
           KeyCode.ESCAPE, KeyCode.ALT, KeyCode.CAPS,
           KeyCode.END, KeyCode.HOME, KeyCode.PAGE_UP, KeyCode.PAGE_DOWN,KeyCode.DELETE, KeyCode.INSERT,
           KeyCode.INSERT, KeyCode.SCROLL_LOCK,KeyCode.PAUSE, KeyCode.PRINTSCREEN, KeyCode.NUM_LOCK,
           KeyCode.F1, KeyCode.F2, KeyCode.F3, KeyCode.F4, KeyCode.F5, KeyCode.F6, KeyCode.F7, KeyCode.F8, KeyCode.F9, KeyCode.F10, KeyCode.F11, KeyCode.F12, KeyCode.F13, KeyCode.F14, KeyCode.F15, KeyCode.F16
           );
   
   /**
    * Starts countdown
    */
   private void startCountDown(){
      countDownHandle(startTime);
   }
   
   /**
    * Starts countdown if it is the first char typed
    * Checks if correct and switches labels if is end of word
    * @param keyEvent key event
    */
   public void textEnterHandle(KeyEvent keyEvent){
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
      Platform.runLater(() -> {
         timeLabel.setText(String.valueOf(currentTime));
      });
   }
   
   /**
    * counts down entered time
    * Note: will go into negative
    * @param startTime time ine seconds that will be counted down
    */
   private void countDownHandle(int startTime){
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
      Platform.runLater(() -> {
         Main.changeScene("test-finished-window.fxml");
      });
   }
   
   private void setUpCalculatedValues(){
      Game.getPlayer().setUserResults();
      
   }
   
   /**
    * Switches labels to next words from sampleText
    * If there is no more words, list will cycle again from start
    * When switching to new word, text from user will reset to ""
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
    * compares char by char sample text to user input and checks if same
    * @param enteredText text from textField
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
    * checks if user typed same amount of word as displayed text
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


