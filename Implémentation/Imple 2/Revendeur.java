import java.util.Vector;
import java.util.ArrayList;
import java.util.Scanner;

public class Revendeur extends Utilisateur {
	public Revendeur(String nom, String email, String motDePasse, String adresse, String telephone) {
		super(nom, email, motDePasse, adresse, telephone);
		//TODO Auto-generated constructor stub
	}
	
	private Scanner sc = new Scanner(System.in);
	private ArrayList<Produit> _produits = new ArrayList<Produit>();
	private int _likes = 0;
	public Vector<Acheteur> _suit = new Vector<Acheteur>();
	public MetriquesRevendeurs _unnamed_MetriquesRevendeurs_;

	public void ajouterProduit() {
		System.out.println("Titre du produit : ");
		String titre = prompt();
		System.out.println("Categorie du produit : ");
		System.out.println("1. Livres et manuels");
		System.out.println("2. Ressources d'apprentissage");
		System.out.println("3. Articles de papeterie");
		System.out.println("4. Matériel informatique");
		System.out.println("5. Équipement de bureau");
		Categorie categorie = new Categorie();
		int choix = sc.nextInt();
		sc.nextLine();
		if (choix == 1) {
			categorie = new Livres();
		} else if (choix == 2) {
			categorie = new Ressource();
		} else if (choix == 3) {
			categorie = new Papeterie();
		} else if (choix == 4) {
			categorie = new MaterielInformatique();
		} else if (choix == 5) {
			categorie = new EquipementBureau();
		} else {
			System.out.println("Choix invalide");
		}
		System.out.println("Description du produit : ");
		String description = prompt();
		System.out.println("Quantite du produit : ");
		int quantite = sc.nextInt();
		sc.nextLine();
		System.out.println("Prix du produit : ");
		float prix = sc.nextFloat();
		sc.nextLine();
		System.out.println("Point bonus du produit : ");
		int pointBonus = sc.nextInt();
		sc.nextLine();
		System.out.println("Lien image ou video du produit : ");
		String lienImageOuVideo = prompt();
		SystemeGeneral systemeGeneral = new SystemeGeneral();
		String identifiant = systemeGeneral.creerID();
		Produit produit = new Produit(titre, categorie, description, quantite, prix, pointBonus, identifiant, lienImageOuVideo);
		_produits.add(produit);
	}

	private String prompt() {
		return null;
	}

	public int getLikes() {
		return this._likes;
	}

	public void setLikes(int aLikes) {
		this._likes = aLikes;
	}

	public void modifierProfil() {
		throw new UnsupportedOperationException();
	}

	public void changerEtat(Commande aCommande, String aCompagnieExp, int aNumSuivi) {
		throw new UnsupportedOperationException();
	}

	public void ajouterPromotion(Produit aProduit) {
		throw new UnsupportedOperationException();
	}

}