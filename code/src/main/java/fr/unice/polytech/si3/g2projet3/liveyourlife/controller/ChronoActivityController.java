package fr.unice.polytech.si3.g2projet3.liveyourlife.controller;

import fr.unice.polytech.si3.g2projet3.liveyourlife.model.Actions.ChronoAction;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.Activities.ChronoActivity;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.Answers.ChronoAnswer;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
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
    public ListView<ChronoAnswer> pickedActions;


    @Override
    protected void init() {
        ObservableList<ChronoAction> possibleActions =  ((ChronoActivity) model).getPossibleChoices();
        ObservableList<ChronoAnswer> answers =  ((ChronoActivity) model).getAnswers();
        initPossibleActions(possibleActions);
        initAnswers(answers);
    }

    private void initAnswers(ObservableList<ChronoAnswer> answers) {
        pickedActions.setPrefHeight(325);
        pickedActions.setEditable(false);
        pickedActions.setCellFactory(
                new Callback<ListView<ChronoAnswer>, ListCell<ChronoAnswer>>() {
                    public ListCell<ChronoAnswer> call(ListView<ChronoAnswer> listView) {
                        return new ListCell<ChronoAnswer>() {
                            protected void updateItem(ChronoAnswer choice, boolean empty) {
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
        pickedActions.setItems(answers);
    }

    /**
     * Initialize the list view containing the possible actions
     * @param possibleActions the different choices the player have.
     */
    private void initPossibleActions(ObservableList<ChronoAction> possibleActions) {
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
        availableActions.setItems(possibleActions);
    }

    @Override
    protected void reset() {

    }

    @Override
    public void mapTouchToActions() {

    }
}
