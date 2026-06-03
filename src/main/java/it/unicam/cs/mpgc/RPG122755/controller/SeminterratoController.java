package it.unicam.cs.mpgc.RPG122755.controller;
import it.unicam.cs.mpgc.RPG122755.gestione.GestioneSeminterrato;
import it.unicam.cs.mpgc.RPG122755.gestione.GestioneTesti;
import it.unicam.cs.mpgc.RPG122755.model.Testi;
import it.unicam.cs.mpgc.RPG122755.model.TypeTesto;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.List;

public class SeminterratoController {
    private GestioneSeminterrato gestioneseminterrato;
    private static List<Testi> testi;
    @FXML private ImageView imgScena;
    @FXML private Label LabelTesto;
    @FXML private Button btnAvanti;

    public void setSeminterrato(GestioneSeminterrato gestioneseminterrato , boolean chiave){
        this.gestioneseminterrato = gestioneseminterrato;
        GestioneTesti gestioneTesti = new GestioneTesti();
        imgScena.setImage(new Image(getClass().getResourceAsStream("/immagini/Seminterrato.jpeg")));

        if (chiave) {
            testi = gestioneTesti.ReadTesti(TypeTesto.SotteraneoChiave);
        } else{
            testi = gestioneTesti.ReadTesti(TypeTesto.SotteraneoNoChiave);
        }
        String testo = testi.getFirst().getTesto();
        testi.remove(testi.getFirst());
        animaTesto(testo);
    }

    private void animaTesto(String testo) {
        Timeline timeline = new Timeline();
        btnAvanti.setVisible(false);
        for (int i = 0; i < testo.length(); i++) {
            final int index = i;
            KeyFrame kf = new KeyFrame(
                    Duration.millis(70.0 * (i + 1)),
                    e -> LabelTesto.setText(testo.substring(0, index + 1))
            );
            timeline.getKeyFrames().add(kf);
        }
        timeline.setOnFinished(e -> btnAvanti.setVisible(true));
        timeline.play();
    }

    @FXML
    private void Avanti(ActionEvent event) throws IOException {
        if (testi.isEmpty())
        {
            CambiaScena(event);
        }else{
            String testo = testi.getFirst().getTesto();
            testi.remove(testi.getFirst());
            animaTesto(testo);
        }
    }

    private void CambiaScena(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/PiantaOspedale.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 1200, 800);
        if (root instanceof Region region) {
            region.prefWidthProperty().bind(scene.widthProperty());
            region.prefHeightProperty().bind(scene.heightProperty());
        }
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }
}
