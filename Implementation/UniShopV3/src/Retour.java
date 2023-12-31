/**
 * La classe Retour étend la classe RetourEchange et représente un retour de produits d'une commande spécifique.
 * Elle gère les actions liées au processus de retour, telles que le remboursement, le retour des produits en inventaire, et la mise à jour de l'état de la commande.
 */
public class Retour extends RetourEchange {
	private int [] produits;
	private Commande commande;

	/**
	 * Constructeur pour initialiser un retour avec la commande spécifiée et les produits concernés.
	 *
	 * @param commande La commande à laquelle le retour est associé.
	 * @param produits Les indices des produits dans la commande à retourner.
	 */
	public Retour(Commande commande, int [] produits){
		super(commande, produits);
		this.produits = produits;
		this.commande = commande;
		type = "retour";

	}

	/**
	 * Effectue le remboursement du montant total des produits retournés à la carte utilisée pour la commande.
	 */
	public void rembourser() {
		System.out.println(" montant " + sommeRetour + " est retourne a la carte " + commande.getCarte().getNumero());

	}

	/**
	 * Retourne les produits dans l'inventaire du revendeur.
	 */
	public void retourInventaire(){

		for ( Produit produit: listeProduits) {
			produit.getRevendeur().get_produits().add(produit);
		}
	}

	/**
	 * Change l'état de la commande associée à remboursé.
	 */
	public void changerEtat(){
		_etat = EtatsCommande.Rembourse;
	}

	/**
	 * Effectue la procédure complète de retour, incluant la spécification de la raison, l'instruction pour le retour, le remboursement, le retour des produits dans l'inventaire, et le changement d'état.
	 */
	public void effectuerRetour(){
		raison();
		instruction();
		rembourser();
		retourInventaire();
		changerEtat();
	}



}