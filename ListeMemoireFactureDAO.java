package listeMemoire;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import dao.DAOFactory;
import dao.FactureDAO;
import dao.DAOFactory.Persistance;
import metier.Facture;

public class ListeMemoireFactureDAO implements FactureDAO{
	private static ListeMemoireFactureDAO instance;

	private ArrayList<Facture> donnees;

	public static ListeMemoireFactureDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoireFactureDAO();
		}

		return instance;
	}

	private ListeMemoireFactureDAO() {

		this.donnees = new ArrayList<Facture>();

		this.donnees.add(new Facture(1,DAOFactory.getDAOFactory(Persistance.LISTEMEMOIRE).getClientDAO().getById(1),LocalDate.of(2018, Month.FEBRUARY, 11)));
		this.donnees.add(new Facture(2,DAOFactory.getDAOFactory(Persistance.LISTEMEMOIRE).getClientDAO().getById(2),LocalDate.of(2018, Month.SEPTEMBER, 30) ));
		this.donnees.add(new Facture(3,DAOFactory.getDAOFactory(Persistance.LISTEMEMOIRE).getClientDAO().getById(1),LocalDate.of(2018, Month.SEPTEMBER, 20) ));
	}


	public void create(Facture objet) {

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

	public void update(Facture objet) {

		// Ne fonctionne que si l'objet m�tier est bien fait...
		try{
			//int idx = this.donnees.indexOf(objet);
			int idx = objet.getId()-1;
			if (idx == -1) {
				throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
			} else {
				this.donnees.set(idx, objet);
			}
		}catch(Exception e){
			System.out.println("Pb select"+e.getMessage());	
		}
	}

	public void delete(Facture objet) {

		// Ne fonctionne que si l'objet m�tier est bien fait...
		try{
			int idx = objet.getId()-1;
			if (idx == -1) {
				throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
			} else {
				this.donnees.remove(idx);
			}
		}catch(Exception e){
			System.out.println("Pb select"+e.getMessage());	
		}
		}

	public Facture getById(int id) {

		// Ne fonctionne que si l'objet m�tier est bien fait...
		//int idx = this.donnees.indexOf(new Facture(id,0,LocalDate.of(2015, Month.FEBRUARY, 11)));
//		try{
//			int idx=id-1;
//			if (idx == -1) {
//				throw new IllegalArgumentException("Aucun objet ne possede cet identifiant");
//			} else {
//				System.out.println(this.donnees.get(idx));
//			}
//		}catch(Exception e){
//			System.out.println("Pb select"+e.getMessage());	
//			}
		for(Facture f:donnees)
			{
				if(f.getId()==id)
					return f;
			}
			
		return null;
		}

	public ArrayList<Facture> findAll() {

		return this.donnees;
	}

}
