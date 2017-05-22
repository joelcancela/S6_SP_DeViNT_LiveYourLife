package fr.unice.polytech.si3.g2projet3.liveyourlife;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dvt.devint.menu.MenuDevint;
import fr.unice.polytech.si3.g2projet3.liveyourlife.common.*;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.ChronoActivity;
import javafx.application.Application;

import java.io.File;
import java.io.InputStreamReader;

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
        File dir = new File("../ressources/activity/");
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                addGame(child);
            }
        }
//        control.addMenuItem("Se brosser les dents", x-> new BrushTeethGame());
//        control.addMenuItem("Se doucher", x-> new TakeAShower());
//        control.addMenuItem("Se laver les mains", x-> new WashHandsGame());
//        control.addMenuItem("S'habiller", x-> new DressUnderSun());
//        control.addMenuItem("Traverser la route", x-> new PedestrianCrossing());
//        control.addMenuItem("Prendre le bus", x-> new TakeTheBus());
//        control.addMenuItem("S'habiller", x-> new ShuffleActivityController());
    }

    private void addGame(File child) {
        Gson gson = new GsonBuilder().registerTypeAdapter(ChronoActivity.class, new ActivityDeserializer<ChronoActivity>()).create();
        String[] fileNames = child.getName().split("\"");
        String fileName = fileNames[fileNames.length-1];
        ChronoActivity chronoActivity = (ChronoActivity) gson.fromJson(new InputStreamReader(getClass().getResourceAsStream("/activity/"+fileName)), ChronoActivity.class);

        control.addMenuItem(chronoActivity.getTitle(),x->new ChronoGame(chronoActivity));
    }
}
