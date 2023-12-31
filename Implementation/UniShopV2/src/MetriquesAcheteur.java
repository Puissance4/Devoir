import java.util.ArrayList;

/**
 * Représente les métriques spécifiques à un acheteur dans le système UniShop.
 * Elle stocke des informations telles que le nombre de commandes en cours, le nombre d'articles achetés,
 * et la liste des acheteurs suivis par cet acheteur.
 */
public class MetriquesAcheteur extends Metriques {
	private int _nombreCommandes; // Number of ongoing orders
	private int _nombreArticles; // Number of bought articles
	public ArrayList<String> _classementAcheteurSuivis = new ArrayList<>(); // List of followed buyers names

	public Acheteur acheteur;

	// Constructor

	/**
	 * Constructeur pour créer des métriques pour un acheteur spécifique.
	 *
	 * @param acheteur L'acheteur pour lequel les métriques sont créées et associées.
	 */
	public MetriquesAcheteur(Acheteur acheteur){
		this.acheteur = acheteur;
	}

	// Getters
	public int getNombreCommandes() {return this._nombreCommandes;}
	public int getNombreArticles() {return this._nombreArticles;}

	// Setters
	public void setNombreCommandes(int aNombreCommandes) {this._nombreCommandes = aNombreCommandes;}
	public void setNombreArticles(int aNombreArticles) {this._nombreArticles = aNombreArticles;}
}