import java.util.ArrayList;
import java.util.Vector;

public class Panier {
	private float cout;
	private int nombreDePoints;
	private ArrayList<Produit> produits;
	public Panier() {
		this.cout=0f;
		this.nombreDePoints=0;
		this.produits=new ArrayList<Produit>();
	}

	public Commande commander() {
		throw new UnsupportedOperationException();
	}

	public ArrayList<Produit> getProduits() {
		return this.produits;
	}
	public float getCout(){
		return this.cout;
	}
	public int getNombrePoints(){
		return this.nombreDePoints;
	}


	public void retirerDuPanier(Produit produit) {
		this.produits.remove(produit);
		cout=cout-produit.get_prix();
		nombreDePoints=nombreDePoints-produit.getPointsBonus();
		
	}
	public void ajouter(Produit produit){
		this.produits.add(produit);
		this.cout=cout+produit.get_prix();
		this.nombreDePoints=nombreDePoints+produit.getPointsBonus();
	}
}