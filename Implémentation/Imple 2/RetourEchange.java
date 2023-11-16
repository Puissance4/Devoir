public class RetourEchange {
	private date _dateDemande;
	private Produit[] _produits;
	private String _raison;
	private EtatsCommande _etat;
	private int _prix;
	public Commande _peut_avoir;

	public date getDateDemande() {
		return this._dateDemande;
	}

	public void setDateDemande(date aDateDemande) {
		this._dateDemande = aDateDemande;
	}

	public Produit[] getProduits() {
		return this._produits;
	}

	public void setProduits(Produit[] aProduits) {
		this._produits = aProduits;
	}

	public String getRaison() {
		return this._raison;
	}

	public void setRaison(String aRaison) {
		this._raison = aRaison;
	}

	public EtatCommande getEtat() {
		throw new UnsupportedOperationException();
	}

	public void setEtat(EtatCommande aEtat) {
		throw new UnsupportedOperationException();
	}

	public int getPrix() {
		return this._prix;
	}

	public void setPrix(int aPrix) {
		this._prix = aPrix;
	}

	public void annuler() {
		throw new UnsupportedOperationException();
	}
}