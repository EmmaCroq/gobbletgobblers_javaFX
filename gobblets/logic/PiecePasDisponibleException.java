package gobblets.logic;

import gobblets.ihm.Erreur;

public class PiecePasDisponibleException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8040589716669398779L;
	
	private Erreur erreur;
	
	public PiecePasDisponibleException() {
		// TODO Auto-generated constructor stub
	}

	public PiecePasDisponibleException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PiecePasDisponibleException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public PiecePasDisponibleException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PiecePasDisponibleException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	
	public PiecePasDisponibleException(Erreur erreur) {
		this.erreur = erreur;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Erreur getErreur() {
		return erreur;
	}

}
