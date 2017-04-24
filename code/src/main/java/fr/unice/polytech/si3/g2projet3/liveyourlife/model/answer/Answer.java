package fr.unice.polytech.si3.g2projet3.liveyourlife.model.answer;

import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.Action;
import javafx.scene.image.Image;

import java.util.Optional;

/**
 * Created by Antoine Dezarnaud on 12/04/2017.
 */
public class Answer <A extends Action> {
    protected Image defaultImage;
    protected Optional<A> actionAnswer;

    public Answer() {
        actionAnswer = Optional.empty();
        defaultImage = new Image(getClass().getResourceAsStream("/images/activity/default.jpg"));
    }

    public void setAction(A action) {
        this.actionAnswer = Optional.ofNullable(action);
    }

    public Image getImage() {
        if(actionAnswer.isPresent()){
            return actionAnswer.get().getImage();
        }else{
            return defaultImage;
        }
    }
}
