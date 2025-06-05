package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;
import com.praktikum.data.Database;

public class Mahasiswa extends User implements MahasiswaActions {


    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public boolean login(String inputNama, String inputNim) {
        boolean isValid = false;
        for (User user : Database.userList) {
            if (user instanceof Mahasiswa) {
                Mahasiswa mhs = (Mahasiswa) user;
                if (mhs.getUsername().equalsIgnoreCase(inputNama) && mhs.getPassword().equals(inputNim)) {
                    isValid = true;
                    break;
                }
            }
        }
        return isValid;
    }
    
}