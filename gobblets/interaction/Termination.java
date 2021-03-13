package gobblets.interaction;

import gobblets.data.Joueur;
import gobblets.logic.CaseBloqueeException;
import gobblets.logic.PiecePasDisponibleException;

public class Termination extends Action {

	@Override
	public boolean verifier(Joueur joueur) throws PiecePasDisponibleException, CaseBloqueeException {
		return true;
	}

	@Override
	public void appliquer(Joueur joueur) {
		// nothing to do
	}
	
}
