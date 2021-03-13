package gobblets.data;

public enum Couleur {
	ROUGE (255, 0, 0, "\u001B[31m"),
	VERT (0, 255, 0, "\u001B[32m"),
	BLEU (0, 0, 255, "\u001B[34m"),
	JAUNE (255, 255, 0, "\u001B[33m"),
	WHITE (255, 255, 255, "\u001B[37m");
	
	private final int r;
	private final int g;
	private final int b;
	private String code;
	
	private Couleur(int r, int g, int b, String c) {
		this.r = r;
		this.g = g;
		this.b = b;
		this.code = c;
	}
	
	public int getR() {
		return r;
	}

	public int getG() {
		return g;
	}

	public int getB() {
		return b;
	}

	public String getCode() {
		return code;
	}
	
	public String toString() {
		return this.code+"r: "+this.r+" b: "+this.b+" g: "+this.g;
	}
}
