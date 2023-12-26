import java.util.Date;
import java.util.Scanner;

public class RetourEchange {
	protected String type ;
	protected Scanner scanner = new Scanner(System.in);
	private Date _dateDemande;
	protected Produit[] listeProduits;
	private int[] nbProduit;
	private String _raison;
	protected EtatsCommande _etat = EtatsCommande.EnProduction;
	private int _prix;
	private Commande commande;

	protected float sommeRetour = 0;



	public RetourEchange (Commande commande, int [] nbProduit){
		this.commande = commande;
		this.nbProduit =nbProduit;
		listeProduitRetour();

	}

	public void instruction(){
		System.out.println("Veuillez retourner le(s) produits par la poste a l'address suivant :" );
		System.out.println("  12345 rue de Charlevoix , Montreal , Qc , ASD QWE ");
	}

	public void listeProduitRetour(){
		listeProduits = new Produit[nbProduit.length];
		for (int i = 0; i < nbProduit.length; i++) {
			sommeRetour =  sommeRetour + commande.getProduits().get(nbProduit[i]).get_prix();
			listeProduits[i] = commande.getProduits().get(nbProduit[i]);
		}
	}
	public void raison(){
		System.out.println("Veuillez specifier la raison pour " + type);
		Scanner scanner = new Scanner(System.in);
		_raison = scanner.nextLine();


	}


	public void afficherEtat(){

		System.out.println("votre " + type + "  de la commande " + commande.getID() + " est " + _etat);
		System.out.println(" pour les produits suivants : ");
		for ( Produit produit: listeProduits) {
			System.out.println(produit.get_titre());
		}
	}

	public int prompt() {

		int choix = 0;
		try {
			choix = scanner.nextInt();
			scanner.nextLine();
		} catch (Exception e) {
			System.out.println("Veuillez saisir un numero valide ");
		}

		return choix;
	}

	public Date getDateDemande() {
		return this._dateDemande;
	}

	public void setDateDemande(Date aDateDemande) {
		this._dateDemande = aDateDemande;
	}


	public String getRaison() {
		return this._raison;
	}

	public void setRaison(String aRaison) {
		this._raison = aRaison;
	}

	public EtatsCommande getEtat() {
		throw new UnsupportedOperationException();
	}

	public void setEtat(EtatsCommande aEtat) {

	}

	public Commande getCommande() {
		return commande;
	}

	public void set_etat(EtatsCommande _etat) {
		this._etat = _etat;
	}

	public int getPrix() {
		return this._prix;
	}

	public void setPrix(int aPrix) {
		this._prix = aPrix;
	}

	public void annuler() {
		throw new UnsupportedOperationException();
	}
}