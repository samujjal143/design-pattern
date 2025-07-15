package org.example.prototype;

public class BlackSheep implements Sheep {
    private String name;

    public BlackSheep(String name) {
        this.name = name;
    }

    public Sheep clone() {
        return new BlackSheep(this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}