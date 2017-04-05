package fr.unice.polytech.si3.g2projet3.liveyourlife.controller;

import dvt.devint.ConstantesDevint;
import dvt.devint.SceneDevint;
import dvt.jeu.simple.ControleDevint;
import dvt.jeu.simple.JeuDevint;
import dvt.jeu.simple.ModeleDevint;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.ChronoActivity;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

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
        // création de la scene et du controleur
        SceneDevint sc = null;
        FXMLLoader loader = new FXMLLoader();
        String FXMLfileName = ConstantesDevint.packageFileName("fxml/chronoActivity.fxml");
        try {
            loader.setLocation(new URL(FXMLfileName));
        } catch (MalformedURLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            AnchorPane root = (AnchorPane)loader.load();
            sc = new SceneDevint(root,ConstantesDevint.MAX_SCREEN_WIDTH,ConstantesDevint.MAX_SCREEN_HEIGHT);
            control = loader.getController();
            control.setScene(sc);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return control;
    }
}
