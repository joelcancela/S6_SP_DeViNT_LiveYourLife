package fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity;

import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.ShuffleAction;
import javafx.scene.image.Image;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public class ShuffleActivity extends Activity<ShuffleAction> {

    private Image contextImagePath;
    private Queue<Image> currentStateImagePath;
    private Queue<List<ShuffleAction>> allChoices;

    public ShuffleActivity(String title, List<List<ShuffleAction>> choices,
                           List<ShuffleAction> correctChoices,
                           List<String> currentStateImagePath, String contextImagePath) {
        super(title, choices.get(0));
        this.contextImagePath = new Image(getClass().getResourceAsStream(contextImagePath));
        this.currentStateImagePath = new LinkedList<>();
        for (String s : currentStateImagePath)
            this.currentStateImagePath.add(new Image(getClass().getResourceAsStream(s)));

        this.correctAnswer = new LinkedList<>(correctChoices);
        this.allChoices = new LinkedList<>(choices);
    }

    public Image getContextImagePath() {
        return contextImagePath;
    }

    public Image getCurrentStateImagePath() {
        Image image = currentStateImagePath.poll();
        if (image == null)
            return new Image(getClass().getResourceAsStream("/images/activity/default.jpg"));
        else
            return image;
    }

    @Override
    public boolean answer(ShuffleAction act) {
        if (!possibleChoices.contains(act))
            throw new IllegalArgumentException("This action isn't a possibility");
        if (!correctAnswer.contains(act))
            return false;
        if (allChoices.isEmpty()) {
            //TODO: end activity go menu
            System.out.println("EMPTY LIST CAN'T GO FURTHER");
            return true;
        } else {
            possibleChoices.clear();
            possibleChoices.addAll(allChoices.poll());

            return true;
        }
    }

    public void updateSelectedIndex(int newIndexByMouse) {
        currentChoice = newIndexByMouse;
    }
}
