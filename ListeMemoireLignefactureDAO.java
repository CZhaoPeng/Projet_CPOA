package listeMemoire;

import java.util.ArrayList;

import dao.DAOFactory;
import dao.Ligne_factureDAO;
import dao.DAOFactory.Persistance;
import metier.Ligne_facture;

public class ListeMemoireLignefactureDAO implements Ligne_factureDAO{
	private static ListeMemoireLignefactureDAO instance;

	private ArrayList<Ligne_facture> donnees;

	public static ListeMemoireLignefactureDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoireLignefactureDAO();
		}

		return instance;
	}

	private ListeMemoireLignefactureDAO() {

		this.donnees = new ArrayList<Ligne_facture>();

		this.donnees.add(new Ligne_facture(1,1,DAOFactory.getDAOFactory(Persistance.LISTEMEMOIRE).getProduitDAO().getById(1),4));
		this.donnees.add(new Ligne_facture(2,2,DAOFactory.getDAOFactory(Persistance.LISTEMEMOIRE).getProduitDAO().getById(2),5));
		this.donnees.add(new Ligne_facture(3,5,DAOFactory.getDAOFactory(Persistance.LISTEMEMOIRE).getProduitDAO().getById(2),3));

	}


	public void create(Ligne_facture objet) {

		// gestion de l'auto-incr�ment
		try{
			if (this.donnees.size() == 0) {
				objet.setId(0);
			} else {
				int id = this.donnees.get(this.donnees.size() - 1).getId()+1;
				objet.setId(id);
			}
			
			// ajout du nouvel objet � la liste
			this.donnees.add(objet);
		}catch(Exception e){
			System.out.println("Pb select"+e.getMessage());
		}
	}

	public void update(Ligne_facture objet) {

		// Ne fonctionne que si l'objet m�tier est bien fait...
		try{
			int idx =objet.getId()-1;
			if (idx == -1) {
				throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
			} else {
				this.donnees.set(idx, objet);
			}
		}catch(Exception e){
			System.out.println("Pb select"+e.getMessage());
		}
	}

	public void delete(Ligne_facture objet) {

		// Ne fonctionne que si l'objet m�tier est bien fait...
		//int idx = this.donnees.indexOf(objet);
		try{
			
			int id =objet.getId()-1;
			//int idligne =objet.getIdligne()-1;
			if (id == -1){
				throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
			} else {
				this.donnees.remove(id);
				//this.donnees.remove(idligne);
			}
		}catch(Exception e){
			System.out.println("Pb select"+e.getMessage());
			}
		}

	public Ligne_facture getById(int id) {

		// Ne fonctionne que si l'objet m�tier est bien fait...
		try{
			int idx =id-1;
//			//int idx = this.donnees.indexOf(new Ligne_facture(id,0, 0,0));
			if (idx == -1) {
				throw new IllegalArgumentException("Aucun objet ne poss�de cet identifiant");
			} else {
				System.out.println(this.donnees.get(idx));
			}
	}catch(Exception e){
			System.out.println("Pb select"+e.getMessage());
			}
		return null;
	}	

	public ArrayList<Ligne_facture> findAll() {

		return this.donnees;
	}

}
