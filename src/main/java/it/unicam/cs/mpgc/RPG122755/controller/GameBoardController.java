package it.unicam.cs.mpgc.RPG122755.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import it.unicam.cs.mpgc.RPG122755.gestione.GestioneGameBoard;
import it.unicam.cs.mpgc.RPG122755.gestione.GestioneOspedale;
import it.unicam.cs.mpgc.RPG122755.model.Eventi;
import it.unicam.cs.mpgc.RPG122755.model.Ospedale;
import it.unicam.cs.mpgc.RPG122755.model.Scelte;
import it.unicam.cs.mpgc.RPG122755.model.TypeReparto;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameBoardController {

    private final StringProperty testoEvento = new SimpleStringProperty();
    private final StringProperty testoScelta1 = new SimpleStringProperty();
    private final StringProperty testoScelta2 = new SimpleStringProperty();
    private final StringProperty testoEffettiScelta1 = new SimpleStringProperty();
    private final StringProperty testoEffettiScelta2 = new SimpleStringProperty();
    GestioneGameBoard gestioneGameBoard;
    @FXML private Label LabelEvento;
    @FXML private Label LabelScelta1;
    @FXML private Label LabelScelta2;
    @FXML private Label LabelEffettiScelta1;
    @FXML private Label LabelEffettiScelta2;
    private Stage stage = null;
    private Eventi Evento;

    @FXML
    private void initialize() {
        // Imposta solo i binding — le label @FXML sono pronte qui
        LabelEvento.textProperty().bind(testoEvento);
        LabelScelta1.textProperty().bind(testoScelta1);
        LabelScelta2.textProperty().bind(testoScelta2);
        LabelEffettiScelta1.textProperty().bind(testoEffettiScelta1);
        LabelEffettiScelta2.textProperty().bind(testoEffettiScelta2);
    }

    /** Chiamato da LoadBoard dopo loader.load() con l'istanza già pronta **/
    public void setGestioneGameBoard(GestioneGameBoard gestione) {
        this.gestioneGameBoard = gestione;
        Evento = gestioneGameBoard.getEvento();
        testoEvento.set(Evento.getDescription());
        FillScelte();
    }
    @FXML
    private void RunScelta(MouseEvent event) {
        if ( event.getButton().equals(MouseButton.PRIMARY))
            return;
        GestioneOspedale ospedale = new GestioneOspedale();
        int SceltaIndex = 0;
        String id = ((Node) event.getTarget()).getId();
        if(id.equals("cartDestra")){
            SceltaIndex = 1;
        }
        Scelte Scelta = gestioneGameBoard.ReadScelte().get(SceltaIndex);
        if (! ospedale.ChangeParameters(Scelta.getFiduciaPazienti(),Scelta.getBudget(),Scelta.getMoralePersonale(),Scelta.getQualitaCure())) {
            //Qui bisogna che capisco come chudere il tutto
            return;
        }
        gestioneGameBoard.GenerateEvento();
    }

    private void FillScelte() {
        List<Scelte> Scelte = gestioneGameBoard.ReadScelte();
        if (!Scelte.isEmpty()) {
            testoScelta1.set(Scelte.get(0).getDescription());
            testoScelta2.set(Scelte.get(1).getDescription());
            testoEffettiScelta1.set(Scelte.get(0).toString());
            testoEffettiScelta2.set(Scelte.get(1).toString());
        }
    }

}
