package fr.unice.polytech.si3.g2projet3.liveyourlife.common;

import dvt.devint.ConstantesDevint;
import dvt.devint.SceneDevint;
import dvt.jeu.simple.ControleDevint;
import dvt.jeu.simple.JeuDevint;
import dvt.jeu.simple.ModeleDevint;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.ShuffleAction;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.ShuffleActivity;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 10/04/2017.
 */
public class JeuShuffle extends JeuDevint {

    private ShuffleActivity shuffleActivity;

    public JeuShuffle() {
    }

    @Override
    public String titre() {
        return "S'habiller";
    }

    @Override
    protected ModeleDevint initModel() {
        List<ShuffleAction> answers = new ArrayList<>();
        answers.add(new ShuffleAction("Tee-shirt", "/images/activity/shabiller_soleil/tee.jpg"));
        answers.add(new ShuffleAction("Veste", "/images/activity/shabiller_soleil/veste.jpg"));
        answers.add(new ShuffleAction("Polaire", "/images/activity/shabiller_soleil/polaire.jpg"));
        answers.add(new ShuffleAction("K-way", "/images/activity/shabiller_soleil/kway.jpg"));
        shuffleActivity = new ShuffleActivity(titre(), answers, "/images/activity/shabiller_soleil/contexte.png");
        return shuffleActivity;
    }

    @Override
    protected ControleDevint initControlAndScene() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent rootNode = null;
        try {
            rootNode = fxmlLoader.load(getClass().getResourceAsStream("/fxml/shuffleActivity.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        SceneDevint sceneDevint = new SceneDevint(rootNode, ConstantesDevint.MAX_SCREEN_WIDTH, ConstantesDevint.MAX_SCREEN_HEIGHT);
        sceneDevint.getStylesheets().add("/styles/style.css");
        sceneDevint.getSIVox().stop();
        control = fxmlLoader.getController();

        control.setModel(initModel());

        control.setScene(sceneDevint);


        return control;
    }
}
