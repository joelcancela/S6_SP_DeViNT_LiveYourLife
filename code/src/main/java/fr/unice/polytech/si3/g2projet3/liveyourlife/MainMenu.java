package fr.unice.polytech.si3.g2projet3.liveyourlife;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dvt.devint.menu.MenuDevint;
import fr.unice.polytech.si3.g2projet3.liveyourlife.common.ActivityDeserializer;
import fr.unice.polytech.si3.g2projet3.liveyourlife.game.ChronoGame;
import fr.unice.polytech.si3.g2projet3.liveyourlife.game.ShuffleGame;
import fr.unice.polytech.si3.g2projet3.liveyourlife.game.Submenu;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.Activity;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.ChronoActivity;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.ShuffleActivity;
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
        File dir = new File("../ressources/activity/");
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                if (child.isDirectory())
                    addSubmenu(child);
                else
                    addGame(child);
            }
        }
    }

    private void addGame(File child) {
        String[] fileNames = child.getName().split("\"");
        String fileName = fileNames[fileNames.length-1];
        Gson gson = new GsonBuilder().registerTypeAdapter(Activity.class, new ActivityDeserializer<Activity>()).create();
        Activity activity = gson.fromJson(new InputStreamReader(getClass().getResourceAsStream("/activity/"+fileName)), Activity.class);
        if(activity instanceof ChronoActivity)control.addMenuItem(activity.getTitle(),x->new ChronoGame("/activity/"+fileName));
        if(activity instanceof ShuffleActivity)control.addMenuItem(activity.getTitle(), x->new ShuffleGame("/activity/"+fileName));
    }

    private void addSubmenu(File child) {
        String[] fileNames = child.getName().split("\"");
        String fileName = fileNames[fileNames.length-1];
        control.addMenuItem(fileName, x->new Submenu(child, fileName));
    }
}
