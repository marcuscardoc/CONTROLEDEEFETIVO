package main.java.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class pjtcontroller {
	 @FXML
	    private TextField usuario;

	    @FXML
	    private PasswordField senha;

	    @FXML
	    private Button entrarButton;
	    
	    private void mostrarAlerta(String titulo, String mensagem, Alert.AlertType tipo) {
            Alert alerta = new Alert(tipo);
            alerta.setTitle(titulo);
            alerta.setHeaderText(null);
            alerta.setContentText(mensagem);
            alerta.showAndWait();
        }	

	    @FXML
	    private void handleLogin() throws IOException {
	    	try {
	        String usuarioo = usuario.getText();
	        String senhaa = senha.getText();

	        if (usuarioo.equals("admin") && senhaa.equals("admin")) {
	        	Stage stage = (Stage) entrarButton.getScene().getWindow();
	        	Parent root = FXMLLoader.load(getClass().getResource("/main/java/view/telaprincipal.fxml"));
	        	stage.setScene(new Scene(root));
	        	//stage.setFullScreen(true);
	        	stage.show();
	        } else {
	           mostrarAlerta("Erro", "Usuario ou senha incorreto", Alert.AlertType.ERROR);
	        }
	    	}catch(Exception e) {
	    		e.printStackTrace();
	    		mostrarAlerta("Erro", "Erro inesperado", Alert.AlertType.ERROR);
	    		
	    	}
	        
	        
	    }
	}

