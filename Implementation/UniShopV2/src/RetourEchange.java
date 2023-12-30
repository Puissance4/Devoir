import java.util.Date;
import java.util.Scanner;

/**
 * La classe RetourEchange sert de base pour gérer les retours et les échanges de produits dans le cadre d'une commande.
 * Elle encapsule les informations et les actions communes liées au processus de retour ou d'échange d'articles.
 */
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


	/**
	 * Constructeur pour initialiser un retour ou un échange avec une commande et une liste d'indices des produits concernés.
	 *
	 * @param commande La commande concernée par le retour ou l'échange.
	 * @param nbProduit Les indices des produits à retourner ou à échanger.
	 */
	public RetourEchange (Commande commande, int [] nbProduit){
		this.commande = commande;
		this.nbProduit =nbProduit;
		listeProduitRetour();

	}


	/**
	 * Affiche les instructions pour retourner les produits concernés par le retour ou l'échange.
	 */
	public void instruction(){
		System.out.println("Veuillez retourner le(s) produits par la poste a l'address suivant :" );
		System.out.println("  12345 rue de Charlevoix , Montreal , Qc , ASD QWE ");
	}

	/**
	 * Crée la liste des produits à retourner ou à échanger et calcule la somme totale à rembourser.
	 */
	public void listeProduitRetour(){
		listeProduits = new Produit[nbProduit.length];
		for (int i = 0; i < nbProduit.length; i++) {
			sommeRetour =  sommeRetour + commande.getProduits().get(nbProduit[i]).get_prix();
			listeProduits[i] = commande.getProduits().get(nbProduit[i]);
		}
	}

	/**
	 * Invite l'utilisateur à spécifier la raison pour le retour ou l'échange.
	 */
	public void raison(){
		System.out.println("Veuillez specifier la raison pour " + type);
		Scanner scanner = new Scanner(System.in);
		_raison = scanner.nextLine();


	}

	/**
	 * Affiche l'état actuel du retour ou de l'échange, y compris les produits concernés.
	 */
	public void afficherEtat(){

		System.out.println("votre " + type + "  de la commande " + commande.getID() + " est " + _etat);
		System.out.println(" pour les produits suivants : ");
		for ( Produit produit: listeProduits) {
			System.out.println(produit.get_titre());
		}
	}

	/**
	 * Invite l'utilisateur à entrer un choix numérique et valide l'entrée.
	 *
	 * @return Le choix numérique validé de l'utilisateur.
	 */
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