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
   
   private int currentChar = 0;
   private int currentLine = 0;
   
   private int charsTyped = 0;
   private int correctCharsTyped = 0;
   private boolean isFirstTyped = true;
   private int startTime = 60;
   
   
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
   
   private final List<KeyCode> keyCodes = Arrays.asList(
           KeyCode.UP, KeyCode.DOWN, KeyCode.LEFT, KeyCode.RIGHT,
           KeyCode.ENTER, KeyCode.CONTROL, KeyCode.SHIFT,
           KeyCode.BACK_SPACE, KeyCode.TAB, KeyCode.WINDOWS,
           KeyCode.ESCAPE, KeyCode.ALT, KeyCode.CAPS,
           KeyCode.END, KeyCode.HOME, KeyCode.PAGE_UP, KeyCode.PAGE_DOWN,
           KeyCode.INSERT, KeyCode.SCROLL_LOCK,KeyCode.PAUSE, KeyCode.PRINTSCREEN, KeyCode.NUM_LOCK,
           KeyCode.F1, KeyCode.F2, KeyCode.F3, KeyCode.F4, KeyCode.F5, KeyCode.F6, KeyCode.F7, KeyCode.F8, KeyCode.F9, KeyCode.F10, KeyCode.F11, KeyCode.F12, KeyCode.F13, KeyCode.F14, KeyCode.F15, KeyCode.F16
           );
   
   private void startCountDown(){
      countDownHandle(startTime);
   }
   
   public void textEnterHandle(KeyEvent keyEvent){
      if(isFirstTyped){
         startCountDown();
         isFirstTyped = false;
      }
      checkCorrect(userInputTextField.getText(), keyEvent);
      if(isEndOfWord()){
         currentLine++;
         currentChar = 0;
         switchLabels();
      }
   }
   /*
   private void countDownHandle(int howLongInSec){
      Timer timer = new Timer();
      for(int i = howLongInSec; i >= 0; i--){
         int finalI = i;
         timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
               Platform.runLater(() -> {
                  timeLabel.setText(String.valueOf(finalI));
               });
            }
         },0,1000);
      }
   }
    */
   
   private void updateTimer(){
      startTime--;
      Platform.runLater(() -> {
         timeLabel.setText(String.valueOf(startTime));
      });
      ;
      
   }
   
   private void countDownHandle(int startTime){
      Timer timer = new Timer();
      timer.scheduleAtFixedRate(new TimerTask() {
         @Override
         public void run() {
            if(startTime == 0){
               timer.cancel();
            }
            updateTimer();
         }
      },0,1000);
   }
   
   private void showEndScreen() {
   
   }
   
   /**
    * Switches labels to next words from sampleText
    * If there is no more words, on comeUp label will be displayed "END" (Shouldn't happen)
    * When switching to new word, text from user will reset to ""
    */
   private void switchLabels() {
      userInputTextField.setText("");
      textSampleLabel.setText(sampleText.get(currentLine));
      if(currentLine < sampleText.size() - 1){
         textSampleLabelComeUp.setText(sampleText.get(currentLine + 1));
      }
      textSampleLabelComeUp.setText("END");
   }
   
   /**
    * If user typed BACKSPACE "\b" currentChar will go back one
    * Otherwise it will take substring of sampleText from start to currentChar and compare to what is currently in textField entered by user
    * @param enteredText text from textField
    * @param keyEvent key event
    */
   private void checkCorrect(String enteredText, KeyEvent keyEvent){
      if(keyEvent.getCharacter().equals("\b")){
         if(currentChar > 0) currentChar--;
         return;
      }
      currentChar++;
      if(enteredText.substring(0,currentChar).equals(textSampleLabel.getText().substring(0,currentChar))){
         correctCharsTyped++;
      }
      charsTyped++;
      //System.out.println(STR."\{enteredText.substring(0,currentChar).charAt(enteredText.substring(0,currentChar).length()-1)} \{charsTyped} \{correctCharsTyped} \{currentChar} \{currentLine}");
   }
   
   /**
    * checks if the number of chars typed is the same as chars in the word to type
    * @return is it end word
    */
   private boolean isEndOfWord(){
      return currentChar == sampleText.get(currentLine).length();
   }
   
   
}
