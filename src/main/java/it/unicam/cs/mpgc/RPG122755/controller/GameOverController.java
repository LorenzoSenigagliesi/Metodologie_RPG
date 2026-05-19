package it.unicam.cs.mpgc.RPG122755.controller;

import it.unicam.cs.mpgc.RPG122755.gestione.GestioneGameBoard;
import it.unicam.cs.mpgc.RPG122755.gestione.GestioneGameOver;
import it.unicam.cs.mpgc.RPG122755.gestione.GestioneOspedale;
import it.unicam.cs.mpgc.RPG122755.model.Ospedale;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import javax.tools.Diagnostic;
import java.io.IOException;

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

    public void ReloadGame(ActionEvent event) throws IOException {
        GestioneOspedale gestioneOspedale = new GestioneOspedale();
        gestioneOspedale.StartGame();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/PiantaOspedale.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 1200, 800);
        if (root instanceof Region region) {
            region.prefWidthProperty().bind(scene.widthProperty());
            region.prefHeightProperty().bind(scene.heightProperty());
        }
        Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        currentStage.setScene(scene);
    }
}
