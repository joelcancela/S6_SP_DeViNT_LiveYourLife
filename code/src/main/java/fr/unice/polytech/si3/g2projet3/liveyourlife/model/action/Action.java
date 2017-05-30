package fr.unice.polytech.si3.g2projet3.liveyourlife.model.action;


import javafx.scene.image.Image;

/**
 * @author Coconut team.
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

    @Override
    public String toString() {
        return "Action{" +
                "description='" + description + '\'' +
                ", image=" + image +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Action action = (Action) o;

        return description.equals(action.description);
    }

    @Override
    public int hashCode() {
        int result = description.hashCode();
        result = 31 * result + image.hashCode();
        return result;
    }
}
