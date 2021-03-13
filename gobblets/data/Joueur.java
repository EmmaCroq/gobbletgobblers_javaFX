package gobblets.data;

import java.util.ArrayList;

import gobblets.ihm.Erreur;
import gobblets.ihm.IHM;
import gobblets.interaction.Action;
import gobblets.logic.PiecePasDisponibleException;
import javafx.scene.control.ColorPicker;

public abstract class Joueur {
	
	private final String nom;
	private final ColorPicker couleur;
	private ArrayList<Piece> pieces;//I'll stock the stable here

	public Joueur(String nom, ColorPicker colorPicker) {
		this.nom = nom;
		this.couleur = colorPicker;
		pieces = null;
	}

	public ArrayList<Piece> getPieces() {
		return pieces;
	}
	
	public void setPieces(ArrayList<Piece> pieces) {
		this.pieces = pieces;
	}
	
	public void ajoutePiece(Piece p) {
		p.setCouleur(this.couleur);
		this.pieces.add(p);
	}
	
	public boolean aPiece(final Piece p) {
		return this.pieces.contains(p);
	}

	public String getNom() {
		return nom;
	}

	public ColorPicker getCouleur() {
		return couleur;
	}
	
	public abstract Action choisirAction(final Plateau plateau);
	
	public Piece enlevePiece(Taille taille) throws PiecePasDisponibleException {
		Piece tmpPiece = null;
		if(!this.aPieceDeTaille(taille)) throw new PiecePasDisponibleException(String.format(IHM.getIHM().erreur(Erreur.PASDETAILLEDISPONIBLE), taille.name()));
		switch(taille) {
			case PETITE:
				if(this.pieces.get(0) != null) {
					tmpPiece = this.pieces.get(0);
					this.pieces.set(0, null);
				}else if(this.pieces.get(1) != null){
					tmpPiece = this.pieces.get(1);
					this.pieces.set(1, null);
				}
				break;
			case MOYENNE:
				if(this.pieces.get(2) != null) {
					tmpPiece = this.pieces.get(2);
					this.pieces.set(2, null);
				}
				else if(this.pieces.get(3) != null) {
					tmpPiece = this.pieces.get(3);
					this.pieces.set(3, null);
				}
				break;
			case GRANDE:
				if(this.pieces.get(4) != null) {
					tmpPiece = this.pieces.get(4);
					this.pieces.set(4, null);
				}
				else if(this.pieces.get(5) != null) {
					tmpPiece = this.pieces.get(5);
					this.pieces.set(5, null);
				}
				break;
		}
		return tmpPiece;
	}
	
	public boolean aPieceDeTaille(Taille taille) {
		if(taille == null) return false;
		if(taille == Taille.PETITE) return (this.pieces.get(0) != null || this.pieces.get(1) != null);
		if(taille == Taille.MOYENNE) return (this.pieces.get(2) != null || this.pieces.get(3) != null);
		if(taille == Taille.GRANDE) return (this.pieces.get(4) != null || this.pieces.get(5) != null);
		return false;
	}

}
