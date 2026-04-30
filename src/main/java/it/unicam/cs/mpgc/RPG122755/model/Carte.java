package it.unicam.cs.mpgc.RPG122755.model;

public class Carte {
    private int IdDomanda;
    private int id;
    private String Description;
    private int FiduciaPazienti;
    private int Budget;
    private int MoralePersonale;
    private int QualitaCure;

    public Carte(int id,int IdDomanda,int qualitaCure, int moralePersonale, int budget, int fiduciaPazienti, String description) {
        this.QualitaCure = qualitaCure;
        this.MoralePersonale = moralePersonale;
        this.Budget = budget;
        this.FiduciaPazienti = fiduciaPazienti;
        this.Description = description;
        this.id = id;
        this.IdDomanda = IdDomanda;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return Description;
    }

    public int getFiduciaPazienti() {
        return FiduciaPazienti;
    }

    public int getBudget() {
        return Budget;
    }

    public int getMoralePersonale() {
        return MoralePersonale;
    }

    public int getQualitaCure() {
        return QualitaCure;
    }
}
