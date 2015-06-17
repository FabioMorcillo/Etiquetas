package fx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import mvc.model.Juridico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;
import reports.JuridicoRel;

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
	@FXML private TextField txtProcesso;
	@FXML private TextField txtAutor;
	@FXML private TextField txtReu;
	
	@FXML private Label lblQuantidade;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		lblQuantidade.setText("Etiquetas -> " + etiquetas.size());
	}

@FXML private void btnSalvar_Clicked() 
	{

	/*
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
		*/	

		//System.out.println(etiquetas.size()+1);
		
		etiquetas.add(new Juridico(etiquetas.size()+1, txtVara.getText(), txtJuizo.getText(), txtComarca.getText(), txtProcesso.getText(), txtAutor.getText(), txtReu.getText()));

		txtVara.setText("");
		txtJuizo.setText("");
		txtComarca.setText("");
		txtProcesso.setText("");
		txtAutor.setText("");
		txtReu.setText("");
		
		txtVara.requestFocus();
		
		lblQuantidade.setText("Etiquetas -> " + etiquetas.size());
	}

@FXML private void btnCancelar_Clicked(ActionEvent event) 
	{
	
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	
		app_stage.close();
	
	}

@FXML private void btnImprimir_Clicked() 
	{

		if ( etiquetas.size() == 0 )
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERRO");
			alert.setHeaderText(null);
			alert.setContentText("Nenhuma etiqueta para ser impressa !");
			
			alert.showAndWait();
			
			return;
		}
	
		Stage stage = new Stage();
	    Parent root = null;
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fx/view/LayoutImpressao.fxml"));
			root = (Parent)loader.load();
			
			LayoutImpressaoController controller = loader.getController();
		    
			controller.setArrayList(etiquetas);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    stage.setScene(new Scene(root));
	    stage.setTitle("Etiquetas");
	    stage.initModality(Modality.APPLICATION_MODAL);
	    
	    stage.initOwner(txtVara.getScene().getWindow());
	    
	    stage.setResizable(false);
	    
	    stage.show();
	
	
	}
}
