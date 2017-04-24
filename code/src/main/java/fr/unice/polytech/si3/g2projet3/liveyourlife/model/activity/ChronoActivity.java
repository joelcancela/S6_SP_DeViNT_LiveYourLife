package fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity;

import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.ChronoAction;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.answer.ChronoAnswer;

import java.util.List;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public class ChronoActivity extends Activity<ChronoAction,ChronoAnswer> {

    private int currentChoice = 0;

    public ChronoActivity(String title, List<ChronoAction> choices) {
        super(title, choices);
        for(int i = 0; i < possibleChoices.size();i++){
            answers.add(new ChronoAnswer());
        }
    }

    public void chooseRight() {
        try{
            ChronoAction action = possibleChoices.get(currentChoice+1);
            currentChoice++;
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }

    public void chooseLeft() {
        try{
            ChronoAction action = possibleChoices.get(currentChoice-1);
            currentChoice--;
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }

    public void answerSelectedAction() {
        answer(possibleChoices.get(currentChoice));
        currentChoice = 0;
    }
}
