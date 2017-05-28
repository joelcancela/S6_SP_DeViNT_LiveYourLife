package fr.unice.polytech.si3.g2projet3.liveyourlife.games;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dvt.jeu.simple.ControleDevint;
import fr.unice.polytech.si3.g2projet3.liveyourlife.common.ActivityDeserializer;
import fr.unice.polytech.si3.g2projet3.liveyourlife.controller.SubmenuController;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.Activity;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.ChronoActivity;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity.ShuffleActivity;
import javafx.stage.Stage;

import java.io.File;
import java.io.InputStreamReader;

public class Submenu extends Stage {

    private SubmenuController control;
    private File workingDir;
    private String title;

    public Submenu(File workingDir, String title) {
        this.workingDir = workingDir;
        this.title = title;

        control = new SubmenuController();
        control.setTitre(titre());
        control.mapTouchToActions();
        initMenu();
        control.render();

        setScene(control.getScene());
        setTitle(titre());
        show();
    }

    public String titre() {
        return title;
    }

    public void initMenu() {
        File[] directoryListing = workingDir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                addGame(child);
            }
        }
    }

    private void addGame(File child) {
        String[] fileNames = child.getName().split("\"");
        String fileName = fileNames[fileNames.length-1];
        Gson gson = new GsonBuilder().registerTypeAdapter(Activity.class, new ActivityDeserializer<Activity>()).create();
        String s = "/activity/"+title+"/"+fileName;
        Activity activity = gson.fromJson(new InputStreamReader(getClass().getResourceAsStream(s)), Activity.class);
        if(activity instanceof ChronoActivity)control.addMenuItem(activity.getTitle(), x->new ChronoGame(s));
        if(activity instanceof ShuffleActivity)control.addMenuItem(activity.getTitle(), x->new ShuffleGame(s));
    }
}
