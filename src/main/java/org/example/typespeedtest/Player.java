package org.example.typespeedtest;

import org.example.typespeedtest.Controllers.*;

public class Player {
   
   private String username;
   
   private userResults userResults;
   private double wpm;
   private int prctAccuracy;
   private double netSpeed;
   public Player() {
   }
   
   public Player(String username) {
      this.username = username;
      setUserResults(calculateWPM(TestWindowController.getCharsTyped()),calculatePrctAccuracy(TestWindowController.getCharsTyped(),TestWindowController.getCorrectCharsTyped()),calculateNetSpeed());
   }
   
   public void setUserResults(double wpm, int prctAccuracy, double netSpeed) {
      this.userResults = new userResults(wpm, prctAccuracy, netSpeed);
   }
   
   public userResults getUserResults() {
      return userResults;
   }
   
   private int calculatePrctAccuracy(int charsTyped, int correctChars) {
      return (correctChars / charsTyped) * 100;
   }
   
   private double calculateNetSpeed() {
      return getWpm() * (getPrctAccuracy() / 100);
   }
   private double calculateWPM(int charsTyped) {
      return (charsTyped /5.0) / ((double) TestWindowController.getStartTime() /60);
   }
   
   public double getWpm() {
      return wpm;
   }
   
   public void setWpm() {
      this.wpm = calculateWPM(TestWindowController.getCharsTyped());
   }
   
   public int getPrctAccuracy() {
      return prctAccuracy;
   }
   
   public void setPrctAccuracy() {
      this.prctAccuracy = calculatePrctAccuracy(TestWindowController.getCharsTyped(), TestWindowController.getCorrectCharsTyped());
   }
   
   public double getNetSpeed() {
      return netSpeed;
   }
   
   public void setNetSpeed() {
      this.netSpeed = calculateNetSpeed();
   }
   
}
