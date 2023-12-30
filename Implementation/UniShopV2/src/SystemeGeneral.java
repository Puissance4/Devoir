import java.util.ArrayList;

/**
 * La classe SystemeGeneral sert de base pour gérer les fonctionnalités communes du système,
 * telles que la vérification des cartes de paiement, la gestion des commandes, et la création d'identifiants uniques.
 */
public class SystemeGeneral extends Systeme {
	private Carte[] _cartes;
	private ArrayList<Integer> IDs = new ArrayList<Integer>();

	/**
	 * Vérifie la validité d'une carte de paiement.
	 * @param carte L'objet Carte à vérifier.
	 * @return true si la carte est valide, false sinon.
	 */
	public boolean verifierCarte(Carte carte) {
		return true;
	}

	/**
	 * Vérifie la disponibilité des produits d'une commande et décrémente la quantité disponible pour chaque produit.
	 * @param com La commande à vérifier.
	 * @return true si tous les produits de la commande sont disponibles, false sinon.
	 */
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

	/**
	 * Crée un identifiant unique pour une commande, un produit ou un utilisateur.
	 * @return Un String représentant l'identifiant unique créé.
	 */
	public String creerID() {
		int id = (int) (Math.random() * 1000000000);
		while (IDs.contains(id)) {
			id = (int) (Math.random() * 1000000000);
		}
		IDs.add(id);
		return Integer.toString(id);
	}
		
}