package fr.unice.polytech.si3.g2projet3.liveyourlife.controller;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.Action;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.ShuffleActivity;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

import java.io.IOException;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public class ShuffleActivityController extends ActivityController {

    @FXML
    public Label activityName;
    @FXML
    public Label activityDescription;
    @FXML
    public ImageView contextImage;
    @FXML
    public ImageView currentStateImage;
    @FXML
    public ListView<Action> availableActions;

    //used to know how many items are visible on list
    private VirtualFlow flow;

    @Override
    protected void init() {
        activityName.setText(((ShuffleActivity) model).getTitle());
        ((ShuffleActivity) model).setSIVOXInstance(scene.getSIVox());
        initPossibleActions();
        contextImage.setImage(((ShuffleActivity) model).getContextImagePath());
        currentStateImage.setImage(((ShuffleActivity) model).getCurrentStateImagePath());
    }

    private void initPossibleActions() {
        availableActions.setEditable(false);
        availableActions.setCellFactory(listView -> new ShuffleCell());
        availableActions.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue!=null){
                activityDescription.setText(newValue.getDescription());
                flow = (VirtualFlow) availableActions.lookup( ".virtual-flow");
                scene.getSIVox().playText(newValue.getDescription());
            }
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
        Action selectedItem = availableActions.getSelectionModel().getSelectedItem();
        if(((ShuffleActivity) model).answerAction(selectedItem))
            win();
        else
            currentStateImage.setImage(((ShuffleActivity) model).getCurrentStateImagePath());
    }

    private void right() {
        availableActions.getSelectionModel().selectNext();
    }

    private void left() {
        availableActions.getSelectionModel().selectPrevious();
    }

    private class ShuffleCell extends ListCell<Action> {
        protected void updateItem(Action choice, boolean empty) {
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
                        ((ActivityChoiceController) loader.getController()).init(choice);
                        this.setGraphic(listElement);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
