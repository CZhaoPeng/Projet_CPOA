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
import javafx.stage.Stage;

public class CtrlMenu implements Initializable{
	@FXML
	private Button listememoire;
	@FXML
	private Button mysql;
	@FXML
	private void creerModele(ActionEvent e){

		if(e.getSource()==listememoire){
			try{
				Stage stage = new Stage();
				stage.setTitle("Gestion par ListeMemoire");
				URL fxmlURL= getClass().getResource("/vue/listememoire.fxml");
				FXMLLoader fxmlLoader=new FXMLLoader(fxmlURL);
				AnchorPane root = fxmlLoader.load();
				Scene scene = new Scene(root,550,350);
				scene.getStylesheets().add(getClass().getResource("/vue/application.css").toExternalForm());
				stage.setScene(scene);
				stage.show();
			} catch(Exception e1) {
				e1.printStackTrace();
			}
			}
		else if(e.getSource()==mysql){
			
			try{
				Stage stage = new Stage();
				stage.setTitle("Gestion par MySQL");
				URL fxmlURL= getClass().getResource("/vue/mysql.fxml");
				FXMLLoader fxmlLoader = new FXMLLoader(fxmlURL);
				AnchorPane node = fxmlLoader.load();
				Scene scene = new Scene (node,550,350);
				scene.getStylesheets().add(getClass().getResource("/vue/application.css").toExternalForm());	
				stage.setScene(scene);
				stage.show();
			} catch(Exception e1) {
				e1.printStackTrace();
			}
			
		}
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}