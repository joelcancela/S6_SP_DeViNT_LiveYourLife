package fr.unice.polytech.si3.g2projet3.liveyourlife.game;

import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.ChronoActivity;

/**
 * @author Coconut team.
 */
public class ChronoGame extends Game<ChronoActivity> {

    public ChronoGame(String activityPath) {
        super("/fxml/chronoActivity.fxml", activityPath, ChronoActivity.class);

    }
}
