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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import metier.Ligne_facture;
import metier.Produit;
import metier.TVA;

public class CtrlProduitSQL implements Initializable{
	@FXML
	private TextField tf_tarif;
	@FXML
	private TextField tf_libelle;
	@FXML
	private Label l1;
	@FXML
	private Label l2;
	@FXML
	private Label l3;
	@FXML
	private Label l4;
	@FXML
	private Label l5;
	@FXML
	private Label l6;
	@FXML
	private Label l7;
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
	private TableColumn<Produit,Integer> Id;
	@FXML
	private TableColumn<Produit,String> Libelle;
	@FXML
	private TableColumn<Produit,Float> Tarif;
	@FXML
	private TableColumn<Produit,TVA> Tva;
	@FXML
	private ComboBox<TVA> cbxTva;
	@FXML
	private TableView<Produit> tblProduits;
	
	private Produit p;
	
	@FXML
	private void creerModele(ActionEvent e){
			if((tf_tarif.getText().isEmpty())||(tf_libelle.getText().isEmpty())||cbxTva.getValue()==null)
		
			{
					 alertfenetre();
				}

		else if(e.getSource()==btnajoute){
					
			boolean exit = false;
			for(Produit p1: DAOFactory.getDAOFactory(Persistance.MYSQL).getProduitDAO().findAll())
				if(p1.getLibelle().equals(tf_libelle.getText()))
				{
					alertWarming2();
					exit = true;
					break;
				}
			if(exit==false){
				Produit p = new Produit();
			p.setLibelle(tf_libelle.getText());
			p.setPrix(Float.parseFloat(tf_tarif.getText()));
			p.setIdtva(cbxTva.getSelectionModel().getSelectedItem());
			DAOFactory.getDAOFactory(Persistance.MYSQL).getProduitDAO().create(p);
			this.tblProduits.getItems().add(p);
			}
			tf_libelle.clear();
			tf_tarif.clear();
			cbxTva.setValue(null);
			btnsupprimer.setDisable(false);
			btnmodifier.setDisable(false);
			}
		else if(e.getSource()==btnmodifier){
			// Produit p = new Produit();
			this.p.setLibelle(tf_libelle.getText());
			this.p.setPrix(Float.parseFloat(tf_tarif.getText()));
			this.p.setIdtva(cbxTva.getSelectionModel().getSelectedItem());
			//p.setId(tblProduits.getSelectionModel().getSelectedItem().getIdtva().id);
			DAOFactory.getDAOFactory(Persistance.MYSQL).getProduitDAO().update(p);
			this.tblProduits.refresh();
			//this.tblProduits.getItems().add(p);
			tf_libelle.clear();
			tf_tarif.clear();
			cbxTva.setValue(null);
			btnsupprimer.setDisable(true);
			btnajoute.setDisable(false);
			btnmodifier.setDisable(true);
			tblProduits.getSelectionModel().clearSelection();
		}
	}
	@FXML
	private void selectionAction(){
		p = tblProduits.getSelectionModel().getSelectedItem();
		//tf_libelle.setText(tblProduits.getSelectionModel().getSelectedItem().getLibelle());
		//tf_tarif.setText(Float.toString(tblProduits.getSelectionModel().getSelectedItem().getPrix()));
		//cbxTva.getSelectionModel().select(tblProduits.getSelectionModel().getSelectedItem().getIdtva());
		tf_libelle.setText(p.getLibelle());
		tf_tarif.setText((Float.toString(p.getPrix())));
		cbxTva.getSelectionModel().select(p.getIdtva());
		btnsupprimer.setDisable(false);
		btnajoute.setDisable(true);
		btnmodifier.setDisable(false);

			if (getClass().getResource("/images/"+p.getLibelle()+".png") != null)
			   {
				   Image image = new Image("images/"+p.getLibelle()+".png", 150,150,false,false);
				   this.l1.setGraphic(new ImageView(image));	
			   }
			   else{
				   Image image = new Image("/images/notfound.png",150,150,false,false);
				   this.l1.setGraphic(new ImageView(image));
			   }
	}
	@FXML
	private void supprimerAction(ActionEvent e){
		boolean utilise = true;
		for(Ligne_facture lf: DAOFactory.getDAOFactory(Persistance.MYSQL).getlignefactureDAO().findAll())
			if(lf.getIdproduit().getId()==tblProduits.getSelectionModel().getSelectedItem().getId())
			{
				alertWarming();
				utilise = false;
				break;
			}
		if(utilise){
		Produit t=this.tblProduits.getSelectionModel().getSelectedItem();
		DAOFactory.getDAOFactory(Persistance.MYSQL).getProduitDAO().delete(t);
		tblProduits.getItems().remove(t);
		}
		tf_libelle.clear();
		tf_tarif.clear();
		cbxTva.setValue(null);
		btnsupprimer.setDisable(true);
		btnajoute.setDisable(false);
		btnmodifier.setDisable(true);
		tblProduits.getSelectionModel().clearSelection();
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
	public void alertWarming2(){
		String waring = "Vous ne pouvez pas ajouter le Produit, car il exite deja";
		Alert alert = new Alert(Alert.AlertType.WARNING);
		//alert.initOwner(primaryStage);
		alert.setTitle("Attention");
		alert.setHeaderText(null);
		alert.setContentText(waring);
		alert.showAndWait();
	}
	public void alertWarming(){
		String waring = "Vous ne pouvez pas supprimer le Produit\n il est utilisé";
		Alert alert = new Alert(Alert.AlertType.WARNING);
		//alert.initOwner(primaryStage);
		alert.setTitle("Attention");
		alert.setHeaderText(null);
		alert.setContentText(waring);
		alert.showAndWait();
	}
	
	public void alertfenetre(){
		String erreur1 ="le libelle n'est pas correct \nle tarif n'est pas correct\nle titre ne doit pas etre vide";
		Alert alert = new Alert(Alert.AlertType.ERROR);
		//alert.initOwner(primaryStage);
		alert.setTitle("Erreur lors de la saisie");
		alert.setHeaderText("Un ou plusieurs champs sont mal remplis.");
		alert.setContentText(erreur1);
		alert.showAndWait();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.cbxTva.setItems(FXCollections.observableArrayList(DAOFactory.getDAOFactory(Persistance.MYSQL).getTVADAO().findAll()));
		this.tblProduits.setEditable(true);
		Id.setCellValueFactory(new PropertyValueFactory<Produit,Integer>("id"));
		Libelle.setCellValueFactory(new PropertyValueFactory<Produit,String>("libelle"));
		Libelle.setCellFactory(TextFieldTableCell.forTableColumn());
		Tarif.setCellValueFactory(new PropertyValueFactory<Produit,Float>("prix"));
		//Libelle.setCellFactory(TextFieldTableCell.forTableColumn());
		Tva.setCellValueFactory(new PropertyValueFactory<Produit,TVA>("idtva"));
		
		this.tblProduits.getItems().addAll(DAOFactory.getDAOFactory(Persistance.MYSQL).getProduitDAO().findAll());
		btnsupprimer.setDisable(true);
		btnajoute.setDisable(false);
		btnmodifier.setDisable(true);
		btnretour.setDisable(false);
	}
}
