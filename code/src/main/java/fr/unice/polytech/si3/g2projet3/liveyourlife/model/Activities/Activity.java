package fr.unice.polytech.si3.g2projet3.liveyourlife.model.Activities;

import dvt.jeu.simple.ModeleDevint;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.Actions.Action;
import fr.unice.polytech.si3.g2projet3.liveyourlife.model.Answers.Answer;

import java.util.LinkedList;
import java.util.List;

/**
 * Class x
 *
 * @author Joël CANCELA VAZ
 */
public abstract class Activity<A extends Action, B extends Answer> extends ModeleDevint{

    protected final String title;
    protected List<A> possibleChoices;
    protected List<B> answers;
    protected int status = 0;

    public Activity(String title, List<A> possibleChoices) {
        super();
        this.title = title;
        this.possibleChoices = possibleChoices;
        answers = new LinkedList<>();
    }

    public void answer(A act) {
        if (!possibleChoices.contains(act))
            throw new IllegalArgumentException("This action isn't a possibility");
        possibleChoices.remove(act);
        answers.get(status++).setAction(act);
    }

    public List<A> getPossibleChoices(){
        return possibleChoices;
    }

    public List<B> getAnswers(){
        return answers;
    }
}
