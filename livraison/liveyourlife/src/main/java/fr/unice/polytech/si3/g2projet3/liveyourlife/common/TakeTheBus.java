package fr.unice.polytech.si3.g2projet3.liveyourlife.common;

import dvt.devint.ConstantesDevint;
import dvt.devint.SceneDevint;
import dvt.jeu.simple.ControleDevint;
import dvt.jeu.simple.JeuDevint;
import dvt.jeu.simple.ModeleDevint;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.Action;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.MultiChoiceList;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.ChronoActivity;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * {@code TakeTheBus} is [desc]
 * <p>
 * [descSuite]
 *
 * @author Joël CANCELA VAZ
 */
public class TakeTheBus extends JeuDevint {


	private ChronoActivity chronoActivity;

	public TakeTheBus() {
    }

	@Override
	public String titre() {
		return "Prendre le bus";
	}

	@Override
	protected ModeleDevint initModel() {
		Action attendre_arret = new Action("Attendre à l'arrêt de bus","/images/activity/takeTheBus/1.jpg");
		Action monter_bus = new Action("Monter dans le bus","/images/activity/takeTheBus/2.jpg");
		Action payer_un_ticket = new Action("Prendre un ticket de bus","/images/activity/takeTheBus/3.jpg");
		Action appuyer_stop = new Action("Appuyer sur le bouton stop avant l'arrêt","/images/activity/takeTheBus/4.jpg");
		Action attendre_bus_arret = new Action("Attendre que le bus s'arrête","/images/activity/takeTheBus/5.jpg");
		Action sortir_bus = new Action("Sortir du bus","/images/activity/takeTheBus/6.jpg");
		List<Action> optimalWay = new ArrayList<>();
		optimalWay.add(attendre_arret);
		optimalWay.add(monter_bus);
		optimalWay.add(payer_un_ticket);
		optimalWay.add(appuyer_stop);
		optimalWay.add(attendre_bus_arret);
		optimalWay.add(sortir_bus);
		List<List<Action>> allWays = new ArrayList<>();
		allWays.add(optimalWay);
		MultiChoiceList multiChoiceList = new MultiChoiceList(allWays);
		chronoActivity = new ChronoActivity(titre(),multiChoiceList);
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
		SceneDevint sceneDevint = new SceneDevint(rootNode, ConstantesDevint.MAX_SCREEN_WIDTH, ConstantesDevint.MAX_SCREEN_HEIGHT);
		sceneDevint.getStylesheets().add("/styles/style.css");
		control = fxmlLoader.getController();

		control.setModel(model);

		control.setScene(sceneDevint);


		return control;
	}
}