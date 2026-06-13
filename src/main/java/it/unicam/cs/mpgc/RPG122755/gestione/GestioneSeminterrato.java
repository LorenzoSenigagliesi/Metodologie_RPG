package it.unicam.cs.mpgc.RPG122755.gestione;

import it.unicam.cs.mpgc.RPG122755.controller.SeminterratoController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;

public class GestioneSeminterrato implements IGestioneSeminterrato {

    @Override
    public void LoadInterface(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Seminterrato.fxml"));
        Parent root = loader.load();
        IGestioneOspedale gestioneospedale = GestioneOspedale.getInstance();
        SeminterratoController controller = loader.getController();
        controller.setSeminterrato(this, gestioneospedale.getOspedale().getChiave());
        Scene scene = new Scene(root, 1200, 800);
        if (root instanceof Region region) {
            region.prefWidthProperty().bind(scene.widthProperty());
            region.prefHeightProperty().bind(scene.heightProperty());
        }
        stage.setScene(scene);
    }
}
