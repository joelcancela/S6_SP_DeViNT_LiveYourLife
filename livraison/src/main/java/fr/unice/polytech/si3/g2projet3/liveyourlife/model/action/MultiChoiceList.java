package fr.unice.polytech.si3.g2projet3.liveyourlife.model.action;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Coconut team.
 */
public class MultiChoiceList<A> {
    private List<List<A>> choices;//Liste des listes des choix possibles à l'instant t
    private List<A> best;
    private int currentIndex;//Index courant


    public MultiChoiceList(List<List<A>> choices) {
        this.choices = choices;
        this.best = choices.get(0);
        this.currentIndex = 0;
    }

    public boolean isCorrect(A choiceMade) {
        List<List<A>> removalList = new ArrayList<>();//On crée une liste temporaire des chemins impossibles
        for (List<A> innerList : choices) {//Pour chaque liste restante
            Action actionMade = (Action)choiceMade;
            Action actionToCheck = (Action) innerList.get(currentIndex);
            if (!actionToCheck.equals(actionMade)) { //On regarde si le choix n'est pas possible à l'index n
                removalList.add(innerList);//Et on ajoute la liste à la liste de celles à supprimer
            }
        }
        if (removalList.size() == choices.size())//Si tous les chemins sont à supprimer, le choix est forcément faux
            return false;

        choices.removeAll(removalList);//Sinon on supprime les chemins impossibles
        currentIndex++;//On incrémente l'index pour le prochain choix
        return true;//Le choix est donc bon
    }

    public List<A> getIdealChoices() {
        return best;
    }

    @Override
    public String toString() {
        return "MultiChoiceList{" +
                "choices=" + choices +
                '}';
    }
}
