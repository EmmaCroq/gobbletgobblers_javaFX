package gobblets.interaction;

import gobblets.data.Joueur;
import gobblets.data.Taille;
import gobblets.ihm.Erreur;
import gobblets.ihm.IHM;
import gobblets.logic.CaseBloqueeException;
import gobblets.logic.PiecePasDisponibleException;

public class Placement extends Action {
	
	private final Taille taille;
	private final gobblets.data.Case destination;
	
	public Placement(Taille taille, gobblets.data.Case destination) {
		this.taille = taille;
		this.destination = destination;
	}

	public Taille getTaille() {
		return taille;
	}

	public gobblets.data.Case getDestination() {
		return destination;
	}

	@Override
	public boolean verifier(Joueur joueur) throws PiecePasDisponibleException, CaseBloqueeException {
		if(!joueur.aPieceDeTaille(this.taille)) throw new PiecePasDisponibleException(String.format(IHM.erreur(Erreur.PASDETAILLEDISPONIBLE),taille));
		if(!this.destination.acceptePiece(this.taille)) throw new CaseBloqueeException(IHM.erreur(Erreur.CASEBLOQUEE));
		return joueur.aPieceDeTaille(this.taille) && this.destination.acceptePiece(this.taille);
	}

	@Override
	public void appliquer(Joueur joueur) throws CaseBloqueeException, PiecePasDisponibleException {
		
		this.destination.placePiece(joueur.enlevePiece(this.taille));
	}

	@Override
	public String toString() {
		return String.format("{%s => %d, %d}", taille, 0,0/*destX, destY*/);
	}
}
