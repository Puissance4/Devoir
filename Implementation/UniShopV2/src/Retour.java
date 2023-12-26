public class Retour extends RetourEchange {
	private int [] produits;
	private Commande commande;


	public Retour(Commande commande, int [] produits){
		super(commande, produits);
		this.produits = produits;
		this.commande = commande;
		type = "retour";

	}
	public void rembourser() {
		System.out.println(" montant " + sommeRetour + " est retourne a la carte " + commande.getCarte().getNumero());

	}
	public void retourInventaire(){

		for ( Produit produit: listeProduits) {
			produit.getRevendeur().get_produits().add(produit);
		}
	}
	public void changerEtat(){
		_etat = EtatsCommande.Rembourse;
	}

	public void effectuerRetour(){
		raison();
		instruction();
		rembourser();
		retourInventaire();
		changerEtat();
	}



}