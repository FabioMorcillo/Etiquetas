package reports;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import mvc.model.Juridico;

public class JuridicoRel 
{
	private String path; //Caminho base
	
	private String pathToReportPackage; // Caminho para o package onde estão armazenados os relatorios Jarper
	
	//Recupera os caminhos para que a classe possa encontrar os relatórios
	public JuridicoRel() {
		this.path = this.getClass().getClassLoader().getResource("").getPath();
		this.pathToReportPackage = this.path + "reports/";
		//System.out.println(path);
	}
	
	//Imprime/gera uma lista de Clientes
	public void imprimir(List<Juridico> etiquetas) throws Exception	
	{
		JasperReport report = JasperCompileManager.compileReport(getPathToReportPackage() +"etiqueta-20.jrxml");
		
		JasperPrint print = JasperFillManager.fillReport(report, new HashMap(), new JRBeanCollectionDataSource(etiquetas));
 
	       
		if ( print.getPages().size() > 0 )
		{
			JasperViewer.viewReport(print, false);
		}
		else
		{
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("ERRO");
			alert.setHeaderText(null);
			alert.setContentText("Nenhuma etiqueta para ser impressa !");
			
			alert.showAndWait();
		}
        
		// JasperExportManager.exportReportToPdfFile(print, "c:/Relatorio_de_Clientes.pdf");		
	}
	
	public String getPathToReportPackage() 
	{
		return this.pathToReportPackage;
	}
}
