package com.company.enitites;

/**
 * Created by Serhii_Kobzar on 10/4/2016.
 */
public class Genres {
    private int id;
    private String name;

    public Genres(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Genres() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Genres{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
