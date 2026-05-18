package it.unicam.cs.mpgc.RPG122755.controller;

import it.unicam.cs.mpgc.RPG122755.gestione.GestioneGameBoard;
import it.unicam.cs.mpgc.RPG122755.gestione.GestioneGameOver;
import it.unicam.cs.mpgc.RPG122755.gestione.GestioneOspedale;
import it.unicam.cs.mpgc.RPG122755.model.Ospedale;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GameOverController {
    private GestioneGameOver GestioneGameOver;
    @FXML private Label LabelDecisioni;
    @FXML private Label LabelQualitaCure;
    @FXML private Label LabelMoralePersonale;
    @FXML private Label LabelBudgetOperativo;
    @FXML private Label LabelFiduciaPazienti;
    public void setGestioneGameBoard(GestioneGameOver gestione) {
        this.GestioneGameOver = gestione;
        GestioneOspedale Gestioneospedale = new GestioneOspedale();
        Ospedale ospedale = Gestioneospedale.getOspedale();
        LabelQualitaCure.setText(ospedale.getQualitaCure() + "/10");
        LabelMoralePersonale.setText(ospedale.getMoralePersonale() + "/10");
        LabelBudgetOperativo.setText(ospedale.getBudget() + "/10");
        LabelFiduciaPazienti.setText(ospedale.getFiduciaPazienti() + "/10");
        LabelDecisioni.setText(ospedale.getScelteFatte() + "/10");
    }
}
