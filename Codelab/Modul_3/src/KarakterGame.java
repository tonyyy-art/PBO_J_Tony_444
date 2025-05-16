// Superclass KarakterGame
class KarakterGame {
    private String nama;
    private int kesehatan;

    // Constructor
    public KarakterGame(String nama, int kesehatan) {
        this.nama = nama;
        this.kesehatan = kesehatan;
    }

    // Getter and Setter untuk nama
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    // Getter and Setter untuk kesehatan
    public int getKesehatan() {
        return kesehatan;
    }

    public void setKesehatan(int kesehatan) {
        this.kesehatan = kesehatan;
    }

    public void serang(KarakterGame target) {
        // To be overridden by subclass
    }
}
