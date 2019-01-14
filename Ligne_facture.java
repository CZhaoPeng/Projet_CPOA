package metier;


public class Ligne_facture {
		private int id; 
		private int idligne;
		private Produit idproduit ;	
		private int  quantite ;
		public Ligne_facture(int id, int idligne,Produit idproduit, int quantite ) {
			this.id =id;
			this.idligne=idligne;
			this.idproduit =idproduit;
			this.quantite =quantite;
		}
		
		public Ligne_facture() {}
		
		public Ligne_facture(int id) {
			this.id=id;
		}
		@Override
		public String toString() {
			return "Ligne_facture [id=" + id + ", idligne=" + idligne + ", idproduit=" + idproduit + ", quantite="
					+ quantite + "]";
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public int getIdligne() {
			return idligne;
		}

		public void setIdligne(int idligne) {
			this.idligne = idligne;
		}

		public Produit getIdproduit() {
			return idproduit;
		}

		public void setIdproduit(Produit idproduit) {
			this.idproduit = idproduit;
		}

		public int getQuantite() {
			return quantite;
		}

		public void setQuantite(int quantite) {
			this.quantite = quantite;
		}
	
}
