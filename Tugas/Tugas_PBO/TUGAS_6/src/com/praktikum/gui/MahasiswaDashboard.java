package com.praktikum.gui;

import javafx.scene.Scene;
import com.praktikum.data.Item;
import com.praktikum.data.Database;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class MahasiswaDashboard {
    private Stage stage;
    private Label header = new Label("Hallo Mahasiswa");
    private Label report = new Label("Laporan Hilang Barang/Teman");

    private TextField namaBarang = new TextField();
    private TextField lokasiBarang = new TextField();
    private TextField deskripsi = new TextField();
    private Button addReport = new Button("Laporkan");

    private HBox reportBox = new HBox(10, namaBarang, deskripsi, lokasiBarang, addReport);

    private TableView<Item> reportTable = new TableView<>();
    private TableColumn<Item, String> column1 = new TableColumn<>("Nama Barang");
    private TableColumn<Item, String> column2 = new TableColumn<>("Lokasi");
    private TableColumn<Item, String> column3 = new TableColumn<>("Status");

    {
        column1.setMinWidth(150);
        column2.setMinWidth(150);
        column3.setMinWidth(100);
    }
    private Button logout = new Button("Logout");

    private VBox layout = new VBox(10, header, report, reportBox, reportTable, logout);

    private Scene scene = new Scene(layout,  850, 500);

    public Scene getScene() {
        return scene;
    }

    public MahasiswaDashboard(String name) {
        column1.setCellValueFactory(new PropertyValueFactory<>("name"));
        column2.setCellValueFactory(new PropertyValueFactory<>("location"));
        column3.setCellValueFactory(new PropertyValueFactory<>("status"));
        reportTable.getColumns().addAll(column1, column2, column3);
        reportTable.setStyle("-fx-background-color: lightblue;");
        header.setText("Hallo " + name);
        logout.setOnAction(e -> logout());
        addReport.setOnAction(e -> addReport());
        namaBarang.setPromptText("Nama Barang");
        lokasiBarang.setPromptText("Lokasi Barang");
        deskripsi.setPromptText("Deskripsi (Opsional)");
        updateTable();
    }

    public void addReport() {
        String name = namaBarang.getText();
        String location = lokasiBarang.getText();
        String description = deskripsi.getText();
        
        if (!name.isEmpty() && !location.isEmpty()) {
            Database.reportItems.add(new Item(name, location, description, "Reported"));
            namaBarang.clear();
            lokasiBarang.clear();
            deskripsi.clear();
            updateTable();
        }
    }

    public void updateTable(){
        reportTable.getItems().clear();
        for (Item item : Database.reportItems) {
            reportTable.getItems().add(new Item(item.getName(), item.getLocation(), item.getDescription(), item.getStatus()));
        }
    }

    public void logout() {
        stage = (Stage) ((Node) logout).getScene().getWindow();
        LoginPane loginPane = new LoginPane();
        stage.setScene(loginPane.getScene());
    }
    
}
