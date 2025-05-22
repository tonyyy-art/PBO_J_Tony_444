package com.praktikum.users;

import java.util.InputMismatchException;
import com.praktikum.actions.MahasiswaActions;
import com.praktikum.data.Database;
import com.praktikum.data.Item;
import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions {

    Scanner scanner = new Scanner(System.in);

    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public User login(String inputNama, String inputNim) {
        for (User user : Database.userList) {
            if (user instanceof Mahasiswa) {
                Mahasiswa mhs = (Mahasiswa) user;
                if (mhs.getUsername().equalsIgnoreCase(inputNama) && mhs.getPassword().equals(inputNim)) {
                    return mhs;
                }
            }
        }
        return null;
    }

    public void reportItems() {
        System.out.print("Masukkan nama barang : ");
        String namaBarang = scanner.nextLine();

        System.out.print("Masukkan deskripsi barang : ");
        String deskripsiBarang = scanner.nextLine();

        System.out.print("Masukkan lokasi barang : ");
        String lokasiBarang = scanner.nextLine();

        System.out.print("Konfirmasi (ya/tidak) : ");
        String konfirmasi = scanner.nextLine();
        //scanner.nextLine();

        if (konfirmasi.equalsIgnoreCase("ya") || konfirmasi.equalsIgnoreCase("y")) {
            Database.reportItems.add(new Item(namaBarang, deskripsiBarang, lokasiBarang, "Reported"));
            System.out.println("Laporan berhasil dikirim!");
        } else {
            System.out.println("Laporan dibatalkan.");
        }
    }

    public void viewReportedItems() {
        if (Database.reportItems.isEmpty()) {
            System.out.println("Tidak ada laporan yang tersedia.");
            return;
        }
        System.out.println("======================Daftar laporan==================================");
        for (int i = 0; i < Database.reportItems.size(); i++) {
            Item item = Database.reportItems.get(i);
            System.out.println((i) + ". " + item.getName() + " - " + item.getDescription() + " - " + item.getLocation() + " - " + item.getStatus());
        }
        System.out.println("======================================================================");
    }

    @Override
    public void displayAppMenu() {
        

        while (true) {

            try {
                System.out.println("=== Menu Mahasisswa ===");
                displayInfo();
                System.out.println("1. Laporkan Barang Temuan/Hilang\n2. Lihat Daftar Laporan\n0. Logout");
                System.out.print("Pilih : ");
                int pilihan = scanner.nextInt();
                scanner.nextLine(); // consume the leftover newline
            
                if (pilihan == 1) {
                    reportItems();  
                }
                else if (pilihan == 2){
                    viewReportedItems();
                }else if(pilihan == 0){
                    System.out.println("Logout berhasil!");
                    break;
                }else{
                System.out.println("Pilihan tidak valid!");
                }
            }catch (InputMismatchException e) {
                System.out.println("Input tidak valid! Harap masukkan angka.");
                scanner.nextLine();
            }catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
            }
       
        }
        
    }

    @Override
        public void displayInfo() {
            System.out.println("Username : " + getUsername());
            System.out.println("NIM: " + getPassword());
        }

    
}