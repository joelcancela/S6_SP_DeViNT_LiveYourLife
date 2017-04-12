package fr.unice.polytech.si3.g2projet3.liveyourlife.model.Activities;

import fr.unice.polytech.si3.g2projet3.liveyourlife.model.Answers.Answer;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.Actions.ShuffleAction;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public class ShuffleActivity extends Activity<ShuffleAction,Answer> {

    private Queue<List<ShuffleAction>> nextChoices;

    public ShuffleActivity(String title, List<ShuffleAction> choices) {
        super(title, choices);
        nextChoices = new LinkedList<>();
    }

    @Override
    public void answer(ShuffleAction act) {
        super.answer(act);
        if (nextChoices.isEmpty()) {
            //TODO: Go to the next activity
        }
//        possibleChoices = nextChoices.remove();
    }
}
