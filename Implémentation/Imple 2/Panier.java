import java.util.Vector;

public class Panier {
	private float _cout;
	private int _nombreDePoints;
	private Produit[] _produits;
	public Acheteur _unnamed_Acheteur_;
	public Vector<Produit> _contient = new Vector<Produit>();

	public Commande commander() {
		throw new UnsupportedOperationException();
	}

	public Produit[] getProduits() {
		return this._produits;
	}

	public void retirerDuPanier(Produit aProduit) {
		throw new UnsupportedOperationException();
	}
}