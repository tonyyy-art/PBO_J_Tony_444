package app;

import perpustakaan.*;

public class Main {
    public static void main(String[] args) {
        Buku buku1 = new NonFiksi("Madilog", "Tan Malaka", "Sejarah & Ilmu Pengetahuan");
        Buku buku2 = new Fiksi("Hainuwele: Sang Putri Kelapa", "Lilis Hu", "Dongeng");

        buku1.displayInfo();
        buku2.displayInfo();
        System.out.println();

        Anggota anggota1 = new Anggota("Ahmad Fathoni", "J444");
        Anggota anggota2 = new Anggota("Daffa Farrel", "J475");
        System.out.println();

        System.out.println("Anggota: " + anggota1.getNama() + " (ID: " + anggota1.getIdAnggota() + ")");
        System.out.println("Anggota: " + anggota2.getNama() + " (ID: " + anggota2.getIdAnggota() + ")");
        System.out.println();

        anggota1.pinjamBuku(buku1.getJudul());
        anggota2.pinjamBuku(buku2.getJudul(), 7);
        System.out.println();

        anggota1.kembalikanBuku(buku1.getJudul());
        anggota2.kembalikanBuku(buku2.getJudul());
    }
}
