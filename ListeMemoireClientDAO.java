package listeMemoire;

import java.util.ArrayList;

import dao.ClientDAO;
import metier.Client;

public class ListeMemoireClientDAO implements ClientDAO{
	private static ListeMemoireClientDAO instance;

	private ArrayList<Client> donnees;

	public static ListeMemoireClientDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoireClientDAO();
		}

		return instance;
	}

	private ListeMemoireClientDAO() {

		this.donnees = new ArrayList<Client>();

		this.donnees.add(new Client(1, "ZHAO", "xixi"));
		this.donnees.add(new Client(2, "HUANG", "HE"));
	}


	public void create(Client objet) {

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

	public void update(Client objet) {

		// Ne fonctionne que si l'objet m�tier est bien fait...
		try
		{
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

	public void delete(Client objet) {

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

	public Client getById(int id) {

		// Ne fonctionne que si l'objet m�tier est bien fait...
		//int idx = this.donnees.indexOf(new Client(id, "test", "test"));
//		try{
//			//int idx = this.donnees.indexOf(new Client(id));
//			int idx = id-1; 
//			if (idx == -1) {
//				throw new IllegalArgumentException("Aucun objet ne poss�de cet identifiant");
//			} else {
//				System.out.println(this.donnees.get(idx));
//			}
//		}catch(Exception e){
//			System.out.println("Pb select"+e.getMessage());
//			}
		
		for(Client c:donnees){
			if(c.getId()==id)
				return c;
		}
		return null;
		}

	public ArrayList<Client> findAll() {

		return this.donnees;
	}

}
