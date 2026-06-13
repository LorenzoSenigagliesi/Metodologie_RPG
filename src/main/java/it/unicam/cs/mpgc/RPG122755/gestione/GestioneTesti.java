package it.unicam.cs.mpgc.RPG122755.gestione;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import it.unicam.cs.mpgc.RPG122755.model.Testi;
import it.unicam.cs.mpgc.RPG122755.model.TypeTesto;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class GestioneTesti implements IGestioneTesti {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final String FILE_Testi = "src/main/resources/FileJson/Testi.json";

    @Override
    public List<Testi> ReadTesti(TypeTesto tipo) {
        try (Reader reader = new FileReader(FILE_Testi)) {
            var listType = new TypeToken<List<Testi>>(){}.getType();
            List<Testi> testi = GSON.fromJson(reader, listType);
            return new ArrayList<>(testi.stream().filter(testo -> testo.getTipo().equals(tipo)).toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
