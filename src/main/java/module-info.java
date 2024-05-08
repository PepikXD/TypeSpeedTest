module org.example.typespeedtest {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens org.example.typespeedtest to javafx.fxml;
    exports org.example.typespeedtest;
   exports org.example.typespeedtest.Controllers;
   opens org.example.typespeedtest.Controllers to javafx.fxml;
}