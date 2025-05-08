package com.praktikum.users;

public abstract class User {
    private String nama;
    private String nim;

    public User(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    // Getter dan Setter
    public void setNama (String nama){
        this.nama = nama;
    }

    public void setNIM (String nim){
        this.nim = nim;
    }

    
    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public abstract boolean login(String inputNama, String inputNIM);
    public abstract void displayAppMenu();
    public abstract void displayIfo();
    

}
