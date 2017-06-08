package fr.unice.polytech.si3.g2projet3.liveyourlife.controller;

import dvt.devint.SceneDevint;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ShuffleWinController {

    @FXML
    public Label activityName;

    @FXML
    public Label winText;

    @FXML
    public Label bestText;

    @FXML
    public ImageView finalImage;

    private SceneDevint scene;

    public void setText(String activityName) {
        this.activityName.setText(activityName);
        winText.setPrefWidth(scene.getWidth() * 3.0 / 4.0);
    }

    public void setScene(SceneDevint scene) {
        this.scene = scene;
    }

    public void setBestText(String bestText) {
        this.bestText.setText(bestText);
    }

    public void setFinalImage(Image finalImage) {
        this.finalImage.setImage(finalImage);
        this.finalImage.setFitHeight(scene.getHeight() / 2.0);
    }
}
