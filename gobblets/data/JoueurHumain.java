package gobblets.data;

import gobblets.interaction.Action;
import gobblets.interaction.Deplacement;
import gobblets.interaction.Placement;
import gobblets.ihm.IHM;
import gobblets.interaction.Termination;
import javafx.scene.control.ColorPicker;

public class JoueurHumain extends Joueur {

	public JoueurHumain(String nom, ColorPicker colorPicker) {
		super(nom, colorPicker);
	}

	@Override
	public Action choisirAction(final Plateau plateau) {
		ActionType chosenAction = IHM.getIHM().saisirAction(this);
		Taille chosenSize;
		int tmpCoords [];
		
		switch(chosenAction) {
			case QUITTER:
				return new Termination();
			case PLACER:
				chosenSize = IHM.getIHM().saisirTaille();
				tmpCoords = IHM.getIHM().saisirCoordonnees(chosenAction);
				return new Placement(chosenSize, plateau.getPlateau()[tmpCoords[0]-1][tmpCoords[1]-1]);
			case DEPLACER:
				tmpCoords = IHM.getIHM().saisirCoordonnees(chosenAction);
				return new Deplacement(plateau.getPlateau()[tmpCoords[0]-1][tmpCoords[1]-1], plateau.getPlateau()[tmpCoords[2]-1][tmpCoords[3]-1]);
			default:
				return null;
		}
		
	}

}
