package com.praktikum.gui;

import com.praktikum.data.Item;
import com.praktikum.data.Database;
import com.praktikum.users.Mahasiswa;
import com.praktikum.users.User;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;

public class AdminDashboard {
    private Stage stage;

    private Label header = new Label("Hallo Administrator Admin");
    private Label report = new Label("Laporan Barang");

    private TableView<Item> reportTable = new TableView<>();

    private TableColumn<Item, String> column1 = new TableColumn<>("Nama");
    private TableColumn<Item, String> column2 = new TableColumn<>("Lokasi");
    private TableColumn<Item, String> column3 = new TableColumn<>("Deskripsi");
    private TableColumn<Item, String> column4 = new TableColumn<>("Status");

    private Button check = new Button("Tandai Barang");
    private Button logout = new Button("Logout");
    private TextField namaBarang = new TextField();
    private TextField lokasiBarang = new TextField();
    private HBox reportBox = new HBox(10, namaBarang, lokasiBarang, check);

    private VBox layout1 = new VBox(5, report, reportTable, reportBox);

    private Label temp2 = new Label("");
    private Label mahasiswaLabel = new Label("Daftar Mahasiswa");
    private TableView<User> mahasiswaTable = new TableView<>();
    private TableColumn<User, String> namaColumn = new TableColumn<>("Nama");
    private TableColumn<User, String> nimColumn = new TableColumn<>("NIM");

    private TextField namaMahasiswa = new TextField();
    private TextField nimMahasiswa = new TextField(); 
    private Button addMahasiswa = new Button("Tambah");
    private Button deleteMahasiswa = new Button("Hapus");
    private HBox addMhs = new HBox(10, namaMahasiswa, nimMahasiswa, addMahasiswa, deleteMahasiswa);

    private VBox dataMahasiswa = new VBox(10, mahasiswaLabel, mahasiswaTable, addMhs);

    private HBox Layout = new HBox(10, layout1, dataMahasiswa);
    private VBox mainLayout = new VBox(10, header, Layout, logout);


    public Scene scene = new Scene(mainLayout, 850, 500);
    

    public Scene getScene() {
        return scene;
    }

    public AdminDashboard(String username) {
        column1.setCellValueFactory(new PropertyValueFactory<>("name"));
        column2.setCellValueFactory(new PropertyValueFactory<>("location"));
        column3.setCellValueFactory(new PropertyValueFactory<>("description"));
        column4.setCellValueFactory(new PropertyValueFactory<>("Status"));
        namaColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        nimColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        reportTable.getColumns().addAll(column1, column2, column3, column4);
        reportTable.setPrefWidth(0.5 * 300);
        mahasiswaTable.getColumns().addAll(namaColumn, nimColumn); 
        namaBarang.setPromptText("Nama Barang");
        lokasiBarang.setPromptText("Lokasi Barang");
        namaMahasiswa.setPromptText("Nama Mahasiswa");
        nimMahasiswa.setPromptText("NIM Mahasiswa");
        namaBarang.setPrefWidth(0.3 * 400);
        lokasiBarang.setPrefWidth(0.3 * 400);
        reportTable.setStyle("-fx-background-color: lightblue;");
        header.setText("Hallo Administrator " + username);
        mahasiswaTable.setStyle("-fx-background-color: pink;");
        updateReportTable();
        updateMahasiswaTable();
        addMahasiswa.setOnAction(e -> addMahasiswa());
        deleteMahasiswa.setOnAction(e -> deleteMahasiswa());
        logout.setOnAction(e -> logout());
        check.setOnAction(w -> addReport());
        mainLayout.setStyle("-fx-background-color: lightgrey;");;
    }

    public void updateReportTable() {
        reportTable.getItems().clear();
        for (Item item : Database.reportItems) {
            reportTable.getItems().add(new Item(item.getName(), item.getLocation(), item.getDescription(), item.getStatus()));
        }
        
    }

    public void updateMahasiswaTable() {
        mahasiswaTable.getItems().clear();
        for (User mhs : Database.userList) {
            if (mhs instanceof Mahasiswa) {
                Mahasiswa mahasiswa = (Mahasiswa) mhs;
                mahasiswaTable.getItems().add(new Mahasiswa(mahasiswa.getUsername(), mahasiswa.getPassword()));
            }
            
        }
    }

    public void addMahasiswa() {
        String nama = namaMahasiswa.getText();
        String nim = nimMahasiswa.getText();
        if (!nama.isEmpty() && !nim.isEmpty()) {
            Database.userList.add(new Mahasiswa(nama, nim));
            updateMahasiswaTable();
            namaMahasiswa.clear();
            nimMahasiswa.clear();
        } else {
            temp2.setText("Nama dan NIM tidak boleh kosong!");
        }
    }

    public void deleteMahasiswa() {
        String nim = nimMahasiswa.getText();
        String nama = namaMahasiswa.getText();
        if (!nim.isEmpty()) {
            for (int i = 0; i < Database.userList.size(); i++) {
                User user = Database.userList.get(i);
                if (user instanceof Mahasiswa) {
                    Mahasiswa mahasiswa = (Mahasiswa) user;
                    if (mahasiswa.getPassword().equals(nim) && mahasiswa.getUsername().equals(nama)) {
                        Database.userList.remove(i);
                        updateMahasiswaTable();
                        temp2.setText("Mahasiswa dengan NIM " + nim + " telah dihapus!");
                        break;
                    }
                }
                
            }
            temp2.setText("Mahasiswa dengan NIM " + nim + " tidak ditemukan!");
        } else {
            temp2.setText("NIM tidak boleh kosong!");
        }
        namaMahasiswa.clear();
        nimMahasiswa.clear();
    }

    public void addReport() {
        String name = namaBarang.getText();
        String location = lokasiBarang.getText();
        
        if (!name.isEmpty() && !location.isEmpty()) {
            for (Item item : Database.reportItems) {
                if (item.getName().equalsIgnoreCase(name) && item.getLocation().equalsIgnoreCase(location) && item.getStatus().equalsIgnoreCase("Reported")) {
                    item.setStatus("Claimed");
                    namaBarang.clear();
                    lokasiBarang.clear();
                    updateReportTable();
                    return;
                }
            }
        }
    }

    public void logout() {
        stage = (Stage) ((Node) logout).getScene().getWindow();
        LoginPane loginPane = new LoginPane();
        stage.setScene(loginPane.getScene());
    }

}

