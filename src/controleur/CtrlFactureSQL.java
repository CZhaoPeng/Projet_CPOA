package controleur;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import metier.Client;
import metier.Facture;
import metier.Ligne_facture;

public class CtrlFactureSQL implements Initializable{
	@FXML
	private TextField tf_date;
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
	private TableColumn<Facture,Integer> Id;
	@FXML
	private TableColumn<Facture,LocalDate> Date;
	@FXML
	private TableColumn<Facture,Client> Client;
	@FXML
	private ComboBox<Client> cbxClient;
	@FXML
	private TableView<Facture> tblFacture;
	
	private Facture p;
	
	@FXML
	private void creerModele(ActionEvent e){
			if((tf_date.getText().isEmpty())||cbxClient.getValue()==null)
		
			{
					 alertfenetre();
				}

		else if(e.getSource()==btnajoute){
			//LocalDate date = res.getDate("date_facture").toLocalDate();
			//DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			//formatage.format(date);
			
			//String dateStr = sc.next();
			DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate date = LocalDate.parse(tf_date.getText(), formatage);
			
			Facture p = new Facture();
			p.setDate(date);
			p.setIdclient(cbxClient.getSelectionModel().getSelectedItem());
			DAOFactory.getDAOFactory(Persistance.MYSQL).getFactureDAO().create(p);
			this.tblFacture.getItems().add(p);
			tblFacture.getSelectionModel().clearSelection();
			tf_date.clear();
			cbxClient.setValue(null);
			}
		else if(e.getSource()==btnmodifier){
			DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate date = LocalDate.parse(tf_date.getText(), formatage);
			p.setDate(date);
			p.setIdclient(cbxClient.getSelectionModel().getSelectedItem());
			//DAOFactory.getDAOFactory(Persistance.MYSQL).getFactureDAO().create(p);
			DAOFactory.getDAOFactory(Persistance.MYSQL).getFactureDAO().update(p);
			this.tblFacture.refresh();
			btnsupprimer.setDisable(true);
			btnajoute.setDisable(false);
			btnmodifier.setDisable(true);
			tf_date.clear();
			cbxClient.setValue(null);
			tblFacture.getSelectionModel().clearSelection();
		}
	}
	@FXML
	private void selectionAction(){
		DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		p = tblFacture.getSelectionModel().getSelectedItem();
		tf_date.setText(formatage.format(p.getDate()));
		cbxClient.getSelectionModel().select(p.getIdclient());
		btnsupprimer.setDisable(false);
		btnajoute.setDisable(true);
		btnmodifier.setDisable(false);
		
	}
	@FXML
	private void supprimerAction(ActionEvent e){
		boolean utilise = true;
		for(Ligne_facture lf: DAOFactory.getDAOFactory(Persistance.MYSQL).getlignefactureDAO().findAll())
			if(lf.getId()==tblFacture.getSelectionModel().getSelectedItem().getId())
			{
				alertWarming();
				utilise = false;
				break;
			}
		if(utilise){
		
		Facture t=this.tblFacture.getSelectionModel().getSelectedItem();
		DAOFactory.getDAOFactory(Persistance.MYSQL).getFactureDAO().delete(t);
		tblFacture.getItems().remove(t);
		}
		tf_date.clear();
		cbxClient.setValue(null);
		btnsupprimer.setDisable(true);
		btnajoute.setDisable(false);
		btnmodifier.setDisable(true);
		tblFacture.getSelectionModel().clearSelection();
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
		String waring = "Vous ne pouvez pas supprimer le Facture\n il est utilisé";
		Alert alert = new Alert(Alert.AlertType.WARNING);
		//alert.initOwner(primaryStage);
		alert.setTitle("Attention");
		alert.setHeaderText(null);
		alert.setContentText(waring);
		alert.showAndWait();
	}
	public void alertfenetre(){
		String erreur1 ="le client ne doit pas etre vide\nla date n'est pas correct";
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Erreur lors de la saisie");
		alert.setHeaderText("Un ou plusieurs champs sont mal remplis.");
		alert.setContentText(erreur1);
		alert.showAndWait();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.cbxClient.setItems(FXCollections.observableArrayList(DAOFactory.getDAOFactory(Persistance.MYSQL).getClientDAO().findAll()));
		this.tblFacture.setEditable(true);
		Id.setCellValueFactory(new PropertyValueFactory<Facture,Integer>("id"));
		Date.setCellValueFactory(new PropertyValueFactory<Facture,LocalDate>("date"));
		//Libelle.setCellFactory(TextFieldTableCell.forTableColumn());
		Client.setCellValueFactory(new PropertyValueFactory<Facture,Client>("idclient"));
		
		this.tblFacture.getItems().addAll(DAOFactory.getDAOFactory(Persistance.MYSQL).getFactureDAO().findAll());
		btnsupprimer.setDisable(true);
		btnajoute.setDisable(false);
		btnmodifier.setDisable(true);
		btnretour.setDisable(false);
	}
}