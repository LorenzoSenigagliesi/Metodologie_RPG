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

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GestioneGameBoard {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static FXMLLoader loader;
    private static boolean Special;
    private static final String FILE_Eventi = "src/main/resources/FileJson/Eventi.json";
    private static final String FILE_Scelte = "src/main/resources/FileJson/Scelte.json";
    private static List<Eventi> Eventi;
    private static List<Eventi> EventiSpeciali;
    private static List<Scelte> Scelte;
    private int NEvento;
    private GestioneOspedale ospedale= new GestioneOspedale();

    public GestioneGameBoard(TypeReparto reparto) {
        Eventi = ReadEventi(reparto);
        EventiSpeciali = ReadEventi(TypeReparto.Special);
    }

    public GestioneGameBoard() { }

    public void LoadInterface(javafx.stage.Stage stage) throws IOException {
        loader = new FXMLLoader(getClass().getResource("/Fxml/GameBoard.fxml"));
        Parent root = loader.load();

        // Passa questa istanza (già inizializzata) al controller
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

    public List<Scelte> ReadScelte() {
        File file = new File(FILE_Scelte);
        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>();// Oppure null, a tua scelta
        }

        try (Reader reader = new FileReader(FILE_Scelte)) {
            var listType = new TypeToken<List<Scelte>>(){}.getType();
            List<Scelte> Scelte = GSON.fromJson(reader, listType);
            // Se il file è vuoto o contiene null
            reader.close();
            return Scelte != null ? Scelte.stream().filter(scelta -> scelta.getIdEvento() == getEvento().getId()).toList()
                    : new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void GenerateEvento(){
        Special = false;
        Random random = new Random();
        if (ospedale.getOspedale().getScelteFatte() == 6)
        {
            Special = true;
            NEvento = random.nextInt(0, EventiSpeciali.size()-1);
        } else {
            NEvento = random.nextInt(0, Eventi.size()-1);
        }
    }

    public Eventi getEvento()
    {
        if (Special)
        {
            return EventiSpeciali.get(NEvento);
        }

        return Eventi.get(NEvento);
    }
}
