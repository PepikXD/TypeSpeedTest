package org.example.typespeedtest.Controllers;

import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import org.example.typespeedtest.*;

import java.net.*;
import java.util.*;

public class StatsWindowController implements Initializable {
   @FXML
   private Button backButton;
   @FXML
   private TableView <Data> table;
   @FXML
   private TableColumn <Data, String> dateTime;
   @FXML
   private TableColumn <Data, String> wpm;
   @FXML
   private TableColumn <Data, String> accuracy;
   @FXML
   private TableColumn <Data, String> netSpeed;
   @FXML
   private TableColumn <Data, String> charsTyped;
   @FXML
   private TableColumn <Data, String> correctCharsTyped;
   
   
   public void onBackButtonPressed() {
      Main.changeScene("main-window.fxml");
   }
   ObservableList<Data> data(){
      return FileHandling.readData();
   }
   
   @Override
   public void initialize(URL url, ResourceBundle resourceBundle) {
      //setCellValueFactories();
      table.setItems(data());
      
      dateTime.setCellValueFactory(new PropertyValueFactory<>("dateTime"));
      wpm.setCellValueFactory(new PropertyValueFactory<>("wpm"));
      accuracy.setCellValueFactory(new PropertyValueFactory <>("accuracy"));
      netSpeed.setCellValueFactory(new PropertyValueFactory<>("netSpeed"));
      charsTyped.setCellValueFactory(new PropertyValueFactory<>("charsTyped"));
      correctCharsTyped.setCellValueFactory(new PropertyValueFactory<>("correctCharsTyped"));
      
      
      
   }
   /*
   private void setCellValueFactories(){
      dateTime.setCellValueFactory(new PropertyValueFactory<>("dateTime"));
      wpm.setCellValueFactory(new PropertyValueFactory<>("wpm"));
      accuracy.setCellValueFactory(new PropertyValueFactory <>("accuracy"));
      netSpeed.setCellValueFactory(new PropertyValueFactory<>("netSpeed"));
      charsTyped.setCellValueFactory(new PropertyValueFactory<>("charsTyped"));
      correctCharsTyped.setCellValueFactory(new PropertyValueFactory<>("correctCharsTyped"));
   }
   
    */
}
