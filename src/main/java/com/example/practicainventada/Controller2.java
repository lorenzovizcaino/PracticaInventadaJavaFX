package com.example.practicainventada;


import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Controller2 {

    @FXML
    private CheckBox chLeer;

    @FXML
    private CheckBox chPlanchar;

    @FXML
    private CheckBox chViajar;

    @FXML
    private ImageView ivFoto;

    @FXML
    private TextField tfEdad;

    @FXML
    private TextField tfNombre;

    @FXML
    private TextField tfSexo;

    public void MostrarDatos(Persona persona) {

        tfNombre.setText(persona.getNombre());
        tfSexo.setText(persona.getSexo());
        tfEdad.setText(String.valueOf(persona.getEdad()));
        ivFoto.setImage(new Image(persona.getUrlFoto()));
        for (String hobi: persona.getHobies()) {
            if(hobi.equals(chLeer.getText())){
                chLeer.setSelected(true);
            }
            if(hobi.equals(chViajar.getText())){
                chViajar.setSelected(true);
            }
            if(hobi.equals(chPlanchar.getText())){
                chPlanchar.setSelected(true);
            }

        }
    }
}
