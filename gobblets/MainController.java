package gobblets;

import java.net.URL;
import java.util.ResourceBundle;
import gobblets.data.Etat;
import gobblets.data.Joueur;
import gobblets.data.JoueurHumain;
import gobblets.ihm.Avertissement;
import gobblets.ihm.IHM;
import gobblets.logic.Jeu;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainController implements Initializable{
	
	@FXML
	private RadioButton RadioButton1;
	@FXML
	private RadioButton RadioButton2;
	@FXML
	private Label text13;
	@FXML
	private Label text14;
	@FXML
	private Label text15;
	@FXML
	private Label player1;
	@FXML
	private Label player2;
	@FXML
	private Label errorPseudo;
	@FXML
	private Label errorPseudo2;
	@FXML
	private Label errorColor;
	@FXML
	private TextField textField2;
	@FXML
	private TextField textField1;
	@FXML
	private ColorPicker colorPiker1;
	@FXML
	private ColorPicker colorPiker2;
	@FXML
	private Button starter;
	@FXML
	private VBox roote;
	@FXML
	private Label ChoixNbJoueur;
	
	
	@FXML
	private Label player;
	@FXML
	private Label pseudo;
	@FXML
	private Label color;
	private String err1 = "The pseudonyms are the same !";
	private String err2 = "One or more pseudonyms are empty !";
	private String err3 = "The colors are the same !";
	
	
	
	private static MainController instance;

	public MainController() {
		instance = this;
	}
	
	public static MainController getInstance() {
		return instance;
	}
	
	public String getTextFieldJ1() {
		if(verificationAuth()==1) {
			return textField1.getText().toString();
		}
		return null;
	}
	
	public String getTextFieldJ2() {
		if(verificationAuth()==1) {
			return textField2.getText().toString();
		}
		return null;
	}
	
	
	@FXML
	public int memePseudo() {
		if(textField1.getText().toString().compareTo(textField2.getText().toString())==0) {
			errorPseudo.setText(err1);
			return 0;
		}
		if(textField1.getText().toString().contentEquals("") || textField2.getText().toString().contentEquals("")){
			errorPseudo2.setText(err2);
			return 0;
		}else {
			errorPseudo.setText("");
			errorPseudo2.setText("");
			return 1;
		}
	}
	
	@FXML
	public int memeCouleur() {
		if(colorPiker1.getValue().toString().compareTo(colorPiker2.getValue().toString())==0) {
			errorColor.setText(err3);
			return 0;
		}
		else {
			errorColor.setText("");
			return 1;
		}
	}

	@FXML
	public int verificationAuth() {
		if(memeCouleur()==1 && memePseudo()==1) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	@FXML
	public ColorPicker getCouleurJ1() {
		if(verificationAuth()==1) {
			return colorPiker1;
		}
		return null;
	}
	
	@FXML
	public ColorPicker getCouleurJ2() {
		if(verificationAuth()==1) {
			return colorPiker2;
		}
		return null;
	}
	
	@FXML
	public void lancer() {
		Joueur j1 = new JoueurHumain(getTextFieldJ1(), getCouleurJ1());
		Joueur j2 = new JoueurHumain(getTextFieldJ2(), getCouleurJ2());
		Jeu jeu = new Jeu(j1,j2);
		Etat result = jeu.play();
		            
		System.out.println(IHM.etat(result));
	}
	
	
	@FXML
	public void doExit() {
		Platform.exit();
	}
	
	@FXML
	public void RadioButton1() {
		if(RadioButton1.isSelected()) {
			RadioButton2.setSelected(false);
			text13.setDisable(true);
			text14.setDisable(true);
			text15.setDisable(true);
			textField2.setDisable(true);
			colorPiker2.setDisable(true);
		}
		else {
			RadioButton2.setSelected(true);
			text13.setDisable(false);
			text14.setDisable(false);
			text15.setDisable(false);
			textField2.setDisable(false);
			colorPiker2.setDisable(false);
		}
	}
	
	@FXML
	public void RadioButton2() {
		if(RadioButton2.isSelected()) {
			RadioButton1.setSelected(false);
			text13.setDisable(false);
			text14.setDisable(false);
			text15.setDisable(false);
			textField2.setDisable(false);
			colorPiker2.setDisable(false);
		}
		else {
			RadioButton1.setSelected(true);
			text13.setDisable(true);
			text14.setDisable(true);
			text15.setDisable(true);
			textField2.setDisable(true);
			colorPiker2.setDisable(true);
		}
	}
	
	@FXML
	public void help() throws Exception{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gobblets/fxml/Help.fxml")); 
		Parent root = fxmlLoader.load(); 
		Stage stage = new Stage(); 
		Image Icone = new Image(getClass().getResource("/gobblets/image/icone.png").toString());
		stage.getIcons().add(Icone);
		stage.initModality(Modality.APPLICATION_MODAL);  
		stage.setTitle("Help"); 
		stage.setScene(new Scene(root)); 
		stage.setResizable(false);
		stage.showAndWait();
	}
	
	@FXML
	public void about() throws Exception{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gobblets/fxml/About.fxml")); 
		Parent root = fxmlLoader.load(); 
		Stage stage = new Stage(); 
		Image Icone = new Image(getClass().getResource("/gobblets/image/icone.png").toString());
		stage.getIcons().add(Icone);
		stage.initModality(Modality.APPLICATION_MODAL);  
		stage.setTitle("About"); 
		stage.setScene(new Scene(root)); 
		stage.setResizable(false);
		stage.showAndWait();
	}
	
	@FXML
	public void putFrench(){
		IHM.setLanguage("fr");
		this.setText();
		//save et load
	}
	@FXML
	public void putEnglish(){
		IHM.setLanguage("en");
		this.setText();
	}
	@FXML
	public void putGerman(){
		IHM.setLanguage("de");
		this.setText();
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	public void testNew(ActionEvent e) throws Exception {
		if(verificationAuth()==1) {
			NextGame(e);
		}
	}
	
	@FXML
	public void startGame(ActionEvent e) throws Exception{
		Parent boardParent = FXMLLoader.load(getClass().getResource("/gobblets/fxml/Board.fxml"));
		Scene board = new Scene(boardParent);
		
		Stage window = (Stage)((Node) e.getSource()).getScene().getWindow();
		window.setScene(board);
		window.setTitle("Gobblets Gobblers"); 
		window.show();
		window.centerOnScreen();// centrer la fenetre ; tj après show()
	}
	
	@FXML
	public void GoGame(KeyEvent e) throws Exception{
		Parent boardParent = FXMLLoader.load(getClass().getResource("/gobblets/fxml/Main.fxml"));
		Scene board = new Scene(boardParent);
		
		Stage window = (Stage)((Node) e.getSource()).getScene().getWindow();
		window.setScene(board);
		window.setTitle("Gobblets Gobblers"); 
		window.show();
		window.centerOnScreen();// centrer la fenetre ; tj après show()
	}

	@FXML
	public void NextGame(ActionEvent e){
			try {
				FadeTransition fadeTransition = new FadeTransition();
				fadeTransition.setDuration(Duration.millis(500));
				fadeTransition.setNode(roote);
				fadeTransition.setFromValue(1);
				fadeTransition.setToValue(0);
				fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent arg0) {
						try {
							startGame(e);
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
	}
	
	@FXML
	public void MenuNewGame() throws Exception{
		Parent boardParent = FXMLLoader.load(getClass().getResource("/gobblets/fxml/Main.fxml"));
		Scene board = new Scene(boardParent);
		Stage window = (Stage) Stage.getWindows().get(0);
		
		window.setScene(board);
		window.setTitle("Gobblets Gobblers"); 
		window.show();
		window.centerOnScreen();// centrer la fenetre ; tj après show()
	}
	
	@FXML
	public void setText(){
		this.ChoixNbJoueur.setText(IHM.avertissement(Avertissement.CHOIXNBJOUEUR));
		this.player.setText(IHM.avertissement(Avertissement.JOUEUR) +"1");
		this.pseudo.setText(IHM.avertissement(Avertissement.NOMJOUEUR));
		this.color.setText(IHM.avertissement(Avertissement.COULEURJOUEUR));
		this.text13.setText(IHM.avertissement(Avertissement.JOUEUR) +"2");
		this.text14.setText(IHM.avertissement(Avertissement.NOMJOUEUR));
		this.text15.setText(IHM.avertissement(Avertissement.COULEURJOUEUR));
		this.starter.setText(IHM.avertissement(Avertissement.COMMENCER));
		
		this.err1=(IHM.avertissement(Avertissement.CHOIXNOM));
		this.err2=(IHM.avertissement(Avertissement.NOMVIDE));
		this.err3=(IHM.avertissement(Avertissement.CHOIXCOULEUR));
	}
	
}
