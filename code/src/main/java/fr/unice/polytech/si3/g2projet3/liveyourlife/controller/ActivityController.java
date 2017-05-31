package fr.unice.polytech.si3.g2projet3.liveyourlife.controller;

import dvt.jeu.simple.ControleDevint;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.util.Duration;

import java.io.IOException;

/**
 * @author Coconut team.
 */
public abstract class ActivityController extends ControleDevint {

    public void win() {
        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(500),
                ae -> displayWin()));
        timeline.play();
    }

    protected abstract void displayWin();

}
