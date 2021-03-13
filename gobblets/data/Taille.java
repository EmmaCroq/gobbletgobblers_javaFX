package gobblets.data;

public enum Taille {
	
	PETITE ('x'){		
		@Override
		public boolean recouvre(Taille taille) {
			return false;
		}
	},
	MOYENNE ('o'){
		
		@Override
		public boolean recouvre(Taille taille) {
			return taille==PETITE;
		}
	},
	GRANDE ('X'){
		
		@Override
		public boolean recouvre(Taille taille) {
			return taille != GRANDE;
		}
	};
	
	private final char symbole;
	
	private Taille(char s) {
		this.symbole = s;
	}

	public char getSymbole() {
		return symbole;
	}
	
	public boolean recouvre(Piece piece) {
		return (piece==null)||this.recouvre(piece.getTaille()); 
	}
	
	public abstract boolean recouvre(Taille taille); 
}
