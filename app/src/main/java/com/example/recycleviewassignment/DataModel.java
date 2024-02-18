package com.example.recycleviewassignment;

public class DataModel {
    private String name;

    private String description;

    private String bio;

    private int id_;

    private int image;

    public DataModel(String name, String description, int id_, int image, String bio) {
        this.name = name;
        this.description = description;
        this.id_ = id_;
        this.image = image;
        this.bio = bio;
    }

    public DataModel(String name, String description, int id_, int image) {
        this.name = name;
        this.description = description;
        this.id_ = id_;
        this.image = image;
    }

    public int getId_() {
        return id_;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getBio() {
        return bio;
    }

}
