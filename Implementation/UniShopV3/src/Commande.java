import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Représente une commande dans un système de commerce électronique, contenant des détails sur les produits commandés, l'acheteur, et les informations d'expédition et de paiement.
 */
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
	public String acheteur;
	public ArrayList<BilletSignalement> signalements = new ArrayList<>();

	/**
	 * Constructeur pour créer une commande à partir d'une liste de produits, d'informations d'acheteur et de paiement.
	 *
	 * @param produits Liste des produits commandés.
	 * @param acheteur L'acheteur qui passe la commande.
	 * @param adresse Adresse de livraison.
	 * @param telephone Numéro de téléphone pour la livraison.
	 * @param carte Détails de la carte de paiement.
	 * @param id Identifiant unique de la commande.
	 * @param infoLivraison Informations supplémentaires pour la livraison.
	 */
	public Commande (ArrayList<Produit> produits,Acheteur acheteur, String adresse,String telephone, Carte carte, String id,String infoLivraison){
		float prix=0;
		for(int i=0;i<produits.size();i++){
			prix+=produits.get(i).get_prix();
		}
		this.cout=prix;
		this.telephone=telephone;
		this.adresse=adresse;
		this.produits=produits;
		this.acheteur=acheteur.getPseudo();
		this.carte=carte;
		this.id=id;
		this.infoLivraison=infoLivraison;
		this.etat= EtatsCommande.EnProduction;
	}

	/**
	 * Constructeur pour créer une commande à partir de données fournies sous forme de chaîne de caractères et d'un catalogue de produits.
	 *
	 * @param donnee Tableau de chaînes contenant les données de la commande.
	 * @param catalogue Liste des produits disponibles pour référence.
	 */
	public Commande(String [] donnee,ArrayList<Produit> catalogue){
		this.produits=new ArrayList<Produit>();
		String[] prod=donnee[0].split(";");
		for (Produit produit : catalogue) {
			for (int i=0;i<prod.length;i++){
				if (produit.getIdentifiant().equals(prod[i])) {
					this.produits.add(produit);}
				}
			}
		this.acheteur=donnee[1];
		this.adresse=donnee[2];
		this.telephone=donnee[3];
		String [] donneecarte= donnee[4].split(";");
		this.carte=new Carte(donneecarte[0],donneecarte[1],donneecarte[2],donneecarte[3]);
		
		this.id=donnee[5];
		this.infoLivraison=donnee[5];
		if(donnee[6].equals("EnProduction")){this.etat= EtatsCommande.EnProduction;}
		else if(donnee[6].equals("EnLivraison")){this.etat= EtatsCommande.EnLivraison;}
		else if(donnee[6].equals("Livre")){this.etat= EtatsCommande.Livre;}
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
	public String getProduitsBuff(){
		String prod=produits.get(1).getIdentifiant();
		for (int i=1;i<produits.size();i++){
			prod=prod+";"+produits.get(i).getIdentifiant();
		}
		return prod;
	}
	public String getDateBuff(){
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(dateArrivee);
		int annee = calendar.get(Calendar.YEAR);
		int mois = calendar.get(Calendar.MONTH);
		int jour = calendar.get(Calendar.DAY_OF_MONTH);

		String date= annee+";"+mois+";"+jour;
		return date;
	}

	public String getCarteBuff(){
		return carte.getExpDate()+";"+carte.getNumero()+";"+carte.getPin()+";"+carte.getAcheteur();

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

	public String getAcheteur() {
		return this.acheteur;
	}
	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}
	
}