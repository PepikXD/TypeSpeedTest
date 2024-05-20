package org.example.typespeedtest;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public abstract class FileHandling {
   
   /**
    * Creates new folder for user in data if not already exists
    * @param username entered username
    */
   public static void createFolder(String username){
      Path path = Path.of("src/main/data/" + username);
      if (!Files.exists(path)) {
         try {
            Files.createDirectory(path);
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }
   
   public static List<String> loadText() throws IOException {
      List<String> text = new ArrayList <>();
      BufferedReader br = new BufferedReader(new FileReader(getRandomText(new File("src/main/Texts"))));
      while (br.ready()){
         text.add(br.readLine());
      }
      return text;
   }
   
   private static File getRandomText(File directory){
      Random random = new Random();
      return directory.listFiles()[random.nextInt(directory.listFiles().length)];
   }
   
   public static void writeData(){
   
   }
}
