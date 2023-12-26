import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SystemeCatalogue extends Systeme {
	public ArrayList<Produit> catalogue=new ArrayList<Produit>();
	public ArrayList<Commande> listeCommandes=new ArrayList<Commande>();

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

	public ArrayList<Produit> getCatalogue() {
		return this.catalogue;
	}

	public Produit[] recherche(String aMotcle, Filtre[] aFiltres) {
		throw new UnsupportedOperationException();
	}

	public boolean verifierTitre(String aTitre) {
		throw new UnsupportedOperationException();
	}
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

	public void deconnexion(){
		try {
			BufferedWriter writterCommandes=new BufferedWriter(new FileWriter("../Commandes.csv"));
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
			BufferedWriter writterProduits=new BufferedWriter(new FileWriter("../Produits.csv"));
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
}