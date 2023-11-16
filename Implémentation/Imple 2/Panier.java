import java.util.Vector;

public class Panier {
	private float cout;
	private int nombreDePoints;
	private Produit[] produits;
	public Acheteur _unnamed_Acheteur_;
	public Vector<Produit> _contient = new Vector<Produit>();

	public Commande commander() {
		throw new UnsupportedOperationException();
	}

	public Produit[] getProduits() {
		return this.produits;
	}

	public void retirerDuPanier(int adresseProduit) {
		//this.produits=produits.remove(adresseProduit);
		
	}
}