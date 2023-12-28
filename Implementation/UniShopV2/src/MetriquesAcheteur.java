import java.util.ArrayList;

public class MetriquesAcheteur extends Metriques {
	private int _nombreCommandes; // Number of ongoing orders
	private int _nombreArticles; // Number of bought articles
	public ArrayList<String> _classementAcheteurSuivis = new ArrayList<>(); // List of followed buyers names

	public Acheteur acheteur;

	// Constructor
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