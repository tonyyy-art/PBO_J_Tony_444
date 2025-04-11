import java.util.Scanner;

public class Tugas1 {
    private static Scanner penginput = new Scanner(System.in);

    public static void main(String[] args) {
    
        System.out.print("Pilih Login:\n1. Admin\n2. Mahasiswa\nMasukkan Pilihan: ");
        int pilihan = penginput.nextInt();
        penginput.nextLine(); 
        switch (pilihan) {
            case 1:
                admin();
                break;
            case 2:
                mahasiswa();
                break;
            default:
                System.out.println("Pilihan tidak valid.");
                break;
            }
        
    }

    public static void admin() {
        System.out.print("Masukkan username: ");
        String usernameAdmin = penginput.nextLine();
        System.out.print("Masukkan Password: ");
        String passwordAdmin = penginput.nextLine();

        if (usernameAdmin.equals("admin444") && passwordAdmin.equals("password444")) {
            System.out.println("Login Admin Berhasil!");
        } else {
            System.out.println("Login gagal! Username atau password salah.");
        }
    }

    public static void mahasiswa() {
        System.out.print("Masukkan username: ");
        String usernamemahasiswa = penginput.nextLine();
        System.out.print("Masukkan NIM: ");
        String passwordmahasiswa = penginput.nextLine();

        if (usernamemahasiswa.equals("ahmadfathoni") && passwordmahasiswa.equals("202410370110444")) {
            System.out.println("Login Mahasiswa Berhasil!");
        } else {
            System.out.println("Login gagal! Nama atau NIM salah.");
        }
    }
}