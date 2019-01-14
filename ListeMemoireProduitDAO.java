package listeMemoire;

import java.util.ArrayList;

import dao.DAOFactory;
import dao.ProduitDAO;
import dao.DAOFactory.Persistance;
import metier.Produit;

public class ListeMemoireProduitDAO implements ProduitDAO{
	private static ListeMemoireProduitDAO instance;
	private ArrayList<Produit> donnees;

	public static ListeMemoireProduitDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoireProduitDAO();
		}

		return instance;
	}

	private ListeMemoireProduitDAO() {

		this.donnees = new ArrayList<Produit>();

		this.donnees.add(new Produit(1,"choux",10,DAOFactory.getDAOFactory(Persistance.LISTEMEMOIRE).getTVADAO().getById(1)));
		this.donnees.add(new Produit(2,"radis",10,DAOFactory.getDAOFactory(Persistance.LISTEMEMOIRE).getTVADAO().getById(2)));
	}


	public void create(Produit objet) {

		// gestion de l'auto-incr�ment
		try{
			if (this.donnees.size() == 0) {
				objet.setId(0);
			} else {
				int id = this.donnees.get(this.donnees.size() - 1).getId() + 1;
				objet.setId(id);
			}
			
			// ajout du nouvel objet � la liste
			this.donnees.add(objet);
		}catch(Exception e){
			System.out.println("Pb select"+e.getMessage());
			}
		}

	public void update(Produit objet) {

		// Ne fonctionne que si l'objet m�tier est bien fait...
		try{
			int idx = objet.getId()-1;
			if (idx == -1) {
				throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
			} else {
				this.donnees.set(idx, objet);
			}
		}catch(Exception e)
		{
			System.out.println("Pb select"+e.getMessage());
			}
		}

	public void delete(Produit objet) {

		// Ne fonctionne que si l'objet m�tier est bien fait...
			try{int idx = objet.getId()-1;
			if (idx == -1) {
				throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
			} else {
				this.donnees.remove(idx);
			}
		}catch(Exception e){
			System.out.println("Pb select"+e.getMessage());
			}
		}

	public Produit getById(int id) {

		// Ne fonctionne que si l'objet m�tier est bien fait...
		//int idx = this.donnees.indexOf(new Produit(id, "test",0, 0));
//		try{
//			int idx = id-1;
//			if (idx == -1) {
//				throw new IllegalArgumentException("Aucun objet ne poss�de cet identifiant");
//			} else {
//				System.out.println(this.donnees.get(idx));
//			}
//		}catch(Exception e){
//			System.out.println("Pb select"+e.getMessage());
//		}
		for(Produit p: donnees)
		{
			if(p.getId()==id)
				return p;
		}
		return null;
		
		}

	public ArrayList<Produit> findAll() {

		return this.donnees;
	}
}
