package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;
import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions{

    Scanner scanner = new Scanner(System.in);

    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    @Override
        public boolean login(String inputNama, String inputNim) {
        return getNama().equals(inputNama) && getNim().equals(inputNim);
    }

    public void reportItems() {
        System.out.print("massukan nama barang : ");
        String namaBarang = scanner.nextLine();
        scanner.nextLine();
        System.out.print("masukkan deskripsi barang : ");
        String deskripsiBarang = scanner.nextLine();
        System.out.print("masukkan lokasi barang : ");
        String lokasiBarang = scanner.nextLine();
        System.out.print("Konfirmasi (ya/tidak) : ");
        String konfirmasi = scanner.nextLine();
        //scanner.nextLine();

        if (konfirmasi.equalsIgnoreCase("ya") || konfirmasi.equalsIgnoreCase("y")) {
            System.out.println("Laporan berhasil dikirim!");
        } else {
            System.out.println("Laporan dibatalkan.");
        }
    }

    public void viewReportedItems() {
        System.out.println(">> Fitur Lihat Laporan Belum Tersedia <<");
    }

    @Override
    public void displayAppMenu() {
        

        while (true) {

            System.out.println("=== Menu Mahasisswa ===");
            displayIfo();
            System.out.println("1. Laporkan Barang Temuan/Hilang\n2. Lihat Daftar Laporan\n0. Logout");
            System.out.print("Pilih : ");
            int pilihan = scanner.nextInt();
            
            if (pilihan == 1) {
                reportItems();  
            }
            else if (pilihan == 2){
                viewReportedItems();
            }else if(pilihan == 0){
                System.out.println("Logout berhasil!");
                break;
            }else
            {
                System.out.println("Pilihan tidak valid!");
            }
       
        }
        
    }

    @Override
        public void displayIfo() {
            System.out.println("Username : " + getNama());
            System.out.println("NIM: " + getNim());
        }
    
}