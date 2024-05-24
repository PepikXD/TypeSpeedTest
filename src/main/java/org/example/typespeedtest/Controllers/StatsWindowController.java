package org.example.typespeedtest.Controllers;

import javafx.collections.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import org.example.typespeedtest.*;

import java.io.IOException;
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
   ObservableList<Data> data() throws IOException {
      return FileHandling.readData();
   }
   
   @Override
   public void initialize(URL url, ResourceBundle resourceBundle) {
      //setCellValueFactories();
      try {
         table.setItems(data());
      } catch (IOException e) {
         MyAlert a = new MyAlert(Alert.AlertType.ERROR);
         a.showAlert(e.getMessage());
      }

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
