package org.example.typespeedtest;

public record userResults(double wpm, int prctAccuracy, double netSpeed) {
   
   
   public userResults (double wpm, int prctAccuracy, double netSpeed){
      this.wpm = wpm;//calculateWPM(TestWindowController.getCharsTyped());
      this.prctAccuracy = prctAccuracy;//calculatePrctAccuracy(TestWindowController.getCharsTyped(), TestWindowController.getCorrectCharsTyped());;
      this.netSpeed = netSpeed;//calculateNetSpeed();
   }
   
   
   
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
   /*
   private int calculatePrctAccuracy(int charsTyped, int correctChars) {
      return (correctChars / charsTyped) * 100;
   }
   
   private double calculateNetSpeed() {
      return wpm() * (prctAccuracy() / 100);
   }
   private double calculateWPM(int charsTyped) {
      return (charsTyped /5.0) / ((double) TestWindowController.getStartTime() /60);
   }
   
    */
   @Override
   public String toString(){
      String s = wpm + "," + prctAccuracy + "," + netSpeed;
      return s;
   }
}
