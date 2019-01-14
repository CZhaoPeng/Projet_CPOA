package metier;

public class TVA {
	public int id; 		
	public String libelle ;	
	public float taux;
	
	public TVA(){}
	public TVA(int id){
		this.id= id;
	}
	public TVA(int id,String libelle,float taux){
		
		this.id=id;
		this.libelle=libelle;
		this.taux=taux;
	}
	public TVA(String libelle, int taux) {
		this.libelle=libelle;
		this.taux=taux;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public float getTaux() {
		return taux;
	}

	public void setTaux(float taux) {
		this.taux = taux;
	}
	
	@Override
	public String toString() {
		//return "TVA [id :"+id+", libelle :"+libelle+", taux:"+ taux+"]";
		return libelle+"("+taux+"%)";
	}
}