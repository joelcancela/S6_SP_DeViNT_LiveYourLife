package fr.unice.polytech.si3.g2projet3.liveyourlife.controller;

import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.Action;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.ShuffleActivity;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
        contextImage.setFitHeight(getScene().getHeight()/3.5f);
        currentStateImage.setFitHeight(getScene().getHeight()/3.5f);
    }

    @Override
    protected void choose() {
        Action selectedItem = availableActions.getSelectionModel().getSelectedItem();
        boolean haveFinished = ((ShuffleActivity) model).answerAction(selectedItem);
        Image image = ((ShuffleActivity) model).getCurrentStateImagePath();
        currentStateImage.setImage(image);
        if(haveFinished) {
            win();
        }
    }
}
