package fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity;

import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.ChronoAction;
import t2s.SIVOXDevint;

import java.util.List;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public class ChronoActivity extends Activity<ChronoAction> {

    private SIVOXDevint sivoxDevint;
    private int currentChoice = 0;

    public ChronoActivity(String title, List<ChronoAction> choices) {
        super(title, choices);
        for (int i = 0; i < possibleChoices.size(); i++) {
            answers.add(new ChronoAction());
        }
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

    public void updateSelectedIndex(int newIndexByMouse) {
        currentChoice = newIndexByMouse;
    }

    public void setSIVOXInstance(SIVOXDevint sivoxDevint){
        this.sivoxDevint = sivoxDevint;
    }
}
