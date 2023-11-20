import java.util.ArrayList;

import java.util.Vector;

public class Acheteur extends Utilisateur {
	public Acheteur(String pseudo, String nom, String prenom, String email, String motDePasse, String adresse, String telephone) {
		super(nom, email, telephone, adresse, motDePasse);
		this.pseudo = pseudo;
		this.prenom = prenom;
		this.nombrePoints = 0;
		this.revendeursLike = new Revendeur[0];
		this.produitsLike = new Produit[0];
		this.acheteurLike = new ArrayList<Acheteur>();
		this.notification = new String[0];
		this.panier=new Panier();
	}
	
	private String prenom;
	private String pseudo;
	private int nombrePoints = 0;
	private Revendeur[] revendeursLike;
	private Produit[] produitsLike;
	private ArrayList<Acheteur> acheteurLike;
	private String[] notification;
	//private ArrayList<Produit>produitsAchetes= new ArrayList<>();
	public Vector<Revendeur> _est_suivi_par = new Vector<Revendeur>();
	public Panier panier;
	private ArrayList<Commande> commandes = new ArrayList<Commande>();
	//public Vector<Carte> _unnamed_Carte_ = new Vector<Carte>();
	//public MetriquesAcheteur _unnamed_MetriquesAcheteur_;
	//public Vector<Evaluation> _est__laisse_par_acheteur = new Vector<Evaluation>();


	public Panier getPanier() {
		return this.panier;
	}

	public void modifRevendeursLike(Revendeur aRevendeur) {
		throw new UnsupportedOperationException();
	}

	public void modifProduitsLike(Produit aProduitsLike) {
		throw new UnsupportedOperationException();
	}

	public void modifAcheteurLike(Acheteur aAcheteurLike) {
		throw new UnsupportedOperationException();
	}

	public Notification[] getNotification() {
		throw new UnsupportedOperationException();
	}

	public void modifierProfil(Menu menu) {
		super.modifierProfil(menu);
	
		System.out.println("Souhaitez vous conserver le prenom "+this.prenom);
		String nouveau=modif("prenom",menu);
		if(nouveau!=""){this.prenom=nouveau;}
    
		System.out.println("Souhaitez vous conserver le pseudo "+this.pseudo);
		nouveau=modif("pseudo",menu);
		if(nouveau!=""){this.pseudo=nouveau;}
    
        System.out.println("Profil mis à jour avec succès !");
	}
	public void addCommande(Commande newCommande){
		commandes.add(newCommande);
	}

	//getters
	public String getPseudo() {
		return pseudo;
	}
	public int getNombrePoints() {
		return this.nombrePoints;
	}
	public String getPrenom() {
		return this.prenom;
	}
	public Produit[] getProduitsLike() {
		return this.produitsLike;
	}
	public ArrayList<Acheteur> getAcheteurLike() {
		return this.acheteurLike;
	}
	public void setAcheteurLike(Acheteur acheteur) {
		if(!acheteurLike.isEmpty() && acheteurLike.contains(acheteur)){
			acheteurLike.remove(acheteur);
		}
		else{
			acheteurLike.add(acheteur);
		}
	}

	public ArrayList<Commande> getCommande(){
		return this.commandes;
	}

	//setters
	public void setNombrePoints(int aNombrePoints) {
		this.nombrePoints = aNombrePoints;
	}
	public void setNotification(String[] aNotification) {
		this.notification = aNotification;
	}
	//public void addProduitsAchetes(Produit produit) {produitsAchetes.add(produit);}
}