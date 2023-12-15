import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import java.util.Vector;

public class Acheteur extends Utilisateur {
<<<<<<< Updated upstream:Implémentation/Imple 2/Acheteur.java
=======

	public Acheteur(String[] donnee,ArrayList<Produit> catalogue) {
		super(donnee[1], donnee[3], donnee[6], donnee[5], donnee[4]);
		this.pseudo = donnee[0];
		this.prenom = donnee[2];
		this.nombrePoints = 0;
		String [] liste=donnee[7].split(";");
		for (int i=0;i<liste.length;i++){
			this.revendeursLike.add(liste[i]) ;
		}
		String [] liste2=donnee[8].split(";");
		for (int i=0;i<liste2.length;i++){
			this.acheteurLike.add(liste2[i]) ;
		}
		String [] liste3=donnee[9].split(";");
		for (int i=0;i<liste3.length;i++){
			this.notifications.add(liste3[i]) ;
		}
		Boolean panierInit=false;
		try {
			BufferedReader readerPanier=new BufferedReader(new FileReader("../Paniers.csv"));
			String line=readerPanier.readLine();//ignore la ligne des noms de colonnes
			while ((line=readerPanier.readLine())!=null) {
				String[] panier=line.split(",");
				if (panier[0]==donnee[0]){
					this.panier=new Panier(panier,catalogue);
					panierInit=true;
				}
				
			}
			readerPanier.close();
		} catch (Exception e) {
	
			e.printStackTrace();
		}

		if (panierInit==false){this.panier=new Panier();}

		String[] prod=donnee[10].split(";");
		for (Produit produit : catalogue) {
			for (int i=0;i<prod.length;i++){
				if (produit.getIdentifiant().equals(prod[i])) {
					this.produitsLike.add(produit);}
				}
			}
		this.nombrePoints=Integer.parseInt(donnee[11]);

		try {
			BufferedReader readerCommandes=new BufferedReader(new FileReader("../Commandes.csv"));
			String line=readerCommandes.readLine();//ignore la ligne des noms de colonnes
			while ((line=readerCommandes.readLine())!=null) {
				String[] commande=line.split(",");
				if (commande[1]==donnee[0]){
					this.commandes.add(new Commande(commande,catalogue,this));
				}
				
			}
			readerCommandes.close();
		} catch (Exception e) {
	
			e.printStackTrace();
		}

	}
	
>>>>>>> Stashed changes:Implementation/UniShopV2/src/Acheteur.java
	public Acheteur(String pseudo, String nom, String prenom, String email, String motDePasse, String adresse, String telephone) {
		super(nom, email, telephone, adresse, motDePasse);
		this.pseudo = pseudo;
		this.prenom = prenom;
		this.nombrePoints = 0;
		this.panier=new Panier();
	}
	
	private String prenom;
	private String pseudo;
	private int nombrePoints = 0;
<<<<<<< Updated upstream:Implémentation/Imple 2/Acheteur.java
	private Revendeur[] revendeursLike;
	private Produit[] produitsLike;
	private ArrayList<Acheteur> acheteurLike;
	private String[] notification;
	//private ArrayList<Produit>produitsAchetes= new ArrayList<>();
=======
	private ArrayList <String> revendeursLike=new ArrayList<String>();
	private ArrayList <Produit> produitsLike=new ArrayList<Produit>();
	private ArrayList<String> acheteurLike=new ArrayList<String>();
	private ArrayList <String> notifications=new ArrayList<String>();
	private ArrayList<Produit>produitsAchetes= new ArrayList<>();
>>>>>>> Stashed changes:Implementation/UniShopV2/src/Acheteur.java
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
	public ArrayList<Produit> getProduitsLike() {
		return this.produitsLike;
	}
	public ArrayList<String> getAcheteurLike() {
		return this.acheteurLike;
	}
	public void setAcheteurLike(Acheteur acheteur) {
		if(!acheteurLike.isEmpty() && acheteurLike.contains(acheteur.pseudo)){
			acheteurLike.remove(acheteur.pseudo);
		}
		else{
			acheteurLike.add(acheteur.pseudo);
		}
	}

	public ArrayList<Commande> getCommande(){
		return this.commandes;
	}

	//setters
	public void setNombrePoints(int aNombrePoints) {
		this.nombrePoints = aNombrePoints;
	}
	public void setNotification(ArrayList<String> aNotification) {
		this.notifications = aNotification;
	}
	//public void addProduitsAchetes(Produit produit) {produitsAchetes.add(produit);}
}