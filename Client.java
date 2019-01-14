package metier;

public class Client {
	
	private  int id; 		
	private String nom ;	
	private String prenom ;
	private String rue ;
	private String cp ;
	private String voie ;
	private String ville ;
	private String pays ;
	private String ca;
	public Client(int id, String nom, String prenom) {
	
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}
	public Client(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}
	public Client(int id) {
		this.id = id;
	}
	public Client() {}
	
	public Client(int id, String nom, String prenom, String rue, String voie, String ville, String pays) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.rue = rue;
		this.voie = voie;
		this.ville = ville;
		this.pays = pays;
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getVoie() {
		return voie;
	}
	public void setVoie(String voie) {
		this.voie = voie;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	
	public String getCa() {
		return ca;
	}
	public void setCa(String ca) {
		this.ca = ca;
	}
	@Override
	public String toString() {
		//return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + "]";
		return nom+" "+prenom;
	}	
	
	
}
