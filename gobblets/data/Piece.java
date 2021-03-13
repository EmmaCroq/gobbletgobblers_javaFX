package gobblets.data;

import javafx.scene.control.ColorPicker;

public class Piece {
	
	private ColorPicker couleur;
	private final Taille taille;

	public Piece(Taille t) {
		this.taille = t;
		couleur = null;
	}

	public Taille getTaille() {
		return taille;
	}

	public ColorPicker getCouleur() {
		return couleur;
	}
	
	public void setCouleur(ColorPicker couleur2) {
		this.couleur = couleur2;
	}
	
	public boolean appartientA(final Joueur joueur) {
		return this.couleur == joueur.getCouleur();
	}

}
