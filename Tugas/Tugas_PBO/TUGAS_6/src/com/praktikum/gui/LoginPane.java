package com.praktikum.gui;

import com.praktikum.users.Mahasiswa;
import com.praktikum.users.Admin;

import javafx.geometry.Pos;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.layout.HBox;

public class LoginPane {
    private Label header1 = new Label("Login Sistem Lost & Found");
    private Stage stage;
    private ChoiceBox<String> userType = new ChoiceBox<>();
    private TextField username = new TextField();
    private TextField password = new TextField();
    private Button loginButton = new Button("Login");
    private Label loginInfo = new Label("drytg");

    private VBox loginLayout = new VBox(15, header1, userType, username, password, loginButton, loginInfo);
    private HBox mainLayout = new HBox(10, loginLayout);
    private Scene scene = new Scene(mainLayout, 400, 400);
    
   

    public Scene getScene() {
        return scene;
    }
    public LoginPane() {
        userType.getItems().addAll("Admin", "Mahasiswa");
        userType.setValue("Admin");
        loginLayout.setAlignment(Pos.CENTER);
        mainLayout.setAlignment(Pos.CENTER);
        loginInfo.setVisible(false);
        loginButton.setOnAction(e -> Login());
        username.setPromptText("Username");
        password.setPromptText("Password");
        mainLayout.setStyle("-fx-background-color: lightblue;");
        
    }

    void Login() {
        stage = (Stage) ((Node) loginButton).getScene().getWindow();
        String user = userType.getValue();
        String inputUsername = username.getText();
        String inputPassword = password.getText();

        if (user.equalsIgnoreCase("Admin")) {
            Admin tempAdmin = new Admin("", ""); 
            if (tempAdmin.login(inputUsername, inputPassword)) {
                loginInfo.setText("Login Berhasil");
                loginInfo.setVisible(true);
                AdminDashboard dashboard = new AdminDashboard(inputUsername);
                stage.setScene(dashboard.getScene());
            } else {
                loginInfo.setText("Login Gagal, Silahkan Coba Lagi");
                loginInfo.setVisible(true);
                loginInfo.setTextFill(Color.RED);
                
            }
           
        } else if (user.equalsIgnoreCase("Mahasiswa")) {
            Mahasiswa mahasiswa = new Mahasiswa("", "");
            if (mahasiswa.login(inputUsername, inputPassword)) {
                loginInfo.setText("Login Berhasil");
                loginInfo.setVisible(true);
                MahasiswaDashboard dashboard1 = new MahasiswaDashboard(inputUsername);
                stage.setScene(dashboard1.getScene());
            } else {
                loginInfo.setText("Login Gagal, Silahkan Coba Lagi");
                loginInfo.setVisible(true);
                loginInfo.setTextFill(Color.RED);
            }
            
        }

        
        
    }
}
