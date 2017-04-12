package fr.unice.polytech.si3.g2projet3.liveyourlife.model.Activities;

import fr.unice.polytech.si3.g2projet3.liveyourlife.model.Actions.ChronoAction;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.Answers.ChronoAnswer;

import java.util.List;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public class ChronoActivity extends Activity<ChronoAction,ChronoAnswer> {

    public ChronoActivity(String title, List<ChronoAction> choices) {
        super(title, choices);
        for(int i = 0; i < possibleChoices.size();i++){
            answers.add(new ChronoAnswer());
        }
    }

}
