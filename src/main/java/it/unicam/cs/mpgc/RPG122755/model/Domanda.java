package it.unicam.cs.mpgc.RPG122755.model;

public class Domanda {
    private int id;
    private String Description;

    public Domanda(int id, String description) {
        this.id = id;
        Description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return Description;
    }
}
