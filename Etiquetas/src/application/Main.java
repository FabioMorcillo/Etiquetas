package application;
	
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try 
		{
			Parent root = FXMLLoader.load(getClass().getResource("/fx/view/Cadastro.fxml"));
			
			Scene scene = new Scene(root);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setTitle("ETIQUETAS");
			primaryStage.setScene(scene);
			
			adicionarProcessadorEventoEnterPressionado(root);
			
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
	
	protected EventHandler<KeyEvent> processadorEnterEmCampo = new EventHandler<KeyEvent>() {
	    public void handle(final KeyEvent evento) {
	        if (evento.getCode() == KeyCode.ENTER) {
	            evento.consume();
	            ((Node)evento.getSource()).fireEvent(new KeyEvent(evento.getSource(), evento.getTarget(), evento.getEventType(), null, "TAB", KeyCode.TAB, false, false, false, false));
	        }
	    }
	};  

	private void adicionarProcessadorEventoEnterPressionado(Node elemento) {
	    if(elemento instanceof Pane){
	        Pane painel= (Pane) elemento;
	        for(Node filho :painel.getChildren()){
	            if(filho instanceof TextField)
	                filho.setOnKeyPressed(processadorEnterEmCampo);
	            else
	                adicionarProcessadorEventoEnterPressionado(filho);
	        }
	    }
	}
}
