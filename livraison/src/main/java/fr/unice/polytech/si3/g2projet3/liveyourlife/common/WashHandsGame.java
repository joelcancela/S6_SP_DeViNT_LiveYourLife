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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller of the Chrono Activity
 *
 * @author Joël CANCELA VAZ
 */
public class WashHandsGame extends JeuDevint {


    private ChronoActivity chronoActivity;

    public WashHandsGame() {
    }

    @Override
    public String titre() {
        return "Se laver les mains";
    }

    @Override
    protected ModeleDevint initModel() {
        List<ChronoAction> answers = new ArrayList<>();
        answers.add(new ChronoAction("ouvrir le robinet","/images/activity/washHands/openTap.jpg"));
        answers.add(new ChronoAction("se mouiller les mains","/images/activity/washHands/wetHands.jpg"));
        answers.add(new ChronoAction("prendre du savon","/images/activity/washHands/takeSoap.jpg"));
        answers.add(new ChronoAction("se frotter les mains","/images/activity/washHands/frotterMains.jpg"));
        answers.add(new ChronoAction("se rincer les mains","/images/activity/washHands/rincerMains.jpg"));
        answers.add(new ChronoAction("fermer le robinet","/images/activity/washHands/closeTap.jpg"));
        answers.add(new ChronoAction("se sécher les mains","/images/activity/washHands/secherMains.jpg"));
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

        control = fxmlLoader.getController();

        control.setModel(initModel());

        control.setScene(sceneDevint);


        return control;
    }
}
