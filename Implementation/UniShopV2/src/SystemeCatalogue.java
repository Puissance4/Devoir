import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class SystemeCatalogue extends Systeme {
	public ArrayList<Produit> catalogue=new ArrayList<Produit>();

	public SystemeCatalogue (){
		try {
			BufferedReader readerProduits=new BufferedReader(new FileReader("../Produits.csv"));
			String line=readerProduits.readLine();//ignore la ligne des noms de colonnes
			while ((line=readerProduits.readLine())!=null) {
				String[] donnee=line.split(",");
				catalogue.add(new Produit(donnee));
			
				
			}
			readerProduits.close();
		} catch (Exception e) {
	
			e.printStackTrace();
		}


	}

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