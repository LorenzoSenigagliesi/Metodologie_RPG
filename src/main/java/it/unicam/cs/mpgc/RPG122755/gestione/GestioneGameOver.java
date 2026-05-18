package it.unicam.cs.mpgc.RPG122755.gestione;

import it.unicam.cs.mpgc.RPG122755.controller.GameBoardController;
import it.unicam.cs.mpgc.RPG122755.controller.GameOverController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;

import java.io.IOException;

public class GestioneGameOver {

    public void LoadInterface(javafx.stage.Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/GameOver.fxml"));
        Parent root = loader.load();

        // Passa questa istanza (già inizializzata) al controller
        GameOverController controller = loader.getController();
        controller.setGestioneGameBoard(this);

        Scene scene = new Scene(root, 1200, 800);
        if (root instanceof Region region) {
            region.prefWidthProperty().bind(scene.widthProperty());
            region.prefHeightProperty().bind(scene.heightProperty());
        }
        stage.setScene(scene);
    }

    private void ReloadGame()
    {

    }
}
