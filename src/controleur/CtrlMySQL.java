package controleur;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class CtrlMySQL implements Initializable{
	@FXML
	private Button produitSQL;
	@FXML
	private Button tvaSQL;
	@FXML
	private Button clientSQL;
	@FXML
	private Button factureSQL;
	@FXML
	private Button lignefactureSQL;
	@FXML
	private Button btnretour;
	@FXML
	private void creerModele(ActionEvent e){
		if(e.getSource()==produitSQL){
				try{
					Stage stage = new Stage();
					stage.setTitle("Gestion des TVASQL");
					URL fxmlURL= getClass().getResource("/vue/produitSQL.fxml");
					FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
					VBox node = fxmlLoader.load();
					Scene scene = new Scene (node,700,700);
					scene.getStylesheets().add(getClass().getResource("/vue/application.css").toExternalForm());
					stage.setScene(scene);
					stage.show();
				} catch(Exception e1) {
					e1.printStackTrace();
		}
			
}			
	
else if(e.getSource()==tvaSQL){
	
	try{
		Stage stage = new Stage();
		stage.setTitle("Gestion des TVASQL");
		URL fxmlURL= getClass().getResource("/vue/tvaSQL.fxml");
		FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
		VBox node = fxmlLoader.load();
		Scene scene = new Scene (node,700,700);
		scene.getStylesheets().add(getClass().getResource("/vue/application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	} catch(Exception e1) {
		e1.printStackTrace();
	}
	
}		
else if(e.getSource()==clientSQL){
	
	try{
		Stage stage = new Stage();
		stage.setTitle("Gestion des ClientSQL");
		URL fxmlURL= getClass().getResource("/vue/clientSQL.fxml");
		FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
		VBox node = fxmlLoader.load();
		Scene scene = new Scene (node,700,700);
		scene.getStylesheets().add(getClass().getResource("/vue/application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	} catch(Exception e1) {
		e1.printStackTrace();
	}
	
}		
else if(e.getSource()==factureSQL){
	
	try{
		Stage stage = new Stage();
		stage.setTitle("Gestion des FactureSQL");
		URL fxmlURL= getClass().getResource("/vue/factureSQL.fxml");
		FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
		VBox node = fxmlLoader.load();
		Scene scene = new Scene (node,700,700);
		scene.getStylesheets().add(getClass().getResource("/vue/application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	} catch(Exception e1) {
		e1.printStackTrace();
	}
	
}		
else if(e.getSource()==lignefactureSQL){
	
	try{
		Stage stage = new Stage();
		stage.setTitle("Gestion des LignefactureSQL");
		URL fxmlURL= getClass().getResource("/vue/lignefactureSQL.fxml");
		FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
		VBox node = fxmlLoader.load();
		Scene scene = new Scene (node,700,700);
		scene.getStylesheets().add(getClass().getResource("/vue/application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
	} catch(Exception e1) {
		e1.printStackTrace();
	}
	
}		
}
	
@FXML
public void retourAction(){
	try {
		Stage primaryStage = new Stage();
		URL fxmlURL= getClass().getResource("/vue/MenuPrin.fxml");
		FXMLLoader fxmlLoader=new FXMLLoader(fxmlURL);
		AnchorPane root = fxmlLoader.load();
		Scene scene = new Scene(root,600,500);
		scene.getStylesheets().add(getClass().getResource("/vue/application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setTitle("Menu de Gestion");
		primaryStage.show();
		Stage stage= (Stage) btnretour.getScene().getWindow();
		stage.close();
	} catch(Exception e) {
		e.printStackTrace();
	}
}

	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
	}
}
