package fr.unice.polytech.si3.g2projet3.liveyourlife.controller;

import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.ChronoAction;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.ChronoActivity;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import javafx.util.Callback;

import java.io.IOException;

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
        ObservableList<ChronoAction> possibleActions =  ((ChronoActivity) model).getPossibleChoices();
        ObservableList<ChronoAction> answers =  ((ChronoActivity) model).getAnswers();
        initPossibleActions(possibleActions);
        initAnswers(answers);
    }

    private void initAnswers(ObservableList<ChronoAction> answers) {
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
        scene.mapKeyPressedToConsumer(KeyCode.LEFT, (x) -> left());
        scene.mapKeyPressedToConsumer(KeyCode.RIGHT, (x) -> right());
        scene.mapKeyPressedToConsumer(KeyCode.SPACE, (x) -> choose());
    }


    private void choose() {
        System.out.println("choose");
        ((ChronoActivity) model).answerSelectedAction();
    }

    private void right() {
        System.out.println("right!!!!!");
        ((ChronoActivity) model).chooseRight();
    }

    private void left() {
        System.out.println("left!!!!!");
        ((ChronoActivity) model).chooseLeft();
    }


}
