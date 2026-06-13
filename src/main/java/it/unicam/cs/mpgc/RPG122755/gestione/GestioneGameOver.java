package it.unicam.cs.mpgc.RPG122755.gestione;

import it.unicam.cs.mpgc.RPG122755.controller.GameOverController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;

public class GestioneGameOver implements IGestioneGameOver {

    @Override
    public void LoadInterface(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/GameOver.fxml"));
        Parent root = loader.load();
        GameOverController controller = loader.getController();
        controller.setGestioneGameBoard(this);
        Scene scene = new Scene(root, 1200, 800);
        if (root instanceof Region region) {
            region.prefWidthProperty().bind(scene.widthProperty());
            region.prefHeightProperty().bind(scene.heightProperty());
        }
        stage.setScene(scene);
    }
}
