// Kelas RekeningBank
class RekeningBank {
    // Atribut
    String nomorRekening;
    String namaPemilik;
    double saldo;

    public RekeningBank(String nomorRekening, String namaPemilik, double saldo) {
        this.nomorRekening = nomorRekening;
        this.namaPemilik = namaPemilik;
        this.saldo = saldo;
    }

    // Method untuk menampilkan informasi rekening
    public void tampilkanInfo() {
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.println("Saldo: Rp" + saldo);
        System.out.println();
    }

    // Method untuk setor uang
    public void setorUang(double jumlah) {
        saldo += jumlah;
        System.out.println(namaPemilik + " menyetor Rp" + jumlah + ". Saldo sekarang: Rp" + saldo);
    }

    // Method untuk tarik uang
    public void tarikUang(double jumlah) {
        if (saldo >= jumlah) {
            saldo -= jumlah;
            System.out.println(namaPemilik + " menarik Rp" + jumlah + ". (Berhasil) Saldo sekarang: Rp" + saldo);
        } else {
            System.out.println(namaPemilik + " menarik Rp" + jumlah + ". (Gagal, Saldo tidak mencukupi) Saldo saat ini: Rp" + saldo);
        }
    }
}

// Kelas Main
public class Codelab2 {
    public static void main(String[] args) {
        // Membuat dua objek RekeningBank
        RekeningBank rekening1 = new RekeningBank("202310370110444", "Ahmad fathoni", 500000);
        RekeningBank rekening2 = new RekeningBank("202310370110485", "Daffa farrel", 1000000);

        // Menampilkan informasi awal rekening
        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();

        // Melakukan setor uang dan tarik uang
        rekening1.setorUang(200000); // setor uang ke rekening1
        rekening2.setorUang(500000); // setor uang ke rekening2
        System.out.println();
        rekening1.tarikUang(800000); // coba tarik uang lebih banyak dari saldo rekening1
        rekening2.tarikUang(300000); // tarik uang dari rekening2
        System.out.println();

        // Menampilkan informasi akhir rekening
        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();
    }
}
