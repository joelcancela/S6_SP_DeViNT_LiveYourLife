package fr.unice.polytech.si3.g2projet3.liveyourlife.controller;

import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.ChronoAction;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.ShuffleAction;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.ChronoActivity;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.ShuffleActivity;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.IOException;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public class ShuffleActivityController extends ActivityController {
    @FXML
    public Text activityName;
    @FXML
    public ImageView contextImage;
    @FXML
    public ImageView currentStateImage;
    @FXML
    public ListView<ShuffleAction> availableActions;
    @FXML
    public Text actionType;

    @Override
    protected void init() {
        activityName.setText(((ShuffleActivity) model).getTitle());
        ((ShuffleActivity) model).setSIVOXInstance(scene.getSIVox());
    }

    private void initPossibleActions() {
        availableActions.setPrefHeight(325);
        availableActions.setEditable(false);
        availableActions.setCellFactory(listView -> new ShuffleCell());
        availableActions.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            int newIndexByMouse = availableActions.getSelectionModel().getSelectedIndex();
            ((ShuffleActivity) model).updateSelectedIndex(newIndexByMouse);
        });
        availableActions.setItems(((ShuffleActivity) model).getPossibleChoices());
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
        int newIndex = ((ShuffleActivity) model).answerSelectedAction();
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
        int newIndex = ((ShuffleActivity) model).chooseRight();
        availableActions.getSelectionModel().select(newIndex);
    }

    private void left() {
        int newIndex = ((ShuffleActivity) model).chooseLeft();
        availableActions.getSelectionModel().select(newIndex);

    }

    private class ShuffleCell extends ListCell<ShuffleAction> {
        protected void updateItem(ShuffleAction choice, boolean empty) {
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
                        ((ShuffleActivityChoiceController) loader.getController()).init(choice);
                        this.setGraphic(listElement);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
