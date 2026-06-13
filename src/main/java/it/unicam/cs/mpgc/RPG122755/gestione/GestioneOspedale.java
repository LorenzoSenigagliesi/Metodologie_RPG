package it.unicam.cs.mpgc.RPG122755.gestione;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import it.unicam.cs.mpgc.RPG122755.model.Ospedale;

import java.io.*;

public class GestioneOspedale implements IGestioneOspedale {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final String FILE_Ospedale = "src/main/resources/FileJson/Ospedale.json";
    private static GestioneOspedale instance;
    private Ospedale ospedale;

    private GestioneOspedale() {
        ReadOspedale();
    }

    public static GestioneOspedale getInstance() {
        if (instance == null) {
            instance = new GestioneOspedale();
        }
        return instance;
    }

    private void ReadOspedale() {
        File file = new File(FILE_Ospedale);
        if (!file.exists() || file.length() == 0) {
            ospedale = new Ospedale();
            CaricaOspedale(ospedale);
            return;
        }
        try (Reader reader = new FileReader(FILE_Ospedale)) {
            var listType = new TypeToken<Ospedale>(){}.getType();
            ospedale = GSON.fromJson(reader, listType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean ChangeParameters(int fiduciaPazienti, int budget, int moralePersonale, int qualitaCure) {
        if (fiduciaPazienti != 0) ospedale.setFiduciaPazienti(ospedale.getFiduciaPazienti() + fiduciaPazienti);
        if (budget != 0) ospedale.setBudget(ospedale.getBudget() + budget);
        if (moralePersonale != 0) ospedale.setMoralePersonale(ospedale.getMoralePersonale() + moralePersonale);
        if (qualitaCure != 0) ospedale.setQualitaCure(ospedale.getQualitaCure() + qualitaCure);
        ospedale.addScelteFatte();
        CaricaOspedale(ospedale);
        return ospedale.getFiduciaPazienti() > 0 && ospedale.getBudget() > 0
                && ospedale.getQualitaCure() > 0 && ospedale.getMoralePersonale() > 0;
    }

    @Override
    public void StartGame() {
        ospedale = new Ospedale();
        CaricaOspedale(ospedale);
    }

    private void CaricaOspedale(Ospedale ospedale) {
        try (Writer writer = new FileWriter(FILE_Ospedale)) {
            GSON.toJson(ospedale, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Ospedale getOspedale() {
        return ospedale;
    }
}
