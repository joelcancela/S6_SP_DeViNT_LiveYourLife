package fr.unice.polytech.si3.g2projet3.liveyourlife.game;

import dvt.devint.SceneDevint;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.ChronoActivity;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 * Created by Antoine on 5/22/2017.
 */
public class ChronoGame extends Game<ChronoActivity> {

    public ChronoGame(String activityPath) {
        super("/fxml/chronoActivity.fxml", activityPath, ChronoActivity.class);

    }
}
