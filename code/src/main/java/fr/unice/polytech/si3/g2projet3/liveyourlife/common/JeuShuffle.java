package fr.unice.polytech.si3.g2projet3.liveyourlife.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dvt.devint.ConstantesDevint;
import dvt.devint.SceneDevint;
import dvt.jeu.simple.ControleDevint;
import dvt.jeu.simple.JeuDevint;
import dvt.jeu.simple.ModeleDevint;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.ChronoActivity;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.ShuffleActivity;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by user on 03/05/2017.
 */
public class JeuShuffle extends JeuDevint {

    private ShuffleActivity shuffleActivity;

    public JeuShuffle(String activityPath) {
        Gson gson = new GsonBuilder().registerTypeAdapter(ShuffleActivity.class, new ActivityDeserializer<ShuffleActivity>()).create();
        shuffleActivity = gson.fromJson(new InputStreamReader(getClass().getResourceAsStream(activityPath)), ShuffleActivity.class);
        init();
    }

    @Override
    public String titre() {
        return shuffleActivity.getTitle();
    }

    @Override
    protected ModeleDevint initModel() {
        return shuffleActivity;
    }

    @Override
    protected ControleDevint initControlAndScene() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent rootNode = null;
        try {
            rootNode = fxmlLoader.load(getClass().getResourceAsStream("/fxml/shuffleActivity.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        SceneDevint sceneDevint = new SceneDevint(rootNode, ConstantesDevint.MAX_SCREEN_WIDTH, ConstantesDevint.MAX_SCREEN_HEIGHT);
        sceneDevint.getStylesheets().add("/styles/style.css");

        control = fxmlLoader.getController();

        control.setModel(initModel());

        control.setScene(sceneDevint);


        return control;
    }
}


