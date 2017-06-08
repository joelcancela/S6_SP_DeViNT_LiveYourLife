package fr.unice.polytech.si3.g2projet3.liveyourlife.controller;

import com.sun.javafx.scene.control.skin.ListViewSkin;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.Action;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.ChronoActivity;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.IndexedCell;
import javafx.scene.control.ListView;
import javafx.util.Duration;

import java.io.IOException;

/**
 * @author Coconut team.
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

    @Override
    protected void displayWin() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent rootNode = null;
        Timeline timeline = null;
        try {
            rootNode = fxmlLoader.load(getClass().getResourceAsStream("/fxml/chronoWin.fxml"));
            getScene().setRoot(rootNode);
            ChronoWinController controller = (ChronoWinController) fxmlLoader.getController();
            controller.setScene(getScene());
            controller.setText(((ChronoActivity) model).getTitle());
            controller.setActions(((ChronoActivity) model).getCorrectAnswer().getIdealChoices());
            String best = ((ChronoActivity) model).getBest();
            controller.setBestText(best);
            timeline = new Timeline(new KeyFrame(
                    Duration.millis(1500),
                    ae -> scene.getSIVox().playText(best)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        scene.getSIVox().playText("bravo tu as réussi");
        timeline.play();

    }
}
