package fr.unice.polytech.si3.g2projet3.liveyourlife.controller;

import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.ChronoAction;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.ChronoActivity;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
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
    public Label activityName;
    @FXML
    public ListView<ChronoAction> availableActions;
    @FXML
    public ListView<ChronoAction> pickedActions;


    @Override
    protected void init() {
        activityName.setText(((ChronoActivity) model).getTitle());
        ObservableList<ChronoAction> possibleActions =  ((ChronoActivity) model).getPossibleChoices();
        ObservableList<ChronoAction> answers =  ((ChronoActivity) model).getAnswers();
        initPossibleActions(possibleActions);
        initAnswers(answers);
        availableActions.getSelectionModel().select(0);

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
                                super.updateItem(choice,empty);
                                if(empty){
                                    this.setGraphic(null);
                                }
                                else {
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
        int newIndex = ((ChronoActivity) model).answerSelectedAction();
        availableActions.getSelectionModel().select(newIndex);

    }

    private void right() {
        System.out.println("right!!!!!");
        int newIndex = ((ChronoActivity) model).chooseRight();
        availableActions.getSelectionModel().select(newIndex);
//        System.out.println(availableActions.getItems());
    }

    private void left() {
        System.out.println("left!!!!!");
        int newIndex = ((ChronoActivity) model).chooseLeft();
//        System.out.println(availableActions.getItems());
        availableActions.getSelectionModel().select(newIndex);

    }


}
