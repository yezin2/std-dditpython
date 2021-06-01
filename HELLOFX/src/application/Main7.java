package application;
	
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class Main7 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("main7.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			
			TextField tfI = (TextField)scene.lookup("#tfI");
			TextField tfC = (TextField)scene.lookup("#tfC");
			TextField tfR = (TextField)scene.lookup("#tfR");
			Button btn = (Button) scene.lookup("#sr");
			btn.setOnMouseClicked(new EventHandler<Event>() {

				@Override
				public void handle(Event event) {
					String tf1 = tfI.getText();
					String tf2;
					double a = Math.random();
					if(a < 0.33) {
						tf2 = "����";
					} else if(a > 0.33 && a < 0.66) {
						tf2 = "����";
					}else {
						tf2 = "��";
					}
					System.out.println("click");
					tfC.setText(tf2);
					
					if(tf1.equals("����")) {
						if(tf2.equals("����")) {
							tfR.setText("DRAW--");
						} else if (tf2.equals("����")) {
							tfR.setText("LOSE...");
						} else if (tf2.equals("��")) {
							tfR.setText("WIN!");
						}
					} else if(tf1.equals("����")) {
						if(tf2.equals("����")) {
							tfR.setText("WIN!");
						} else if (tf2.equals("����")) {
							tfR.setText("DRAW--");
						} else if (tf2.equals("��")) {
							tfR.setText("LOSE...");
						}
					} else if(tf1.equals("��")) {
						if(tf2.equals("����")) {
							tfR.setText("LOSE...");
						} else if (tf2.equals("����")) {
							tfR.setText("WIN!");
						} else if (tf2.equals("��")) {
							tfR.setText("DRAW--");
						}
					}
					
				}
			});
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}