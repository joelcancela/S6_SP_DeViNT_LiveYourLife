package fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity;

import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.Action;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.MultiChoiceList;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public class ChronoActivity extends Activity<Action> {

   public ChronoActivity(String titre, String description, MultiChoiceList<Action> allWays) {
        super(titre, description, allWays);
        for (int i = 0; i < possibleChoices.size(); i++) {
            answers.add(new Action());
        }
    }

    public boolean answerAction(Action action) {
        boolean wasCorrect = answer(action);
        if (wasCorrect) {
            sivoxDevint.playText("Bonne réponse !");
        } else {
            sivoxDevint.playText("Mauvaise réponse !");
        }
        return wasCorrect;
    }

}
