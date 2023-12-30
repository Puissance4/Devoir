import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * La classe SystemeCatalogue gère le catalogue des produits et les commandes dans le système.
 * Elle permet de charger les données à partir de fichiers CSV, de rechercher des produits,
 * d'afficher les détails des produits, et de sauvegarder l'état actuel du système lors de la déconnexion.
 */
public class SystemeCatalogue extends Systeme {
	public ArrayList<Produit> catalogue=new ArrayList<Produit>();
	public ArrayList<Commande> listeCommandes=new ArrayList<Commande>();

	/**
	 * Constructeur de SystemeCatalogue qui initialise le catalogue et la liste des commandes en les chargeant à partir des fichiers CSV.
	 */
	public SystemeCatalogue (){
		try {
			BufferedReader readerProduits=new BufferedReader(new FileReader("Implementation/UniShopV2/Produits.csv"));
			String line=readerProduits.readLine();//ignore la ligne des noms de colonnes
			while ((line=readerProduits.readLine())!=null) {
				String[] donnee=line.split(",");
				catalogue.add(new Produit(donnee));
			}
			readerProduits.close();
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		try {
			BufferedReader readerCommandes=new BufferedReader(new FileReader("Implementation/UniShopV2/Commandes.csv"));
			String line=readerCommandes.readLine();//ignore la ligne des noms de colonnes
			while ((line=readerCommandes.readLine())!=null) {
				String[] donnee=line.split(",");
				listeCommandes.add(new Commande(donnee,catalogue));
			}
			readerCommandes.close();
		} catch (Exception e) {
	
			e.printStackTrace();
		}

	}

	/**
	 * Retourne la liste actuelle des produits dans le catalogue.
	 * @return ArrayList de produits dans le catalogue.
	 */
	public ArrayList<Produit> getCatalogue() {
		return this.catalogue;
	}

	/**
	 * Recherche des produits dans le catalogue basée sur un mot clé fourni.
	 * @param aMotcle Le mot clé utilisé pour la recherche.
	 * @return Un tableau de produits correspondant au mot clé.
	 */
	public Produit[] recherche(String aMotcle) {
		ArrayList<Produit> resultat=new ArrayList<Produit>();
		for (Produit produit : catalogue) {
			if (produit.get_titre().contains(aMotcle)) {
				resultat.add(produit);
			}
			else if (produit.getDesc().contains(aMotcle)) {
				resultat.add(produit);
			}
			else if (produit.getCategorieString().contains(aMotcle)) {
				resultat.add(produit);
			}
			else if (Float.toString(produit.get_prix()).contains(aMotcle)){
				resultat.add(produit);
			}
		}

		Produit[] resultat2=new Produit[resultat.size()];
		for (int i=0;i<resultat.size();i++){
			resultat2[i]=resultat.get(i);
		}
		if (resultat2.length==0){
			System.out.println("\nAucun produit ne correspond a votre recherche");
		}
		else {
			System.out.println("\nVoici les produits correspondant a votre recherche:");
			for (Produit produit : resultat2) {
				afficherProduit(produit);
			}
		}
		return resultat2;
	}

	public boolean verifierTitre(String aTitre) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Affiche les détails d'un produit spécifique.
	 * @param produit Le produit à afficher.
	 */
	public void afficherProduit(Produit produit){
		System.out.println("--------------------------");
		System.out.println("Titre: " + produit.get_titre());
		System.out.println("Categorie: " + produit.getCategorieString());
		System.out.println("Description: " + produit.getDesc());
		System.out.println("Quantité: " + produit.getQuantite());
		System.out.println("Prix: " + produit.get_prix());
		System.out.println("Points Bonus: " + produit.getPointsBonus());
		System.out.println("Lien image: " + produit.getLien());
		System.out.println("--------------------------");
	}

	/**
	 * Sauvegarde l'état actuel du catalogue et de la liste des commandes dans des fichiers CSV.
	 * Cette méthode est appelée avant la déconnexion du système pour s'assurer que toutes les données sont à jour.
	 */
	public void deconnexion(){
		try {
			BufferedWriter writterCommandes=new BufferedWriter(new FileWriter("Implementation/Commandes.csv"));
			writterCommandes.write("produit,acheteur,adresse,tel,carte,id,infoLivraison,dateArrivee(annee,mois,jour),numSuivi,compagnieExp,billetSignalement");
			for (Commande commande: listeCommandes){
				writterCommandes.newLine();
				String produits=commande.getProduitsBuff();
				String acheteur=commande.getAcheteur();
				String adresse=commande.getAdresse();
				String tel=commande.getTelephone();
				String carte=commande.getCarteBuff();
				String id= commande.getID();
				String infoLivraison=commande.getInfoLivraison();
				String dateArrivee=commande.getDateBuff();
				String numSuivi=commande.getNumSuivi();
				String compagnieExp=commande.getCompagnieExp();
				String billetSignalement="null";
				writterCommandes.write(produits+","+acheteur+","+adresse+","+tel+","+carte+","+id+","+infoLivraison+","+dateArrivee+","+numSuivi+","+compagnieExp+","+billetSignalement);
			}
			writterCommandes.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			BufferedWriter writterProduits=new BufferedWriter(new FileWriter("Implementation/Produits.csv"));
			writterProduits.write("titre,categorie,description,quantite,prix,pointBonus,identifiant,lienImageOuVideo,nombreDeLike,PrixPromotionnel,PointsBonusPromotion,dateFinPromotion");
			for (Produit produit: catalogue){
				try {
				writterProduits.newLine();
				String titre=produit.get_titre();
				String categorie=produit.getCategorieBuff();
				String description=produit.getDesc();
				int quantite= produit.getQuantite();
				Float prix= produit.get_prix();
				int pointBonus=produit.getPointsBonusNormal();
				String identifiant=produit.getIdentifiant();
				String lienImageOuVideo=produit.get_lienImageOuVideo();
				int nombreDeLike=produit.getNombreLike();
				String PrixPromotionnel=produit.getPrixPromobuff();
				String PointsBonusPromotion=produit.getPointsBonusPromoBuff();
				String dateFinPromotion= produit.getDateFinPromotionBuff();
				
				writterProduits.write(titre+","+categorie+","+description+","+quantite+","+prix+","+pointBonus+","+identifiant+","+lienImageOuVideo+","+nombreDeLike+","+PrixPromotionnel+","+PointsBonusPromotion+","+dateFinPromotion);
			
				} catch (Exception e) {
					System.out.println("Le produit "+produit.get_titre()+" n'a pas ete ajoute car il n'avait pas de categorie");
				}
			}
			writterProduits.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void setCatalogue(ArrayList<Produit> catalogue) {
		this.catalogue = catalogue;
	}

	public void setListeCommandes(ArrayList<Commande> listeCommandes) {
		this.listeCommandes = listeCommandes;
	}
}