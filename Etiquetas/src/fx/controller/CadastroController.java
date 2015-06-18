package fx.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import mvc.model.Juridico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;
import reports.JuridicoRel;

public class CadastroController implements Initializable
{
	private ArrayList<Juridico> etiquetas = new ArrayList<Juridico>();
	
	public void setArrayList(ArrayList<Juridico> etiquetas)
	{
		this.etiquetas = etiquetas;
	}

	private ObservableList<EtiquetasTableView> data;
	
	@FXML private TableView<EtiquetasTableView> tbl_Etiquetas;
	
	@FXML private TableColumn<EtiquetasTableView, String> tblcol_Etiqueta;
	
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
		tblcol_Etiqueta.setCellValueFactory(new PropertyValueFactory< EtiquetasTableView, String> ("etiqueta"));
		
		lblQuantidade.setText("Etiquetas -> " + etiquetas.size());
		
		AtualizarLista();
	}

	private void AtualizarLista()
	{
		tbl_Etiquetas.setOnMousePressed(new EventHandler<MouseEvent>() 
		{
		    @Override 
		    public void handle(MouseEvent event) 
		    {
		        if (event.isPrimaryButtonDown() && event.getClickCount() == 2) 
		        {
		        	Juridico juridico = tbl_Etiquetas.getSelectionModel().getSelectedItem().getJuridico();
		        	
		            txtVara.setText(juridico.getVara());
		            txtJuizo.setText(juridico.getJuizo());
		            txtComarca.setText(juridico.getComarca());
		            txtProcesso.setText(juridico.getProcesso());
		            txtAutor.setText(juridico.getAutor());
		            txtReu.setText(juridico.getReu());
		            
		            txtVara.requestFocus();		            
		        }
		    }
		});
		
		tbl_Etiquetas.getItems().clear();
		
		data = FXCollections.observableArrayList();
		
		for ( Juridico etiqueta : etiquetas )
		{
			String etq = etiqueta.getVara() + "/" + etiqueta.getJuizo() + "/" + etiqueta.getComarca()+"\n";
			
			etq += "Processo: " + etiqueta.getProcesso() + "\n";
			etq += "Autor: " + etiqueta.getAutor() + "\n";
			etq += "Reu: " + etiqueta.getReu();
			
			data.add(new EtiquetasTableView(etq, etiqueta));
		}
		
		tbl_Etiquetas.setItems(data);
		
		lblQuantidade.setText("Etiquetas -> " + etiquetas.size());
	}
	
@FXML private void btnCadastrar_Clicked() 
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

		btnCancelar_Clicked();
		
		
		
		AtualizarLista();
	}

@FXML private void btnResetar_Clicked()
{
	etiquetas.clear();
	
	AtualizarLista();
}

@FXML private void btnCancelar_Clicked()
{
	txtVara.setText("");
	txtJuizo.setText("");
	txtComarca.setText("");
	txtProcesso.setText("");
	txtAutor.setText("");
	txtReu.setText("");
	
	txtVara.requestFocus();
}

@FXML private void btnSair_Clicked(ActionEvent event) 
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

	public static class EtiquetasTableView 
	{
	 
		private final String etiqueta;
		private final Juridico juridico;
    
		private EtiquetasTableView(String etiqueta, Juridico juridico) 
		{
			this.etiqueta = etiqueta;
			this.juridico = juridico;
		}

		public String getEtiqueta() {
			return this.etiqueta;
		}

		public Juridico getJuridico() {
			return this.juridico;
		}

	}
}
