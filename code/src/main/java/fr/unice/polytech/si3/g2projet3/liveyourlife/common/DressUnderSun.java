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
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by user on 10/04/2017.
 */
public class DressUnderSun extends JeuDevint {

    private ShuffleActivity shuffleActivity;

    public DressUnderSun() {
    }

    @Override
    public String titre() {
        return "S'habiller";
    }

    @Override
    protected ModeleDevint initModel() {
        List<ShuffleAction> bottom = new LinkedList<>();
        ShuffleAction correct1 = new ShuffleAction("Short", "/images/activity/shabiller_soleil/1_short.jpg");
        bottom.add(correct1);
        bottom.add(new ShuffleAction("Pantalon", "/images/activity/shabiller_soleil/1_pantalon.jpg"));

        List<ShuffleAction> top = new LinkedList<>();
        ShuffleAction correct2 = new ShuffleAction("Tee-shirt", "/images/activity/shabiller_soleil/2_tee.jpg");
        top.add(correct2);
        top.add(new ShuffleAction("Veste", "/images/activity/shabiller_soleil/2_veste.jpg"));
        top.add(new ShuffleAction("Polaire", "/images/activity/shabiller_soleil/2_polaire.jpg"));
        top.add(new ShuffleAction("K-way", "/images/activity/shabiller_soleil/2_kway.jpg"));

        List<ShuffleAction> head = new LinkedList<>();
        ShuffleAction correct3 = new ShuffleAction("Chapeau", "/images/activity/shabiller_soleil/3_chapeau.jpg");
        head.add(correct3);
        head.add(new ShuffleAction("Bonnet", "/images/activity/shabiller_soleil/3_bonnet.jpg"));

        List<List<ShuffleAction>> answers = new LinkedList<>();
        answers.add(bottom);
        answers.add(top);
        answers.add(head);

        List<ShuffleAction> correctChoices = new LinkedList<>();
        correctChoices.add(correct1);
        correctChoices.add(correct2);
        correctChoices.add(correct3);

        List<String> currentStateImages = new LinkedList<>();
        currentStateImages.add("/images/activity/default.jpg");
        currentStateImages.add("/images/activity/shabiller_soleil/1_short.jpg");
        currentStateImages.add("/images/activity/shabiller_soleil/2_tee.jpg");

        shuffleActivity = new ShuffleActivity(titre(), (Queue) answers, correctChoices,
                currentStateImages, "/images/activity/shabiller_soleil/contexte.png");
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
