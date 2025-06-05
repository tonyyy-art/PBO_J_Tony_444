package com.praktikum.users;

import com.praktikum.data.Database;

public class test {

    public static void testData() {
        Database.userList.add(new Admin("admin444", "password444"));
        Database.userList.add(new Mahasiswa("Ahmad Fathoni", "202410370110444"));

    }
}
