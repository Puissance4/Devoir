import java.util.Scanner;

/**
 * Représente un échange dans un système de commerce électronique, permettant à un acheteur d'échanger des produits d'une commande existante contre de nouveaux produits.
 */
public class Echange extends RetourEchange {

	private Produit[] nouveauProduits;
	private Commande commande;

	/**
	 * Constructeur pour créer un échange à partir d'une commande existante, de produits à retourner et de nouveaux produits à recevoir.
	 *
	 * @param commande La commande concernée par l'échange.
	 * @param produitsRetour Les indices des produits à retourner de la commande.
	 * @param nouveauProduits Les nouveaux produits à envoyer à l'acheteur.
	 */
	public Echange (Commande commande, int [] produitsRetour, Produit [] nouveauProduits){
		super(commande, produitsRetour);
		this.commande = commande;
		this.nouveauProduits = nouveauProduits;
		type = " echange";
	}

	/**
	 * Calcule la différence de prix entre les produits retournés et les nouveaux produits, puis gère le paiement ou le remboursement de la différence.
	 */
	public void payerDifference() {

		float sommeAPayer = sommeNouveauProduit() - sommeRetour;

		if (sommeAPayer < 0) {
			sommeAPayer = Math.abs(sommeAPayer);
			System.out.println(" Nous vous remboursons le montant de " + sommeAPayer + " $ a votre compte" );
			System.out.println("et le produit sera envoye a votre address : " + commande.getAdresse());
		} else if (sommeAPayer ==0 ) {
			System.out.println("La difference est 0 $");
			System.out.println("le produit sera envoye a votre address : " + commande.getAdresse());
		} else {
			System.out.println(" Vous devez payer la difference de " + sommeAPayer + " $ ");
			payer();

		}
	}

	/**
	 * Calcule la somme des prix des nouveaux produits.
	 *
	 * @return La somme totale des prix des nouveaux produits.
	 */
	public float sommeNouveauProduit(){
		float somme = 0;
		for (Produit produit: nouveauProduits) {
			somme = somme + produit.get_prix();
		}
		return somme ;
	}

	/**
	 * Permet à l'utilisateur de payer la différence due pour l'échange en saisissant le PIN de la carte.
	 */
	public void payer(){
		try {
			System.out.println(" Veuillez saisir le PIN pour la carte " + commande.getCarte().getNumero());
			Scanner scan = new Scanner(System.in);
			String pin = scan.nextLine();
			scan.nextLine();
			if (pin == commande.getCarte().getPin() ){
				System.out.println(" Paiement Valide ");
				System.out.println(" le produit sera envoye a votre address : " + commande.getAdresse());
			}else {
				System.out.println(" paiement invalide , veuillez réessayer");
				payer();
			}
		}catch (Exception e ){
			System.out.println("Veuillez saisir un PIN valide");
		}

	}

	/**
	 * Change l'état de l'échange à 'Remboursé'.
	 */
	public void changerEtat(){
		_etat = EtatsCommande.Rembourse;
	}


	/**
	 * Effectue l'échange en suivant les étapes nécessaires telles que la justification, l'instruction, la liste des produits retournés,
	 * le paiement de la différence et le changement d'état.
	 */
	public void effectuerEchange(){
		raison();
		instruction();
		listeProduitRetour();
		payerDifference();
		changerEtat();
	}
}