package fr.unice.polytech.devint.g2projet3.run;

import fr.unice.polytech.devint.g2projet3.devint.menu.MenuDevint;
import fr.unice.polytech.devint.g2projet3.exemple.chronometre.JeuChrono;
import fr.unice.polytech.devint.g2projet3.exemple.multijoueur.JeuMulti;
import fr.unice.polytech.devint.g2projet3.exemple.quizz.JeuQuizz;
import javafx.application.Application;

/** cette classe lance les différents exemples de jeux DeViNT.
 * Vous devez obligatoirement étendre la classe menu pour écrire le menu de votre jeu
 * (ex: choix entre différents niveaux de jeu, options, aide ...)
 * 
 * @author helen
 *
 */
public class MainMenu extends MenuDevint {

	@Override
	public String titre() {
		return "Jeux DeViNT";
	}
	
	@Override
	public void initMenu() {
		control.addMenuItem("chrono", (x) -> new JeuChrono());
		control.addMenuItem("multi", (x) -> new JeuMulti());
		control.addMenuItem("quizz", (x) -> new JeuQuizz());
	}
	
	public static void main(String[] s){
		Application.launch(MainMenu.class,s);
	}

}
