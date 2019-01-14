package dao;

import MySQL.MySQLDAOFactory;
import listeMemoire.ListeMemoireDAOFactory;

public abstract class DAOFactory {
	
	public enum Persistance
	{
		MYSQL,
		LISTEMEMOIRE,
	}

	public static DAOFactory getDAOFactory(Persistance cible){
		DAOFactory daoF = null;
		switch(cible){
			case MYSQL: daoF = new MySQLDAOFactory();break;
			case LISTEMEMOIRE: daoF = new ListeMemoireDAOFactory();break;
		}
		return daoF;
	}
	
	public abstract TVADAO getTVADAO();
	public abstract ClientDAO getClientDAO();
	public abstract ProduitDAO getProduitDAO();
	public abstract FactureDAO getFactureDAO();
	public abstract Ligne_factureDAO getlignefactureDAO();
}
