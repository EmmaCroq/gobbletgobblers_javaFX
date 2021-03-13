package gobblets.interaction;

import gobblets.data.Joueur;
import gobblets.ihm.Erreur;
import gobblets.ihm.IHM;
import gobblets.logic.CaseBloqueeException;
import gobblets.logic.PiecePasDisponibleException;

public class Deplacement extends Action {
	
	private final gobblets.data.Case origin;
	private final gobblets.data.Case destination;
	
	public Deplacement(gobblets.data.Case origin, gobblets.data.Case destination) {
		
		this.origin = origin;
		this.destination = destination;
	}

	public gobblets.data.Case getOrigin() {
		return origin;
	}


	public gobblets.data.Case getDestination() {
		return destination;
	}


	@Override
	public boolean verifier(Joueur joueur) throws PiecePasDisponibleException, CaseBloqueeException {
		gobblets.data.Piece tmpPiece = this.origin.plusGrandePiece();
		if(tmpPiece == null) throw new PiecePasDisponibleException(IHM.erreur(Erreur.ORIGINEVIDE));//Same problem here
		if(!tmpPiece.appartientA(joueur)) throw new PiecePasDisponibleException(IHM.erreur(Erreur.PASTAPIECE));
		if(!this.destination.acceptePiece(tmpPiece.getTaille())) throw new CaseBloqueeException(IHM.erreur(Erreur.CASEBLOQUEE));
		return this.destination.acceptePiece(tmpPiece.getTaille());
	}

	@Override
	public void appliquer(Joueur joueur) throws CaseBloqueeException, PiecePasDisponibleException {
		this.destination.placePiece(this.origin.enlevePiece());
	}

	@Override
	public String toString() {
		return String.format("{%d, %d => %d, %d}", 0,0,0,0/*origX, origY, destX, destY*/);
	}
}
