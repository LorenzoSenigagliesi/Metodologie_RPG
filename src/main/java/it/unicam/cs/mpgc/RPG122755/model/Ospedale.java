package it.unicam.cs.mpgc.RPG122755.model;

public class Ospedale {
    private int FiduciaPazienti;
    private int Budget;
    private int MoralePersonale;
    private int QualitaCure;

    public Ospedale(){
        FiduciaPazienti = 50;
        Budget = 50;
        MoralePersonale = 50;
        QualitaCure = 50;
    }

    public int getFiduciaPazienti() {
        return FiduciaPazienti;
    }

    public void setFiduciaPazienti(int fiduciaPazienti) {
        FiduciaPazienti = fiduciaPazienti;
        if (FiduciaPazienti > 100) {
            FiduciaPazienti = 100;
        }
    }

    public int getBudget() {
        return Budget;
    }

    public void setBudget(int budget) {
        Budget = budget;
        if (Budget > 100) {
            Budget = 100;
        }
    }

    public int getMoralePersonale() {
        return MoralePersonale;
    }

    public void setMoralePersonale(int moralePersonale) {
        MoralePersonale = moralePersonale;
        if (MoralePersonale > 100) {
            MoralePersonale = 100;
        }
    }

    public int getQualitaCure() {
        return QualitaCure;
    }

    public void setQualitaCure(int qualitaCure) {
        QualitaCure = qualitaCure;
        if (QualitaCure > 100) {
            QualitaCure = 100;
        }
    }
}
