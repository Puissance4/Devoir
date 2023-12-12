import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class SystemeGeneral extends Systeme {
	private Carte[] _cartes;
	private ArrayList<Integer> IDs = new ArrayList<Integer>();

	public boolean verifierCarte(Carte carte) {
		return true;
	}

	public boolean verifierCommande(Commande com) {
		ArrayList<Produit> produits=com.getProduits();
		for(int i=0;i<produits.size();i++){
			Produit produitTemp=produits.get(i);
			int quantite=produitTemp.getQuantite();
			if(quantite==0){
				return false;
			}
			else{
				produitTemp.setQuantite(quantite-1);
			}}
		return true;}

	public String creerID() {
		int id = (int) (Math.random() * 1000000000);
		while (IDs.contains(id)) {
			id = (int) (Math.random() * 1000000000);
		}
		IDs.add(id);
		return Integer.toString(id);
	}
		
}