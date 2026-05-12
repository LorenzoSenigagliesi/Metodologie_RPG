package it.unicam.cs.mpgc.RPG122755.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import it.unicam.cs.mpgc.RPG122755.model.Eventi;
import it.unicam.cs.mpgc.RPG122755.model.Scelte;
import it.unicam.cs.mpgc.RPG122755.model.TypeReparto;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameBoardController {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static FXMLLoader loader;
    private static final String FILE_Eventi = "src/main/resources/FileJson/Eventi.json";
    private static final String FILE_Scelte = "src/main/resources/FileJson/Scelte.json";
    private final StringProperty testoEvento = new SimpleStringProperty();
    private final StringProperty testoScelta1 = new SimpleStringProperty();
    private final StringProperty testoScelta2 = new SimpleStringProperty();
    private final StringProperty testoEffettiScelta1 = new SimpleStringProperty();
    private final StringProperty testoEffettiScelta2 = new SimpleStringProperty();
    private List<Eventi> Eventi;
    @FXML private Label LabelEvento,LabelScelta1,LabelScelta2,LabelEffettiScelta1,LabelEffettiScelta2;

    public GameBoardController(TypeReparto reparto) {
        Eventi = ReadEventi(reparto);
        loader = new FXMLLoader(getClass().getResource("/Fxml/GameBoard.fxml"));
        LabelEvento.textProperty().bind(testoEvento);
        LabelScelta1.textProperty().bind(testoScelta1);
        LabelScelta2.textProperty().bind(testoScelta2);
        LabelEffettiScelta1.textProperty().bind(testoEffettiScelta1);
        LabelEffettiScelta2.textProperty().bind(testoEffettiScelta2);
    }

    public FXMLLoader LoadBoard()
    {
        return loader;
    }

    public void GenerateEvento(){
        Random random = new Random();
        Eventi Evento = Eventi.get(random.nextInt(0, Eventi.size()-1));
        testoEvento.set(Evento.getDescription());
        FillScelte(Evento.getId());
    }

    private void FillScelte(int idEvento) {
        List<Scelte> Scelte = ReadScelte(idEvento);
        if (!Scelte.isEmpty()) {
            testoScelta1.set(Scelte.get(0).getDescription());
            testoScelta2.set(Scelte.get(1).getDescription());
            testoEffettiScelta1.set(Scelte.get(0).toString());
            testoEffettiScelta2.set(Scelte.get(1).toString());
        }
    }

    public List<Eventi> ReadEventi(TypeReparto reparto) {
        File file = new File(FILE_Scelte);
        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>();// Oppure null, a tua scelta
        }

        try (Reader reader = new FileReader(FILE_Eventi)) {
            var listType = new TypeToken<List<Eventi>>(){}.getType();
            List<Eventi> Eventi = GSON.fromJson(reader, listType);
            // Se il file è vuoto o contiene null
            reader.close();
            return Eventi != null ? Eventi.stream().filter(evento -> evento.getReparto().equals(reparto)).toList()
                            : new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Scelte> ReadScelte(int IdEvento) {
        File file = new File(FILE_Scelte);
        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>();// Oppure null, a tua scelta
        }

        try (Reader reader = new FileReader(FILE_Scelte)) {
            var listType = new TypeToken<List<Eventi>>(){}.getType();
            List<Scelte> Scelte = GSON.fromJson(reader, listType);
            // Se il file è vuoto o contiene null
            reader.close();
            return Scelte != null ? Scelte.stream().filter(scelta -> scelta.getIdEvento() == IdEvento).toList()
                                    : new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
