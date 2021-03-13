package gobblets.data;

import gobblets.ihm.Erreur;
import gobblets.ihm.IHM;
import gobblets.logic.CaseBloqueeException;
import gobblets.logic.PiecePasDisponibleException;

public class Case{
	
	private Piece petite;
	private Piece moyenne;
	private Piece grande;

	public Case() {
		this.petite = null;
		this.moyenne = null;
		this.grande = null;
	}

	public boolean acceptePiece(Taille taille){
		return taille.recouvre(this.plusGrandePiece());
	}
	
	public Piece enlevePiece() throws PiecePasDisponibleException {
		Piece res;
		if(grande != null) {
			res = grande;
			grande = null;
		} else
		if(moyenne != null) {
			res = moyenne;
			moyenne = null;
		} else
		if(petite != null) {
			res = petite;
			petite = null;
		} else
		  throw new PiecePasDisponibleException(IHM.getIHM().erreur(Erreur.PASDEPIECEDISPONIBLE));
		return res;
	}
	
	public void placePiece(Piece piece)  throws CaseBloqueeException{
		switch(piece.getTaille()) {
			case PETITE:
			if(petite != null || moyenne != null || grande != null) throw new CaseBloqueeException(IHM.getIHM().erreur(Erreur.CASEBLOQUEE));
			this.petite = piece;
			break;
		case MOYENNE:
			if(moyenne != null || grande != null) throw new CaseBloqueeException(IHM.getIHM().erreur(Erreur.CASEBLOQUEE));
			this.moyenne = piece;
			break;
		case GRANDE:
			if(grande != null) throw new CaseBloqueeException(IHM.getIHM().erreur(Erreur.CASEBLOQUEE));
			this.grande = piece;
			break;
		}
	}
	
	public Piece plusGrandePiece() {
		if(grande != null) return grande;
		if(moyenne != null) return moyenne;
		if(petite != null) return petite;
		return null;
	}

	@Override
	public String toString() {
		return String.format("%c%c%c",
				petite==null?'.':petite.getCouleur().toString().charAt(0),
				moyenne==null?'.':moyenne.getCouleur().toString().charAt(0),
				grande==null?'.':grande.getCouleur().toString().charAt(0)
				);
	}
}
