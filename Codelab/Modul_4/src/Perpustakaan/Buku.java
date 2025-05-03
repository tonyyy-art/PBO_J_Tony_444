package perpustakaan;

public abstract class Buku {
    protected String judul;
    protected String penulis;
    protected String genre;

    public Buku(String judul, String penulis, String genre){
        this.judul = judul;
        this.penulis = penulis;
        this.genre = genre;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getJudul() {
        return judul;
    }

    public abstract void displayInfo();
}
