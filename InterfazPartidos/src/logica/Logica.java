package logica;

import models.Partido;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Logica {
    private static Logica INSTANCE = null;
    private ObservableList<Partido> listaPartidos;

    private Logica() {
        listaPartidos = FXCollections.observableArrayList();
    }

    public static Logica getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Logica();
        }
        return INSTANCE;
    }

    public ObservableList<Partido> getListaPartidos() {
        return listaPartidos;
    }

    public void addPartido(Partido partido) {
        listaPartidos.add(partido);
    }

    public void borrarPartido(int pos) {
        listaPartidos.remove(pos);
    }

    public void modificarPartido(Partido partidoM, int posicion) {
        listaPartidos.set(posicion, partidoM);
    }

}



