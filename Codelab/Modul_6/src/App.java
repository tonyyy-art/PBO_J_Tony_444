import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;

public class App extends Application {
    private int angkaRahasia;
    private int jumlahPercobaan;
    private TextField inputTebakan;
    private Label pesanLabel;
    private Label percobaanLabel;
    private Button tombolTebak;
    private Button tombolMainLagi;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        angkaRahasia = generateAngkaRahasia();
        jumlahPercobaan = 0;

        Label judul = new Label("🎯 Tebak Angka 1–100");
        judul.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        judul.setTextFill(Color.DARKBLUE);

        pesanLabel = new Label("Masukkan tebakanmu!");
        pesanLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 16));

        inputTebakan = new TextField();
        inputTebakan.setPromptText("Masukkan angka di sini");
        inputTebakan.setPrefWidth(200);

        tombolTebak = new Button("🧠 Coba Tebak!");
        tombolTebak.setStyle("-fx-background-color: #da70d6; -fx-text-fill: white;");
        tombolTebak.setOnAction(e -> prosesTebakan());

        tombolMainLagi = new Button("🔁 Main Lagi");
        tombolMainLagi.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
        tombolMainLagi.setVisible(false);
        tombolMainLagi.setOnAction(e -> resetGame());

        HBox inputBox = new HBox(10, inputTebakan, tombolTebak, tombolMainLagi);
        inputBox.setPadding(new Insets(10));
        inputBox.setAlignment(javafx.geometry.Pos.CENTER);

        percobaanLabel = new Label("Jumlah percobaan: 0");
        percobaanLabel.setFont(Font.font("Arial", FontPosture.REGULAR, 14));

        VBox root = new VBox(10, judul, pesanLabel, inputBox, percobaanLabel);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #ffb6c1;");
        root.setAlignment(javafx.geometry.Pos.CENTER);

        Scene scene = new Scene(root, 450, 250);
        primaryStage.setTitle("Tebak Angka Advance");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void prosesTebakan() {
        String input = inputTebakan.getText();
        try {
            int tebakan = Integer.parseInt(input);
            jumlahPercobaan++;
            percobaanLabel.setText("Jumlah percobaan: " + jumlahPercobaan);

            if (tebakan < 1 || tebakan > 100) {
                pesanLabel.setText("Masukkan angka 1–100 saja!");
                pesanLabel.setTextFill(Color.ORANGE);
            } else if (tebakan > angkaRahasia) {
                pesanLabel.setText("▲ Terlalu besar!");
                pesanLabel.setTextFill(Color.ORANGE);
            } else if (tebakan < angkaRahasia) {
                pesanLabel.setText("▼ Terlalu kecil!");
                pesanLabel.setTextFill(Color.GOLDENROD);
            } else {
                pesanLabel.setText("✔ Tebakan benar!");
                pesanLabel.setTextFill(Color.GREEN);
                inputTebakan.setDisable(true);
                tombolTebak.setDisable(true);
                tombolMainLagi.setVisible(true);
            }

            inputTebakan.clear();

        } catch (NumberFormatException e) {
            pesanLabel.setText("Masukkan angka yang valid!");
            pesanLabel.setTextFill(Color.RED);
        }
    }

    private void resetGame() {
        angkaRahasia = generateAngkaRahasia();
        jumlahPercobaan = 0;
        percobaanLabel.setText("Jumlah percobaan: 0");
        pesanLabel.setText("Masukkan tebakanmu!");
        pesanLabel.setTextFill(Color.BLACK);
        inputTebakan.setDisable(false);
        inputTebakan.clear();
        tombolTebak.setDisable(false);
        tombolMainLagi.setVisible(false);
    }

    private int generateAngkaRahasia() {
        return (int) (Math.random() * 100) + 1;
    }
}
