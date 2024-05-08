package org.example.typespeedtest;

public class Player {
   
   private String username;
   
   private byte wpm;
   private int prctAccuracy;
   private byte netSpeed;
   private byte netAccuracy;
   
   public Player() {
   }
   
   public Player(String username) {
      this.username = username;
   }
}
