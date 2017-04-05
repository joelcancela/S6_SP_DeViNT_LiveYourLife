package fr.unice.polytech.si3.g2projet3.liveyourlife.controller;

import dvt.devint.ConstantesDevint;
import dvt.devint.SceneDevint;
import dvt.jeu.simple.ControleDevint;
import dvt.jeu.simple.JeuDevint;
import dvt.jeu.simple.ModeleDevint;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.ChronoActivity;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Controller of the Chrono Activity
 *
 * @author Joël CANCELA VAZ
 */
public class JeuChrono extends JeuDevint {

    private final ChronoActivity chronoActivity;

    public JeuChrono(ChronoActivity chronoActivity) {
        this.chronoActivity = chronoActivity;
    }

    @Override
    public String titre() {
        return "Jeu Chronologie";
    }

    @Override
    protected ModeleDevint initModel() {
        return chronoActivity;
    }

    @Override
    protected ControleDevint initControlAndScene() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent rootNode = null;
        try {
            rootNode = fxmlLoader.load(getClass().getResourceAsStream("/fxml/chronoActivity.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        SceneDevint sceneDevint = new SceneDevint(rootNode,ConstantesDevint.MAX_SCREEN_WIDTH, ConstantesDevint.MAX_SCREEN_HEIGHT);
        sceneDevint.getSIVox().stop();
        control = fxmlLoader.getController();
        control.setScene(sceneDevint);
        return control;
    }
}
