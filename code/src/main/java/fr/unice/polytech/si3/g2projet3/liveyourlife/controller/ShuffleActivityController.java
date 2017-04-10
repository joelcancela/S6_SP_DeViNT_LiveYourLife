package fr.unice.polytech.si3.g2projet3.liveyourlife.controller;

import dvt.jeu.simple.ControleDevint;
import dvt.jeu.simple.JeuDevint;
import dvt.jeu.simple.ModeleDevint;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public class ShuffleActivityController extends JeuDevint {
    @FXML
    public Text activityName;
    @FXML
    public ImageView contextImage;
    @FXML
    public ImageView currentStateImage;
    @FXML
    public Text actionType;

    /**
     * le titre du jeu
     *
     * @return le titre
     */
    @Override
    public String titre() {
        return null;
    }

    /**
     * initialisation du modèle
     * méthode appelée dans le constructeur
     */
    @Override
    protected ModeleDevint initModel() {
        return null;
    }

    /**
     * initialisation du contrôle devint et de la scene devint
     * méthode appelée dans le constructeur
     * la scene peut être construite à partir du FXML via un FXMLLoader()
     * <p>
     * on peut aussi tout créer à la main si on ne veut pas passer par FXML
     */
    @Override
    protected ControleDevint initControlAndScene() {
        return null;
    }
}
