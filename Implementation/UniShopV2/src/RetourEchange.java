import java.util.Date;

public class RetourEchange {
	private Date _dateDemande;
	private Produit[] _produits;
	private String _raison;
	private EtatsCommande _etat;
	private int _prix;
	public Commande _peut_avoir;

	public Date getDateDemande() {
		return this._dateDemande;
	}

	public void setDateDemande(Date aDateDemande) {
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

	public EtatsCommande getEtat() {
		throw new UnsupportedOperationException();
	}

	public void setEtat(EtatsCommande aEtat) {
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