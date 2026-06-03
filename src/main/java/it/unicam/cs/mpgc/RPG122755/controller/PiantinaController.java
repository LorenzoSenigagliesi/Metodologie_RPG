package it.unicam.cs.mpgc.RPG122755.controller;

import it.unicam.cs.mpgc.RPG122755.gestione.GestioneGameBoard;
import it.unicam.cs.mpgc.RPG122755.gestione.GestioneOspedale;
import it.unicam.cs.mpgc.RPG122755.gestione.GestioneSeminterrato;
import it.unicam.cs.mpgc.RPG122755.model.TypeReparto;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class PiantinaController {

    @FXML private Label LabelFiduciaPazienti;
    @FXML private Label LabelBudgetOperativo;
    @FXML private Label LabelMoralePersonale;
    @FXML private Label LabelQualitaCure;
    @FXML private Label LabelStatoGenerale;

    @FXML
    private void initialize() {
        aggiornaPiantina();
    }

    @FXML
    public void OpenBoard(javafx.event.ActionEvent event) throws IOException {
        Node source = (Node) event.getSource();
        String id = source.getId();
        Stage stage = (Stage) source.getScene().getWindow();
        GestioneGameBoard Board = new GestioneGameBoard(TypeReparto.valueOf(id));
        Board.LoadInterface(stage);
    }

    @FXML
    public void OpenSeminterrato(javafx.event.ActionEvent event) throws IOException {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        GestioneSeminterrato gestioneSeminterrato = new GestioneSeminterrato();
        gestioneSeminterrato.LoadInterface(stage);
    }

    private void aggiornaPiantina() {
        if (LabelFiduciaPazienti == null || LabelBudgetOperativo == null
                || LabelMoralePersonale == null || LabelQualitaCure == null
                || LabelStatoGenerale == null) {
            return;
        }
        GestioneOspedale gestioneOspedale = new GestioneOspedale();
        var ospedale = gestioneOspedale.getOspedale();
        LabelFiduciaPazienti.setText("Fiducia: " + ospedale.getFiduciaPazienti());
        LabelBudgetOperativo.setText("Budget: " + ospedale.getBudget());
        LabelMoralePersonale.setText("Morale: " + ospedale.getMoralePersonale());
        LabelQualitaCure.setText("Qualità: " + ospedale.getQualitaCure());

        int minimo = Math.min(Math.min(ospedale.getFiduciaPazienti(), ospedale.getBudget()),
                Math.min(ospedale.getMoralePersonale(), ospedale.getQualitaCure()));
        if (minimo > 70) {
            LabelStatoGenerale.setText("Stato: Ottimo");
            LabelStatoGenerale.setStyle("-fx-text-fill: #2ecc71;");
        } else if (minimo > 40) {
            LabelStatoGenerale.setText("Stato: Operativo");
            LabelStatoGenerale.setStyle("-fx-text-fill: #f1c40f;");
        } else {
            LabelStatoGenerale.setText("Stato: Critico");
            LabelStatoGenerale.setStyle("-fx-text-fill: #e74c3c;");
        }
    }
}
