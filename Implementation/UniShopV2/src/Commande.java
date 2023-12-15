import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
	private String numSuivi;
	private String compagnieExp;
	public Acheteur acheteur;
	public Vector<BilletSignalement> peut_avoir = new Vector<BilletSignalement>();

	public Commande (ArrayList<Produit> produits,Acheteur acheteur, String adresse,String telephone, Carte carte, String id,String infoLivraison){
		float prix=0;
		for(int i=0;i<produits.size();i++){
			prix+=produits.get(i).get_prix();
		}
		this.cout=prix;
		this.telephone=telephone;
		this.adresse=adresse;
		this.produits=produits;
		this.acheteur=acheteur;
		this.carte=carte;
		this.id=id;
		this.infoLivraison=infoLivraison;
		this.etat= EtatsCommande.EnProduction;
	}

	public Commande(String [] donnee,ArrayList<Produit> catalogue,Acheteur acheteur){
		this.produits=new ArrayList<Produit>();
		String[] prod=donnee[0].split(";");
		for (Produit produit : catalogue) {
			for (int i=0;i<prod.length;i++){
				if (produit.getIdentifiant().equals(prod[i])) {
					this.produits.add(produit);}
				}
			}
		this.acheteur=acheteur;
		this.adresse=donnee[2];
		this.telephone=donnee[3];
		//instancier la carte
		
		this.id=donnee[5];
		this.infoLivraison=donnee[5];
		if(donnee[6]=="EnProduction"){this.etat= EtatsCommande.EnProduction;}
		else if(donnee[6]=="EnLivraison"){this.etat= EtatsCommande.EnLivraison;}
		else if(donnee[6]=="Livre"){this.etat= EtatsCommande.Livre;}
		String [] date= donnee[7].split(";");
		this.dateArrivee= new GregorianCalendar(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])).getTime();
		this.numSuivi=donnee[8];
		this.compagnieExp=donnee[9];
		//instancier les billets de signalement

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

	public String getNumSuivi() {
		return this.numSuivi;
	}

	public void setNumSuivi(String numSuivi) {
		this.numSuivi = numSuivi;
	}

	public String getCompagnieExp() {
		return this.compagnieExp;
	}
	public String getAdresse() {
		return this.adresse;
	}
	public String getTelephone() {
		return this.telephone;
	}
	public Carte getCarte() {
		return this.carte;
	}
	public String getID() {
		return this.id;
	}
	public float getCout() {
		return this.cout;
	}
	public ArrayList<Produit> getProduits() {
		return this.produits;
	}
	
	public String getInfoLivraison() {
		return this.infoLivraison;
	}
	
	public EtatsCommande getEtatsCommande() {
		return this.etat;
	}
	public void setEtatsCommande(EtatsCommande etat) {
		this.etat=etat;
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