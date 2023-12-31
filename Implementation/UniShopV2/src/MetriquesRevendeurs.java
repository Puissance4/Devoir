/**
 * Représente les métriques spécifiques à un revendeur dans le système UniShop.
 * Elle stocke des informations telles que le revenu du revendeur, le nombre d'articles mis en vente par le revendeur,
 * et le nombre d'articles vendus par le revendeur.
 */
public class MetriquesRevendeurs extends Metriques {
	private float _revenu; // Reseller's revenue
	private int _nombreArticles; // Number of articles reseller has put up for sale
	private int _nombreProduitsVendus; // Number of articles sold
	public Revendeur revendeur;

	// Constructor

	/**
	 * Constructeur pour créer des métriques pour un revendeur spécifique.
	 *
	 * @param revendeur Le revendeur pour lequel les métriques sont créées et associées.
	 */
	public MetriquesRevendeurs(Revendeur revendeur){
		this.revendeur = revendeur;
	}

	// Getters
	public float getRevenu() {return this._revenu;}
	public int getNombreArticles() {return this._nombreArticles;}
	public int getNombreProduitsVendus() {return this._nombreProduitsVendus;}

	// Setters
	public void setNombreProduitsVendus(int aNombreProduitsVendus) {this._nombreProduitsVendus = aNombreProduitsVendus;}
	public void setRevenu(float aRevenu) {this._revenu = aRevenu;}
	public void setNombreArticles(int aNombreArticles) {this._nombreArticles = aNombreArticles;}
}