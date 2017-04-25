package fr.unice.polytech.si3.g2projet3.liveyourlife.controller;

import dvt.devint.ConstantesDevint;
import dvt.devint.SceneDevint;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.ChronoAction;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.ChronoActivity;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Cell;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.util.Callback;
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
        availableActions.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ChronoAction>() {

            @Override
            public void changed(ObservableValue<? extends ChronoAction> observable, ChronoAction oldValue, ChronoAction newValue) {
                int newIndexByMouse = availableActions.getSelectionModel().getSelectedIndex();
                ((ChronoActivity) model).updateSelectedIndex(newIndexByMouse);
            }
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
    }


    private void choose() {
        System.out.println("choose");
        int newIndex = ((ChronoActivity) model).answerSelectedAction();
        availableActions.getSelectionModel().select(newIndex);
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
