package gobblets.ihm;

import gobblets.data.ActionType;
import gobblets.data.Couleur;
import gobblets.data.Etat;
import gobblets.data.Taille;

public interface Dictionnaire {
	String couleur(Couleur couleur);
	String taille(Taille taille);
	String etat(Etat etat);
	String action(ActionType action);
	String erreur(Erreur erreur);
	String avertissement(Avertissement avertissement);
  String menu(Menu menu);
}
