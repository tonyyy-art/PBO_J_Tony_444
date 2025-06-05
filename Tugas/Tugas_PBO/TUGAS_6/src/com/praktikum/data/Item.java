package com.praktikum.data;

public class Item {
    private String name;
    private String description;
    private String location;
    private String Status;

    public Item(String name, String location, String description, String status) {
        this.name = name;
        this.description = description;
        this.location = location;
        this.Status = status;
    }

    public String getName()   {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public String getLocation() {
        return location;
    }
    public String getStatus() {
        return Status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setStatus(String status) {
        this.Status = status;
    }
}
