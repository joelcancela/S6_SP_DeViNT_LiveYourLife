package fr.unice.polytech.si3.g2projet3.liveyourlife.controller;

import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.Action;
import javafx.scene.image.ImageView;

/**
 * @author Coconut team.
 */
public class ChronoActivityChoiceController {
    public ImageView image;

    public void init(Action choice) {
        image.setImage(choice.getImage());
        image.setFitWidth(200);
    }
}
