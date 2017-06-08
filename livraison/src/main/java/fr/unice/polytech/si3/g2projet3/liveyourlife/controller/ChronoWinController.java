package fr.unice.polytech.si3.g2projet3.liveyourlife.controller;

import dvt.devint.SceneDevint;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.Action;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

import java.util.List;

public class ChronoWinController {

    @FXML
    public Label activityName;

    @FXML
    public ListView<ImageView> actions;

    @FXML
    public Label winText;

    @FXML
    public Label bestText;

    private SceneDevint scene;

    public void setText(String activityName) {
        this.activityName.setText(activityName);
        winText.setPrefWidth(scene.getWidth() * 3.0 / 4.0);
    }

    public void setActions(List<Action> actions) {

        double nb_elements = actions.size();
        double width = scene.getWidth() * 4.0 / 5.0;
        double image_size = width / nb_elements;

        this.actions.setMaxWidth(image_size * nb_elements + 6);
        this.actions.setPrefHeight(image_size + 6);

        ObservableList<ImageView> images = FXCollections.observableArrayList();
        for (Action a : actions) {
            ImageView imageView = new ImageView(a.getImage());
            imageView.setPreserveRatio(true);
            imageView.setFitHeight(image_size);
            imageView.setFitWidth(image_size);
            images.add(imageView);
        }

        this.actions.setItems(images);
        this.actions.setEditable(false);
    }

    public void setScene(SceneDevint scene) {
        this.scene = scene;
    }

    public void setBestText(String bestText) {
        this.bestText.setText(bestText);
    }
}
