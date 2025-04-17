import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Admin admin = new Admin("Admin444", "444", "admin444", "password444");
        Mahasiswa mahasiswa = new Mahasiswa("Ahmad Fathoni", "202410370110444");

        System.out.println("===Selamat datang===");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Pilih opsi (1/2): ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // consume newline

        boolean isLoginBerhasil = false;

        switch (pilihan) {
            case 1:
                System.out.print("Masukkan Username: ");
                String username = scanner.nextLine();
                System.out.print("Masukkan Password: ");
                String password = scanner.nextLine();

                if (admin.login(username, password)) {
                    isLoginBerhasil = true;
                    admin.displayInfo();
                } else {
                    System.out.println("Login gagal! Username atau password salah.");
                }
                break;

            case 2:
                System.out.print("Masukkan Nama: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan NIM : ");
                String nim = scanner.nextLine();

                if (mahasiswa.login(nama, nim)) {
                    isLoginBerhasil = true;
                    mahasiswa.displayInfo();
                } else {
                    System.out.println("Login gagal! Nama atau NIM salah.");
                }
                break;

            default:
                System.out.println("Pilihan tidak valid.");
        }

        scanner.close();
    }
}
