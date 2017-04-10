package fr.unice.polytech.si3.g2projet3.liveyourlife.controller;

import fr.unice.polytech.si3.g2projet3.liveyourlife.model.ChronoAction;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.ChronoActivity;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.util.Callback;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * Controller of the Chrono Activity
 *
 * @author Joël CANCELA VAZ
 */
public class ChronoActivityController extends ActivityController {

    @FXML
    public Text activityName;
    @FXML
    public ListView<ChronoAction> availableActions;
    @FXML
    public ListView<ChronoAction> pickedActions;


    @Override
    protected void init() {
        List<ChronoAction> possibleActions =  ((ChronoActivity) model).getPossibleChoices();
        initPossibleActions(possibleActions);
        initAnswers(possibleActions);
    }

    private void initAnswers(List<ChronoAction> possibleActions) {
        ObservableList<ChronoAction> list = FXCollections.observableArrayList(possibleActions);
        pickedActions.setPrefHeight(325);
        pickedActions.setEditable(false);
        pickedActions.setCellFactory(
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
        pickedActions.setItems(list);
    }

    /**
     * Initialize the list view containing the possible actions
     * @param possibleActions the different choices the player have.
     */
    private void initPossibleActions(List<ChronoAction> possibleActions) {
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
