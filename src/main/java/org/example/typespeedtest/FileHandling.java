package org.example.typespeedtest;

import javafx.collections.*;
import org.example.typespeedtest.Controllers.*;

import java.io.*;
import java.nio.file.*;
import java.text.*;
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
   
   public static void writeData() throws IOException {
      String write = createWriteString();
      
      String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
      BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/data/" + Game.getPlayer().getUsername() + "/" + timeStamp));
      bw.write(write);
      
      bw.close();
   }
   
   private static String createWriteString(){
      String write = "";
      write += DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.MEDIUM).format(new Date());
      write += ",";
      write += Game.getPlayer();
      write += ",";
      write += TestWindowController.getCharsTyped();
      write += ",";
      write += TestWindowController.getCorrectCharsTyped();
      return write;
   }
   
   public static ObservableList<Data> readData(){
      ObservableList<Data> data = FXCollections.observableArrayList();
      File directory = new File("src/main/data/" + Game.getPlayer().getUsername());
      File[] files = directory.listFiles();
      for (File file : files) {
         try {
            BufferedReader br = new BufferedReader(new FileReader(file.getPath()));
            String[] read = br.readLine().split(",");
            Data d = new Data(read[0],read[1],read[2],read[3],read[4],read[5]);
            data.add(d);
            br.close();
         } catch (IOException e) {
            throw new RuntimeException(e);
         }
         
      }
      return data;
   }
}
