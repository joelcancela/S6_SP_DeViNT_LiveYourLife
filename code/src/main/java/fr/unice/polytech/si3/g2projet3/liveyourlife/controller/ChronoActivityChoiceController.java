package fr.unice.polytech.si3.g2projet3.liveyourlife.controller;

import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.ChronoAction;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

/**
 * Created by Antoine Dezarnaud on 10/04/2017.
 */
public class ChronoActivityChoiceController {
    @FXML
    public ImageView image;

    public void init(ChronoAction choice) {
        image.setImage(choice.getImage());
        image.setFitWidth(300);
    }
}
