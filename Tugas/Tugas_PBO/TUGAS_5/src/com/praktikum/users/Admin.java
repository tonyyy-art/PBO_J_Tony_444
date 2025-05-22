package com.praktikum.users;

import com.praktikum.actions.AdminActions;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.praktikum.data.Database;
import com.praktikum.data.Item;


public class Admin extends User implements AdminActions{

    Scanner scanner = new Scanner(System.in);
    public Admin(String username, String password) {
        super(username, password);
    }
     
    @Override
    public User login(String inputUsername, String inputPassword) {
        for (User user : Database.userList) {
            if (user instanceof Admin) {
                Admin admin = (Admin) user;
                if (admin.getUsername().equalsIgnoreCase(inputUsername) && admin.getPassword().equals(inputPassword)) {
                    return admin;
                    
                }
            }
        }
        return null;
    }
    
    public void manageItems() {
        if (Database.reportItems.isEmpty()) {
            System.out.println("Tidak ada laporan yang tersedia.");
            return;
        }

        try {
            System.out.println("========================Daftar laporan================================");
            for (int i = 0; i < Database.reportItems.size(); i++) {
                Item item = Database.reportItems.get(i);
                System.out.println((i) + ". " + item.getName() + " - " + item.getDescription() + " - " + item.getLocation() + " - " + item.getStatus());
            }
            System.out.println("======================================================================");
            System.out.print("Pilih index barang yang ingin diambil: ");
            int index = scanner.nextInt();

            if (Database.reportItems.get(index).getStatus().equals("Claimed")) {
                throw new Exception("Barang sudah diambil!");
            }

            System.out.print("konfirmasi (ya/tidak): ");
            String konfirmasi = scanner.next();
            if (konfirmasi.equalsIgnoreCase("ya") || konfirmasi.equalsIgnoreCase("y")) {
                Database.reportItems.get(index).setStatus("Claimed");
                System.out.println("Barang berhasil diambil!");
            } else {
                System.out.println("Pengambilan dibatalkan.");
            }

        }catch (InputMismatchException e) {
            System.out.println("Input tidak valid! Harap masukkan angka.");
            scanner.nextLine(); // Clear the invalid input
            return;
        }catch (IndexOutOfBoundsException e) {
            System.out.println("Index tidak valid! Harap masukkan index yang sesuai.");
            return;
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        

    }

    public void manageUsers() {
    
        System.out.println("===Menu manage users===");
        System.out.println("1. Tambah Mahasiswa\n2. Hapus Mahasiswa");
        System.out.print("Pilih : ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // consume newline

        switch (pilihan) {
            case 1:
                System.out.println("===Tambah Mahasiswa===");
                System.out.print("Masukkan Nama: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan NIM: ");
                String nim = scanner.nextLine();
                
                System.out.print("konfirmasi (ya/tidak): ");
                String konfirmasi = scanner.nextLine();
                if (konfirmasi.equalsIgnoreCase("ya") || konfirmasi.equalsIgnoreCase("y")) {
                    Database.userList.add(new Mahasiswa(nama, nim));
                    System.out.println("Mahasiswa berhasil ditambahkan!");
                } else {
                    System.out.println("Penambahan dibatalkan.");
                }
                break;
            case 2:
                System.out.println("===Hapus Mahasiswa===");
                System.out.print("Masukkan NIM: ");
                String nimHapus = scanner.nextLine();

                for (int i = 0; i < Database.userList.size(); i++) {
                    User user = Database.userList.get(i);
                    if (user instanceof Mahasiswa) {
                        Mahasiswa mahasiswa = (Mahasiswa) user;
                        if (mahasiswa.getPassword().equals(nimHapus)) {                      
                            System.out.print("konfirmasi (ya/tidak): ");
                            String konfirmasiHapus = scanner.nextLine();
                            if (konfirmasiHapus.equalsIgnoreCase("ya") || konfirmasiHapus.equalsIgnoreCase("y")) {
                                Database.userList.remove(i);
                                System.out.println("Mahasiswa berhasil dihapus!");
                            } else {
                                System.out.println("Penghapusan dibatalkan.");
                            }
                            return;
                        }
                    }

                    if (i == Database.userList.size() - 1) {
                        System.out.println("Mahasiswa tidak ditemukan!");
                        
                    }
                }
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                break;
        }
    }

    @Override
    public void displayAppMenu(){

        while (true) {
            try {
                System.out.println("=== Menu Admin ===");
                System.out.println("1. Kelola Laporan Barang\n2. Kelola Data Mahasiswa\n0. Logout");
                System.out.print("Pilih : ");
                int pilihan = scanner.nextInt();

                if (pilihan == 1) {
                    manageItems();
                }
                else if (pilihan == 2){
                    manageUsers();
                }else if(pilihan == 0){
                    System.out.println("Logout Berhasil!");
                    break;
                }else{
                    System.out.println("Pilihan tidak valid!");
                }
            }catch (InputMismatchException e) {
                System.out.println("Input tidak valid! Harap masukkan angka.");
                scanner.nextLine(); 
            
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
    }

    @Override
    public void displayInfo() {
        System.out.println("Nama: " + getUsername());
        System.out.println("NIM: " + getPassword());
    }


}
