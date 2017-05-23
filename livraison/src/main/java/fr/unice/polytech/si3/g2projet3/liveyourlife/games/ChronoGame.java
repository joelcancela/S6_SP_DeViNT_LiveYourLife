package fr.unice.polytech.si3.g2projet3.liveyourlife.games;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dvt.devint.ConstantesDevint;
import dvt.devint.SceneDevint;
import dvt.jeu.simple.ControleDevint;
import dvt.jeu.simple.JeuDevint;
import dvt.jeu.simple.ModeleDevint;
import fr.unice.polytech.si3.g2projet3.liveyourlife.common.ActivityDeserializer;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.ChronoActivity;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Antoine on 5/22/2017.
 */
public class ChronoGame extends Game<ChronoActivity> {

    public ChronoGame(String activityPath) {
        super("/fxml/chronoActivity.fxml", activityPath, ChronoActivity.class);
    }
}
