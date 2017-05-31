package fr.unice.polytech.si3.g2projet3.liveyourlife.controller;

import dvt.devint.SceneDevint;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ShuffleWinController {

    @FXML
    public Label activityName;

    @FXML
    public Label winText;

    private SceneDevint scene;

    public void setText(String activityName) {
        this.activityName.setText(activityName);
        winText.setPrefWidth(scene.getWidth() * 3.0 / 4.0);
    }

    public void setScene(SceneDevint scene) {
        this.scene = scene;
    }
}
