package gobblets;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;


public class MainApp extends Application {
	public void start(Stage primaryStage) throws Exception{
		
		MainController main = new MainController();
		
		Rectangle r = new Rectangle();
		r.setHeight(25);
		r.setWidth(25);
		r.setRotate(45);
		r.setFill(Color.BLACK);
		r.setLayoutX(10);
		r.setLayoutY(170);
		
		TranslateTransition t = new TranslateTransition();
		t.setDuration(Duration.seconds(0.8));
		t.setAutoReverse(true);
		t.setCycleCount(1000);
		t.setToX(130);
		t.setNode(r);
		t.play();
		
		Label title = new Label("Gobblets Gobblers");
		title.setFont(Font.font("Cambria",FontWeight.EXTRA_BOLD,50));
		title.setTextFill(Color.BLACK);
		
		Button button = new Button("Pressed any key to continue");
		button.setStyle("-fx-background-color: #fff3e2;");
		button.setFont(Font.font("Cambria",FontWeight.THIN,12));
		button.setAlignment(Pos.CENTER_RIGHT);
		
		VBox root =new VBox(100);
		root.setPadding(new Insets(150,0,0,0));
		root.setStyle("-fx-background-color: #fff3e2;");
		VBox v2 =new VBox(100);
		HBox h1 = new HBox(130);
		HBox h2 = new HBox(130);
		h2.setPadding(new Insets(30,0,0,220));
		v2.setPadding(new Insets(18,0,0,10));
		v2.getChildren().add(r);
		h1.getChildren().addAll(v2,title);
		h2.getChildren().add(button);
		root.getChildren().addAll(h1,h2);
		
		button.setOnKeyPressed((e) -> { 
			try {
				button.setVisible(false);
				FadeTransition fadeTransition = new FadeTransition();
				fadeTransition.setDuration(Duration.millis(1500));
				fadeTransition.setNode(root);
				fadeTransition.setFromValue(1);
				fadeTransition.setToValue(0);
				fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent arg0) {
						try {
							main.GoGame(e);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					}
				});
				fadeTransition.play();
				
			} catch (Exception e1) {
				// TODO retravailler l'exception
				e1.printStackTrace();
			}
		});
		
		
		h1.setLayoutX(10);
		h1.setLayoutY(160);
		primaryStage.setTitle("Gobblets Gobblers");
		Image Icone = new Image(getClass().getResource("/gobblets/image/icone.png").toString());
		primaryStage.getIcons().add(Icone);
		Scene scene = new Scene(root,600,377);
		primaryStage.setScene(scene);
		primaryStage.setResizable(false);
		primaryStage.show();
		primaryStage.centerOnScreen();// centrer la fenetre ; tj après show()
		
	}
	
	public static void main(String[] args) {
        
        Application.launch(args);
        
    }

}
