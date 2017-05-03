package fr.unice.polytech.si3.g2projet3.liveyourlife.common;

import dvt.devint.ConstantesDevint;
import dvt.devint.SceneDevint;
import dvt.jeu.simple.ControleDevint;
import dvt.jeu.simple.JeuDevint;
import dvt.jeu.simple.ModeleDevint;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.ChronoAction;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.MultiChoiceList;
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

        ChronoAction ouvrir_robinet = new ChronoAction("ouvrir le robinet","/images/activity/washHands/openTap.jpg");
        ChronoAction mouiller_mains = new ChronoAction("se mouiller les mains","/images/activity/washHands/wetHands.jpg");
        ChronoAction prendre_savon = new ChronoAction("prendre du savon","/images/activity/washHands/takeSoap.jpg");
        ChronoAction frotter_mains = new ChronoAction("se frotter les mains","/images/activity/washHands/frotterMains.jpg");
        ChronoAction rincer_mains = new ChronoAction("se rincer les mains","/images/activity/washHands/rincerMains.jpg");
        ChronoAction fermer_robinet = new ChronoAction("fermer le robinet","/images/activity/washHands/closeTap.jpg");
        ChronoAction secher_mains = new ChronoAction("se sécher les mains","/images/activity/washHands/secherMains.jpg");
        List<ChronoAction> optimalWay = new ArrayList<>();
        optimalWay.add(ouvrir_robinet);
        optimalWay.add(mouiller_mains);
        optimalWay.add(prendre_savon);
        optimalWay.add(frotter_mains);
        optimalWay.add(rincer_mains);
        optimalWay.add(fermer_robinet);
        optimalWay.add(secher_mains);
        List<ChronoAction> secondWay = new ArrayList<>();
        secondWay.add(ouvrir_robinet);
        secondWay.add(mouiller_mains);
        secondWay.add(prendre_savon);
        secondWay.add(frotter_mains);
        secondWay.add(rincer_mains);
        secondWay.add(secher_mains);
        secondWay.add(fermer_robinet);
        List<List<ChronoAction>> allWays = new ArrayList<>();
        allWays.add(optimalWay);
        allWays.add(secondWay);
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
        SceneDevint sceneDevint = new SceneDevint(rootNode,ConstantesDevint.MAX_SCREEN_WIDTH, ConstantesDevint.MAX_SCREEN_HEIGHT);
        sceneDevint.getStylesheets().add("/styles/style.css");

        control = fxmlLoader.getController();

        control.setModel(initModel());

        control.setScene(sceneDevint);


        return control;
    }
}
