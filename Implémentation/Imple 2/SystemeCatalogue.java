public class SystemeCatalogue extends Systeme {
	private Produit[] catalogue;

	public Produit[] getCatalogue() {
		return this.catalogue;
	}

	public void setCatalogue(Produit[] aCatalogue) {
		this.catalogue = aCatalogue;
	}

	public Produit[] recherche(String aMotcle, Filtre[] aFiltres) {
		throw new UnsupportedOperationException();
	}

	public boolean verifierTitre(String aTitre) {
		throw new UnsupportedOperationException();
	}
}