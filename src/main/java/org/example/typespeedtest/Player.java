package org.example.typespeedtest;

import org.example.typespeedtest.Controllers.*;

import java.text.*;

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
      //setUserResults(calculateWPM(TestWindowController.getCharsTyped()),calculatePrctAccuracy(TestWindowController.getCharsTyped(),TestWindowController.getCorrectCharsTyped()),calculateNetSpeed());
   }
   
   public boolean isPlayerLoggedIn(){
      return username != null;
   }
   
   public void setUserResults() {
      DecimalFormat df = new DecimalFormat("0.00");
      
      double wpm1 = Double.parseDouble(df.format(calculateWPM(TestWindowController.getCharsTyped())).replace(",","."));
      int prctAcc1 = calculatePrctAccuracy(TestWindowController.getCharsTyped(),TestWindowController.getCorrectCharsTyped());
      wpm = wpm1;
      prctAccuracy = prctAcc1;
      double netSpeed1 = Double.parseDouble(df.format(calculateNetSpeed()).replace(",","."));
      
      this.userResults = new userResults(wpm1,prctAcc1,netSpeed1);
   }
   
   public userResults getUserResults() {
      return userResults;
   }
   
   private int calculatePrctAccuracy(int charsTyped, int correctChars) {
      int temp = correctChars * 100 / charsTyped;
      return temp;
   }
   
   private double calculateNetSpeed() {
      return getWpm() * ((double) getPrctAccuracy() / 100);
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
   
   public String getUsername() {
      return username;
   }
   
   @Override
   public String toString() {
      return userResults.toString();
   }
}
