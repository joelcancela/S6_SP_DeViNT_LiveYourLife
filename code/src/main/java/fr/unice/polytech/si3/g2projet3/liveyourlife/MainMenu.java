package fr.unice.polytech.si3.g2projet3.liveyourlife;

import dvt.devint.menu.MenuDevint;
import fr.unice.polytech.si3.g2projet3.liveyourlife.common.BrushTeethGame;
import fr.unice.polytech.si3.g2projet3.liveyourlife.common.DressUnderSun;
import fr.unice.polytech.si3.g2projet3.liveyourlife.common.TakeAShower;
import fr.unice.polytech.si3.g2projet3.liveyourlife.common.WashHandsGame;
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
//        control.addMenuItem("Jouer une journée complète", x-> new ShuffleActivityController());
        control.addMenuItem("Se brosser les dents", x-> new BrushTeethGame());
        control.addMenuItem("Se doucher", x-> new TakeAShower());
        control.addMenuItem("Se laver les mains", x-> new WashHandsGame());
        control.addMenuItem("S'habiller", x-> new DressUnderSun());
//        control.addMenuItem("S'habiller", x-> new ShuffleActivityController());
    }
}
