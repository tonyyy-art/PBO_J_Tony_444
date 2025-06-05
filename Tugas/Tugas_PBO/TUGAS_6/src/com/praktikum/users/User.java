package com.praktikum.users;

public abstract class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter dan Setter
    public void setUsername (String Username){
        this.username = Username;
    }

    public void setPassword (String password){
        this.password = password;
    }
    
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public abstract boolean login(String inputNama, String inputNIM);

}
