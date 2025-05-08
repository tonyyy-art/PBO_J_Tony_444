package com.praktikum.users;

import com.praktikum.actions.AdminActions;
import java.util.Scanner;

public class Admin extends User implements AdminActions{
    private String username;
    private String password;

    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }
     
    @Override
    public boolean login(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }
    
    public void manageItems() {
        System.out.println(">> Fitur Kelola Barang Belum tersedia <<");
    }

    public void manageUsers() {
        System.out.println(">> Fitur Kelola Mahasiswa Belum Tersedia <<");
    }

    @Override
    public void displayAppMenu(){

        while (true) {
            Scanner scanner = new Scanner(System.in);
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
        }
        
    }

    @Override
    public void displayIfo() {
        System.out.println("Nama: " + getNama());
        System.out.println("NIM: " + getNim());
    }


}
