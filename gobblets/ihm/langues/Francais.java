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

public class Francais implements Dictionnaire {

	private HashMap <Couleur, String> couleurs;
	private HashMap<Taille, String> tailles;
	private HashMap<Etat, String> etats;
	private HashMap<ActionType, String> actions;
	private HashMap<Erreur, String> erreurs;
	private HashMap<Avertissement, String> avertissements;
	
	public Francais() {
		couleurs = new HashMap<Couleur, String>();
		couleurs.put(Couleur.ROUGE, "rouge");
		couleurs.put(Couleur.BLEU, "bleu");
		couleurs.put(Couleur.VERT, "vert");
		couleurs.put(Couleur.JAUNE, "jaune");
		
		tailles = new HashMap<Taille, String>();
		tailles.put(Taille.PETITE, "petite");
		tailles.put(Taille.MOYENNE, "moyenne");
		tailles.put(Taille.GRANDE, "grande");
		
		etats = new HashMap<Etat, String>();
		etats.put(Etat.MATCHNUL, "match nul");
		etats.put(Etat.JEUENCOURS, "jeu en cours");
		etats.put(Etat.JOUEUR1GAGNE, "joueur 1 a gagné");
		etats.put(Etat.JOUEUR2GAGNE, "joueur 2 a gagné");
		etats.put(Etat.JEUQUITTE, "jeu terminé");
		
		actions = new HashMap<ActionType, String>();
		actions.put(ActionType.DEPLACER, "déplacer");
		actions.put(ActionType.PLACER, "placer");
		actions.put(ActionType.QUITTER, "quitter");
		
		erreurs = new HashMap<Erreur, String>();
		erreurs.put(Erreur.CASEBLOQUEE, "Une pièce de la même taille ou d'une taille supérieure est déjà dans la case!");
		erreurs.put(Erreur.PASDEPIECEDISPONIBLE, "Il n'y a pas de pièce disponible!");
		erreurs.put(Erreur.PASDEPIECEICI, "Il n'y a pas de pièce ici!");
		erreurs.put(Erreur.PASTAPIECE, "Ce n'est pas votre pièce!");
		erreurs.put(Erreur.ARGUMENTINCORRECT, "Valeur incorrecte de l'argument!");
		erreurs.put(Erreur.PASDETAILLEDISPONIBLE, "Vous n'avez plus de %s pièce dans votre écurie!");
		erreurs.put(Erreur.DIAGONALEINCORRECTE, "Seules les diagonales principale et secondaire sont disponibles!");
		erreurs.put(Erreur.ORIGINEVIDE,"L'origine est vide!");
		
		avertissements = new HashMap<Avertissement, String>();
		avertissements.put(Avertissement.CHOIXNBJOUEUR, "Choisissez le nombre de joueurs :");
		avertissements.put(Avertissement.JOUEUR, "Joueur ");
		avertissements.put(Avertissement.NOMJOUEUR, "Pseudo :");
		avertissements.put(Avertissement.COULEURJOUEUR, "Couleur :");
		avertissements.put(Avertissement.COMMENCER, "Commencer !");
		avertissements.put(Avertissement.CHOIXCOULEUR, "Vous ne pouvez pas choisir la même couleur ! ");
		avertissements.put(Avertissement.CHOIXNOM, "Vous ne pouvez pas choisir le même nom ! ");
		avertissements.put(Avertissement.NOMVIDE, "Un ou plusieurs pseudonymes sont vides");

		avertissements.put(Avertissement.CREER, "Crédit : ");
		avertissements.put(Avertissement.TONTOUR, ", c'est à ton tour !");
		avertissements.put(Avertissement.GAGNER, ", vous avez gagné !");
		avertissements.put(Avertissement.REJOUER, "Voulez-vous rejouer?");
		avertissements.put(Avertissement.MATCHNUL, "C'est un match nul !");
		avertissements.put(Avertissement.JOUEUR1GAGNE, "Le joueur 1 à gagner !");
		avertissements.put(Avertissement.JOUEUR2GAGNE, "Le joueur 2 à gagner !");
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
