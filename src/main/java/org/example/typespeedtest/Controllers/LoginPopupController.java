package org.example.typespeedtest.Controllers;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import org.example.typespeedtest.*;

import java.net.*;
import java.util.*;

public class LoginPopupController implements Initializable{
   
   @FXML
   private Label enterUsernameLabel;
   @FXML
   private TextField enterUsernameTextField;
   @FXML
   private Button submitUsernameButton;
   @FXML
   private Button playAsGuestButton;
   @FXML
   private Button enterUsernameButton;
   @FXML
   private Label statsNotLabel;
   
   /**
    * When submitUsernameButton is pressed
    * - creates new Directory with username in data directory
    * - sets Game player to new player with username
    * - changes scene to main-window
    */
   public void onSubmitUsernameButtonPressed(ActionEvent actionEvent) {
      FileHandling.createFolder(enterUsernameTextField.getText());
      Game.setPlayer(new Player(enterUsernameTextField.getText()));
      Main.changeScene("main-window.fxml");
   }
   
   /**
    * Changes visibility of fields to enter username
    */
   public void onEnterUsernameButtonPressed(ActionEvent actionEvent) {
      setUsernameEnterFields();
   }
   
   /**
    * When playAsGuestButton is pressed
    * - set Game player to new Player without username
    * - changes scene to main-window
    */
   public void onPlayAsGuestButtonPressed(ActionEvent actionEvent) {
      Game.setPlayer(new Player());
      Main.changeScene("main-window.fxml");
   }
   
   /**
    * Changes visibility of fields
    */
   private void setUsernameEnterFields(){
      //makes enter properties visible
      enterUsernameLabel.setVisible(true);
      enterUsernameLabel.setDisable(false);
      enterUsernameTextField.setVisible(true);
      enterUsernameTextField.setDisable(false);
      submitUsernameButton.setVisible(true);
      submitUsernameButton.setDisable(false);
      //makes choose buttons invisible
      playAsGuestButton.setVisible(false);
      playAsGuestButton.setDisable(true);
      enterUsernameButton.setVisible(false);
      enterUsernameButton.setDisable(true);
      statsNotLabel.setVisible(false);
      statsNotLabel.setDisable(true);
   }
   
   /**
    * makes enter properties invisible
    */
   @Override
   public void initialize(URL url, ResourceBundle resourceBundle) {
      enterUsernameLabel.setVisible(false);
      enterUsernameLabel.setDisable(true);
      enterUsernameTextField.setVisible(false);
      enterUsernameTextField.setDisable(true);
      submitUsernameButton.setVisible(false);
      submitUsernameButton.setDisable(true);
   }
}
