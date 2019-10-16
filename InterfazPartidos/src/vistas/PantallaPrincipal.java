package vistas;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import logica.Logica;
import models.Partido;

import java.text.ParseException;
//creamos la classs
public class PantallaPrincipal extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Gestionn de los partidos");
        TableView tablaPartidos = new TableView(Logica.getInstance().getListaPartidos()); //creamos la tabla
       //creamos un anchorPane
        AnchorPane.setTopAnchor(tablaPartidos,5d);
        AnchorPane.setLeftAnchor(tablaPartidos,5d);
        AnchorPane.setRightAnchor(tablaPartidos,5d);
        AnchorPane.setBottomAnchor(tablaPartidos,40d);
        //creamos los componentes de la tabla
        TableColumn<String, Partido> column1 = new TableColumn<>("Local");
        column1.setCellValueFactory(new PropertyValueFactory<>("local"));
        TableColumn<String, Partido> column2 = new TableColumn<>("Visitante");
        column2.setCellValueFactory(new PropertyValueFactory<>("visitante"));
        TableColumn<String, Partido> column3 = new TableColumn<>("Division");
        column3.setCellValueFactory(new PropertyValueFactory<>("division"));
        TableColumn<String, Partido> column4 = new TableColumn<>("Resultado");
        column4.setCellValueFactory(new PropertyValueFactory<>("resultado"));
        TableColumn<String, Partido> column5 = new TableColumn<>("Fecha");
        column5.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        //añadimos las columnnas
        tablaPartidos.getColumns().addAll(column1, column2, column3, column4, column5);

        Button buttonAlta = new Button("Alta");
        AnchorPane.setBottomAnchor(buttonAlta,10d);
        AnchorPane.setLeftAnchor(buttonAlta,10d);

        Button buttonBorrar = new Button("Borrar");
        AnchorPane.setBottomAnchor(buttonBorrar,10d);
        AnchorPane.setRightAnchor(buttonBorrar,10d);

        Button buttonModificar = new Button("Modificar");
        AnchorPane.setBottomAnchor(buttonModificar,10d);
        AnchorPane.setLeftAnchor(buttonModificar,50d);

        AnchorPane anchorPane = new AnchorPane(tablaPartidos, buttonAlta, buttonBorrar, buttonModificar);
        Scene scene = new Scene(anchorPane,250,250);
        stage.setScene(scene);
        stage.show();

        buttonAlta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                InterfazPartido interfazPartido = null;
                try {
                    interfazPartido = new InterfazPartido();

                } catch (ParseException e) {
                    e.printStackTrace();
                }
                interfazPartido.show();
            }
        });
        //Boton de borrar
        buttonBorrar.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("indice para borrar ");
                int id_partido = tablaPartidos.getSelectionModel().getSelectedIndex();
                if (id_partido>=0)
                    Logica.getInstance().borrarPartido(id_partido);
            }
        });
        //boton de modificar.
        buttonModificar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int modificar_primer = tablaPartidos.getSelectionModel().getSelectedIndex();
                Partido selectPartido = Logica.getInstance().getListaPartidos().get(modificar_primer);
                InterfazPartido interfazPartido = null;
                interfazPartido = new InterfazPartido(selectPartido,modificar_primer);
                interfazPartido.show();
            }
        });
    }
}
