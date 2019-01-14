package metier;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Connexion {
	private String url,login,pwd;
	private static Connection maConnexion;
	private static Connexion instance;
	public static Connexion getInstance(){
		if(instance==null){
			instance = new Connexion();
			
		}
		return instance;
	}
public Connexion(){
		this.litFichier();
		creeConnexion();
	}
public void litFichier() {

		try{
			Properties accesBdd = new Properties();
			File fBdd = new File("Properties.xml");
			FileInputStream source = new FileInputStream(fBdd);
			accesBdd.loadFromXML(source);
			this.url= "jdbc:mysql://localhost:8000/zhao37u_CPOA";
			//this.url="jdbc:mysql://infodb.iutmetz.univ-lorraine.fr:3306/zhao37u_CPOA"+
		//"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDateTimeCode=false&serverTimezone=Europe/Paris";
			this.login=accesBdd.getProperty("login");
			this.pwd=accesBdd.getProperty("pass");	
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
public  Connection creeConnexion(){
		
		try {
			if(maConnexion == null|| maConnexion.isClosed()){
				maConnexion = DriverManager.getConnection(this.url,this.login,this.pwd);
			}
		}
		catch(SQLException sqle) {
			System.out.println("Erreur connexion "+ sqle.getMessage());
		}
		
		return maConnexion;
	}
}
