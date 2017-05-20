package fr.unice.polytech.si3.g2projet3.liveyourlife.controller;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.Action;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.ChronoActivity;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
 * Controller of the Chrono Activity
 *
 * @author Joël CANCELA VAZ
 */
public class ChronoActivityController extends ActivityController {

    @FXML
    public Label activityName;
    @FXML
    public ListView<Action> availableActions;
    @FXML
    public ListView<Action> pickedActions;
    @FXML
    public Label activityDescription;

    //used to know how many items are visible on list
    private VirtualFlow flow;

    protected ObservableList<Action> answers;

    @Override
    protected void init() {
        activityName.setText(((ChronoActivity) model).getTitle());
        ((ChronoActivity) model).setSIVOXInstance(scene.getSIVox());
        ObservableList<Action> possibleActions =  ((ChronoActivity) model).getPossibleChoices();
        this.answers =  ((ChronoActivity) model).getAnswers();
        initPossibleActions();
        initAnswers(answers);
        availableActions.getSelectionModel().select(0);

    }

    private void initAnswers(ObservableList<Action> answers) {
        ChronoCell cell = new ChronoCell();
        pickedActions.setPrefHeight(cell.getSizeOfElement()+(cell.getMarginOfElement()*2.5));
        pickedActions.setEditable(false);
        pickedActions.setCellFactory(listView -> new ChronoCell());
        pickedActions.setItems(answers);

    }

    private class ChronoCell extends ListCell<Action> {
        private Parent listElement = null;
        private ActivityChoiceController controller;

        public ChronoCell() {
            String fxmlFile = "/fxml/Activity_Element.fxml";
            FXMLLoader loader = new FXMLLoader();
            try {
                this.listElement = loader.load(getClass().getResourceAsStream(fxmlFile));
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.controller = loader.getController();
        }

        public ChronoCell(int size, int margin) {
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
                    System.out.println(controller.getMarginOfElement());
                    System.out.println(controller.getSizeOfElement());
                    this.setGraphic(listElement);
                }
            }
        }

        public double getSizeOfElement() {
            return controller.getSizeOfElement();
        }

        public int getMarginOfElement() {
            return controller.getMarginOfElement();
        }
    }

    /**
     * Initialize the list view containing the possible actions
     */
    private void initPossibleActions() {

        int nb_elements = Math.min(5,answers.size());
        int margin = 50;
        int size_per_block =(int) ((this.getScene().getWidth()/nb_elements));
        availableActions.setPrefHeight(size_per_block+(2*margin));
        availableActions.setEditable(false);
        availableActions.setCellFactory(listView -> new ChronoCell(size_per_block-(2*margin),margin));
        //Selection Change listener
        availableActions.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Action>() {
            @Override
            public void changed(ObservableValue<? extends Action> observable, Action oldValue, Action newValue) {
                if(newValue!=null){
                    activityDescription.setText(newValue.getDescription());
                    flow = (VirtualFlow) availableActions.lookup( ".virtual-flow");
                    scene.getSIVox().playText(newValue.getDescription());
                }
            }
        });
        availableActions.setItems(((ChronoActivity) model).getPossibleChoices());
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
        Action selectedItem = availableActions.getSelectionModel().getSelectedItem();
        ((ChronoActivity) model).answerAction(selectedItem);

        if(availableActions.getItems().isEmpty()){
            win();
        }
    }

    private void right() {
        availableActions.getSelectionModel().selectNext();
        IndexedCell last = flow.getLastVisibleCellWithinViewPort();
        IndexedCell first = flow.getFirstVisibleCellWithinViewPort();
        if(last.getIndex()<availableActions.getSelectionModel().getSelectedIndex()){
            availableActions.scrollTo(first.getIndex()+1);
        }
    }

    private void left() {
        availableActions.getSelectionModel().selectPrevious();
        IndexedCell first = flow.getFirstVisibleCellWithinViewPort();
        if(first.getIndex()>availableActions.getSelectionModel().getSelectedIndex()-1){
            availableActions.scrollTo(first.getIndex()-1);
        }
    }
}
