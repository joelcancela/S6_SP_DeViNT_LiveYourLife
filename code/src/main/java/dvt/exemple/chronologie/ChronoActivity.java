package dvt.exemple.chronologie;

import dvt.devint.ConstantesDevint;
import dvt.devint.SceneDevint;
import dvt.exemple.quizz.QuizzModel;
import dvt.jeu.simple.ControleDevint;
import dvt.jeu.simple.JeuDevint;
import dvt.jeu.simple.ModeleDevint;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Antoine Dezarnaud on 05/04/2017.
 */
public class ChronoActivity extends JeuDevint {
    @Override
    public String titre() {
        return "Activité Chrono";
    }

    @Override
    protected ModeleDevint initModel() {
        return new QuizzModel();
    }

    @Override
    protected ControleDevint initControlAndScene() {
        // création de la scene et du controleur
        SceneDevint sc = null;
        FXMLLoader loader = new FXMLLoader();
        String FXMLfileName = ConstantesDevint.packageFileName("main/java/dvt/exemple/quizz/quizzGUI.fxml");
        try {
            loader.setLocation(new URL(FXMLfileName));
        } catch (MalformedURLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {
            AnchorPane root = (AnchorPane)loader.load();
            sc = new SceneDevint(root,ConstantesDevint.MAX_SCREEN_WIDTH,ConstantesDevint.MAX_SCREEN_HEIGHT);
            control = loader.getController();
            control.setScene(sc);


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return control;
    }
}
