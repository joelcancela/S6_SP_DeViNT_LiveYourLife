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
public class ChronoActivityController extends ListActivityController {

    @FXML
    public ListView<Action> pickedActions;

    protected ObservableList<Action> answers;

    @Override
    protected void init() {
        super.init();
        this.answers =  ((ChronoActivity) model).getAnswers();
        initAnswers(answers);
    }

    private void initAnswers(ObservableList<Action> answers) {
        Cell cell = new Cell();
        pickedActions.setPrefHeight(cell.getSizeOfElement()+(cell.getMarginOfElement()*2.5));
        pickedActions.setEditable(false);
        pickedActions.setCellFactory(listView -> new Cell());
        pickedActions.setItems(answers);

    }

    @Override
    protected void choose() {
        Action selectedItem = availableActions.getSelectionModel().getSelectedItem();
        ((ChronoActivity) model).answerAction(selectedItem);

        if(availableActions.getItems().isEmpty()){
            win();
        }
    }
}
