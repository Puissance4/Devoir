public class Echange extends RetourEchange {
	private Produit[] _nouveauProduits;
	private int _prixNouveauProduits;

	public void setNouveauProduits(Produit[] aProduits) {
		this._nouveauProduits = aProduits;
	}

	public void payerDifference(Carte aCarte) {
		throw new UnsupportedOperationException();
	}
}