package it.unicam.cs.mpgc.RPG122755.gestione;

import it.unicam.cs.mpgc.RPG122755.model.Eventi;
import it.unicam.cs.mpgc.RPG122755.model.Scelte;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public interface IGestioneGameBoard {
    void LoadInterface(Stage stage) throws IOException;
    void GenerateEvento();
    Eventi getEvento();
    List<Scelte> ReadScelte();
}
