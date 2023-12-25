import java.util.Scanner;

public class Echange extends RetourEchange {

	private Produit[] nouveauProduits;
	private Commande commande;




	public Echange (Commande commande, int [] produitsRetour, Produit [] nouveauProduits){
		super(commande, produitsRetour);
		this.commande = commande;
		this.nouveauProduits = nouveauProduits;
		type = " echange";
	}
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

	public float sommeNouveauProduit(){
		float somme = 0;
		for (Produit produit: nouveauProduits) {
			somme = somme + produit.get_prix();
		}
		return somme ;
	}
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

	public void changerEtat(){
		_etat = EtatsCommande.Rembourse;
	}


	public void effectuerEchange(){
		raison();
		instruction();
		listeProduitRetour();
		payerDifference();
		changerEtat();
	}
}