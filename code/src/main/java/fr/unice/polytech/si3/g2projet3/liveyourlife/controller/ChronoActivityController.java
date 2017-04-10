package fr.unice.polytech.si3.g2projet3.liveyourlife.controller;

import com.sun.org.apache.xpath.internal.SourceTree;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.ChronoAction;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.ChronoActivity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import javafx.util.Callback;

import javax.swing.text.Element;
import javax.swing.text.html.ImageView;
import java.io.IOException;
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
    public ListView availableActions;
    @FXML
    public ListView pickedActions;


    @Override
    protected void init() {
        List<ChronoAction> possibleActions =  ((ChronoActivity) model).getPossibleChoices();
        ObservableList<ChronoAction> list = FXCollections.observableArrayList(possibleActions);
        availableActions.setPrefHeight(325);
        availableActions.setEditable(false);
        availableActions.setCellFactory(
                new Callback<ListView<ChronoAction>, ListCell<ChronoAction>>() {
                    public ListCell<ChronoAction> call(ListView<ChronoAction> listView) {
                        return new ListCell<ChronoAction>() {
                            protected void updateItem(ChronoAction choice, boolean empty) {
                                if (choice != null) {
                                    try {
                                        String fxmlFile = "/fxml/Activity_Element.fxml";
                                        FXMLLoader loader = new FXMLLoader();
                                        Parent listElement = loader.load(getClass().getResourceAsStream(fxmlFile));
                                        ((ChronoActivityChoiceController) loader.getController()).init(choice);
                                        this.setGraphic(listElement);
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        };
                    }
                }
        );
        availableActions.setItems(list);
    }

    @Override
    protected void reset() {

    }

    @Override
    public void mapTouchToActions() {

    }
}
