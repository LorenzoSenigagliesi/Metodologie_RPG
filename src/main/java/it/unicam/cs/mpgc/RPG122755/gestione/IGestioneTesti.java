package it.unicam.cs.mpgc.RPG122755.gestione;

import it.unicam.cs.mpgc.RPG122755.model.Testi;
import it.unicam.cs.mpgc.RPG122755.model.TypeTesto;

import java.util.List;

public interface IGestioneTesti {
    List<Testi> ReadTesti(TypeTesto tipo);
}
