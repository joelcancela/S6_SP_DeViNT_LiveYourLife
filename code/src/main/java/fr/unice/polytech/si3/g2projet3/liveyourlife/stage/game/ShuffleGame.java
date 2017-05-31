package fr.unice.polytech.si3.g2projet3.liveyourlife.stage.game;

import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.ShuffleActivity;

/**
 * @author Coconut team.
 */
public class ShuffleGame extends Game<ShuffleActivity> {

    public ShuffleGame(String activityPath) {
        super("/fxml/shuffleActivity.fxml", activityPath, ShuffleActivity.class);
    }
}


