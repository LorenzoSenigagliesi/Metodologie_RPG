package it.unicam.cs.mpgc.RPG122755.gestione;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import it.unicam.cs.mpgc.RPG122755.controller.GameBoardController;
import it.unicam.cs.mpgc.RPG122755.controller.SeminterratoController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;

import java.io.IOException;

public class GestioneSeminterrato {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final String FILE_Eventi = "src/main/resources/FileJson/Eventi.json";

    public void LoadInterface(javafx.stage.Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/GameBoard.fxml"));
        Parent root = loader.load();

        // Passa questa istanza (già inizializzata) al controller
        SeminterratoController controller = loader.getController();
        controller.setSeminterrato(this);

        Scene scene = new Scene(root, 1200, 800);
        if (root instanceof Region region) {
            region.prefWidthProperty().bind(scene.widthProperty());
            region.prefHeightProperty().bind(scene.heightProperty());
        }
        stage.setScene(scene);
    }
}
