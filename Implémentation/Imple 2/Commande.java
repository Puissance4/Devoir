import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

public class Commande {
	private float cout;
	private String adresse;
	private String telephone;
	private ArrayList<Produit> produits;
	private Carte carte;
	private String id;
	private EtatsCommande etat;
	private Date dateArrivee;
	private String infoLivraison;
	private int numSuivi;
	private String compagnieExp;
	public Acheteur acheteur;
	public Vector<BilletSignalement> peut_avoir = new Vector<BilletSignalement>();
	public Vector<Produit> comporter = new Vector<Produit>();

	public Commande (float cout, ArrayList<Produit> produits,Acheteur acheteur, String adresse,String telephone, Carte carte, String id,String infoLivraison){
		this.cout=cout;
		this.telephone=telephone;
		this.adresse=adresse;
		this.produits=produits;
		this.acheteur=acheteur;
		this.carte=carte;
		this.id=id;
		this.infoLivraison=infoLivraison;
		//this.etat= a ajouter
	}
	public Retour retour() {
		throw new UnsupportedOperationException();
	}

	public Echange echange() {
		throw new UnsupportedOperationException();
	}

	public void annuler() {
		throw new UnsupportedOperationException();
	}

	public void confirmerReception() {
		throw new UnsupportedOperationException();
	}

	public void setCout(Object aFloat_36) {
		throw new UnsupportedOperationException();
	}

	public void setAdresse(String adr) {
		this.adresse = adr;
	}

	public void setTelephone(String tel) {
		this.telephone = tel;
	}

	public void setCarte(Carte carte) {
		this.carte = carte;
	}

	public void setInfoLivraison(String info) {
		this.infoLivraison = info;
	}

	public void setID(String aId) {
		throw new UnsupportedOperationException();
	}

	public BilletSignalement signaler() {
		throw new UnsupportedOperationException();
	}

	public int getNumSuivi() {
		return this.numSuivi;
	}

	public void setNumSuivi(int numSuivi) {
		this.numSuivi = numSuivi;
	}

	public String getCompagnieExp() {
		return this.compagnieExp;
	}
	public String getID() {
		return this.id;
	}
	public ArrayList<Produit> getProduits() {
		return this.produits;
	}
	
	

	public void setCompagnieExp(String compagnieExp) {
		this.compagnieExp = compagnieExp;
	}

	public Date getDateArrivee() {
		return this.dateArrivee;
	}

	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}
}