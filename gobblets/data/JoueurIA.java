package gobblets.data;

import gobblets.interaction.Action;
import javafx.scene.control.ColorPicker;

public class JoueurIA extends Joueur {

	public JoueurIA(String nom, ColorPicker couleur) {
		super("Bot", couleur);
	}

	@Override
	public Action choisirAction(Plateau plateau) {
		// TODO Auto-generated method stub
		return null;
	}

}
