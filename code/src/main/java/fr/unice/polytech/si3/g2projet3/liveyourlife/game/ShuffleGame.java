package fr.unice.polytech.si3.g2projet3.liveyourlife.game;

import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.ShuffleActivity;

/**
 * Created by user on 03/05/2017.
 */
public class ShuffleGame extends Game<ShuffleActivity> {

    public ShuffleGame(String activityPath) {
        super("/fxml/shuffleActivity.fxml", activityPath, ShuffleActivity.class);
    }
}


