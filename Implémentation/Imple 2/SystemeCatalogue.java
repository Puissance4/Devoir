import java.util.ArrayList;

public class SystemeCatalogue extends Systeme {
	public ArrayList<Produit> catalogue=new ArrayList<Produit>();

	public ArrayList<Produit> getCatalogue() {
		return this.catalogue;
	}

	public Produit[] recherche(String aMotcle, Filtre[] aFiltres) {
		throw new UnsupportedOperationException();
	}

	public boolean verifierTitre(String aTitre) {
		throw new UnsupportedOperationException();
	}
	public void afficherProduit(Produit produit){
		System.out.println("--------------------------");
		System.out.println("Titre: " + produit.get_titre());
		System.out.println("Categorie: " + produit.getCategorieString());
		System.out.println("Description: " + produit.getDesc());
		System.out.println("Quantité: " + produit.getQuantite());
		System.out.println("Prix: " + produit.get_prix());
		System.out.println("Points Bonus: " + produit.getPointsBonus());
		System.out.println("Lien image: " + produit.getLien());
		System.out.println("--------------------------");
	}
}