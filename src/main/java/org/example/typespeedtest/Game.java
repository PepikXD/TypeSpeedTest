package org.example.typespeedtest;

public class Game {
   
   private static Player player;
   
   public static void setPlayer(Player player) {
      Game.player = player;
   }
   public static Player getPlayer() {
      return player;
   }
}
