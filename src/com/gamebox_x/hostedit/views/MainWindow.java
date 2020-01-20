package com.gamebox_x.hostedit.views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class MainWindow {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<?> availableList;

    @FXML
    private Button updateFromFile;

    @FXML
    private TextField ipaddrress;

    @FXML
    private Button addToList;

    @FXML
    private ComboBox<?> groupsAvailable;

    @FXML
    private Button saveGroup;

    @FXML
    private Button editEntity;

    @FXML
    private Button disableEntity;

    @FXML
    private Button removeFromList;

    @FXML
    private Button loadFromList;

    @FXML
    private TextField webaddress;

    @FXML
    void initialize() {
       
    }
}
