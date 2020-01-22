package com.gamebox_x.hostedit;

import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	@SuppressWarnings("serial")
	public static Map<String, String> hostsList = new HashMap<String, String>(){{
		put("Windows", "C:\\Windows\\System32\\drivers\\etc\\hosts");
		put("MacOS", "/etc/hosts");
		put("Linux", "/etc/hosts");
		put("Other", "Not known path");
	}};

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		FXMLLoader fxmlLoader = new FXMLLoader();
		fxmlLoader.setLocation(this.getClass().getResource("views/MainWindow.fxml"));
		AnchorPane rootAnchorPane = fxmlLoader.load();
		Scene scene = new Scene(rootAnchorPane);
		primaryStage.setScene(scene);
		primaryStage.setMaxWidth(500);
		primaryStage.setMaxHeight(400);
		primaryStage.setMinWidth(363);
		primaryStage.setMinHeight(293);
		primaryStage.show();
		
	}

}
