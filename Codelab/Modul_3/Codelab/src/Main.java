// Main class
public class Main {
    public static void main(String[] args) {
        // Membuat objek KarakterGame, Pahlawan, dan Musuh
        KarakterGame KarakterUmum = new KarakterGame("Karakterumum", 100);
        Pahlawan brimstone = new Pahlawan("Brimston", 150);
        Musuh viper = new Musuh("Viper", 200);

        // Menampilkan status awal
        System.out.println("Status awal:");
        for (int i = 0 ; i < 2; i++) {
            if (i == 0){
                System.out.println(brimstone.getNama() + " memiliki kesehatan: " + brimstone.getKesehatan());
            }else{
                System.out.println(viper.getNama() + " memiliki kesehatan: " + viper.getKesehatan());
            }
        }
        
        /* Simulasi pertarungan
        System.out.println(brimstone.getNama() + " menyerang " + viper.getNama() + " menggunakan Orbital Strike!");
        viper.setKesehatan(viper.getKesehatan() - 20); // Simulasi serangan
        System.out.println(viper.getNama() + " sekarang memiliki kesehatan " + viper.getKesehatan());

        System.out.println(viper.getNama() + " menyerang " + brimstone.getNama() + " menggunakan Snake Bite!");
        brimstone.setKesehatan(brimstone.getKesehatan() - 15); // Simulasi serangan
        System.out.println(brimstone.getNama() + " sekarang memiliki kesehatan " + brimstone.getKesehatan()); */

        brimstone.serang(viper);
        viper.serang(brimstone);
    }
}
