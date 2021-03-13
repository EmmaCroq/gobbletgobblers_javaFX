package gobblets.data;

import java.util.ArrayList;

import gobblets.ihm.Erreur;
import gobblets.ihm.IHM;
import gobblets.logic.CaseBloqueeException;
import gobblets.logic.PiecePasDisponibleException;
import javafx.scene.control.ColorPicker;

public class Plateau {
	
	private Case [][] plateau;
	private ArrayList<Piece> ecurieJoueur1;
	private ArrayList<Piece> ecurieJoueur2;

	private Plateau() {
		plateau = new Case[3][3]; 
		ecurieJoueur1 = new ArrayList<Piece>(6);
		ecurieJoueur2 = new ArrayList<Piece>(6);
	}
	
	public static Plateau initPlateau() {
		Plateau tmp = new Plateau();
		for(int l = 0; l < 3; l++) {
			for(int c = 0; c < 3; c++) {
				tmp.plateau[l][c] = new Case();
			}
		}
		for(int p = 0; p < 2; p++) {
			tmp.ecurieJoueur1.add(p, new Piece(Taille.GRANDE));
			tmp.ecurieJoueur2.add(p, new Piece(Taille.GRANDE));
		}
		for(int p = 0; p < 2; p++) {
			tmp.ecurieJoueur1.add(p, new Piece(Taille.MOYENNE));
			tmp.ecurieJoueur2.add(p, new Piece(Taille.MOYENNE));
		}
		for(int p = 0; p < 2; p++) {
			tmp.ecurieJoueur1.add(p, new Piece(Taille.PETITE));
			tmp.ecurieJoueur2.add(p, new Piece(Taille.PETITE));
		}
		return tmp;
	}

	public Case[][] getPlateau() {
		return plateau;
	}

	private Case [] getLigne(int l) {
		
		Case tmpLigne [] = new Case[3]; 
		
		tmpLigne[0] = this.plateau[l][0];
		tmpLigne[1] = this.plateau[l][1];
		tmpLigne[2] = this.plateau[l][2];
		
		return tmpLigne;
	}
	
	private Case [] getColonne(int c) {
		
		Case tmpColonne [] = new Case[3];
		
		tmpColonne[0] = this.plateau[0][c];
		tmpColonne[1] = this.plateau[1][c];
		tmpColonne[2] = this.plateau[2][c];
		
		return tmpColonne;
	}

	private Case [] getDiagonalePrincipale() {
		
		Case tmpDiagonale [] = new Case[3];
		
		tmpDiagonale[0] = this.plateau[0][0];
		tmpDiagonale[1] = this.plateau[1][1];
		tmpDiagonale[2] = this.plateau[2][2];
		
		return tmpDiagonale;
	}
	
	private Case [] getDiagonaleSecondaire() {
		
		Case tmpDiagonale [] = new Case[3];
		
		tmpDiagonale[0] = this.plateau[0][2];
		tmpDiagonale[1] = this.plateau[1][1];
		tmpDiagonale[2] = this.plateau[2][0];
		
		return tmpDiagonale;
	}

	public ArrayList<Piece> getEcurieJoueur1() {
		return ecurieJoueur1;
	}

	public ArrayList<Piece> getEcurieJoueur2() {
		return ecurieJoueur2;
	}
	
	public void placePiece(Piece piece, int destX, int destY) throws CaseBloqueeException {
		this.plateau[destX][destY].placePiece(piece);
	}
	
	public Piece enlevePiece(int origX, int origY) throws PiecePasDisponibleException {
		return this.plateau[origX][origY].enlevePiece();
	}
	
	public Piece plusGrandPiece(int origX, int origY) {
		return this.plateau[origX][origY].plusGrandePiece();
	}
	
	public ColorPicker verifierLigne(int l) {
		Case[] tmpCases = this.getLigne(l);
		if(tmpCases[0].plusGrandePiece() != null && tmpCases[1].plusGrandePiece() != null && tmpCases[2].plusGrandePiece() != null && tmpCases[0].plusGrandePiece().getCouleur().equals(tmpCases[1].plusGrandePiece().getCouleur()) && tmpCases[0].plusGrandePiece().getCouleur().equals(tmpCases[2].plusGrandePiece().getCouleur())) return tmpCases[0].plusGrandePiece().getCouleur();
		return null;
	}
	
	public ColorPicker verifierColonne(int c) {
		Case[] tmpCases = this.getColonne(c);
		if(tmpCases[0].plusGrandePiece() != null && tmpCases[1].plusGrandePiece() != null && tmpCases[2].plusGrandePiece() != null && tmpCases[0].plusGrandePiece().getCouleur().equals(tmpCases[1].plusGrandePiece().getCouleur()) && tmpCases[0].plusGrandePiece().getCouleur().equals(tmpCases[2].plusGrandePiece().getCouleur())) return tmpCases[0].plusGrandePiece().getCouleur();
		return null;
	}
	
	public ColorPicker verifierDiagonale(char d) {
		Case[] tmpCases = null;
		if(d == 'p') tmpCases = this.getDiagonalePrincipale();
		else if(d == 's') tmpCases = this.getDiagonaleSecondaire();
		else throw new IllegalArgumentException(IHM.getIHM().erreur(Erreur.DIAGONALEINCORRECTE));
		if(tmpCases[0].plusGrandePiece() != null && tmpCases[1].plusGrandePiece() != null && tmpCases[2].plusGrandePiece() != null && tmpCases[0].plusGrandePiece().getCouleur().equals(tmpCases[1].plusGrandePiece().getCouleur()) && tmpCases[0].plusGrandePiece().getCouleur().equals(tmpCases[2].plusGrandePiece().getCouleur())) return tmpCases[0].plusGrandePiece().getCouleur();
		return null;
	}

	public void dump() {
		for (int y=0; y<3; ++y) {
			for (int x=0; x<3; ++x)
				System.out.printf("%s ",plateau[x][y]);
			System.out.println();
		}
	}
}
