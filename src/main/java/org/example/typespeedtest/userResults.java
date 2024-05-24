package org.example.typespeedtest;

public record userResults(double wpm, int prctAccuracy, double netSpeed) {
   
   @Override
   public double wpm() {
      return wpm;
   }
   
   @Override
   public int prctAccuracy() {
      return prctAccuracy;
   }
   
   @Override
   public double netSpeed() {
      return netSpeed;
   }
   @Override
   public String toString(){
      return wpm + ";" + prctAccuracy  + ";" + netSpeed;
   }
}
