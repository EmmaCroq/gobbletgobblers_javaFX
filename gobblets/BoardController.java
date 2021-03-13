package gobblets;

import java.net.URL;
import java.util.ResourceBundle;

import gobblets.data.Etat;
import gobblets.data.Joueur;
import gobblets.data.JoueurHumain;
import gobblets.data.Piece;
import gobblets.data.Taille;
import gobblets.ihm.Avertissement;
import gobblets.ihm.IHM;
import gobblets.logic.Jeu;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class BoardController implements Initializable {

	@FXML
	private Label player1;
	@FXML
	private Label player2;
	@FXML
	private Label stateBar;

	@FXML
	private GridPane gridMaison1;
	@FXML
	private GridPane gridMaison2;
	@FXML
	private GridPane gridPlateau;

	@FXML
	private Label case00;
	@FXML
	private Label case01;
	@FXML
	private Label case02;
	@FXML
	private Label case10;
	@FXML
	private Label case11;
	@FXML
	private Label case12;
	@FXML
	private Label case20;
	@FXML
	private Label case21;
	@FXML
	private Label case22;
	@FXML
	private Label m100;
	@FXML
	private Label m101;
	@FXML
	private Label m102;
	@FXML
	private Label m110;
	@FXML
	private Label m111;
	@FXML
	private Label m112;
	@FXML
	private Label m200;
	@FXML
	private Label m201;
	@FXML
	private Label m202;
	@FXML
	private Label m210;
	@FXML
	private Label m211;
	@FXML
	private Label m212;
	@FXML
	private Label labelGagnant;

	private Label caseSurvolee;

	private Jeu jeu;
	private String tour = (IHM.avertissement(Avertissement.TONTOUR));
	private String truc1 = (IHM.avertissement(Avertissement.MATCHNUL));
	private String truc2 = (IHM.avertissement(Avertissement.JOUEUR1GAGNE));
	private String truc3 = (IHM.avertissement(Avertissement.JOUEUR2GAGNE));

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setJ1(MainController.getInstance().getTextFieldJ1());
		setJ2(MainController.getInstance().getTextFieldJ2());

		Joueur j1 = new JoueurHumain(this.player1.getText().toString(), MainController.getInstance().getCouleurJ1());
		Joueur j2 = new JoueurHumain(this.player2.getText().toString(), MainController.getInstance().getCouleurJ2());
		this.jeu = new Jeu(j1, j2);

		this.setMessageJoueurActif();
	}

	public void setJ1(String user) {
		this.player1.setText(user);
	}

	public void setJ2(String user) {
		this.player2.setText(user);
	}

	public void setMessageJoueurActif() {
		this.stateBar.setText(this.jeu.getJoueurActif().getNom().toString() + tour);
	}

	public void joueurSuivant() {
		this.jeu.changeJoueur();
		this.setMessageJoueurActif();
	}

	public void actualiserPlateau() {
		// TODO : Gérer couleurs et case vides
		Piece p00 = this.jeu.getPlateau().getPlateau()[0][0].plusGrandePiece();
		if (p00 != null) {
			this.case00.setText(p00.getTaille().toString());
		}
		Piece p01 = this.jeu.getPlateau().getPlateau()[0][1].plusGrandePiece();
		if (p01 != null) {
			this.case01.setText(p01.getTaille().toString());
		}
		Piece p02 = this.jeu.getPlateau().getPlateau()[0][2].plusGrandePiece();
		if (p02 != null) {
			this.case02.setText(p02.getTaille().toString());
		}
		Piece p10 = this.jeu.getPlateau().getPlateau()[1][0].plusGrandePiece();
		if (p00 != null) {
			this.case10.setText(p10.getTaille().toString());
		}
		Piece p11 = this.jeu.getPlateau().getPlateau()[1][1].plusGrandePiece();
		if (p01 != null) {
			this.case11.setText(p11.getTaille().toString());
		}
		Piece p12 = this.jeu.getPlateau().getPlateau()[1][2].plusGrandePiece();
		if (p02 != null) {
			this.case12.setText(p12.getTaille().toString());
		}
		Piece p20 = this.jeu.getPlateau().getPlateau()[2][0].plusGrandePiece();
		if (p00 != null) {
			this.case20.setText(p20.getTaille().toString());
		}
		Piece p21 = this.jeu.getPlateau().getPlateau()[2][1].plusGrandePiece();
		if (p01 != null) {
			this.case21.setText(p21.getTaille().toString());
		}
		Piece p22 = this.jeu.getPlateau().getPlateau()[2][2].plusGrandePiece();
		if (p02 != null) {
			this.case22.setText(p22.getTaille().toString());
		}
	}
	
	@FXML
	public Label setMaisonJ1(){
		Label x;
		Piece p100 = (new Piece(Taille.PETITE));
		x=verification(p100, this.m100);
		Piece p101 = (new Piece(Taille.MOYENNE));
		x=verification(p101, this.m101);
		Piece p102 = (new Piece(Taille.GRANDE));
		x=verification(p102, this.m102);
		Piece p110 = (new Piece(Taille.PETITE));
		x=verification(p110, this.m110);
		Piece p111 = (new Piece(Taille.MOYENNE));
		x=verification(p111, this.m111);
		Piece p112 = (new Piece(Taille.GRANDE));
		x=verification(p112, this.m112);
		
		return x;
	}
	@FXML
	public Label setMaisonJ2(){
		Label x;
		Piece p200 = (new Piece(Taille.PETITE));
		x=verification(p200, this.m200);
		Piece p201 = (new Piece(Taille.MOYENNE));
		x=verification(p201, this.m201);
		Piece p202 = (new Piece(Taille.GRANDE));
		x=verification(p202, this.m202);
		Piece p210 = (new Piece(Taille.PETITE));
		x=verification(p210, this.m210);
		Piece p211 = (new Piece(Taille.MOYENNE));
		x=verification(p211, this.m211);
//		Piece p212 = (new Piece(Taille.GRANDE));
//		x=verification(p212, this.m212);
		
		return x;
	}
	
	
	public Label verification(Piece a, Label b){
		if(a==(new Piece(Taille.PETITE))) {
			b.setText("o");
		}
		else if(a==(new Piece(Taille.MOYENNE))) {
			b.setText("O");
		}
		else if(a==(new Piece(Taille.GRANDE))) {
			b.setText("@");
		}
		return b;
	}

	public void dragMaison1(MouseEvent e) {
		Dragboard db = gridMaison1.startDragAndDrop(TransferMode.MOVE);
		ClipboardContent cb = new ClipboardContent();
		System.out.println(setMaisonJ1().toString());
		cb.putString(setMaisonJ1().getText().toString());
		db.setContent(cb);

		e.consume();
	}
	public void dragMaison2(MouseEvent e) {
		Dragboard db = gridMaison2.startDragAndDrop(TransferMode.MOVE);
		ClipboardContent cb = new ClipboardContent();
		System.out.println(setMaisonJ2().toString());
		cb.putString(setMaisonJ2().getText().toString());
		db.setContent(cb);

		e.consume();
	}

	public void casePlateauOver(DragEvent e) {
		this.caseSurvolee = (Label) e.getSource();
	}

	public void preparePlacerPiece(DragEvent e) {
		if (e.getDragboard().hasString()) {
			e.acceptTransferModes(TransferMode.MOVE);
		}
	}
	
	public void dropPlacerPiece(DragEvent e) throws Exception {
		
		String piece = e.getDragboard().getString();
		System.out.println(piece);

		this.caseSurvolee.setText(e.getDragboard().getString());

		/*
		 * Ici, on récupère l'ID du label sur lequel on a drop pour savoir dans quelle
		 * case du plateau on va tenter de placer la pièce.
		 * 
		 * On appelle ensuite dans un try/catch Plateau.PlacePiece avec la valeur de la
		 * piece dragndroppée et la case qui correspond à l'ID du label. Toujours dans
		 * le try, on appelle this.dropJoueurSuivant() pour passer au joueur suivant
		 * (comme ça si exception, on reste sur le même joueur).
		 * 
		 * Si erreur, le catch permet d'afficher un message expliquant au joueur le
		 * souci, et empêche de passer au joueur suivant.
		 * 
		 * 
		 * 
		 * Enfin, l'affichage dans chaque case se fait "tout seul". En gros
		 * (http://eyezmaze.com/sp/2018/08/diet.html LOL MDR...) appeller
		 * this.actualiserPlateau() et s'arranger pour avoir le texte et la couleur des
		 * pièces
		 * 
		 * etc...
		 * 
		 */

		try {
			this.jeu.getPlateau().placePiece(null, 0,0);
//			this.joueurSuivant(); //change de joueur
			this.actualiserPlateau();
			jeu.play();
			this.setMessageJoueurActif();
			this.aGagne();
		} catch (Exception exception) {
			System.err.println("Erreur dans placement pièce : " + exception);
			// TODO: reste au même joueur
		}


		e.setDropCompleted(true);
		e.consume();
	}

	@FXML
	public void doExit() {
		Platform.exit();
	}

	@FXML
	public void help() throws Exception {
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
	public void about() throws Exception {
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
	public void putFrench() {
		IHM.setLanguage("fr");
		this.setText();
	}

	@FXML
	public void putEnglish() {
		IHM.setLanguage("en");
		this.setText();
	}

	@FXML
	public void putGerman() {
		IHM.setLanguage("de");
		this.setText();
	}

	@FXML
	public void MenuNewGame() throws Exception {
		Parent boardParent = FXMLLoader.load(getClass().getResource("/gobblets/fxml/Main.fxml"));
		Scene board = new Scene(boardParent);
		Stage window = (Stage) Stage.getWindows().get(0);

		window.setScene(board);
		window.setTitle("Gobblets Gobblers");
		window.show();
		window.centerOnScreen();// centrer la fenetre ; tj après show()
	}
	
	@FXML
	public void avertissement() throws Exception{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/gobblets/fxml/Avertissement.fxml"));
		Parent root = fxmlLoader.load();
		Stage stage = new Stage();
		Image Icone = new Image(getClass().getResource("/gobblets/image/icone.png").toString());
		stage.getIcons().add(Icone);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle("Warning");
		stage.setScene(new Scene(root));
		stage.setResizable(false);
		stage.showAndWait();
	}
	
	@FXML
	public void aGagne() throws Exception{
		if(jeu.getEtat()==Etat.MATCHNUL) {
			this.labelGagnant.setText(truc1);
			this.avertissement();
		}
		if(jeu.getEtat()==Etat.JOUEUR1GAGNE) {
			this.labelGagnant.setText(truc2);
			this.avertissement();
		}
		if(jeu.getEtat()==Etat.JOUEUR2GAGNE) {
			this.labelGagnant.setText(truc3);
			this.avertissement();
		}
	}
	
	@FXML
	public void setText(){
		this.tour=(IHM.avertissement(Avertissement.TONTOUR));
		this.truc1=(IHM.avertissement(Avertissement.MATCHNUL));
		this.truc2=(IHM.avertissement(Avertissement.JOUEUR1GAGNE));
		this.truc3=(IHM.avertissement(Avertissement.JOUEUR2GAGNE));
	}
	
}
