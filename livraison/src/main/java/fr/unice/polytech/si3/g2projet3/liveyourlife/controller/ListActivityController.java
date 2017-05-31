package fr.unice.polytech.si3.g2projet3.liveyourlife.controller;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.Action;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.Activity;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.IndexedCell;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;

import java.io.IOException;

/**
 * @author Coconut team.
 */
public abstract class ListActivityController extends ActivityController{
    @FXML
    public Label activityName;
    @FXML
    public Label activityDescription;
    @FXML
    public ListView<Action> availableActions;

    //used to know how many items are visible on list
    protected VirtualFlow availableActionFlow;

    @Override
    protected void init() {
        activityName.setText(((Activity) model).getTitle());
        ((Activity) model).setSIVOXInstance(scene.getSIVox());
        ObservableList<Action> possibleActions =  ((Activity) model).getPossibleChoices();
        initPossibleActions(possibleActions);
        availableActions.getSelectionModel().select(0);
    }

    private void initPossibleActions(ObservableList<Action> possibleActions) {
        int nb_elements = Math.min(5,possibleActions.size());
        float margin_percentage = 1f/10f;
        double size_slot = Math.min(((this.getScene().getWidth()/(float)nb_elements)),getScene().getHeight()/2.5f);
        double size_item = size_slot-(2*margin_percentage*size_slot);
        availableActions.setPrefHeight(size_slot+margin_percentage*size_item);
        availableActions.setEditable(false);
        availableActions.setCellFactory(listView -> new Cell(size_item, (margin_percentage*size_slot)));
        //Selection Change listener
        availableActions.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(newValue!=null){
                activityDescription.setText(newValue.getDescription());
                availableActionFlow = (VirtualFlow) availableActions.lookup( ".virtual-flow");
                scene.getSIVox().playText(newValue.getDescription());
            }
        });
        availableActions.setItems(((Activity) model).getPossibleChoices());
        availableActions.getSelectionModel().selectFirst();
        availableActions.setOnMouseClicked(event -> choose());
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

    protected abstract void choose();

    private void right() {
        availableActions.getSelectionModel().selectNext();
        IndexedCell last = availableActionFlow.getLastVisibleCellWithinViewPort();
        IndexedCell first = availableActionFlow.getFirstVisibleCellWithinViewPort();
        if(last.getIndex()<availableActions.getSelectionModel().getSelectedIndex()){
            availableActions.scrollTo(first.getIndex()+1);
        }
    }

    private void left() {
        availableActions.getSelectionModel().selectPrevious();
        IndexedCell first = availableActionFlow.getFirstVisibleCellWithinViewPort();
        if(first.getIndex()>availableActions.getSelectionModel().getSelectedIndex()-1){
            availableActions.scrollTo(first.getIndex()-1);
        }
    }

    protected class Cell extends ListCell<Action> {
        private Parent listElement = null;
        private ActivityChoiceController controller;

        public Cell() {
            String fxmlFile = "/fxml/Activity_Element.fxml";
            FXMLLoader loader = new FXMLLoader();
            try {
                this.listElement = loader.load(getClass().getResourceAsStream(fxmlFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.controller = loader.getController();
        }

        public Cell(double size, double margin) {
            this();
            controller.setSizeOfElement(size);
            controller.setMarginOfElement(margin);
        }

        protected void updateItem(Action choice, boolean empty) {
            super.updateItem(choice,empty);
            if(empty){
                this.setGraphic(null);
            }
            else {
                if (choice != null) {
                    controller.init(choice);
//                    System.out.println(controller.getMarginOfElement());
//                    System.out.println(controller.getSizeOfElement());
                    this.setGraphic(listElement);
                }
            }
        }

        public double getSizeOfElement() {
            return controller.getSizeOfElement();
        }

        public double getMarginOfElement() {
            return controller.getMarginOfElement();
        }
    }
}
