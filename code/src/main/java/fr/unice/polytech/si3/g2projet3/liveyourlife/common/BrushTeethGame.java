package fr.unice.polytech.si3.g2projet3.liveyourlife.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dvt.devint.ConstantesDevint;
import dvt.devint.SceneDevint;
import dvt.jeu.simple.ControleDevint;
import dvt.jeu.simple.JeuDevint;
import dvt.jeu.simple.ModeleDevint;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.ChronoActivity;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Controller of the Chrono Activity
 *
 * @author Joël CANCELA VAZ
 */
public class BrushTeethGame extends JeuDevint {


    private ChronoActivity chronoActivity;

    public BrushTeethGame() {
    }

    @Override
    public String titre() {
        return "Se brosser les dents";
    }

    @Override
    protected ModeleDevint initModel() {
        Gson gson = new GsonBuilder().registerTypeAdapter(ChronoActivity.class, new ActivityDeserializer<ChronoActivity>()).create();
        chronoActivity = gson.fromJson(new InputStreamReader(getClass().getResourceAsStream("/activity/brush.json")), ChronoActivity.class);
        return chronoActivity;
    }

    @Override
    protected ControleDevint initControlAndScene() {
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent rootNode = null;
        try {
            rootNode = fxmlLoader.load(getClass().getResourceAsStream("/fxml/chronoActivity.fxml"));
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
}
