package listeMemoire;

import java.util.ArrayList;

import dao.TVADAO;
import metier.TVA;

public class ListeMemoireTvaDAO implements TVADAO{
	private static ListeMemoireTvaDAO instance;

	private ArrayList<TVA> donnees;

	public static ListeMemoireTvaDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoireTvaDAO();
		}

		return instance;
	}

	public ListeMemoireTvaDAO() {

		this.donnees = new ArrayList<TVA>();

		this.donnees.add(new TVA(1, "Normal", 20));
		this.donnees.add(new TVA(2, "Reduit", 10));
	}


	public void create(TVA objet) {

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

	public void update(TVA objet) {

		// Ne fonctionne que si l'objet m�tier est bien fait...
		//int idx = this.donnees.indexOf(objet);
		try{
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

	public void delete(TVA objet) {

		// Ne fonctionne que si l'objet m�tier est bien fait...
		//int idx = this.donnees.indexOf(objet);
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

	public TVA getById(int id) {

		for(TVA tva:donnees)
			if(tva.getId()==id)
				return tva;
			return null;
	}

	public ArrayList<TVA> findAll() {

		return this.donnees;
	}
}
