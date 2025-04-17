public class Mahasiswa extends User {

    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public boolean login(String inputNama, String inputNim) {
        return getNama().equalsIgnoreCase(inputNama) && getNim().equals(inputNim);
    }

    @Override
    public void displayInfo() {
        System.out.println("Login berhasil!");
        System.out.println("Nama: " + getNama());
        System.out.println("NIM : " + getNim());
    }
}
