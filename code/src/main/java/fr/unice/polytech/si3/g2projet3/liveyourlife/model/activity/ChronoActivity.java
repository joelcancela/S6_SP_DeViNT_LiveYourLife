package fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity;

import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.ChronoAction;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.MultiChoiceList;
import t2s.SIVOXDevint;

import java.util.List;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public class ChronoActivity extends Activity<ChronoAction> {

    private SIVOXDevint sivoxDevint;
    private MultiChoiceList multichoices;

    public ChronoActivity(String title, List<ChronoAction> choices) {
        super(title, choices);
        multichoices = null;
        for (int i = 0; i < possibleChoices.size(); i++) {
            answers.add(new ChronoAction());
        }
    }

    public ChronoActivity(String titre, MultiChoiceList allWays) {
        super(titre, allWays.getIdealChoices());//TODO pb multiChoices
        this.multichoices = allWays;
        for (int i = 0; i < possibleChoices.size(); i++) {
            answers.add(new ChronoAction());
        }
    }

    public void setSIVOXInstance(SIVOXDevint sivoxDevint) {
        this.sivoxDevint = sivoxDevint;
    }

    @Override
    public boolean answer(ChronoAction act) {


        if (multichoices != null) {//MultiChoice
            if (multichoices.isCorrect(act)) {
                answerCorrect(act);
                return true;
            }
        } else {//List<ChronoAction>
            if (correctAnswer.get(status).equals(act)) {
                answerCorrect(act);
                return true;
            }
        }
        return false;
    }

    public void answerAction(ChronoAction action) {
        boolean wasCorrect = answer(action);
        if (wasCorrect) {
            sivoxDevint.playText("Bonne réponse !");
//            sivoxDevint.playText(action.getDescription());
        } else {
            sivoxDevint.playText("Mauvaise réponse !");
        }
    }
}
