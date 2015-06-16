package fx.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import reports.JuridicoRel;
import mvc.model.Juridico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CadastroController implements Initializable
{
	private ArrayList<Juridico> etiquetas = new ArrayList<Juridico>();
	
	public void setArrayList(ArrayList<Juridico> etiquetas)
	{
		this.etiquetas = etiquetas;
	}
	
	@FXML private TextField txtVara;
	@FXML private TextField txtJuizo;
	@FXML private TextField txtComarca;
	@FXML private TextField txtAutor;
	@FXML private TextField txtReu;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
	}

@FXML private void btnSalvar_Clicked() 
	{
	
		if ( txtVara.getText().trim().isEmpty() ) 
		{
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERRO");
			alert.setHeaderText(null);
			alert.setContentText("Vara não informada !");
			
			alert.showAndWait();
			
			txtVara.requestFocus();
			
			return;
		}
		
		if ( txtJuizo.getText().trim().isEmpty() ) 
		{
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERRO");
			alert.setHeaderText(null);
			alert.setContentText("Juízo não informado !");
			
			alert.showAndWait();
			
			txtJuizo.requestFocus();
			
			return;
		}	
		
		if ( txtComarca.getText().trim().isEmpty() ) 
		{
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERRO");
			alert.setHeaderText(null);
			alert.setContentText("Comarca não informada !");
			
			alert.showAndWait();
			
			txtComarca.requestFocus();
			
			return;
		}	
		
		if ( txtAutor.getText().trim().isEmpty() ) 
		{
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERRO");
			alert.setHeaderText(null);
			alert.setContentText("Autor não informado !");
			
			alert.showAndWait();
			
			txtAutor.requestFocus();
			
			return;
		}	

		if ( txtReu.getText().trim().isEmpty() ) 
		{
			
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERRO");
			alert.setHeaderText(null);
			alert.setContentText("Reu não informado !");
			
			alert.showAndWait();
			
			txtReu.requestFocus();
			
			return;
		}	

		System.out.println(etiquetas.size()+1);
		
		etiquetas.add(new Juridico(etiquetas.size()+1, txtVara.getText(), txtJuizo.getText(), txtComarca.getText(), txtAutor.getText(), txtReu.getText()));

		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("QUANTIDADE");
		alert.setHeaderText(null);
		alert.setContentText("Etiquetas -> " + etiquetas.size());
		
		alert.showAndWait();
		
	}

@FXML private void btnCancelar_Clicked(ActionEvent event) 
	{
	
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	
		app_stage.close();
	
	}

@FXML private void btnImprimir_Clicked() 
	{
		JuridicoRel relatorio = new JuridicoRel();
		
		try 
		{
			relatorio.imprimir(etiquetas);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
