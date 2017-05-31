package fr.unice.polytech.si3.g2projet3.liveyourlife;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import dvt.devint.menu.MenuDevint;
import fr.unice.polytech.si3.g2projet3.liveyourlife.common.ActivityDeserializer;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.Activity;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.ChronoActivity;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.ShuffleActivity;
import fr.unice.polytech.si3.g2projet3.liveyourlife.stage.Submenu;
import fr.unice.polytech.si3.g2projet3.liveyourlife.stage.game.ChronoGame;
import fr.unice.polytech.si3.g2projet3.liveyourlife.stage.game.ShuffleGame;
import javafx.application.Application;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Coconut team.
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
                try {
                    if (child.getCanonicalFile().isDirectory())
                        addSubmenu(child);
                    else if (child.getCanonicalFile().isFile())
                        addGame(child);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void addGame(File child) {
        try {
            String[] fileNames = child.getName().split("\"");
            String fileName = fileNames[fileNames.length-1];
            Gson gson = new GsonBuilder().registerTypeAdapter(Activity.class, new ActivityDeserializer<Activity>()).create();
            Activity activity = gson.fromJson(new InputStreamReader(getClass().getResourceAsStream("/activity/"+fileName)), Activity.class);
            if(activity instanceof ChronoActivity)control.addMenuItem(activity.getTitle(),x->new ChronoGame("/activity/"+fileName));
            if(activity instanceof ShuffleActivity)control.addMenuItem(activity.getTitle(), x->new ShuffleGame("/activity/"+fileName));
        } catch (JsonSyntaxException | JsonIOException | NullPointerException e) {
            // If we launch with the bat, there is some bug with the directory
            addSubmenu(child);
        }
    }

    private void addSubmenu(File child) {
        String[] fileNames = child.getName().split("\"");
        String fileName = fileNames[fileNames.length-1];
        control.addMenuItem(fileName, x->new Submenu(child, fileName));
    }
}
