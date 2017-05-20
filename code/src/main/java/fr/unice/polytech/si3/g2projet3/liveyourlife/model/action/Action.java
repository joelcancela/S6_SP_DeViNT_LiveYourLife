package fr.unice.polytech.si3.g2projet3.liveyourlife.model.action;


import javafx.scene.image.Image;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public class Action {

    private final String description;
    private final Image image;

    public Action(String description, String imgPath) {
        this.description = description;
        image = new Image(getClass().getResourceAsStream(imgPath));
    }

    public Action() {
        this.description = "";
        image = new Image(getClass().getResourceAsStream("/images/activity/default.jpg"));
    }

    public String getDescription() {
        return description;
    }

    public Image getImage() {
        return image;
    }
}
