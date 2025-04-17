public class User {
    private String nama;
    private String nim;

    public User(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public boolean login(String input1, String input2) {
        System.out.println("Login dari kelas User");
        return false;
    }

    public void displayInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
    }
}
