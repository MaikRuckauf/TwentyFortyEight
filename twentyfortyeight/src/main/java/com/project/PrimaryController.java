package com.project;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML // this will exit the application
    private void exit() throws IOException {
        return;
        //App.exit();
    }
}
