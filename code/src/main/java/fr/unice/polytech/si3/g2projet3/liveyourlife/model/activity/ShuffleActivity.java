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

    private SIVOXDevint sivoxDevint;
    private Queue<List<ShuffleAction>> nextChoices;
    private int currentChoice = 0;

    public ShuffleActivity(String title, List<ShuffleAction> choices) {
        super(title, choices);
        nextChoices = new LinkedList<>();
    }

    @Override
    public boolean answer(ShuffleAction act) {
        super.answer(act);
        if (nextChoices.isEmpty()) {
            //TODO: Go to the next activity
        }
//        possibleChoices = nextChoices.remove();
        return false;
    }

    public int answerSelectedAction() {
        if(possibleChoices.size()>0){
            boolean wasCorrect = answer(possibleChoices.get(currentChoice));
            if(wasCorrect){
                currentChoice = Math.max(currentChoice-1,0);
                sivoxDevint.playText("Bonne réponse !");
            }
            else{
                sivoxDevint.playText("Mauvaise réponse !");
            }
        }
        return currentChoice;
    }

    public int chooseRight() {
        if (currentChoice < possibleChoices.size() - 1)
            currentChoice++;
        return currentChoice;
    }

    public int chooseLeft() {
        if (currentChoice > 0)
            currentChoice--;
        return currentChoice;
    }

    public void setSIVOXInstance(SIVOXDevint sivoxDevint){
        this.sivoxDevint = sivoxDevint;
    }
}
