package fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity;

import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.ShuffleAction;
import javafx.scene.image.Image;
import t2s.SIVOXDevint;

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
    private SIVOXDevint sivoxDevint;

    public ShuffleActivity(String title, Queue<List<ShuffleAction>> choices,
                           List<ShuffleAction> correctChoices,
                           List<String> currentStateImagePath, String contextImagePath) {
        super(title, choices.poll());
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
        return currentStateImagePath.peek();
    }

    @Override
    public boolean answer(ShuffleAction act) {
        if (!possibleChoices.contains(act))
            throw new IllegalArgumentException("This action isn't a possibility");
        if (!correctAnswer.contains(act))
            return false;
        else {
            possibleChoices.clear();
            if (allChoices.peek() != null) {
                possibleChoices.addAll(allChoices.poll());
                currentStateImagePath.poll();
            }
            return true;
        }
    }

    public boolean answerAction(ShuffleAction action) {
        boolean wasCorrect = answer(action);
        if(wasCorrect){
            sivoxDevint.playText("Bonne réponse !");
        }
        else{
            sivoxDevint.playText("Mauvaise réponse !");
        }
        return possibleChoices.isEmpty();
    }

    public void setSIVOXInstance(SIVOXDevint SIVOXInstance) {
        this.sivoxDevint = SIVOXInstance;
    }
}
