package gobblets.ihm;

import gobblets.data.*;
import gobblets.ihm.langues.Allemand;
import gobblets.ihm.langues.Anglais;
import gobblets.ihm.langues.Francais;

public abstract class IHM {

  private static IHM courante = null;
  public static IHM getIHM() {
    return IHM.courante;
  }
  public static void setIHM(IHM courante) {
    IHM.courante = courante;
  }

  private static Dictionnaire language = new Francais();

  public static void setLanguage(String langage) {
    if(langage.equals("en")) language = new Anglais();
    else if(langage.equals("de")) language = new Allemand();
    else if(langage.equals("fr")) language = new Francais();
    else throw new IllegalArgumentException(language.erreur(Erreur.ARGUMENTINCORRECT));
  }

  public static String couleur(Couleur couleur) {
    return language.couleur(couleur);
  }

  public static String taille(Taille taille) {
    return language.taille(taille);
  }

  public static String etat(Etat etat) {
    return language.etat(etat);
  }

  public static String action(ActionType action) {
    return language.action(action);
  }

  public static String erreur(Erreur erreur) {
    return language.erreur(erreur);
  }

  public static String avertissement(Avertissement avertissement) {
    return language.avertissement(avertissement);
  }

  public static String menu(Menu menu) { return language.menu(menu); }

  abstract public Joueur saisirJoueur(int j);
  abstract public ActionType saisirAction(Joueur j);
  abstract public Taille saisirTaille();
  abstract public int[] saisirCoordonnees(ActionType action);
  abstract public void display(gobblets.data.Plateau plateau, Joueur joueur) ;
}
