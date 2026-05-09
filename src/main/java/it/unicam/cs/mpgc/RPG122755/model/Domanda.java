package it.unicam.cs.mpgc.RPG122755.model;

public class Domanda {
    private int id;
    private String Description;
    private TypeReparto typeReparto;

    public Domanda(int id, String description, TypeReparto typeReparto) {
        this.id = id;
        this.Description = description;
        this.typeReparto = typeReparto;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return Description;
    }

    public TypeReparto getReparto(){
        return typeReparto;
    }
}
