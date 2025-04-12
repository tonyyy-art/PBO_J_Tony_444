public class Mahasiswa {
    String nama = "Ahmad Fathoni";
    String nim = "202410370110444";

    public boolean login(String inputNama, String inputNim) {
        return inputNama.equals(nama) && inputNim.equals(nim);
    }

    public void displayInfo() {
        System.out.println("Login berhasil!");
        System.out.println("Nama Mahasiswa : " + nama);
        System.out.println("NIM            : " + nim);
    }
}
