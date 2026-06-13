package it.unicam.cs.mpgc.RPG122755.controller;

import it.unicam.cs.mpgc.RPG122755.gestione.GestioneGameOver;
import it.unicam.cs.mpgc.RPG122755.gestione.GestioneOspedale;
import it.unicam.cs.mpgc.RPG122755.gestione.IGestioneGameBoard;
import it.unicam.cs.mpgc.RPG122755.gestione.IGestioneGameOver;
import it.unicam.cs.mpgc.RPG122755.gestione.IGestioneOspedale;
import it.unicam.cs.mpgc.RPG122755.model.Eventi;
import it.unicam.cs.mpgc.RPG122755.model.Ospedale;
import it.unicam.cs.mpgc.RPG122755.model.Scelte;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class GameBoardController {

    private final StringProperty testoEvento = new SimpleStringProperty();
    private final StringProperty testoScelta1 = new SimpleStringProperty();
    private final StringProperty testoScelta2 = new SimpleStringProperty();
    private final StringProperty testoEffettiScelta1 = new SimpleStringProperty();
    private final StringProperty testoEffettiScelta2 = new SimpleStringProperty();
    private final StringProperty testoQualitaCure = new SimpleStringProperty();
    private final StringProperty testoMoralePersonale = new SimpleStringProperty();
    private final StringProperty testoBudgetOperativo = new SimpleStringProperty();
    private final StringProperty testoFiduciaPazienti = new SimpleStringProperty();
    private IGestioneGameBoard gestioneGameBoard;
    private IGestioneOspedale gestioneOspedale = GestioneOspedale.getInstance();
    @FXML private Label LabelEvento;
    @FXML private Label LabelScelta1;
    @FXML private Label LabelScelta2;
    @FXML private Label LabelEffettiScelta1;
    @FXML private Label LabelEffettiScelta2;
    @FXML private Label LabelQualitaCure;
    @FXML private Label LabelMoralePersonale;
    @FXML private Label LabelBudgetOperativo;
    @FXML private Label LabelFiduciaPazienti;
    private Eventi Evento;
    private Stage stage = null;

    @FXML
    private void initialize() {
        LabelEvento.textProperty().bind(testoEvento);
        LabelScelta1.textProperty().bind(testoScelta1);
        LabelScelta2.textProperty().bind(testoScelta2);
        LabelEffettiScelta1.textProperty().bind(testoEffettiScelta1);
        LabelEffettiScelta2.textProperty().bind(testoEffettiScelta2);
        LabelQualitaCure.textProperty().bind(testoQualitaCure);
        LabelMoralePersonale.textProperty().bind(testoMoralePersonale);
        LabelBudgetOperativo.textProperty().bind(testoBudgetOperativo);
        LabelFiduciaPazienti.textProperty().bind(testoFiduciaPazienti);
    }

    public void setGestioneGameBoard(IGestioneGameBoard gestione) {
        this.gestioneGameBoard = gestione;
        Update();
    }

    @FXML
    private void RunScelta(MouseEvent event) throws IOException {
        if (!event.getButton().equals(MouseButton.PRIMARY))
            return;
        int sceltaIndex = 0;
        String id = ((Node) event.getSource()).getId();
        if (id.equals("cartaDestra")) {
            sceltaIndex = 1;
        }
        Scelte scelta = gestioneGameBoard.ReadScelte().get(sceltaIndex);
        if (gestioneOspedale.ChangeParameters(scelta.getFiduciaPazienti(), scelta.getBudget(), scelta.getMoralePersonale(), scelta.getQualitaCure())) {
            gestioneGameBoard.GenerateEvento();
            Update();
        } else {
            IGestioneGameOver gameOver = new GestioneGameOver();
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            gameOver.LoadInterface(currentStage);
        }
    }

    @FXML
    private void tornaAllaPiantina(ActionEvent event) throws IOException {
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

    private void FillLabel() {
        List<Scelte> scelte = gestioneGameBoard.ReadScelte();
        if (!scelte.isEmpty()) {
            testoScelta1.set(scelte.get(0).getDescription());
            testoScelta2.set(scelte.get(1).getDescription());
            testoEffettiScelta1.set(scelte.get(0).toString());
            testoEffettiScelta2.set(scelte.get(1).toString());
        }
        Ospedale ospedale = gestioneOspedale.getOspedale();
        testoQualitaCure.set(ospedale.getQualitaCure() + "/10");
        testoMoralePersonale.set(ospedale.getMoralePersonale() + "/10");
        testoBudgetOperativo.set(ospedale.getBudget() + "/10");
        testoFiduciaPazienti.set(ospedale.getFiduciaPazienti() + "/10");
    }

    private void Update() {
        gestioneGameBoard.GenerateEvento();
        Evento = gestioneGameBoard.getEvento();
        testoEvento.set(Evento.getDescription());
        FillLabel();
    }
}
