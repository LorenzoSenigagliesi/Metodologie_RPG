package it.unicam.cs.mpgc.RPG122755.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import it.unicam.cs.mpgc.RPG122755.model.Domanda;
import it.unicam.cs.mpgc.RPG122755.model.TypeReparto;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameBoardController {
    private TypeReparto Reparto;
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final String FILE_Domande = "src/main/resources/FileJson/Domande.json";
    public GameBoardController(TypeReparto reparto) {
        Reparto = reparto;
    }

    public void GenerateDomanda(){
        Random random = new Random();
    }

    public List<Domanda> ReadAttivita() {
        File file = new File(FILE_Domande);

        //TODO: Da siluppare e da vedere meglio cosa usare per la persistenza dei dati, per ora utilizzo il json
        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>();// Oppure null, a tua scelta
        }

        try (Reader reader = new FileReader(FILE_Domande)) {
            var listType = new TypeToken<List<Domanda>>(){}.getType();
            List<Domanda> Domande = GSON.fromJson(reader, listType);
            // Se il file è vuoto o contiene null
            reader.close();
            return Domande != null ? Domande : new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
