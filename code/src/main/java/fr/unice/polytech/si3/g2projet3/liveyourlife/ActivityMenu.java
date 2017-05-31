package fr.unice.polytech.si3.g2projet3.liveyourlife;

import dvt.devint.menu.MenuDevint;
import javafx.scene.input.KeyCode;

/**
 * @author Coconut team.
 */
public class ActivityMenu extends MenuDevint {
    /**
     * le titre du menu
     *
     * @return le titre
     */
    @Override
    public String titre() {
        return null;
    }

    /**
     * Permet d'initialiser le menu
     * doit faire des appels à
     * control.addmenuItems(label,action)
     */
    @Override
    public void initMenu() {
        getControl().getScene().getSIVox().stop();
        getControl().getScene().mapKeyPressedToConsumer(KeyCode.F1,(x) -> getControl().getScene().getSIVox().playText("Le but du jeu est de remettre les actions dans le bon ordre."));
        getControl().getScene().mapKeyPressedToConsumer(KeyCode.F2,(x) -> getControl().getScene().getSIVox().playText("Le but du jeu est de remettre les actions dans le bon ordre. Pour cela vous pouvez utiliser la souris, ou les touches fléchées avec espace ou entrée."));
    }
}
