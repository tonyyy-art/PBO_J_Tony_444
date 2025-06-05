package com.praktikum.data;

import java.util.ArrayList;
import com.praktikum.users.User;

public class Database {
    public static ArrayList<Item> reportItems = new ArrayList<>();
    public static ArrayList<User> userList = new ArrayList<>();

    public static ArrayList<User> getUserList() {
        return userList;
    }
}
