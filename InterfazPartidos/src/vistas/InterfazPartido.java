package vistas;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import logica.Logica;
import models.Partido;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//inicio de la class
public class InterfazPartido extends Stage {

    private TextField equipoLocal;
    private TextField equipoVisitante;
    private TextField Division;
    private TextField Resultado;
    private DatePicker Fecha;
    private Button aceptar;

    public InterfazPartido() throws ParseException {
        lanzarVista();
        aceptar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                añadirPartido();
            }
        });
    }

    //Metodo para cambiar el formato de la hora
    public static final LocalDate LOCAL_DATE(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(dateString, formatter);
        return localDate;
    }

    //creamos una interfaz
    public InterfazPartido(Partido partido, int posicion) {

        lanzarVista();
        equipoLocal.setText(partido.getLocal());
        equipoVisitante.setText(partido.getVisitante());
        Division.setText(partido.getDivision());
        Resultado.setText(partido.getResultado());
        Fecha.setValue(LOCAL_DATE(partido.getFecha()));
        aceptar.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent event) {
                                    Partido partidoM = new Partido(equipoLocal.getText(),
                                            equipoVisitante.getText(), Division.getText(),
                                            Resultado.getText(),
                                            Fecha.getValue().toString());
                                    Logica.getInstance().modificarPartido(partidoM, posicion);
                                    close();
                                }
                            }
        );
    }

    private void añadirPartido() {
        Partido partido = new Partido(equipoLocal.getText(),
                equipoVisitante.getText(),
                Division.getText(),
                Resultado.getText(),
                Fecha.getValue().toString());
        Logica.getInstance().addPartido(partido);
        close();
    }

    //metodo de lanzar la vista
    public void lanzarVista() {

        initModality(Modality.APPLICATION_MODAL);
        setTitle("Alta partido");
        Label local = new Label("Local");
        equipoLocal = new TextField();
        Label visitante = new Label("Visitante");
        equipoVisitante = new TextField();
        Label division = new Label("Division");
        Division = new TextField();
        Label resultado = new Label("Resultado");
        Resultado = new TextField();
        Label fecha = new Label("Fecha");
        Fecha = new DatePicker();
        aceptar = new Button("Aceptar");

        //crearmos el vbox con los atributos y lo mostramos
        VBox vBox = new VBox(local, equipoLocal,
                visitante, equipoVisitante,
                division, Division,
                resultado, Resultado,
                fecha, Fecha, aceptar);

        Scene scenePartido = new Scene(vBox, 200, 200);
        setScene(scenePartido);
    }
}
