package it.unicam.cs.mpgc.RPG122755.model;

public class Ospedale {
    private int FiduciaPazienti;
    private int Budget;
    private int MoralePersonale;
    private int QualitaCure;
    private int ScelteFatte;
    private boolean Chiave;

    public void setScelteFatte(int scelteFatte) {
        ScelteFatte = scelteFatte;
    }

    public boolean getChiave() {
        return Chiave;
    }

    public void setChiave(boolean chiave) {
        Chiave = chiave;
    }

    public Ospedale(){
        Chiave = false;
        FiduciaPazienti = 5;
        Budget = 5;
        MoralePersonale = 5;
        QualitaCure = 5;
        ScelteFatte = 0;
    }

    public int getFiduciaPazienti() {
        return FiduciaPazienti;
    }

    public void setFiduciaPazienti(int fiduciaPazienti) {
        FiduciaPazienti = fiduciaPazienti;
        if (FiduciaPazienti > 10) {
            FiduciaPazienti = 10;
        }
    }

    public int getBudget() {
        return Budget;
    }

    public void setBudget(int budget) {
        Budget = budget;
        if (Budget > 10) {
            Budget = 10;
        }
    }

    public int getMoralePersonale() {
        return MoralePersonale;
    }

    public void setMoralePersonale(int moralePersonale) {
        MoralePersonale = moralePersonale;
        if (MoralePersonale > 10) {
            MoralePersonale = 10;
        }
    }

    public int getQualitaCure() {
        return QualitaCure;
    }

    public void setQualitaCure(int qualitaCure) {
        QualitaCure = qualitaCure;
        if (QualitaCure > 10) {
            QualitaCure = 10;
        }
    }

    public int getScelteFatte() {
        return ScelteFatte;
    }

    public void addScelteFatte() {
        ScelteFatte += 1;
    }
}
