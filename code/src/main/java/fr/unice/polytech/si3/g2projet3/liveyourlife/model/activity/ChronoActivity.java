package fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity;

import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.ChronoAction;

import java.util.List;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public class ChronoActivity extends Activity<ChronoAction> {

    private int currentChoice = 0;

    public ChronoActivity(String title, List<ChronoAction> choices) {
        super(title, choices);
        for (int i = 0; i < possibleChoices.size(); i++) {
            answers.add(new ChronoAction());
        }
    }

    public int chooseRight() {
        try {
            ChronoAction action = possibleChoices.get(currentChoice + 1);
            currentChoice++;
        } catch (IndexOutOfBoundsException e) {
            currentChoice = 0;
        }
        return currentChoice;
    }

    public int chooseLeft() {
        try {
            ChronoAction action = possibleChoices.get(currentChoice - 1);
            currentChoice--;
        } catch (IndexOutOfBoundsException e) {
            currentChoice = 0;
        }
        return currentChoice;
    }

    public int answerSelectedAction() {
        answer(possibleChoices.get(currentChoice));
        currentChoice = 0;
        return currentChoice;
    }
}
