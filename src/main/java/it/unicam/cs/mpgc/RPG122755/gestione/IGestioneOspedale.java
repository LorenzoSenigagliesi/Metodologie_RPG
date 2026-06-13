package it.unicam.cs.mpgc.RPG122755.gestione;

import it.unicam.cs.mpgc.RPG122755.model.Ospedale;

public interface IGestioneOspedale {
    Ospedale getOspedale();
    boolean ChangeParameters(int fiduciaPazienti, int budget, int moralePersonale, int qualitaCure);
    void StartGame();
}
