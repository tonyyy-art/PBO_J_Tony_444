public class Codelab1 {
    public static void main(String[] args) {

        Hewan Hewan1 = new Hewan("Kucing", "Mamalia", "Nyann~~");
        Hewan Hewan2 = new Hewan("Anjing", "Mamalia", "Woof-Woof!!");

        
        Hewan1.tampilkanInfo();
        System.out.println();
        Hewan2.tampilkanInfo();
        System.out.println();
        
    }
}

class Hewan {
    String nama;
    String jenis;
    String suara;

    public Hewan(String nama, String jenis, String suara) {
        this.nama = nama;
        this.jenis = jenis;
        this.suara = suara;
    }

    public void tampilkanInfo() {
        System.out.println("Nama  : " + nama);
        System.out.println("Jenis : " + jenis);
        System.out.println("Suara : " + suara);
    }
}
