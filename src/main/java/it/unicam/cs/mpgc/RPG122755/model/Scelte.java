package it.unicam.cs.mpgc.RPG122755.model;

public class Scelte {
    private int IdEvento;
    private int id;
    private String Description;
    private int FiduciaPazienti;
    private int Budget;
    private int MoralePersonale;
    private int QualitaCure;

    public Scelte(int id, int IdEvento, int qualitaCure, int moralePersonale, int budget, int fiduciaPazienti, String description) {
        this.QualitaCure = qualitaCure;
        this.MoralePersonale = moralePersonale;
        this.Budget = budget;
        this.FiduciaPazienti = fiduciaPazienti;
        this.Description = description;
        this.id = id;
        this.IdEvento = IdEvento;
    }

    public int getId() {
        return id;
    }

    public int getIdEvento() {
        return IdEvento;
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

    @Override
    public String toString() {
        return "Fiducia Pazienti = " + getFiduciaPazienti() + System.lineSeparator() +
               "Budget Reparto = " + getBudget() + System.lineSeparator() +
               "Morale Personale = " + getMoralePersonale() + System.lineSeparator() +
               "Qualità Cure = " + getQualitaCure() + System.lineSeparator();
    }
}
