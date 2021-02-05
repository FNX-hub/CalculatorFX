package logic;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    
	@Override
	public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Calculator");
        primaryStage.setResizable(false);
        BorderPane rootLayout = FXMLLoader.load(getClass().getResource("/calculator.fxml"));
        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();        
	}
}
