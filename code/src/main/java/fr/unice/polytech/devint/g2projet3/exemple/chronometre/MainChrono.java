package fr.unice.polytech.devint.g2projet3.exemple.chronometre;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainChrono extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		new JeuChrono();
	}
}
