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
public class CtrlListeMemoire implements Initializable{
	@FXML
	private Button produit;
	@FXML
	private Button tva;
	@FXML
	private Button client;
	@FXML
	private Button facture;
	@FXML
	private Button lignefacture;
	@FXML
	private Button btnretour;
	@FXML
	private void creerModele(ActionEvent e){
		
		if(e.getSource()==produit){
		try{
			Stage stage = new Stage();
			stage.setTitle("Gestion des produits");
			URL fxmlURL= getClass().getResource("/vue/produits.fxml");
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
	else if(e.getSource()==tva){
		
		try{
			Stage stage = new Stage();
			stage.setTitle("Gestion des TVA");
			URL fxmlURL= getClass().getResource("/vue/tva.fxml");
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
		
		
	else if(e.getSource()==client){
		
		try{
			Stage stage = new Stage();
			stage.setTitle("Gestion des TVA");
			URL fxmlURL= getClass().getResource("/vue/client.fxml");
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
		
else if(e.getSource()==facture){
		
		try{
			Stage stage = new Stage();
			stage.setTitle("Gestion des Facture");
			URL fxmlURL= getClass().getResource("/vue/facture.fxml");
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
else if(e.getSource()==lignefacture){
	
	try{
		Stage stage = new Stage();
		stage.setTitle("Gestion des Lignefacture");
		URL fxmlURL= getClass().getResource("/vue/ligne_facture.fxml");
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
