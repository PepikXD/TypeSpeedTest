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
      BufferedReader br = new BufferedReader(new FileReader(getRandomText(new File("src/main/resources/Texts")))); //new FileReader(getRandomText(new File("src/main/resources/Texts"))) new InputStreamReader(Main.class.getResourceAsStream("Texts/1")
      while (br.ready()){
         text.add(br.readLine());
      }
      return text;
   }
   
   private static File getRandomText(File directory){
      Random random = new Random();
      File[] files = directory.listFiles();
      return files[random.nextInt(files.length)];
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
      write += ";";
      write += Game.getPlayer();
      write += ";";
      write += TestWindowController.getCharsTyped();
      write += ";";
      write += TestWindowController.getCorrectCharsTyped();
      return write;
   }

   private static File[] getAllFilesFromDirectory(String dir){
      File directory = new File(dir);
      File[] files = directory.listFiles();

      return files;
   }
   
   public static ObservableList<Data> readData() throws IOException {
      ObservableList<Data> data = FXCollections.observableArrayList();
      File[] files = getAllFilesFromDirectory("src/main/data/" + Game.getPlayer().getUsername());
      for (File file : files) {
         BufferedReader br = new BufferedReader(new FileReader(file.getPath()));
         String[] read = br.readLine().split(";");
         Data d = new Data(read[0] ,read[1] ,read[2] + " %",read[3],read[4],read[5]);
         data.add(d);
         br.close();
         
      }
      return data;
   }

   public static List<Integer> getOnlyAccuracy() throws IOException {
      List<Integer> l = new ArrayList<>();
      File[] files = getAllFilesFromDirectory("src/main/data/" + Game.getPlayer().getUsername());

      for (File f:files){
         BufferedReader br = new BufferedReader(new FileReader(f.getPath()));
         String[] read = br.readLine().split(";");
         l.add(Integer.valueOf(read[2]));
      }

      return l;
   }

   public static List<Double> getOnlyWPM() throws IOException {
      List<Double> l = new ArrayList<>();
      File[] files = getAllFilesFromDirectory("src/main/data/" + Game.getPlayer().getUsername());

      for (File f:files){
         BufferedReader br = new BufferedReader(new FileReader(f.getPath()));
         String[] read = br.readLine().split(";");
         l.add(Double.valueOf(read[1]));
      }

      return l;
   }

   public static List<Integer> getOnlyCharsTyped() throws IOException {
      List<Integer> l = new ArrayList<>();
      File[] files = getAllFilesFromDirectory("src/main/data/" + Game.getPlayer().getUsername());

      for (File f:files){
         BufferedReader br = new BufferedReader(new FileReader(f.getPath()));
         String[] read = br.readLine().split(";");
         l.add(Integer.valueOf(read[4]));
      }

      return l;
   }




}
