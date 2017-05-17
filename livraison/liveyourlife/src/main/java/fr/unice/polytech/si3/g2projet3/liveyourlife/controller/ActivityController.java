package fr.unice.polytech.si3.g2projet3.liveyourlife.controller;

import dvt.jeu.simple.ControleDevint;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.ChronoAction;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.util.Duration;

import java.io.IOException;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public abstract class ActivityController extends ControleDevint {

    public void win() {
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(500),
                ae -> displayWin()));
        timeline.play();
    }

    private void displayWin() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent rootNode = null;
        try {
            rootNode = fxmlLoader.load(getClass().getResourceAsStream("/fxml/win.fxml"));
            getScene().setRoot(rootNode);
        } catch (IOException e) {
            e.printStackTrace();
        }
        scene.getSIVox().playText("bravo tu as réussi");

    }

}
