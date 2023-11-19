import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Panier {
	private Scanner sc = new Scanner(System.in);
	private float cout;
	private int nombreDePoints;
	private ArrayList<Produit> produits;
	public Panier() {
		this.cout=0f;
		this.nombreDePoints=0;
		this.produits=new ArrayList<Produit>();
	}

	public Commande commander(Acheteur acheteur, SystemeGeneral systemeGeneral) throws IllegalArgumentException {
		if (produits.size()==0){
			throw new IllegalArgumentException("il faut que le panier contienne au moins 1 produit pour commander");
		}
		else{
			String adresse= acheteur.getAdresse();
			String telephone= acheteur.getTelephone();
			System.out.println("Souhaitez vous commander avec cette adresse: "+ adresse);
			System.out.println("Et ce numéro de téléphone: "+ telephone);
			System.out.println("Entrez [1] si oui et [2] si non : ");
			int choix = sc.nextInt();
			if (choix==2){
				System.out.println("Entrez l'adresse pour la commande: ");
				adresse=sc.nextLine();
				System.out.println("Entrez le numéro de téléphone pour la commande: ");
				telephone=sc.nextLine();
			}
			if (choix==1 ||choix==2){
				sc.nextLine();
				System.out.println("Entrez le numéro de carte pour la commande: ");
				String numCarte=sc.nextLine();
				System.out.println("Entrez la date d'expiration de la carte: ");
				String dateExp=sc.nextLine();
				System.out.println("Entrez le numéro de confirmation de la carte: ");
				String numConf=sc.nextLine();
				System.out.println("Avez vous des informations supplémentaires pour la livraison? (Entrez non si ce n'est pas le cas): ");
				String infoSupp=sc.nextLine();
				Carte carte=new Carte(dateExp, numCarte, numConf, acheteur);
				System.out.println("Entrez [1] pour confirmer la commande ou [2] pour annuler et revenir au panier");
				choix=sc.nextInt();
				if (choix==2){
					throw new IllegalArgumentException("retour au panier");
				}
				else if (choix==1){
					Boolean verif=systemeGeneral.verifierCarte(carte);
					if (verif==false){}
					else{
						String identifiant=systemeGeneral.creerID();
						Commande commande= new Commande (cout, produits,acheteur,adresse,telephone, carte, identifiant,infoSupp);
						if(systemeGeneral.verifierCommande(commande)==false){
							throw new IllegalArgumentException("quantite insuffisante");
						}
						else{
							acheteur.addCommande(commande);
							return commande;}
						
					}
				}

			}
		}
		throw new IllegalArgumentException("test");
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