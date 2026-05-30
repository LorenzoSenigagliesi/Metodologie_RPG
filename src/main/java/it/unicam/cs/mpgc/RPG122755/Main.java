package it.unicam.cs.mpgc.RPG122755;

import it.unicam.cs.mpgc.RPG122755.gestione.GestioneGameBoard;
import it.unicam.cs.mpgc.RPG122755.gestione.GestioneOspedale;
import it.unicam.cs.mpgc.RPG122755.model.TypeReparto;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    Parent root;
    GestioneGameBoard Board;
    FXMLLoader loader;
    private Stage primaryStage;
    @FXML private Label LabelFiduciaPazienti;
    @FXML private Label LabelBudgetOperativo;
    @FXML private Label LabelMoralePersonale;
    @FXML private Label LabelQualitaCure;
    @FXML private Label LabelStatoGenerale;

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        loader = new FXMLLoader(getClass().getResource("/Fxml/Intro.fxml"));

        root = loader.load();
        Scene scene = new Scene(root, 1200, 800);
        // Adatta il root alla dimensione della finestra
        if (root instanceof Region region) {
            region.prefWidthProperty().bind(scene.widthProperty());
            region.prefHeightProperty().bind(scene.heightProperty());
        }
        stage.setTitle("Direttore d'Ospedale");
        stage.setScene(scene);
        stage.setMinWidth(800);
        stage.setMinHeight(600);
        stage.setResizable(true);
        stage.show();
    }

    @FXML
    private void initialize() {
        aggiornaPiantina();
    }

    @FXML
    public void OpenBoard(javafx.event.ActionEvent event) throws IOException {
        javafx.scene.Node source = (javafx.scene.Node) event.getSource();
        String id = source.getId();
        Stage stage = (Stage) source.getScene().getWindow();
        Board = new GestioneGameBoard(TypeReparto.valueOf(id));
        Board.LoadInterface(stage);
    }

    private void aggiornaPiantina() {
        if (LabelFiduciaPazienti == null || LabelBudgetOperativo == null || LabelMoralePersonale == null || LabelQualitaCure == null || LabelStatoGenerale == null) {
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

    @FXML
    private void GoSotteranei(MouseEvent event){

    }

    public static void main(String[] args) {
        launch(args);
    }

}
