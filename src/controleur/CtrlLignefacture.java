package controleur;

import java.net.URL;
import java.util.ResourceBundle;

import dao.DAOFactory;
import dao.DAOFactory.Persistance;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import metier.Facture;
import metier.Ligne_facture;
import metier.Produit;
public class CtrlLignefacture implements Initializable{
	@FXML
	private TextField tf_ligne;
	@FXML
	private TextField tf_quantite;
	@FXML
	private Button btnajoute;
	@FXML
	private Label TotalPrix;
	@FXML
	private Button calculer;
	@FXML
	private Button btnretour;
	@FXML
	private Button btnmodifier;
	@FXML
	private Button btnselection;
	@FXML
	private Button btnsupprimer;
	@FXML
	private TableColumn<Ligne_facture,Integer> Id;
	@FXML
	private TableColumn<Ligne_facture,Integer> Ligne;
	@FXML
	private TableColumn<Ligne_facture,Integer> Quantite;
	@FXML
	private TableColumn<Ligne_facture,Produit> Produit;
	@FXML
	private ComboBox<Produit> cbxProduit;
	@FXML
	private ComboBox<Facture> cbxFacture;
	@FXML
	private TableView<Ligne_facture> tblLignefacture;
	
	private Ligne_facture lf;
	@FXML
	private void creerModele(ActionEvent e){
			if((tf_ligne.getText().isEmpty())||(tf_quantite.getText().isEmpty())||cbxProduit.getValue()==null||cbxFacture.getValue()==null)
		
			{
					 alertfenetre();
				}

		else if(e.getSource()==btnajoute){
					
			Ligne_facture lf = new Ligne_facture();
			lf.setId(cbxFacture.getSelectionModel().getSelectedItem().getId());
			lf.setIdligne(Integer.parseInt(tf_ligne.getText()));
			lf.setQuantite(Integer.parseInt(tf_quantite.getText()));
			lf.setIdproduit(cbxProduit.getSelectionModel().getSelectedItem());
			DAOFactory.getDAOFactory(Persistance.LISTEMEMOIRE).getlignefactureDAO().create(lf);
			this.tblLignefacture.getItems().add(lf);
			float prix= Float.parseFloat(tf_ligne.getText());
			float taux = cbxProduit.getSelectionModel().getSelectedItem().getIdtva().getTaux();
			int quantite = Integer.parseInt(tf_quantite.getText());
			double total = prix*(1-taux/100)*quantite;
			if(100<=total&&total<200){
				String st = "Totalprix="+String.valueOf(total*0.05)+"€";
				TotalPrix.setText(st);
			}
			else if(200<=total&&total<300){
				String st1 = "Totalprix="+String.valueOf(total*0.10)+"€";
				TotalPrix.setText(st1);
			}
			else if(300<=total&&total<400){
				String st2 = "Totalprix="+String.valueOf(total*0.15)+"€";
				TotalPrix.setText(st2);
			}
			else if (total>400){
				String st3 = "Totalprix="+String.valueOf(total*0.20)+"€";
				TotalPrix.setText(st3);
			}
		
			tblLignefacture.getSelectionModel().clearSelection();
			//btnsupprimer.setDisable(false);
			//btnmodifier.setDisable(false);
			
			tf_ligne.clear();
			tf_quantite.clear();
			cbxProduit.setValue(null);
			cbxFacture.setValue(null);
			}
		else if(e.getSource()==btnmodifier){
			// Produit p = new Produit();
			lf.setId(cbxFacture.getSelectionModel().getSelectedItem().getId());
			lf.setIdligne(Integer.parseInt(tf_ligne.getText()));
			lf.setQuantite(Integer.parseInt(tf_quantite.getText()));
			lf.setIdproduit(cbxProduit.getSelectionModel().getSelectedItem());
			DAOFactory.getDAOFactory(Persistance.LISTEMEMOIRE).getlignefactureDAO().update(lf);
			this.tblLignefacture.refresh();
			//this.tblProduits.getItems().add(p);
			btnsupprimer.setDisable(true);
			btnajoute.setDisable(false);
			btnmodifier.setDisable(true);
			tf_ligne.clear();
			tf_quantite.clear();
			cbxProduit.setValue(null);
			cbxFacture.setValue(null);
			tblLignefacture.getSelectionModel().clearSelection();
		}
	}
	@FXML
	private void selectionAction(){
		this.lf = tblLignefacture.getSelectionModel().getSelectedItem();
		//tf_libelle.setText(tblProduits.getSelectionModel().getSelectedItem().getLibelle());
		//tf_tarif.setText(Float.toString(tblProduits.getSelectionModel().getSelectedItem().getPrix()));
		//cbxTva.getSelectionModel().select(tblProduits.getSelectionModel().getSelectedItem().getIdtva());
		for(Facture f: DAOFactory.getDAOFactory(Persistance.LISTEMEMOIRE).getFactureDAO().findAll())
			if(f.getId()==lf.getId()){
				this.cbxFacture.setValue(f);
			}
		//cbxFacture.getSelectionModel().select(lf.getId());
		tf_ligne.setText(Integer.toString(lf.getIdligne()));
		tf_quantite.setText((Integer.toString(lf.getQuantite())));
		cbxProduit.getSelectionModel().select(lf.getIdproduit());
		btnsupprimer.setDisable(false);
		btnajoute.setDisable(true);
		btnmodifier.setDisable(false);
		
	}
	@FXML
	private void supprimerAction(ActionEvent e){
		
		Ligne_facture t=this.tblLignefacture.getSelectionModel().getSelectedItem();
		DAOFactory.getDAOFactory(Persistance.LISTEMEMOIRE).getlignefactureDAO().delete(t);
		tblLignefacture.getItems().remove(t);
		cbxFacture.setValue(null);
		tf_ligne.clear();
		tf_quantite.clear();
		cbxProduit.setValue(null);
		cbxFacture.setValue(null);
		btnsupprimer.setDisable(true);
		btnajoute.setDisable(false);
		btnmodifier.setDisable(true);
		tblLignefacture.getSelectionModel().clearSelection();
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
	
	public void alertfenetre(){
		String erreur1 ="le numero de ligne n'est pas correct \nle produit ne doit pas etre vide\nles quantites ne sont  pas correct";
		Alert alert = new Alert(Alert.AlertType.ERROR);
		//alert.initOwner(primaryStage);
		alert.setTitle("Erreur lors de la saisie");
		alert.setHeaderText("Un ou plusieurs champs sont mal remplis.");
		alert.setContentText(erreur1);
		alert.showAndWait();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.cbxFacture.setItems(FXCollections.observableArrayList(DAOFactory.getDAOFactory(Persistance.LISTEMEMOIRE).getFactureDAO().findAll()));
		this.cbxProduit.setItems(FXCollections.observableArrayList(DAOFactory.getDAOFactory(Persistance.LISTEMEMOIRE).getProduitDAO().findAll()));
		this.tblLignefacture.setEditable(true);
		Id.setCellValueFactory(new PropertyValueFactory<Ligne_facture,Integer>("id"));
		Ligne.setCellValueFactory(new PropertyValueFactory<Ligne_facture,Integer>("idligne"));
		Quantite.setCellValueFactory(new PropertyValueFactory<Ligne_facture,Integer>("quantite"));
		//Libelle.setCellFactory(TextFieldTableCell.forTableColumn());
		Produit.setCellValueFactory(new PropertyValueFactory<Ligne_facture,Produit>("idproduit"));
		
		this.tblLignefacture.getItems().addAll(DAOFactory.getDAOFactory(Persistance.LISTEMEMOIRE).getlignefactureDAO().findAll());
		btnsupprimer.setDisable(true);
		btnajoute.setDisable(false);
		btnmodifier.setDisable(true);
		btnretour.setDisable(false);
	}
}
