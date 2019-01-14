package controleur;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class CtrlMain implements Initializable{
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
	private Button MySQL;
	@FXML
	private Button ListeMemoire;
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
else if(e.getSource()==produitSQL){
	
	try{
		Stage stage = new Stage();
		stage.setTitle("Gestion des ProduitSQL");
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
public void selectionLMAction(){
	produit.setDisable(false);
	tva.setDisable(false);
	client.setDisable(false);
	facture.setDisable(false);
	lignefacture.setDisable(false);
	produitSQL.setDisable(true);
	tvaSQL.setDisable(true);
	clientSQL.setDisable(true);
	factureSQL.setDisable(true);
	lignefactureSQL.setDisable(true);
	MySQL.setDisable(false);
	ListeMemoire.setDisable(true);
}
@FXML
public void selectionSQLAction(){
	produit.setDisable(true);
	tva.setDisable(true);
	client.setDisable(true);
	facture.setDisable(true);
	lignefacture.setDisable(true);
	produitSQL.setDisable(false);
	tvaSQL.setDisable(false);
	clientSQL.setDisable(false);
	factureSQL.setDisable(false);
	lignefactureSQL.setDisable(false);
	MySQL.setDisable(true);
	ListeMemoire.setDisable(false);
}
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		produit.setDisable(true);
		tva.setDisable(true);
		client.setDisable(true);
		facture.setDisable(true);
		lignefacture.setDisable(true);
		produitSQL.setDisable(true);
		tvaSQL.setDisable(true);
		clientSQL.setDisable(true);
		factureSQL.setDisable(true);
		lignefactureSQL.setDisable(true);
		MySQL.setDisable(false);
		ListeMemoire.setDisable(false);
	}
}
