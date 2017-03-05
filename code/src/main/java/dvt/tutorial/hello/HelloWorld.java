package dvt.tutorial.hello;

import dvt.devint.SceneDevint;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorld extends Stage {

    public HelloWorld() {
        setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        SceneDevint sc = new SceneDevint(root, 300, 250);
        setScene(sc);
        sc.mapKeyPressedToConsumer(KeyCode.F5, (x)->actionF5(sc));
        show();
    }

    private void actionF5(SceneDevint sc) {
        System.out.println("COUCOU");
        sc.getSIVox().playText("Coucou");
    }
}