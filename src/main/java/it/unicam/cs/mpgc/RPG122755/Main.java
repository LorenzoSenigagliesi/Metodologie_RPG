package it.unicam.cs.mpgc.RPG122755;

import it.unicam.cs.mpgc.RPG122755.controller.GameBoardController;
import it.unicam.cs.mpgc.RPG122755.model.TypeReparto;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    Parent root;
    GameBoardController Board;
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/PiantaOspedale.fxml"));
        root = loader.load();

        Scene scene = new Scene(root, 1200, 800);

        // Adatta il root alla dimensione della finestra
        if (root instanceof Region region) {
            region.prefWidthProperty().bind(scene.widthProperty());
            region.prefHeightProperty().bind(scene.heightProperty());
        }

        stage.setTitle("Direttore d'Ospedale");
        stage.setScene(scene);
        stage.setMinWidth(800);
        stage.setMinHeight(600);
        stage.setResizable(true);
        stage.show();
    }

    public void OpenBoard(String Reparto) throws IOException {
        Board= new GameBoardController(TypeReparto.valueOf(Reparto));
        root = Board.LoadBoard().load();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
