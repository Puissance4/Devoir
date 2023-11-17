import java.util.ArrayList;

public class SystemeCatalogue extends Systeme {
	public ArrayList<Produit> catalogue=new ArrayList<Produit>();

	public ArrayList<Produit> getCatalogue() {
		return this.catalogue;
	}

	//public void setCatalogue(Produit[] aCatalogue) {
	//	this.catalogue = aCatalogue;
	//}

	public Produit[] recherche(String aMotcle, Filtre[] aFiltres) {
		throw new UnsupportedOperationException();
	}

	public boolean verifierTitre(String aTitre) {
		throw new UnsupportedOperationException();
	}
}