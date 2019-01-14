package controleur;

import java.net.URL;
import java.util.ResourceBundle;
import dao.DAOFactory;
import dao.DAOFactory.Persistance;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import metier.Client;
import metier.Facture;


public class CtrlClient implements Initializable{
	@FXML
	private TextField tf_nom;
	@FXML
	private TextField tf_prenom;
	@FXML
	private TextField tf_rue;
	@FXML
	private TextField tf_voie;
	@FXML
	private TextField tf_cp;
	@FXML
	private TextField tf_ville;
	@FXML
	private TextField tf_pays;
	@FXML
	private TextField tf_ca;
	@FXML
	private Button btnajoute;
	@FXML
	private Button btnretour;
	@FXML
	private Button btnmodifier;
	@FXML
	private Button btnselection;
	@FXML
	private Button btnsupprimer;
	@FXML
	private TableColumn<Client,Integer> Id;
	@FXML
	private TableColumn<Client,String> Nom;
	@FXML
	private TableColumn<Client,String> Prenom;
	@FXML
	private TableColumn<Client,String> Rue;
	@FXML
	private TableColumn<Client,String> Voie;
	@FXML
	private TableColumn<Client,String> Cp;
	@FXML
	private TableColumn<Client,String> Ville;
	@FXML
	private TableColumn<Client,String> Pays;
	@FXML
	private TableColumn<Client,String> Ca;
	@FXML
	private TableView<Client> tblClient;
	
	private Client c;
	
	@FXML
	private void creerModele(ActionEvent e){
			if((tf_nom.getText().isEmpty())||(tf_prenom.getText().isEmpty()))
		
			{
					 alertfenetre();
				}

		else if(e.getSource()==btnajoute){
					
			Client c = new Client();
			c.setNom(tf_nom.getText());
			c.setPrenom(tf_prenom.getText());
			c.setRue(tf_rue.getText());
			c.setVoie(tf_voie.getText());
			c.setCp(tf_cp.getText());
			c.setVille(tf_ville.getText());
			c.setPays(tf_pays.getText());
			c.setCa(tf_ca.getText());
			DAOFactory.getDAOFactory(Persistance.LISTEMEMOIRE).getClientDAO().create(c);
			this.tblClient.getItems().add(c);
			tf_nom.clear();
			tf_prenom.clear();
			tf_rue.clear();
			tf_voie.clear();
			tf_cp.clear();
			tf_ville.clear();
			tf_pays.clear();
			tf_ca.clear();
			}
		else if(e.getSource()==btnmodifier){
			c.setNom(tf_nom.getText());
			c.setPrenom(tf_prenom.getText());
			c.setRue(tf_rue.getText());
			c.setVoie(tf_voie.getText());
			c.setCp(tf_cp.getText());
			c.setVille(tf_ville.getText());
			c.setPays(tf_pays.getText());
			c.setCa(tf_ca.getText());
			DAOFactory.getDAOFactory(Persistance.LISTEMEMOIRE).getClientDAO().update(c);
			this.tblClient.refresh();
			btnsupprimer.setDisable(true);
			btnajoute.setDisable(false);
			btnmodifier.setDisable(true);
			tf_nom.clear();
			tf_prenom.clear();
			tf_rue.clear();
			tf_voie.clear();
			tf_cp.clear();
			tf_ville.clear();
			tf_pays.clear();
			tf_ca.clear();
			tblClient.getSelectionModel().clearSelection();
		}
	}
	@FXML
	private void selectionAction(){
		c = tblClient.getSelectionModel().getSelectedItem();
		tf_nom.setText(c.getNom());
		tf_prenom.setText(c.getPrenom());
		tf_rue.setText(c.getRue());
		tf_voie.setText(c.getVoie());
		tf_cp.setText(c.getCp());
		tf_ville.setText(c.getVille());
		tf_pays.setText(c.getPays());
		tf_ca.setText(c.getCa());
		btnsupprimer.setDisable(false);
		btnajoute.setDisable(true);
		btnmodifier.setDisable(false);
	}
	@FXML
	private void supprimerAction(ActionEvent e){
		boolean utilise = true;
		for(Facture f: DAOFactory.getDAOFactory(Persistance.LISTEMEMOIRE).getFactureDAO().findAll())
			if(f.getIdclient().getId()==tblClient.getSelectionModel().getSelectedItem().getId())
			{
				alertWarming();
				utilise = false;
				break;
			}
		if(utilise){
		
		Client t=this.tblClient.getSelectionModel().getSelectedItem();
		DAOFactory.getDAOFactory(Persistance.LISTEMEMOIRE).getClientDAO().delete(t);
		tblClient.getItems().remove(t);
		}
		tf_nom.clear();
		tf_prenom.clear();
		tf_rue.clear();
		tf_voie.clear();
		tf_cp.clear();
		tf_ville.clear();
		tf_pays.clear();
		tf_ca.clear();
		btnsupprimer.setDisable(true);
		btnajoute.setDisable(false);
		btnmodifier.setDisable(true);
		tblClient.getSelectionModel().clearSelection();
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
	public void alertWarming(){
		String waring = "Vous ne pouvez pas supprimer le Client\n il est utilisé";
		Alert alert = new Alert(Alert.AlertType.WARNING);
		//alert.initOwner(primaryStage);
		alert.setTitle("Attention");
		alert.setHeaderText(null);
		alert.setContentText(waring);
		alert.showAndWait();
	}
	public void alertfenetre(){
		String erreur1 ="le nom n'est pas correct \nle prenom n'est pas correct";
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Erreur lors de la saisie");
		alert.setHeaderText("Un ou plusieurs champs sont mal remplis.");
		alert.setContentText(erreur1);
		alert.showAndWait();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		this.tblClient.setEditable(true);
		Id.setCellValueFactory(new PropertyValueFactory<Client,Integer>("id"));
		Nom.setCellValueFactory(new PropertyValueFactory<Client,String>("nom"));
		Prenom.setCellValueFactory(new PropertyValueFactory<Client,String>("prenom"));
		Rue.setCellValueFactory(new PropertyValueFactory<Client,String>("rue"));
		Voie.setCellValueFactory(new PropertyValueFactory<Client,String>("voie"));
		Cp.setCellValueFactory(new PropertyValueFactory<Client,String>("cp"));
		Ville.setCellValueFactory(new PropertyValueFactory<Client,String>("ville"));
		Pays.setCellValueFactory(new PropertyValueFactory<Client,String>("pays"));
		Ca.setCellValueFactory(new PropertyValueFactory<Client,String>("ca"));
		this.tblClient.getItems().addAll(DAOFactory.getDAOFactory(Persistance.LISTEMEMOIRE).getClientDAO().findAll());
		btnsupprimer.setDisable(true);
		btnajoute.setDisable(false);
		btnmodifier.setDisable(true);
		btnretour.setDisable(false);
	}
}
