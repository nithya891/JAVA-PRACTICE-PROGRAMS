import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create UI components
        Label label = new Label("Enter your name:");
        TextField textField = new TextField();
        Button button = new Button("Say Hello");
        Label greetingLabel = new Label();

        // Set button action
        button.setOnAction(e -> {
            String name = textField.getText();
            greetingLabel.setText("Hello, " + name + "!");
        });

        // Layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, textField, button, greetingLabel);

        // Scene and Stage setup
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simple JavaFX App");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
