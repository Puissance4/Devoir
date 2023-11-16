public class SystemeCatalogue extends Systeme {
	private Produit[] _catalogue;

	public Produit[] getCatalogue() {
		return this._catalogue;
	}

	public void setCatalogue(Produit[] aCatalogue) {
		this._catalogue = aCatalogue;
	}

	public Produit[] recherche(String aMotcle, Filtre[] aFiltres) {
		throw new UnsupportedOperationException();
	}

	public boolean verifierTitre(String aTitre) {
		throw new UnsupportedOperationException();
	}
}