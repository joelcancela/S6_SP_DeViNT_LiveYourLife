package fr.unice.polytech.si3.g2projet3.liveyourlife.game;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dvt.devint.ConstantesDevint;
import dvt.devint.SceneDevint;
import dvt.jeu.simple.ControleDevint;
import dvt.jeu.simple.JeuDevint;
import dvt.jeu.simple.ModeleDevint;
import fr.unice.polytech.si3.g2projet3.liveyourlife.common.ActivityDeserializer;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.Activity;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.KeyCode;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/**
 * Created by Antoine on 5/22/2017.
 */
public class Game<A extends Activity> extends JeuDevint {

    private A activity;
    private String fxmlPath;

    public Game(String fxmlPath, String activityPath, Class<A> type) {
        Gson gson = new GsonBuilder().registerTypeAdapter(type, new ActivityDeserializer<A>()).create();
        this.activity = gson.fromJson(new InputStreamReader(getClass().getResourceAsStream(activityPath), Charset.forName("UTF-8")), type);
        registerHelp(activity.getDescription());
        this.fxmlPath = fxmlPath;
        init();
    }

    @Override
    public String titre() {
        return activity.getTitle();
    }

    @Override
    protected ModeleDevint initModel() {
        return activity;
    }

    @Override
    protected ControleDevint initControlAndScene() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent rootNode = null;
        try {
            rootNode = fxmlLoader.load(getClass().getResourceAsStream(fxmlPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        SceneDevint sceneDevint = new SceneDevint(rootNode, ConstantesDevint.MAX_SCREEN_WIDTH, ConstantesDevint.MAX_SCREEN_HEIGHT);
        sceneDevint.getStylesheets().add("/styles/style.css");
        control = fxmlLoader.getController();

        control.setModel(model);

        control.setScene(sceneDevint);


        return control;
    }

    protected void registerHelp(String help) {
        this.getScene().setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.F1) {
                ((SceneDevint)getScene()).getSIVox().playText(help);
            }
            event.consume();
        });
    }
}