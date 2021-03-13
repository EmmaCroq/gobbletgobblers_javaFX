package gobblets.logic;

import gobblets.ihm.Erreur;

public class CaseBloqueeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5870715281289947399L;
	
	private Erreur erreur;

	public CaseBloqueeException() {
		// TODO Auto-generated constructor stub
	}

	public CaseBloqueeException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public CaseBloqueeException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public CaseBloqueeException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public CaseBloqueeException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public CaseBloqueeException(Erreur erreur) {
		this.erreur = erreur;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Erreur getErreur() {
		return erreur;
	}
}
