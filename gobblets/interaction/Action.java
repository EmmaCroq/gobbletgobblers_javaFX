package gobblets.interaction;

import gobblets.data.Joueur;
import gobblets.logic.CaseBloqueeException;
import gobblets.logic.PiecePasDisponibleException;

public abstract class Action {
	public abstract boolean verifier(Joueur joueur)  throws PiecePasDisponibleException, CaseBloqueeException;
	public abstract void appliquer(Joueur joueur) throws CaseBloqueeException, PiecePasDisponibleException;
}
