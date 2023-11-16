import java.util.Vector;

public class Revendeur extends Utilisateur {
	public Revendeur(String nom, String email, String motDePasse, String adresse, String telephone) {
		super(nom, email, motDePasse, adresse, telephone);
		//TODO Auto-generated constructor stub
	}

	private Produit[] _produits;
	private int _likes = 0;
	public Vector<Acheteur> _suit = new Vector<Acheteur>();
	public MetriquesRevendeurs _unnamed_MetriquesRevendeurs_;

	public Produit[] getProduits() {
		return this._produits;
	}

	public Produit ajouterProduit() {
		throw new UnsupportedOperationException();
	}

	public int getLikes() {
		return this._likes;
	}

	public void setLikes(int aLikes) {
		this._likes = aLikes;
	}

	public void modifierProfil() {
		throw new UnsupportedOperationException();
	}

	public void changerEtat(Commande aCommande, String aCompagnieExp, int aNumSuivi) {
		throw new UnsupportedOperationException();
	}

	public void ajouterPromotion(Produit aProduit) {
		throw new UnsupportedOperationException();
	}

	public void setProduits(Produit[] aProduits) {
		this._produits = aProduits;
	}

}