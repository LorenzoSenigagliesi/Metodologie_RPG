package it.unicam.cs.mpgc.RPG122755;

import it.unicam.cs.mpgc.RPG122755.controller.GameBoardController;
import it.unicam.cs.mpgc.RPG122755.gestione.GestioneGameBoard;
import it.unicam.cs.mpgc.RPG122755.gestione.GestioneOspedale;
import it.unicam.cs.mpgc.RPG122755.model.TypeReparto;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class Main extends Application {
    Parent root;
    GestioneGameBoard Board;
    FXMLLoader loader;
    private Stage primaryStage;

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        loader = new FXMLLoader(getClass().getResource("/Fxml/PiantaOspedale.fxml"));

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

    @FXML
    public void OpenBoard(javafx.event.ActionEvent event) throws IOException {
        javafx.scene.Node source = (javafx.scene.Node) event.getSource();
        String id = source.getId();
        Stage stage = (Stage) source.getScene().getWindow();
        Board = new GestioneGameBoard(TypeReparto.valueOf(id));
        Board.LoadBoard(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
