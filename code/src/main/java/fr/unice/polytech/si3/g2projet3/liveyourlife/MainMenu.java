package fr.unice.polytech.si3.g2projet3.liveyourlife;

import dvt.devint.menu.MenuDevint;
import fr.unice.polytech.si3.g2projet3.liveyourlife.controller.ActivityController;
import fr.unice.polytech.si3.g2projet3.liveyourlife.controller.ChronoActivityController;
import fr.unice.polytech.si3.g2projet3.liveyourlife.controller.JeuChrono;
import fr.unice.polytech.si3.g2projet3.liveyourlife.controller.ShuffleActivityController;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.ChronoActivity;
import javafx.application.Application;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public class MainMenu extends MenuDevint {

    public static void main(String[] args) {
        Application.launch(MainMenu.class,args);
    }
    /**
     * le titre du menu
     *
     * @return le titre
     */
    @Override
    public String titre() {
        return "Live Your Life";
    }

    /**
     * Permet d'initialiser le menu
     * doit faire des appels à
     * control.addmenuItems(label,action)
     */
    @Override
    public void initMenu() {
        control.addMenuItem("Jouer une journée complète", x-> new ShuffleActivityController());
        control.addMenuItem("Se brosser les dents", x-> new JeuChrono());
        control.addMenuItem("S'habiller", x-> new ShuffleActivityController());
    }
}
