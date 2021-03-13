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

public class Anglais implements Dictionnaire {

	private HashMap <Couleur, String> couleurs;
	private HashMap<Taille, String> tailles;
	private HashMap<Etat, String> etats;
	private HashMap<ActionType, String> actions;
	private HashMap<Erreur, String> erreurs;
	private HashMap<Avertissement, String> avertissements;
	
	public Anglais() {
		couleurs = new HashMap<Couleur, String>();
		couleurs.put(Couleur.ROUGE, "red");
		couleurs.put(Couleur.BLEU, "blue");
		couleurs.put(Couleur.VERT, "green");
		couleurs.put(Couleur.JAUNE, "yellow");
		
		tailles = new HashMap<Taille, String>();
		tailles.put(Taille.PETITE, "small");
		tailles.put(Taille.MOYENNE, "medium");
		tailles.put(Taille.GRANDE, "big");
		
		etats = new HashMap<Etat, String>();
		etats.put(Etat.MATCHNUL, "draw");
		etats.put(Etat.JEUENCOURS, "game running");
		etats.put(Etat.JOUEUR1GAGNE, "player 1 has won");
		etats.put(Etat.JOUEUR2GAGNE, "player 2 has won");
		etats.put(Etat.JEUQUITTE, "game terminated");
		
		actions = new HashMap<ActionType, String>();
		actions.put(ActionType.DEPLACER, "move");
		actions.put(ActionType.PLACER, "place");
		actions.put(ActionType.QUITTER, "quit");
		
		erreurs = new HashMap<Erreur, String>();
		erreurs.put(Erreur.CASEBLOQUEE, "A bigger or equal piece is already at this position!");
		erreurs.put(Erreur.PASDEPIECEDISPONIBLE, "There's no piece available!");
		erreurs.put(Erreur.PASDEPIECEICI, "There's no piece here!");
		erreurs.put(Erreur.PASTAPIECE, "This is not your piece!");
		erreurs.put(Erreur.ARGUMENTINCORRECT, "Incorrect argument value!");
		erreurs.put(Erreur.PASDETAILLEDISPONIBLE, "You don't have a %s piece in the stables anymore!");
		erreurs.put(Erreur.DIAGONALEINCORRECTE, "Only principal and secondary diagonals are available!");
		erreurs.put(Erreur.ORIGINEVIDE,"The origin is empty!");
		
		avertissements = new HashMap<Avertissement, String>();
		avertissements.put(Avertissement.CHOIXNBJOUEUR, "Choose the number of players:");
		avertissements.put(Avertissement.JOUEUR, "Player ");
		avertissements.put(Avertissement.NOMJOUEUR, "Pseudo :");
		avertissements.put(Avertissement.COULEURJOUEUR, "Color :");
		avertissements.put(Avertissement.COMMENCER, "Start a game!");
		avertissements.put(Avertissement.CHOIXCOULEUR, "You cannot choose the same color!");
		avertissements.put(Avertissement.CHOIXNOM, "You cannot choose the same name!");
		avertissements.put(Avertissement.NOMVIDE, "One or more pseudonyms are empty");

		avertissements.put(Avertissement.CREER, "Credit:");
		avertissements.put(Avertissement.TONTOUR, ", it's your turn !");
		avertissements.put(Avertissement.GAGNER, ", you have won !");
		avertissements.put(Avertissement.REJOUER, "Do you want to play again?");
		avertissements.put(Avertissement.MATCHNUL, "It's a draw!");
		avertissements.put(Avertissement.JOUEUR1GAGNE, "Player 1 to win!");
		avertissements.put(Avertissement.JOUEUR2GAGNE, "Player 2 to win!");
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
