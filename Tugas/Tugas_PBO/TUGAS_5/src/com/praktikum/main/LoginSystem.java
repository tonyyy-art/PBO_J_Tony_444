package com.praktikum.main;
import java.util.Scanner;
import com.praktikum.users.*;
import com.praktikum.data.*;
import java.util.InputMismatchException;

public class LoginSystem {
    
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
       
        try  {
            Database.userList.add(new Admin( "admin444", "password444"));
            Database.userList.add(new Mahasiswa("Ahmad Fathoni", "202410370110444"));
   
            while (true) {
                int pilihan;
                
                System.out.println("===Selamat datang===");
                System.out.println("1. Admin");
                System.out.println("2. Mahasiswa");
                System.out.println("3. Keluar");
                System.out.print("Pilih opsi (1-3): ");
                try {
                    pilihan = scanner.nextInt();
                    scanner.nextLine(); 
                }catch (InputMismatchException e) {
                    System.out.println("Input harus berupa angka.");
                    scanner.nextLine(); 
                    continue; 
                }
               

                switch (pilihan) {
                    case 1:
                        System.out.print("Masukkan Username: ");
                        String username = scanner.nextLine();
                        System.out.print("Masukkan Password: ");
                        String password = scanner.nextLine();

                        Admin tempAdmin = new Admin("", "");
                        User AdminLogin = tempAdmin.login(username, password);
                            if (tempAdmin.login(username, password) != null) {
                                Admin admin = (Admin) AdminLogin;
                                System.out.println("Login Berhasil!");
                                admin.displayAppMenu();
                            } else {
                                System.out.println("Login Gagal! Silakan coba lagi.");
                        }
                        break;
                    case 2:
                        System.out.print("Masukkan Nama: ");
                        username = scanner.nextLine();
                        System.out.print("Masukkan NIM : ");
                        password = scanner.nextLine();

                        Mahasiswa tempMahasiswa = new Mahasiswa("","");
                        User mahasiswaLogin = tempMahasiswa.login(username, password);
                        if(tempMahasiswa.login(username, password) != null) {
                            Mahasiswa mahasiswa = (Mahasiswa) mahasiswaLogin;
                            System.out.println("Login Berhasil!");
                            mahasiswa.displayAppMenu();
                        } else {
                            System.out.println("Login Gagal! Silakan coba lagi.");
                        }     
                        break;
                    case 3:
                        System.out.println("Terima kasih telah menggunakan sistem ini.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                    }
                
            }
        
        } catch (NullPointerException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }

    //scanner.close();

}
