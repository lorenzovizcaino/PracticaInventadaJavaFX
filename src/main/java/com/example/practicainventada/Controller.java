package com.example.practicainventada;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnPonerEstilo;

    @FXML
    private Button btnQuitarEstilo;

    @FXML
    private CheckBox chLeer;

    @FXML
    private CheckBox chPlanchar;

    @FXML
    private CheckBox chViajar;

    @FXML
    private ChoiceBox<String> chbSexo;

    @FXML
    private TableColumn<?, ?> colEdad;

    @FXML
    private TableColumn<?, ?> colNombre;

    @FXML
    private TableColumn<?, ?> colSexo;

    @FXML
    private ImageView ivFoto;

    @FXML
    private Slider slEdad;

    @FXML
    private Label lbEdad;

    @FXML
    private TableView<Persona> tblTabla;

    @FXML
    private TextField tfNombre;

    String rutaAbsoluta=new File("src\\main\\resources").getAbsolutePath();
    String ruta1=rutaAbsoluta+"\\image\\chica1.png";
    String ruta2=rutaAbsoluta+"\\image\\icono1.png";
    String ruta3=rutaAbsoluta+"\\image\\icono2.png";
    String ruta4=rutaAbsoluta+"\\image\\icono3.png";

    ObservableList<String> listaSexos;
    ObservableList<CheckBox> listaHobies;
    ObservableList<Persona> listaPersonas;
    ArrayList<String> hobiesSelecionados;
    Persona persona;

    int edad=0;
    String sexo="";

    @FXML
    void Guardar(ActionEvent event) {
        hobiesSelecionados=new ArrayList<>();
        String nombre=tfNombre.getText();
        String url="";
        for (CheckBox ch:listaHobies) {
            if(ch.isSelected()){
                hobiesSelecionados.add(ch.getText());
            }
        }
        Random random=new Random();
        int r= random.nextInt(4)+1;
        switch(r){
            case 1:
                url=ruta1;
                break;
            case 2:
                url=ruta2;
                break;
            case 3:
                url=ruta3;
                break;
            case 4:
                url=ruta4;
                break;


        }
        persona=new Persona(nombre,sexo,edad,hobiesSelecionados,url);
        listaPersonas.add(persona);
        tblTabla.setItems(listaPersonas);







    }

    @FXML
    void PonerEstilo(ActionEvent event) {
        Scene scene = anchorPane.getScene();
        try {
            scene.getStylesheets().clear();
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("style/estilo.css")).toExternalForm());
        } catch (Exception e) {
            System.out.println("no lo encuentro");
        }
    }

    @FXML
    void QuitarEstilo(ActionEvent event) {
        Scene scene = anchorPane.getScene();
        try {
            scene.getStylesheets().clear();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listaSexos= FXCollections.observableArrayList(
                "Varon",
                    "Mujer"
        );
        chbSexo.setItems(listaSexos);

        listaHobies=FXCollections.observableArrayList(
                chViajar,chLeer,chPlanchar
        );

        slEdad.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number edadAntigua, Number edadNueva) {
                edad=edadNueva.intValue();
                lbEdad.setText(String.valueOf(edad));
            }
        });

        chbSexo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                sexo=t1;
            }
        });


        colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        colSexo.setCellValueFactory(new PropertyValueFactory("sexo"));
        colEdad.setCellValueFactory(new PropertyValueFactory("edad"));

        listaPersonas=FXCollections.observableArrayList();

        tblTabla.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Persona>() {
            @Override
            public void changed(ObservableValue<? extends Persona> observableValue, Persona persona, Persona t1) {
                ivFoto.setImage(new Image(t1.getUrlFoto()));
            }
        });


    }

    private void CrearAlerta(String tipoAlerta, String titulo, String mensaje) {
        Alert alert=new Alert(Alert.AlertType.valueOf(tipoAlerta));
        alert.setHeaderText(null);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
