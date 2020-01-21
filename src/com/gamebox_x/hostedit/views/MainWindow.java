package com.gamebox_x.hostedit.views;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.gamebox_x.hostedit.Main;
import com.gamebox_x.hostedit.models.GroupOfHosts;
import com.gamebox_x.hostedit.models.HostEntity;
import com.gamebox_x.hostedit.models.OsCheck;

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
    private ListView<HostEntity> availableList;

    @FXML
    private Button updateFromFile;

    @FXML
    private TextField ipaddrress;

    @FXML
    private Button addToList;

    @FXML
    private ComboBox<GroupOfHosts> groupsAvailable;

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
    
    LocalDateTime lastCurrentChange = LocalDateTime.now();
    Boolean save = false;
    Integer editId = -1;

    @FXML
    void initialize() {
       groupsAvailable.getItems().add(new GroupOfHosts());
       disableEntity.setDisable(true);
       updateFromFile.setOnAction((event)->{
    	   availableList.getItems().clear();
    	   try {
    		   Pattern pattern = Pattern.compile("^(\\#?)\\s*([0-9.]{3,15}|[0-9:.abcdefABCDEF]{3,39})\\s{1,}([a-zA-Z\\.0-9]*)$");
    		   String lineString = "";
        	   BufferedReader br = new BufferedReader(new FileReader(Main.hostsList.get(OsCheck.getOperatingSystemType().toString())));
        	   while((lineString = br.readLine())!=null) {
        		   if(lineString.matches("^\\#?\\s*([0-9.]{3,15}|[0-9:.abcdefABCDEF]{3,39})\\s{1,}[a-zA-Z\\.0-9]*$")) {
        			   Matcher matcher = pattern.matcher(lineString);
        			   matcher.find();
        			   availableList.getItems().add(new HostEntity(matcher.group(2), matcher.group(3), matcher.group(1).length()==1));
        		   }
        	   }
        	   br.close();
        	   groupsAvailable.setValue(null);
    	   }catch (Exception e) {
			// TODO: handle exception
		}
       });
       editEntity.setOnAction((event)->{
    	   if(availableList.getSelectionModel().getSelectedItem()!=null) {
    		   editId = availableList.getSelectionModel().getSelectedIndex();
	    	   save = true;
	    	   String ipaddr = availableList.getItems().get(editId).getIpaddress();
	    	   String webaddr = availableList.getItems().get(editId).getWebaddress();
	    	   ipaddrress.setText(ipaddr);
	    	   webaddress.setText(webaddr);
	    	   addToList.setText("Save It");
    	   }
       });
       addToList.setOnAction((event)->{
    	   if(save) {
    		   availableList.getItems().get(editId).setIpaddress(ipaddrress.getText());
    		   availableList.getItems().get(editId).setWebaddress(webaddress.getText());
    		   addToList.setText("Add");
    	   }else {
    		   availableList.getItems().add(new HostEntity(ipaddrress.getText(),webaddress.getText(),false));
    	   }
		   editId = -1;
		   save = false;
    	   availableList.refresh();
    	   ipaddrress.setText(null);
    	   webaddress.setText(null);
       });
       availableList.getSelectionModel().selectedItemProperty().addListener((list,old,_new)->{
    	   if(_new!=null) {
    		   disableEntity.setDisable(false);
    		   disableEntity.setText((_new.getDisabled())? "Enable":"Disable");
    	   }
    	   else {
    		   disableEntity.setDisable(true);
    		   disableEntity.setText("Disable");
    	   }
       });
       disableEntity.setOnAction((event)->{
    	   if(availableList.getSelectionModel().getSelectedItem()!=null) {
    		   availableList.getSelectionModel().getSelectedItem().setDisabled(!availableList.getSelectionModel().getSelectedItem().getDisabled());
    		   disableEntity.setText((availableList.getSelectionModel().getSelectedItem().getDisabled())? "Enable":"Disable");
    		   availableList.refresh();
    	   }
       });
       removeFromList.setOnAction((event)->{
    	   if(availableList.getSelectionModel().getSelectedItem()!=null) {
    		   availableList.getItems().remove(availableList.getSelectionModel().getSelectedIndex());
    		   availableList.refresh();
    	   }
       });
       saveGroup.setOnAction((event)->{
    	   boolean saveName = groupsAvailable.getEditor().getText().length() != 0;
    	   boolean elementSize = availableList.getItems().size() != 0;
    	   if(saveName && elementSize) {
    		   
    	   }
       });
    }
    
    public MainWindow() {
		// TODO Auto-generated constructor stub
	}
    
}
