package gobblets.logic;

import java.util.ArrayList;

import gobblets.data.Etat;
import gobblets.data.Joueur;
import gobblets.data.JoueurHumain;
import gobblets.data.Piece;
import gobblets.data.Plateau;
import gobblets.MainController;
import gobblets.ihm.IHM;
import gobblets.interaction.*;
import javafx.scene.control.ColorPicker;

public class Jeu {
	
	private Plateau plateau;
	private Joueur j1;
	private Joueur j2;
	private Etat etat;
	private Joueur joueurActif;

	public Jeu(Joueur j1, Joueur j2) {
		this.plateau = Plateau.initPlateau();

		this.j1 = j1;
		this.j2 = j2;

		this.etat = Etat.JEUENCOURS;
//		ArrayList<Piece> tmpPieces = plateau.getEcurieJoueur1();
//
//		this.j1.setPieces(tmpPieces);
//		tmpPieces = plateau.getEcurieJoueur2();
//		for(int p = 0; p < tmpPieces.size(); p++) {
//			tmpPieces.get(p).setCouleur(fx.getCouleurJ2());
//		}
//		this.j2.setPieces(tmpPieces);


		int joueur = (int)Math.round(Math.random()) + 1;
		if(joueur == 1) this.joueurActif = j1;
		else this.joueurActif = j2;
	}
	
	public Etat getEtat() {
		return this.etat;
	}
	
	public void setEtat() {
		ColorPicker resCouleur = null;
		for(int l = 0; l < 3; l++) {
			ColorPicker tmpCouleur = this.plateau.verifierLigne(l);
			if(tmpCouleur != null) {//There is a result
				if(resCouleur == null) resCouleur = tmpCouleur;//There hasn't been a result before
				else if(!resCouleur.equals(tmpCouleur)) {//Conflict
					this.etat = Etat.MATCHNUL;
					return;
				}
			}
			tmpCouleur = this.plateau.verifierColonne(l);//Checking columns
			if(tmpCouleur != null) {//There is a result
				if(resCouleur == null) resCouleur = tmpCouleur;//There hasn't been a result before
				else if(!resCouleur.equals(tmpCouleur)) {//Conflict
					this.etat = Etat.MATCHNUL;
					return;
				}
			}
		}
		ColorPicker tmpCouleur = this.plateau.verifierDiagonale('p');
		if(tmpCouleur != null) {//There is a result
			if(resCouleur == null) resCouleur = tmpCouleur;//There hasn't been a result before
			else if(!resCouleur.equals(tmpCouleur)) {//Conflict
				this.etat = Etat.MATCHNUL;
				return;
			}
		}
		tmpCouleur = this.plateau.verifierDiagonale('s');
		if(tmpCouleur != null) {//There is a result
			if(resCouleur == null) resCouleur = tmpCouleur;//There hasn't been a result before
			else if(!resCouleur.equals(tmpCouleur)) {//Conflict
				this.etat = Etat.MATCHNUL;
				return;
			}
		}
		
		if(this.j1.getCouleur().equals(resCouleur)) this.etat = Etat.JOUEUR1GAGNE;
		else if(this.j2.getCouleur().equals(resCouleur)) this.etat = Etat.JOUEUR2GAGNE;
	}
	
	private Etat unTour(int iteration) {
		Action action;
		
		boolean actionVerifie = false;

		IHM.getIHM().display(this.plateau, this.joueurActif);

		do {
			action = joueurActif.choisirAction(this.plateau);
			if(action instanceof Termination) {
				this.etat = Etat.JEUQUITTE;
				return Etat.JEUQUITTE;
			}
			try {
				actionVerifie = action.verifier(this.joueurActif);
			} catch (PiecePasDisponibleException | CaseBloqueeException e) {
				System.out.println(e.getMessage()); 
				//e.printStackTrace();
			}
		}while(!actionVerifie);
		try {
			action.appliquer(joueurActif);
		} catch (CaseBloqueeException | PiecePasDisponibleException e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();
		}
		this.setEtat();
		changeJoueur();
		return this.getEtat();
	}

	public void changeJoueur() {
		getPlateau().dump();
		if(this.getJoueurActif() == j1) {
			this.joueurActif = j2;
		}else{
			this.joueurActif = j1;
		}
	}

	public Etat play() {
		Etat resultat;
		int iteration = 1;

		do {
				resultat = this.unTour(iteration);
				iteration++;
		}while(resultat != Etat.JEUQUITTE && this.getEtat() == Etat.JEUENCOURS);
		return this.getEtat();
	}

	public Plateau getPlateau() {
		return plateau;
	}

	public Joueur getJ1() {
		return j1;
	}

	public Joueur getJ2() {
		return j2;
	}

	public Joueur getJoueurActif() {
		return joueurActif;
	}

}
