package dvt.exemple.chronologie;


import javafx.application.Application;
import javafx.stage.Stage;

public class MainChronoActivity extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		new ChronoActivity();
	}
}
