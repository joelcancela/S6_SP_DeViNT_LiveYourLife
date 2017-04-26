package fr.unice.polytech.si3.g2projet3.liveyourlife.controller;

import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.ChronoAction;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.ChronoActivity;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

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
        ((ChronoActivity) model).setSIVOXInstance(scene.getSIVox());
        ObservableList<ChronoAction> possibleActions =  ((ChronoActivity) model).getPossibleChoices();
        ObservableList<ChronoAction> answers =  ((ChronoActivity) model).getAnswers();
        initPossibleActions(possibleActions);
        initAnswers(answers);
        availableActions.getSelectionModel().select(0);

    }

    private void initAnswers(ObservableList<ChronoAction> answers) {
        pickedActions.setPrefHeight(325);
        pickedActions.setEditable(false);
        pickedActions.setCellFactory(listView -> new ChronoCell());
        pickedActions.setItems(answers);

    }

    private class ChronoCell extends ListCell<ChronoAction> {
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
    }

    /**
     * Initialize the list view containing the possible actions
     * @param possibleActions the different choices the player have.
     */
    private void initPossibleActions(ObservableList<ChronoAction> possibleActions) {
        availableActions.setPrefHeight(325);
        availableActions.setEditable(false);
        availableActions.setCellFactory(listView -> new ChronoCell());
        availableActions.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            int newIndexByMouse = availableActions.getSelectionModel().getSelectedIndex();
            ((ChronoActivity) model).updateSelectedIndex(newIndexByMouse);
        });
        availableActions.setItems(possibleActions);
        availableActions.getSelectionModel().selectFirst();
    }

    @Override
    protected void reset() {

    }

    @Override
    public void mapTouchToActions() {
        scene.mapKeyPressedToConsumer(KeyCode.LEFT, (x) -> left());
        scene.mapKeyPressedToConsumer(KeyCode.RIGHT, (x) -> right());
        scene.mapKeyPressedToConsumer(KeyCode.SPACE, (x) -> choose());
        scene.mapKeyPressedToConsumer(KeyCode.ENTER, (x) -> choose());
    }


    private void choose() {
        System.out.println("choose");
        int newIndex = ((ChronoActivity) model).answerSelectedAction();
        availableActions.getSelectionModel().select(newIndex);
        int status = ((ChronoActivity) model).getStatus();
        if(status%5==0)pickedActions.scrollTo(status);
        if(availableActions.getItems().isEmpty()){
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(1000),
                    ae -> scene.getSIVox().playText("bravo tu as réussi")));
            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent rootNode = null;
            try {
                rootNode = fxmlLoader.load(getClass().getResourceAsStream("/fxml/win.fxml"));
                getScene().setRoot(rootNode);
            } catch (IOException e) {
                e.printStackTrace();
            }
            timeline.play();
        }
    }

    private void right() {
        System.out.println("right!!!!!");
//        availableActions.getSelectionModel().selectNext();
        int newIndex = ((ChronoActivity) model).chooseRight();
        availableActions.getSelectionModel().select(newIndex);
        if(newIndex%5==0)availableActions.scrollTo(newIndex); // todo : c'est sale, à modifier pour mieux fonctionner
    }

    private void left() {
        System.out.println("left!!!!!");
//        availableActions.getSelectionModel().selectPrevious();
        int newIndex = ((ChronoActivity) model).chooseLeft();
        availableActions.getSelectionModel().select(newIndex);
        if(newIndex%5==0)availableActions.scrollTo(newIndex); // todo : c'est sale, à modifier pour mieux fonctionner

    }


}
