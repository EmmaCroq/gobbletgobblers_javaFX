package gobblets.ihm.langues;

import java.util.HashMap;

import gobblets.data.ActionType;
import gobblets.data.Couleur;
import gobblets.data.Etat;
import gobblets.data.Taille;
import gobblets.ihm.Avertissement;
import gobblets.ihm.Dictionnaire;
import gobblets.ihm.Erreur;
import gobblets.ihm.Menu;

public class Allemand implements Dictionnaire {

	private HashMap<Couleur, String> couleurs;
	private HashMap<Taille, String> tailles;
	private HashMap<Etat, String> etats;
	private HashMap<ActionType, String> actions;
	private HashMap<Erreur, String> erreurs;
	private HashMap<Avertissement, String> avertissements;
	
	public Allemand() {
		couleurs = new HashMap<Couleur, String>();
		couleurs.put(Couleur.ROUGE, "rot");
		couleurs.put(Couleur.BLEU, "blau");
		couleurs.put(Couleur.VERT, "grün");
		couleurs.put(Couleur.JAUNE, "gelb");
		
		tailles = new HashMap<Taille, String>();
		tailles.put(Taille.PETITE, "kleine");
		tailles.put(Taille.MOYENNE, "mittlere");
		tailles.put(Taille.GRANDE, "grosse");
		
		etats = new HashMap<Etat, String>();
		etats.put(Etat.MATCHNUL, "unentschieden");
		etats.put(Etat.JEUENCOURS, "Spiel läuft noch");
		etats.put(Etat.JOUEUR1GAGNE, "Spieler 1 gewinnt");
		etats.put(Etat.JOUEUR2GAGNE, "Spieler 2 gewinnt");
		etats.put(Etat.JEUQUITTE, "Spiel abgebrochen");
		
		actions = new HashMap<ActionType, String>();
		actions.put(ActionType.DEPLACER, "versetzen");
		actions.put(ActionType.PLACER, "platzieren");
		actions.put(ActionType.QUITTER, "abbrechen");
		
		erreurs = new HashMap<Erreur, String>();
		erreurs.put(Erreur.CASEBLOQUEE, "Eine grössere oder genauso grosse Figur ist bereits auf diesem Feld!");
		erreurs.put(Erreur.PASDEPIECEDISPONIBLE, "Ihre Figure ist nicht verfügbar!");
		erreurs.put(Erreur.PASDEPIECEICI, "Hier ist kein Platz!");
		erreurs.put(Erreur.PASTAPIECE, "Das ist nicht ihre Figur!");
		erreurs.put(Erreur.ARGUMENTINCORRECT, "Falscher Attributwert!");
		erreurs.put(Erreur.PASDETAILLEDISPONIBLE, "In Ihrem Stall ist keine %s Figur mehr!");
		erreurs.put(Erreur.DIAGONALEINCORRECTE, "Es sind nur die Haupt- und Nebendiagonalen verfügbar!");
		erreurs.put(Erreur.ORIGINEVIDE,"Das Ursprungsfeld ist leer!");
		
		avertissements = new HashMap<Avertissement, String>();
		avertissements.put(Avertissement.CHOIXNBJOUEUR, "Wählen Sie die Anzahl der Spieler:");
		avertissements.put(Avertissement.JOUEUR, "Spieler ");
		avertissements.put(Avertissement.NOMJOUEUR, "Spitzname:");
		avertissements.put(Avertissement.COULEURJOUEUR, "Farbe :");
		avertissements.put(Avertissement.COMMENCER, "Starte ein Spiel!");
		avertissements.put(Avertissement.CHOIXCOULEUR, "Sie können nicht die gleiche Farbe wählen!");
		avertissements.put(Avertissement.CHOIXNOM, "Sie können nicht den gleichen Namen wählen!");
		avertissements.put(Avertissement.NOMVIDE, "Ein oder mehrere Pseudonyme sind leer");

		avertissements.put(Avertissement.CREER, "Anerkennung:");
		avertissements.put(Avertissement.TONTOUR, ", du bist dran !");
		avertissements.put(Avertissement.GAGNER, ", du hast gewonnen !");
		avertissements.put(Avertissement.REJOUER, "Möchten Sie wiederholen?");
		avertissements.put(Avertissement.MATCHNUL, "Es ist eine Zeichnung!");
		avertissements.put(Avertissement.JOUEUR1GAGNE, "Spieler 1 gewinnt!");
		avertissements.put(Avertissement.JOUEUR2GAGNE, "Spieler 2 gewinnt!");

	}

	@Override
	public String couleur(Couleur couleur) {
		return this.couleurs.get(couleur);
	}

	@Override
	public String taille(Taille taille) {
		return this.tailles.get(taille);
	}

	@Override
	public String etat(Etat etat) {
		return this.etats.get(etat);
	}

	@Override
	public String action(ActionType action) {
		return this.actions.get(action);
	}

	@Override
	public String erreur(Erreur erreur) {
		return this.erreurs.get(erreur);
	}

	@Override
	public String avertissement(Avertissement avertissement) {
		return this.avertissements.get(avertissement);
	}

	@Override
	public String menu(Menu menu) {
		return null;
	}

}
