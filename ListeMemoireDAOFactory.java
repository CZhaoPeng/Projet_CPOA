package listeMemoire;

import dao.ClientDAO;
import dao.DAOFactory;
import dao.FactureDAO;
import dao.Ligne_factureDAO;
import dao.ProduitDAO;
import dao.TVADAO;

public class ListeMemoireDAOFactory extends DAOFactory{

	@Override
	public TVADAO getTVADAO() {
		return ListeMemoireTvaDAO.getInstance();
	}

	@Override
	public ClientDAO getClientDAO() {
		return ListeMemoireClientDAO.getInstance();
	}

	@Override
	public ProduitDAO getProduitDAO() {
		return ListeMemoireProduitDAO.getInstance();
	}

	@Override
	public FactureDAO getFactureDAO() {
		return ListeMemoireFactureDAO.getInstance();
	}

	@Override
	public Ligne_factureDAO getlignefactureDAO() {
		return ListeMemoireLignefactureDAO.getInstance();
	}

}
