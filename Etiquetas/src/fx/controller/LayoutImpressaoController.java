package fx.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import mvc.model.Juridico;
import reports.JuridicoRel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class LayoutImpressaoController implements Initializable
{
	private ArrayList<Juridico> etiquetas = new ArrayList<Juridico>();
	
	public void setArrayList(ArrayList<Juridico> etiquetas)
	{
		this.etiquetas = etiquetas;
	}
	
	@FXML private Rectangle rec1;
	@FXML private Rectangle rec2;
	@FXML private Rectangle rec3;
	@FXML private Rectangle rec4;
	@FXML private Rectangle rec5;
	@FXML private Rectangle rec6;
	@FXML private Rectangle rec7;
	@FXML private Rectangle rec8;
	@FXML private Rectangle rec9;
	@FXML private Rectangle rec10;
	@FXML private Rectangle rec11;
	@FXML private Rectangle rec12;
	@FXML private Rectangle rec13;
	@FXML private Rectangle rec14;
	@FXML private Rectangle rec15;
	@FXML private Rectangle rec16;
	@FXML private Rectangle rec17;
	@FXML private Rectangle rec18;
	@FXML private Rectangle rec19;
	@FXML private Rectangle rec20;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) 
	{
		
	}

@FXML private void btnCancelar_Clicked(ActionEvent event) 
	{
	
		Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	
		app_stage.close();
	
	}

@FXML private void rec_Clicked(MouseEvent event) 
	{
		if ( ((Rectangle) event.getSource()).getFill() == Color.WHITE )
		{
			((Rectangle) event.getSource()).setFill(Color.SILVER);
		}
		else
		{
			((Rectangle) event.getSource()).setFill(Color.WHITE);
		}
		
	}

@FXML private void btnImprimir_Clicked(ActionEvent event) 
	{
		ArrayList<Juridico> etiquetasLayout = new ArrayList<Juridico>();
	
		int pos = 0;
		for ( int i = 1; i <= 20; i++ )
		{
			Rectangle rec = (Rectangle)((Node) event.getSource()).getScene().lookup("#rec"+i); 
			
			//Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			
			if ( rec.getFill() == Color.WHITE )
			{
				etiquetasLayout.add(etiquetas.get(pos));
				pos++;
				
				if ( pos+1 >= etiquetas.size() )
				{
					break;
				}
			}
			else
			{
				etiquetasLayout.add(new Juridico());
			}
		}
	
		JuridicoRel relatorio = new JuridicoRel();
		
		try 
		{
			relatorio.imprimir(etiquetasLayout);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
