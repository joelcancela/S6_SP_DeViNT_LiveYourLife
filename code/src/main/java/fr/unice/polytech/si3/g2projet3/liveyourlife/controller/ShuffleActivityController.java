package fr.unice.polytech.si3.g2projet3.liveyourlife.controller;

import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.Action;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.ShuffleActivity;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

/**
 * @author Coconut team.
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

    @Override
    protected void displayWin() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent rootNode = null;
        try {
            rootNode = fxmlLoader.load(getClass().getResourceAsStream("/fxml/shuffleWin.fxml"));
            getScene().setRoot(rootNode);
            ShuffleWinController controller = fxmlLoader.getController();
            controller.setScene(getScene());
            controller.setText(((ShuffleActivity) model).getTitle());
        } catch (IOException e) {
            e.printStackTrace();
        }
        scene.getSIVox().playText("bravo tu as réussi");
    }
}
