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
public class ShuffleActivityController extends ListActivityController {

    @FXML
    public ImageView contextImage;
    @FXML
    public ImageView currentStateImage;

    @Override
    protected void init() {
        super.init();
        contextImage.setImage(((ShuffleActivity) model).getContextImagePath());
        currentStateImage.setImage(((ShuffleActivity) model).getCurrentStateImagePath());
    }

    @Override
    protected void choose() {
        Action selectedItem = availableActions.getSelectionModel().getSelectedItem();
        if(((ShuffleActivity) model).answerAction(selectedItem))
            win();
        else
            currentStateImage.setImage(((ShuffleActivity) model).getCurrentStateImagePath());
    }
}
