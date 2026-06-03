package it.unicam.cs.mpgc.RPG122755.gestione;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import it.unicam.cs.mpgc.RPG122755.model.Testi;
import it.unicam.cs.mpgc.RPG122755.model.TypeTesto;
import javafx.fxml.FXMLLoader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class GestioneTesti {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static FXMLLoader loader;
    private static final String FILE_Ospedale = "src/main/resources/FileJson/Testi.json";

    public List<Testi> ReadTesti(TypeTesto tipo) {
        File file = new File(FILE_Ospedale);
        List<Testi> Testi = new ArrayList<>();
        try (Reader reader = new FileReader(FILE_Ospedale)) {
            var listType = new TypeToken<List<Testi>>(){}.getType();
            Testi  = GSON.fromJson(reader, listType);
            return new ArrayList<>(Testi.stream().filter(testo -> testo.getTipo().equals(tipo)).toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
