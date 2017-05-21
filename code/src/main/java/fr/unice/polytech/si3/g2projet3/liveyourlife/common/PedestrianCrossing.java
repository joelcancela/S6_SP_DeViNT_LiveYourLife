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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * {@code PedestrianCrossing} is [desc]
 * <p>
 * [descSuite]
 *
 * @author Joël CANCELA VAZ
 */
public class PedestrianCrossing extends JeuDevint {

	private ShuffleActivity shuffleActivity;

	public PedestrianCrossing() {
	}

	@Override
	public String titre() {
		return "Traverser la route";
	}

	@Override
	protected ModeleDevint initModel() {
		//Multi choice list
		Action pushButton = new Action("Appuyer sur le bouton", "/images/activity/crossTheStreet/1.jpg");
		Action wait = new Action("Attendre sur le trottoir", "/images/activity/crossTheStreet/2.jpg");
		Action walk = new Action("Traverser la route", "/images/activity/crossTheStreet/3.jpg");

		List<Action> correctAnswers = new LinkedList<>();
		correctAnswers.add(pushButton);
		correctAnswers.add(wait);
		correctAnswers.add(walk);

		List<List<Action>> choices = new ArrayList<>();
		choices.add(correctAnswers);

		MultiChoiceList<Action> correctChoices = new MultiChoiceList<>(choices);

		//QueueList<Action>
		List<Action> first = new LinkedList<>();
		first.add(pushButton);
		first.add(wait);
		first.add(walk);

		List<Action> second = new LinkedList<>();
		second.add(pushButton);
		second.add(wait);
		second.add(walk);

		List<Action> third = new LinkedList<>();
		third.add(pushButton);
		third.add(wait);
		third.add(walk);


		Queue<List<Action>> answersList = new LinkedList<>();
		answersList.add(first);
		answersList.add(second);
		answersList.add(third);

		List<String> currentStateImages = new LinkedList<>();
		currentStateImages.add("/images/activity/crossTheStreet/redlight.jpg");
		currentStateImages.add("/images/activity/crossTheStreet/greenlight.jpg");
		currentStateImages.add("/images/activity/crossTheStreet/greenlight.jpg");

		shuffleActivity = new ShuffleActivity(titre(), answersList, correctChoices,
				currentStateImages, null);
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