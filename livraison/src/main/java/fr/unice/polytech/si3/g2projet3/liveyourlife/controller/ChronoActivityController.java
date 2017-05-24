package fr.unice.polytech.si3.g2projet3.liveyourlife.controller;

import com.sun.javafx.scene.control.skin.ListViewSkin;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.Action;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.ChronoActivity;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.IndexedCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Skin;

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
        int nb_elements = Math.min(5,answers.size());
        float margin_percentage = 1f/30f;
        double size_slot = Math.min(((this.getScene().getWidth()/(float)nb_elements)),getScene().getHeight()/3f);
        double size_item = size_slot-(2*margin_percentage*size_slot);
        pickedActions.setPrefHeight(size_slot+margin_percentage*size_item);
        pickedActions.setEditable(false);
        pickedActions.setCellFactory(listView -> new Cell(size_item, (margin_percentage*size_slot)));
        pickedActions.setItems(answers);
    }

    @Override
    protected void choose() {
        Action selectedItem = availableActions.getSelectionModel().getSelectedItem();
        ((ChronoActivity) model).answerAction(selectedItem);
        ListViewSkin<Cell> skin = (ListViewSkin<Cell>) pickedActions.getSkin();
        VirtualFlow flow= (VirtualFlow) skin.getChildren().get(0);
        IndexedCell last = flow.getLastVisibleCellWithinViewPort();
        IndexedCell first = flow.getFirstVisibleCellWithinViewPort();
        if(last.getIndex()<pickedActions.getItems().size()-availableActions.getItems().size()-1){
            pickedActions.scrollTo(first.getIndex()+1);
        }
        if(availableActions.getItems().isEmpty()){
            win();
        }
    }
}
