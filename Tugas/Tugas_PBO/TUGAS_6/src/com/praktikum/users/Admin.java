package com.praktikum.users;

import com.praktikum.actions.AdminActions;
import com.praktikum.data.Database;


public class Admin extends User implements AdminActions{
    public Admin(String username, String password) {
        super(username, password);
    }
     
    @Override
    public boolean login(String inputUsername, String inputPassword) {
        boolean isValid = false;
        for (User user : Database.userList) {
            if (user instanceof Admin) {
                Admin admin = (Admin) user;
                if (admin.getUsername().equalsIgnoreCase(inputUsername) && admin.getPassword().equals(inputPassword)) {
                    isValid = true;
                    break;
                    
                }
            }
        }
        return isValid;
    }

    

}
