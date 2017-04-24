package fr.unice.polytech.si3.g2projet3.liveyourlife.model.activity;

import dvt.jeu.simple.ModeleDevint;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.action.Action;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Collections;
import java.util.List;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public abstract class Activity<A extends Action> extends ModeleDevint{

    protected final String title;
    protected ObservableList<A> possibleChoices;
    protected ObservableList<A> answers;
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

        //MAJ des possibilitées
        possibleChoices.remove(act);
        ObservableList<A> temp = FXCollections.observableArrayList(possibleChoices);
        possibleChoices.clear();
        possibleChoices.addAll(temp);

        //MAJ des answers
        answers.set(status++,act);
    }

    public ObservableList<A> getPossibleChoices(){
        return possibleChoices;
    }

    public ObservableList<A> getAnswers(){
        return answers;
    }
}
