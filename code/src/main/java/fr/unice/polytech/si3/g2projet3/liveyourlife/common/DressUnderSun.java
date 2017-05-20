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
import java.util.*;

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
    	//Multi choice list
	    Action shortAction = new Action("Short", "/images/activity/shabiller_soleil/1_short.jpg");
	    Action pantalonAction = new Action("Pantalon", "/images/activity/shabiller_soleil/1_pantalon.jpg");
	    Action tshirt = new Action("Tee-shirt", "/images/activity/shabiller_soleil/2_tee.jpg");
	    Action veste = new Action("Veste", "/images/activity/shabiller_soleil/2_veste.jpg");
	    Action polaire =new Action("Polaire", "/images/activity/shabiller_soleil/2_polaire.jpg");
	    Action kway = new Action("K-way", "/images/activity/shabiller_soleil/2_kway.jpg");
	    Action chapeau = new Action("Chapeau", "/images/activity/shabiller_soleil/3_chapeau.jpg");
	    Action bonnet = new Action("Bonnet", "/images/activity/shabiller_soleil/3_bonnet.jpg");

	    List<Action> correctAnswers = new LinkedList<>();
	    correctAnswers.add(shortAction);
	    correctAnswers.add(tshirt);
	    correctAnswers.add(chapeau);

	    List<List<Action>> choices = new ArrayList<>();
	    choices.add(correctAnswers);

	    MultiChoiceList<Action> correctChoices = new MultiChoiceList<>(choices);

		//QueueList<Action>
        List<Action> bottom = new LinkedList<>();
        bottom.add(shortAction);
        bottom.add(pantalonAction);

        List<Action> top = new LinkedList<>();
        top.add(tshirt);
        top.add(veste);
        top.add(polaire);
        top.add(kway);

        List<Action> head = new LinkedList<>();
	    head.add(bonnet);
	    head.add(chapeau);

        Queue<List<Action>> answersList = new LinkedList<>();
        answersList.add(bottom);
        answersList.add(top);
        answersList.add(head);

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
