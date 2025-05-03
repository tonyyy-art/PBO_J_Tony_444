package perpustakaan;

public class Anggota implements Peminjaman{
    private String nama;
    private String idAnggota;

    public Anggota(String Nama, String idAnggota){
        this.nama = Nama;
        this.idAnggota = idAnggota;
    }

    public void pinjamBuku(String judul) {
        System.out.println(nama + " meminjam buku berjudul: " + judul);
    }

    public void pinjamBuku(String judul, int durasi) {
        System.out.println(nama + " meminjam buku \"" + judul + "\" selama " + durasi + " hari.");
    }

    @Override
    public void kembalikanBuku(String judul) {
        System.out.println(nama + " mengembalikan buku berjudul: " + judul);
    }

    public String getIdAnggota() {
        return idAnggota;
    }

    public String getNama() {
        return nama;
    }
}

