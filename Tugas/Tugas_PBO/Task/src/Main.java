
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.*;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Button button = new Button("Button");

        HBox mainLayout = new HBox(10, button);
        mainLayout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(mainLayout, 500, 500);
        stage.setScene(scene);
        stage.setTitle("Chalengge");
        stage.show();


    }
    public static void main(String[] args) {
        launch(args);
    }
}