package fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity;

import dvt.jeu.simple.ModeleDevint;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.Action;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.answer.Answer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public abstract class Activity<A extends Action, B extends Answer> extends ModeleDevint{

    protected final String title;
    protected ObservableList<A> possibleChoices;
    protected ObservableList<B> answers;
    protected int status = 0;

    public Activity(String title, List<A> possibleChoices) {
        super();
        this.title = title;
        this.possibleChoices = FXCollections.observableArrayList(possibleChoices);
        this.answers = FXCollections.observableArrayList();
    }

    public void answer(A act) {
        if (!possibleChoices.contains(act))
            throw new IllegalArgumentException("This action isn't a possibility");
        possibleChoices.remove(act);
        answers.get(status++).setAction(act);
    }

    public ObservableList<A> getPossibleChoices(){
        return possibleChoices;
    }

    public ObservableList<B> getAnswers(){
        return answers;
    }
}
