package fr.unice.polytech.si3.g2projet3.liveyourlife.common;

import dvt.devint.ConstantesDevint;
import dvt.devint.SceneDevint;
import dvt.jeu.simple.ControleDevint;
import dvt.jeu.simple.JeuDevint;
import dvt.jeu.simple.ModeleDevint;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.ChronoAction;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.ChronoActivity;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.KeyCode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller of the Chrono Activity
 *
 * @author Joël CANCELA VAZ
 */
public class JeuChrono extends JeuDevint {


    private ChronoActivity chronoActivity;

    public JeuChrono() {
    }

    @Override
    public String titre() {
        return "Se brosser les dents";
    }

    @Override
    protected ModeleDevint initModel() {
        List<ChronoAction> answers = new ArrayList<>();
        answers.add(new ChronoAction("mettre le dentifrice sur la brosse à dent","/images/activity/se_brosser_les_dents/dentifrice.jpg"));
        answers.add(new ChronoAction("se brosser les dents","/images/activity/se_brosser_les_dents/brosse_a_dent.jpg"));
        answers.add(new ChronoAction("remplir un verre d'eau","/images/activity/se_brosser_les_dents/remplir_verre.jpg"));
        answers.add(new ChronoAction("se rincer les dents","/images/activity/se_brosser_les_dents/rincer_dents.jpg"));
        chronoActivity = new ChronoActivity(titre(),answers);
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
        sceneDevint.getStylesheets().add("/styles/style.css");
        sceneDevint.getSIVox().stop();
        control = fxmlLoader.getController();

        control.setModel(initModel());

        control.setScene(sceneDevint);


        return control;
    }
}
