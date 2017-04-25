package fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity;

import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.ChronoAction;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.ShuffleAction;
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

    private Queue<List<ShuffleAction>> nextChoices;

    public ShuffleActivity(String title, List<ShuffleAction> choices) {
        super(title, choices);
        nextChoices = new LinkedList<>();
    }

    @Override
    public boolean answer(ShuffleAction act) {
        if (!possibleChoices.contains(act))
            throw new IllegalArgumentException("This action isn't a possibility");
        if (!correctAnswer.contains(act))
            return false;
        if (nextChoices.isEmpty()) {
            //TODO: Go to the next activity
            return true;
        } else {
            possibleChoices.clear();
            possibleChoices.addAll(nextChoices.poll());
            return true;
        }
    }

    public void updateSelectedIndex(int newIndexByMouse) {
        currentChoice = newIndexByMouse;
    }

}
