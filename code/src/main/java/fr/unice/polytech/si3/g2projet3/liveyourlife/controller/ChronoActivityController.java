package fr.unice.polytech.si3.g2projet3.liveyourlife.controller;

import com.sun.org.apache.xpath.internal.SourceTree;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.ChronoAction;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.ChronoActivity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;

import javax.swing.text.Element;
import javax.swing.text.html.ImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Controller of the Chrono Activity
 *
 * @author Joël CANCELA VAZ
 */
public class ChronoActivityController extends ActivityController {

    @FXML
    public Text activityName;
    @FXML
    public TilePane<ImageView> availableActions;
    @FXML
    public ListView pickedActions;


    @Override
    protected void init() {
//        List<ChronoAction> possibleActions =  ((ChronoActivity) model).getPossibleChoices();
//
//        ObservableList<ImageView> observableList = FXCollections.observableArrayList();
//
//        List<ImageView> images = new ArrayList<>();
//        possibleActions.forEach(action->
//                images.add(
//                        new ImageView((Element)action.getImage())
//                ));
//        images.forEach(image->observableList.add(image));
//        availableActions.getChildren().addAll(observableList);
        //TODO AFFICHER LISTE DES ACTIONS POSSIBLES
    }

    @Override
    protected void reset() {

    }

    @Override
    public void mapTouchToActions() {

    }
}
