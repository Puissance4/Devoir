import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import java.util.Vector;

public class Acheteur extends Utilisateur {

	public Acheteur(String[] donnee,ArrayList<Produit> catalogue,ArrayList<Commande> listeCommandes) {
		super(donnee[1], donnee[3], donnee[6], donnee[5], donnee[4]);
		this.pseudo = donnee[0];
		this.prenom = donnee[2];
		String [] liste=donnee[7].split(";");
		if(!(liste[0].equals("null"))){
		for (int i=0;i<liste.length;i++){
			this.revendeursLike.add(liste[i]);
		}}
		String [] liste2=donnee[8].split(";");
		if(!(liste2[0].equals("null"))){
		for (int i=0;i<liste2.length;i++){
			this.metriques._classementAcheteurSuivis.add(liste2[i]) ;

		}}
		Boolean panierInit=false;
		try {
			BufferedReader readerPanier=new BufferedReader(new FileReader("../Paniers.csv"));
			String line=readerPanier.readLine();//ignore la ligne des noms de colonnes
			while ((line=readerPanier.readLine())!=null) {
				String[] panier=line.split(",");
				if (panier[0].equals(donnee[0])){
					this.panier=new Panier(panier,catalogue);
					panierInit=true;
				}
				
			}
			readerPanier.close();
		} catch (Exception e) {
	
			e.printStackTrace();
		}

		if (panierInit==false){this.panier=new Panier(donnee[0]);}

		String[] prod=donnee[9].split(";");
		if(!(prod[0].equals("null"))){
		for (Produit produit : catalogue) {
			for (int i=0;i<prod.length;i++){
				if (produit.getIdentifiant().equals(prod[i])) {
					this.produitsLike.add(produit);}
				}
			}}
		this.nombrePoints=Integer.parseInt(donnee[11]);

		for (Commande commande : listeCommandes){
			if (commande.getAcheteur().equals(donnee[0])){
				this.commandes.add(commande);
			}
		}

	}



	public Acheteur(String pseudo, String nom, String prenom, String email, String motDePasse, String adresse, String telephone) {
		super(nom, email, telephone, adresse, motDePasse);
		this.pseudo = pseudo;
		this.prenom = prenom;
		this.nombrePoints = 0;
		this.panier=new Panier(pseudo);
	}
	
	private String prenom;
	private String pseudo;
	private int nombrePoints = 0;
	public ArrayList <String> revendeursLike=new ArrayList<String>();
	public ArrayList <Produit> produitsLike=new ArrayList<Produit>();
	public ArrayList <Notification> notifications=new ArrayList<>();
	public ArrayList<Produit> produitsAchetes= new ArrayList<>();
	public ArrayList<Acheteur> acheteursSuivis = new ArrayList<>();
	private Panier panier;
	private ArrayList<Commande> commandes = new ArrayList<Commande>();
	private MetriquesAcheteur metriques = new MetriquesAcheteur(this);
	//public Vector<Carte> _unnamed_Carte_ = new Vector<Carte>();
	//public Vector<Evaluation> _est__laisse_par_acheteur = new Vector<Evaluation>();


	public Panier getPanier() {
		return this.panier;
	}

	public String getRevendeurslikeBuff(){
		if (revendeursLike.size()==0){return "null";}
		else{
			String liste=revendeursLike.get(0);
			for(int i=1;i<revendeursLike.size();i++){
				liste=liste+";"+revendeursLike.get(i);
			}
			return liste;
		}
	}
		
	public String getAcheteurlikeBuff(){
		if (acheteursSuivis.isEmpty()){return "null";}
		else{
			String liste=acheteursSuivis.get(0).getPseudo();
			for(int i=1;i<acheteursSuivis.size();i++){
				liste=liste+";"+acheteursSuivis.get(i).getPseudo();
			}
			return liste;
		}
	}

	public String getNotificationBuff(){
		if (notifications.isEmpty()){return "null";}
		else{
			StringBuilder liste= new StringBuilder(notifications.get(0).getDesc());
			for(int i=1;i<notifications.size();i++){
				liste.append(";").append(notifications.get(i).getDesc());
			}
			return liste.toString();
		}
	}
	public String getProduitsLikeBuff(){
		if (produitsLike.size()==0){return "null";}
		else{
			String liste=produitsLike.get(0).getIdentifiant();
			for(int i=1;i<produitsLike.size();i++){
				liste=liste+";"+produitsLike.get(i).getIdentifiant();
			}
			return liste;
		}
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

	public void afficherProfil(){
		System.out.println("--------------------------");
		System.out.println("Pseudo " + pseudo );
		System.out.println("Prenom " + prenom);
		System.out.println("Nom " + super.getNom());
		System.out.println("Nombre de points " + nombrePoints);
		System.out.println("------Articles Like---------- " );
		for (int i=0;i<produitsLike.size();i++){
			System.out.println(produitsLike.get(i).get_titre());
		}
		System.out.println("------Acheteurs Like---------- " );
		for (int i=0;i<acheteursSuivis.size();i++){
			System.out.println(acheteursSuivis.get(i).getPseudo());
		}
		System.out.println("------Revendeurs Like---------- " );
		for (int i=0;i<revendeursLike.size();i++){
			System.out.println(revendeursLike.get(i));
		}
		System.out.println("--------------------------");

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
	public MetriquesAcheteur getMetriques(){
		return this.metriques;
	}

	// Setters
	public void setAcheteursSuivis(Acheteur acheteur) {
			if(!acheteursSuivis.isEmpty() && acheteursSuivis.contains(acheteur)){
			acheteursSuivis.remove(acheteur);
			acheteur.retirerDesPoints(5);
			this.retirerDesPoints(5);
			
		}
		else{
			acheteursSuivis.add(acheteur);
			acheteur.ajouterDesPoints(5);
			this.ajouterDesPoints(5);
			// Send a notification to the followed user
			Notification notification = new Notification(CategorieNotif.NOUVEL_ACHETEUR_SUIVI);
			acheteur.notifications.add(notification);
			// Update buyer's list of followed users
			this.metriques._classementAcheteurSuivis.add(acheteur.getPseudo());
		}
	}
	public void setProduitLike(Produit produit) {
		if(!produitsLike.isEmpty() && produitsLike.contains(produit)){
			produitsLike.remove(produit);
		}
		else{
			produitsLike.add(produit);
		}
	}

	public void setRevendeurLike(Revendeur revendeur) {
		if(!revendeursLike.isEmpty() && revendeursLike.contains(revendeur.getNom())){
			revendeursLike.remove(revendeur.getNom());
			revendeur.retirerDesLikes(1);
		}
		else{
			revendeursLike.add(revendeur.getNom());
			revendeur.ajouterDesLikes(1);
		}
	}

	public ArrayList<Commande> getCommande(){
		return this.commandes;
	}

	//setters
	public void setNombrePoints(int aNombrePoints) {
		this.nombrePoints = aNombrePoints;
	}
	public void retirerDesPoints(int points){
		nombrePoints=nombrePoints-points;
		if (nombrePoints<0){nombrePoints=0;}
	}
	public void ajouterDesPoints(int points){
		nombrePoints=nombrePoints+points;
	}

}