package fr.unice.polytech.si3.g2projet3.liveyourlife.common;

import dvt.devint.ConstantesDevint;
import dvt.devint.SceneDevint;
import dvt.jeu.simple.ControleDevint;
import dvt.jeu.simple.JeuDevint;
import dvt.jeu.simple.ModeleDevint;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.Action;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.MultiChoiceList;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.ShuffleActivity;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.Arrays;
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
        List<Action> bottom = new LinkedList<>();
        Action correct1 = new Action("Short", "/images/activity/shabiller_soleil/1_short.jpg");
        bottom.add(correct1);
        bottom.add(new Action("Pantalon", "/images/activity/shabiller_soleil/1_pantalon.jpg"));

        List<Action> top = new LinkedList<>();
        Action correct2 = new Action("Tee-shirt", "/images/activity/shabiller_soleil/2_tee.jpg");
        top.add(correct2);
        top.add(new Action("Veste", "/images/activity/shabiller_soleil/2_veste.jpg"));
        top.add(new Action("Polaire", "/images/activity/shabiller_soleil/2_polaire.jpg"));
        top.add(new Action("K-way", "/images/activity/shabiller_soleil/2_kway.jpg"));

        List<Action> head = new LinkedList<>();
        Action correct3 = new Action("Chapeau", "/images/activity/shabiller_soleil/3_chapeau.jpg");
        head.add(correct3);
        head.add(new Action("Bonnet", "/images/activity/shabiller_soleil/3_bonnet.jpg"));

        Queue<List<Action>> answersList = new LinkedList<>();
        answersList.add(bottom);
        answersList.add(top);
        answersList.add(head);

        List<Action> tmp = new LinkedList<>();
        tmp.add(correct1);
        tmp.add(correct2);
        tmp.add(correct3);

        MultiChoiceList<Action> correctChoices = new MultiChoiceList<>(Arrays.asList(tmp));

        List<String> currentStateImages = new LinkedList<>();
        currentStateImages.add("/images/activity/default.jpg");
        currentStateImages.add("/images/activity/shabiller_soleil/1_short.jpg");
        currentStateImages.add("/images/activity/shabiller_soleil/2_tee.jpg");

        shuffleActivity = new ShuffleActivity(titre(), answersList, correctChoices,
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

        control.setModel(model);

        control.setScene(sceneDevint);


        return control;
    }
}
