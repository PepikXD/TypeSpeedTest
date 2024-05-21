package org.example.typespeedtest;

public class Data {
   private String dateTime;
   private String wpm;
   private String accuracy;
   private String netSpeed;
   private String charsTyped;
   private String correctCharsTyped;
   
   public Data(String dateTime, String wpm, String accuracy, String netSpeed, String charsTyped, String correctCharsTyped) {
      this.dateTime = dateTime;
      this.wpm = wpm;
      this.accuracy = accuracy;
      this.netSpeed = netSpeed;
      this.charsTyped = charsTyped;
      this.correctCharsTyped = correctCharsTyped;
   }
   
   public String getDateTime() {
      return dateTime;
   }
   
   public void setDateTime(String dateTime) {
      this.dateTime = dateTime;
   }
   
   public String getWpm() {
      return wpm;
   }
   
   public void setWpm(String wpm) {
      this.wpm = wpm;
   }
   
   public String getAccuracy() {
      return accuracy;
   }
   
   public void setAccuracy(String accuracy) {
      this.accuracy = accuracy;
   }
   
   public String getNetSpeed() {
      return netSpeed;
   }
   
   public void setNetSpeed(String netSpeed) {
      this.netSpeed = netSpeed;
   }
   
   public String getCharsTyped() {
      return charsTyped;
   }
   
   public void setCharsTyped(String charsTyped) {
      this.charsTyped = charsTyped;
   }
   
   public String getCorrectCharsTyped() {
      return correctCharsTyped;
   }
   
   public void setCorrectCharsTyped(String correctCharsTyped) {
      this.correctCharsTyped = correctCharsTyped;
   }
}
