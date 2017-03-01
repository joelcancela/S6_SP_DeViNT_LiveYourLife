package fr.unice.polytech.devint.g2projet3.exemple.multijoueur;

import fr.unice.polytech.devint.g2projet3.devint.ConstantesDevint;
import fr.unice.polytech.devint.g2projet3.devint.SceneDevint;
import fr.unice.polytech.devint.g2projet3.jeu.animation.ControleAnimationDevint;
import fr.unice.polytech.devint.g2projet3.jeu.animation.JeuAnimationDevint;
import fr.unice.polytech.devint.g2projet3.jeu.animation.ModeleAnimationDevint;
import javafx.scene.Group;
import javafx.scene.canvas.Canvas;


/**
 * une exemple de jeu d'animation.
 * comme il s'agit d'une animation, il n'y a pas de layout mais on travaille dans le canvas
 * au démarrage, les composants sont placés "à la main", on n'utilise pas FXML
 * 
 * @author helen
 *
 */
public class JeuMulti extends JeuAnimationDevint {
	
	@Override
	public String titre() {
		return "multi joueur";
	}    
	
	@Override
	protected ControleAnimationDevint initControlAndScene() {
		Canvas c = new Canvas(ConstantesDevint.MAX_SCREEN_WIDTH,ConstantesDevint.MAX_SCREEN_HEIGHT);
		Group root = new Group(c);
		SceneDevint sc = new SceneDevint(root);
		control = new JeuMultiControl(sc);
		return control;
	}

	@Override
	protected ModeleAnimationDevint initModel() {
		return new JeuMultiModel();
	}

}
