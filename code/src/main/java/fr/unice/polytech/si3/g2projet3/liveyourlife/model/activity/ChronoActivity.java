package fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity;

import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.ChronoAction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import t2s.SIVOXDevint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public class ChronoActivity extends Activity<ChronoAction> {

    private ObservableList<ChronoAction> answers;

    public ChronoActivity(String title, List<ChronoAction> choices) {
        super(title, choices);
        answers = FXCollections.observableArrayList(new ArrayList<>());
        for (int i = 0; i < possibleChoices.size(); i++) {
            answers.add(new ChronoAction());
        }
    }

    public ObservableList<ChronoAction> getAnswers(){
        return answers;
    }

    @Override
    public boolean answer(ChronoAction act) {
        if (!possibleChoices.contains(act))
            throw new IllegalArgumentException("This action isn't a possibility");
        if(correctAnswer.get(status).equals(act)){
            System.out.println("correct");
            //MAJ des possibilitées
            possibleChoices.remove(act);
            //MAJ des answers
            answers.set(status++,act);
            return true;
        }else return false;
    }

    public void updateSelectedIndex(int newIndexByMouse) {
        currentChoice = newIndexByMouse;
    }

}
