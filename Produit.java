package metier;
public class Produit {
	

		private int id; 		
		private String libelle ;	
		private float prix ;	
		private TVA idtva;
		public Produit(int id, String libelle, float prix,TVA idtva)
		{
			this.id =id;
//			this.libelle =libelle;
//			this.prix = prix;
//			this.idtva = idtva;
			this.libelle = libelle;
			this.prix = prix;
			this.idtva =idtva;
		}
		public Produit() {

		}
		public Produit(String libelle, float prix,TVA idtva)
		{
			this.libelle = libelle;
			this.prix = prix;
			this.idtva =idtva;
		}
		public Produit(String libelle, float prix)
		{
			this.libelle = libelle;
			this.prix = prix;
		}
		public Produit(int id) {

			this.id =id;
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
		public float getPrix() {
			return prix;
		}
		public void setPrix(float prix) {
			this.prix =prix;
		}
	
		public TVA getIdtva() {
			return idtva;
		}
		public void setIdtva(TVA idtva) {
			this.idtva = idtva;
		}

		@Override
		public String toString() {
			//return "Produit [id=" + id + ", libelle=" + libelle + ", prix=" + prix + ", idtva=" + idtva + "]";
			return libelle+"("+prix+"€)";
		}
		
}
