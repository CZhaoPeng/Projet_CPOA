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
import metier.Produit;
import metier.TVA;

public class CtrlTva implements Initializable{
	@FXML
	private TextField tf_taux;
	@FXML
	private TextField tf_libelle;
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
	private TableColumn<TVA,Integer> Id;
	@FXML
	private TableColumn<TVA,String> Libelle;
	@FXML
	private TableColumn<TVA,Float> Taux;
	@FXML
	private TableView<TVA> tblTva;
	
	private TVA t;
	
	@FXML
	private void creerModele(ActionEvent e){
			if((tf_taux.getText().isEmpty())||(tf_libelle.getText().isEmpty()))
		
			{
					 alertfenetre();
				}

		else if(e.getSource()==btnajoute){
					
			TVA t = new TVA();
			t.setLibelle(tf_libelle.getText());
			t.setTaux(Float.parseFloat(tf_taux.getText()));
			DAOFactory.getDAOFactory(Persistance.LISTEMEMOIRE).getTVADAO().create(t);
			this.tblTva.getItems().add(t);
			tblTva.getSelectionModel().clearSelection();
			//btnsupprimer.setDisable(false);
			//btnmodifier.setDisable(false);
			tf_libelle.clear();
			tf_taux.clear();
			}
		else if(e.getSource()==btnmodifier){
			t.setLibelle(tf_libelle.getText());
			t.setTaux(Float.parseFloat(tf_taux.getText()));
			DAOFactory.getDAOFactory(Persistance.LISTEMEMOIRE).getTVADAO().update(t);
			this.tblTva.refresh();
			btnsupprimer.setDisable(true);
			btnajoute.setDisable(false);
			btnmodifier.setDisable(true);
			tf_libelle.clear();
			tf_taux.clear();
			tblTva.getSelectionModel().clearSelection();
		}
	}
	@FXML
	private void selectionAction(){
		t = tblTva.getSelectionModel().getSelectedItem();
		tf_libelle.setText(t.getLibelle());
		tf_taux.setText((Float.toString(t.getTaux())));
		btnsupprimer.setDisable(false);
		btnajoute.setDisable(true);
		btnmodifier.setDisable(false);
		
	}
	@FXML
	private void supprimerAction(ActionEvent e){
	
		boolean utilise = true;
		for(Produit p: DAOFactory.getDAOFactory(Persistance.LISTEMEMOIRE).getProduitDAO().findAll())
			if(p.getIdtva().getId()==tblTva.getSelectionModel().getSelectedItem().getId())
			{
				alertWarming();
				utilise = false;
				break;
			}
		if(utilise){
		TVA t=this.tblTva.getSelectionModel().getSelectedItem();
		DAOFactory.getDAOFactory(Persistance.LISTEMEMOIRE).getTVADAO().delete(t);
		tblTva.getItems().remove(t);
		}
		tf_libelle.clear();
		tf_taux.clear();
		btnsupprimer.setDisable(true);
		btnajoute.setDisable(false);
		btnmodifier.setDisable(true);
		tblTva.getSelectionModel().clearSelection();
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
		String waring = "Vous ne pouvez pas supprimer le TVA\n il est utilisé ";
		Alert alert = new Alert(Alert.AlertType.WARNING);
		//alert.initOwner(primaryStage);
		alert.setTitle("Attention");
		alert.setHeaderText(null);
		alert.setContentText(waring);
		alert.showAndWait();
	}
	public void alertfenetre(){
		String erreur1 ="le libelle n'est pas correct \nle taux n'est pas correct";
		Alert alert = new Alert(Alert.AlertType.ERROR);
		//alert.initOwner(primaryStage);
		alert.setTitle("Erreur lors de la saisie");
		alert.setHeaderText("Un ou plusieurs champs sont mal remplis.");
		alert.setContentText(erreur1);
		alert.showAndWait();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//this.tblTva.setEditable(true);
		Id.setCellValueFactory(new PropertyValueFactory<TVA,Integer>("id"));
		Libelle.setCellValueFactory(new PropertyValueFactory<TVA,String>("libelle"));
		//Libelle.setCellFactory(TextFieldTableCell.forTableColumn());
		Taux.setCellValueFactory(new PropertyValueFactory<TVA,Float>("taux"));
		//Libelle.setCellFactory(TextFieldTableCell.forTableColumn());
		this.tblTva.getItems().addAll(DAOFactory.getDAOFactory(Persistance.LISTEMEMOIRE).getTVADAO().findAll());
		btnsupprimer.setDisable(true);
		btnajoute.setDisable(false);
		btnmodifier.setDisable(true);
		btnretour.setDisable(false);
	}
}
