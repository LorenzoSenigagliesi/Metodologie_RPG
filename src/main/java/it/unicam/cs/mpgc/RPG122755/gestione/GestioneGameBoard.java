package it.unicam.cs.mpgc.RPG122755.gestione;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import it.unicam.cs.mpgc.RPG122755.controller.GameBoardController;
import it.unicam.cs.mpgc.RPG122755.model.Eventi;
import it.unicam.cs.mpgc.RPG122755.model.Scelte;
import it.unicam.cs.mpgc.RPG122755.model.TypeReparto;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GestioneGameBoard implements IGestioneGameBoard {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final String FILE_Eventi = "src/main/resources/FileJson/Eventi.json";
    private static final String FILE_Scelte = "src/main/resources/FileJson/Scelte.json";
    private static final int SOGLIA_EVENTI_SPECIALI = 6;
    private List<Eventi> eventi;
    private List<Eventi> eventiSpeciali;
    private boolean special;
    private int nEvento;
    private IGestioneOspedale ospedale = GestioneOspedale.getInstance();

    public GestioneGameBoard(TypeReparto reparto) {
        eventi = ReadEventi(reparto);
        eventiSpeciali = ReadEventi(TypeReparto.Special);
    }

    public GestioneGameBoard() { }

    @Override
    public void LoadInterface(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/GameBoard.fxml"));
        Parent root = loader.load();
        GameBoardController controller = loader.getController();
        controller.setGestioneGameBoard(this);
        Scene scene = new Scene(root, 1200, 800);
        if (root instanceof Region region) {
            region.prefWidthProperty().bind(scene.widthProperty());
            region.prefHeightProperty().bind(scene.heightProperty());
        }
        stage.setScene(scene);
    }

    private List<Eventi> ReadEventi(TypeReparto reparto) {
        File file = new File(FILE_Eventi);
        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>();
        }
        try (Reader reader = new FileReader(FILE_Eventi)) {
            var listType = new TypeToken<List<Eventi>>(){}.getType();
            List<Eventi> eventiLetti = GSON.fromJson(reader, listType);
            return eventiLetti != null ? eventiLetti.stream().filter(evento -> evento.getReparto().equals(reparto)).toList()
                    : new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Scelte> ReadScelte() {
        File file = new File(FILE_Scelte);
        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>();
        }
        try (Reader reader = new FileReader(FILE_Scelte)) {
            var listType = new TypeToken<List<Scelte>>(){}.getType();
            List<Scelte> scelte = GSON.fromJson(reader, listType);
            return scelte != null ? scelte.stream().filter(scelta -> scelta.getIdEvento() == getEvento().getId()).toList()
                    : new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void GenerateEvento() {
        special = false;
        Random random = new Random();
        if (ospedale.getOspedale().getScelteFatte() == SOGLIA_EVENTI_SPECIALI) {
            special = true;
            nEvento = random.nextInt(0, eventiSpeciali.size() - 1);
        } else {
            nEvento = random.nextInt(0, eventi.size() - 1);
        }
    }

    @Override
    public Eventi getEvento() {
        if (special) return eventiSpeciali.get(nEvento);
        return eventi.get(nEvento);
    }
}
