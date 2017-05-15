package fr.unice.polytech.si3.g2projet3.liveyourlife.controller;

import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.Action;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class ActivityChoiceController {
    @FXML
    public ImageView image;

    public void init(Action choice) {
        image.setImage(choice.getImage());
    }
}
