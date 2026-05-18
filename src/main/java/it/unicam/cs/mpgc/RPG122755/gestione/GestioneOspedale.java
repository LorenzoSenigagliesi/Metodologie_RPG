package it.unicam.cs.mpgc.RPG122755.gestione;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import it.unicam.cs.mpgc.RPG122755.model.Ospedale;
import javafx.fxml.FXMLLoader;

import java.io.*;

public class GestioneOspedale {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static FXMLLoader loader;
    private static final String FILE_Ospedale = "src/main/resources/FileJson/Ospedale.json";
    private static Ospedale ospedale;

    public GestioneOspedale() {
        ReadOspedale();
    }

    public void ReadOspedale() {
        File file = new File(FILE_Ospedale);
        if (!file.exists() || file.length() == 0) {
            ospedale = new Ospedale();
            CaricaOspedale(ospedale);
            return;
        }

        try (Reader reader = new FileReader(FILE_Ospedale)) {
            var listType = new TypeToken<Ospedale>(){}.getType();
            ospedale  = GSON.fromJson(reader, listType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean ChangeParameters(int FiduciaPazienti, int Budget, int MoralePersonale, int QualitaCure) {
        if(FiduciaPazienti != 0)
        {
            ospedale.setFiduciaPazienti(ospedale.getFiduciaPazienti() + FiduciaPazienti);
        }

        if(Budget != 0)
        {
            ospedale.setBudget(ospedale.getBudget() + Budget);
        }

        if(MoralePersonale != 0)
        {
            ospedale.setMoralePersonale(ospedale.getMoralePersonale() + MoralePersonale);
        }

        if(QualitaCure != 0)
        {
            ospedale.setQualitaCure(ospedale.getQualitaCure() + QualitaCure);
        }
        ospedale.addScelteFatte();
        CaricaOspedale(ospedale);
        if (ospedale.getFiduciaPazienti() <= 0 || ospedale.getBudget() <= 0 || ospedale.getQualitaCure() <= 0 || ospedale.getMoralePersonale() <= 0)
        {
            return false;
        }
        return true;
    }

    public void StartGame() {
        ospedale = new Ospedale();
        CaricaOspedale(ospedale);
    }

    private void CaricaOspedale(Ospedale ospedale) {
        try (Writer writer = new FileWriter(FILE_Ospedale)) {
            GSON.toJson(ospedale, writer);
            //writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Ospedale getOspedale(){
        return ospedale;
    }

}
