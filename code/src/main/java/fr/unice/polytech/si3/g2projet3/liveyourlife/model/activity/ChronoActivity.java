package fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity;

import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.Action;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.MultiChoiceList;
import t2s.SIVOXDevint;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public class ChronoActivity extends Activity<Action> {

    private SIVOXDevint sivoxDevint;

    public ChronoActivity(String titre, MultiChoiceList<Action> allWays) {
        super(titre, allWays);//TODO pb multiChoices
        for (int i = 0; i < possibleChoices.size(); i++) {
            answers.add(new Action());
        }
    }

    public void setSIVOXInstance(SIVOXDevint sivoxDevint) {
        this.sivoxDevint = sivoxDevint;
    }

    public void answerAction(Action action) {
        boolean wasCorrect = answer(action);
        if (wasCorrect) {
            sivoxDevint.playText("Bonne réponse !");
//            sivoxDevint.playText(action.getDescription());
        } else {
            sivoxDevint.playText("Mauvaise réponse !");
        }
    }
}
