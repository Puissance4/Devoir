import java.util.Vector;

import javax.sound.midi.MidiDevice.Info;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Revendeur extends Utilisateur {
	public Revendeur(String nom, String email, String motDePasse, String adresse, String telephone) {
		super(nom, email, telephone, adresse, motDePasse);

		//TODO Auto-generated constructor stub
	}
	
	private Scanner sc = new Scanner(System.in);
	private ArrayList<Produit> _produits = new ArrayList<Produit>();
	private int _likes = 0;
	public Vector<Acheteur> _suit = new Vector<Acheteur>();
	public MetriquesRevendeurs _unnamed_MetriquesRevendeurs_;

	public void ajouterProduit() {
		System.out.println("\n");
		System.out.println("-----------------------------------------------");
		System.out.println("\nTitre du produit : ");
		String titre = sc.nextLine();
		System.out.println("\nCategorie du produit : ");
		System.out.println("1. Livres et manuels");
		System.out.println("2. Ressources d'apprentissage");
		System.out.println("3. Articles de papeterie");
		System.out.println("4. Matériel informatique");
		System.out.println("5. Équipement de bureau");
		System.out.print("\nVeuillez choisir une option : ");
		Categorie categorie = new Categorie();
		int choix = sc.nextInt();
		sc.nextLine();
		if (choix == 1) {
			System.out.println("\nISBN du produit : ");
			String isbn = sc.nextLine();
			System.out.println("\nAuteur :");
			String auteur = sc.nextLine();
			System.out.println("\nMaison d'edition : ");
			String maisonEdition = sc.nextLine();
			System.out.println("\nGenre :");
			String genre = sc.nextLine();
			System.out.println("\nAnnee de parution (AAAA): ");
			int anneeParution = sc.nextInt();
			System.out.println("\nMois de parution (numerique): ");
			int moisParution = sc.nextInt();
			System.out.println("\nJour de parution (numerique): ");
			int jourParution = sc.nextInt();
			System.out.println("\nNumero d'edition (laisser vide pour passer): ");
			String numeroEdition = sc.nextLine();
			if (numeroEdition.equals("")) {
				numeroEdition = null;
			}
			System.out.println("\nNumero de volume (laisser vide pour passer): ");
			String numeroVolume = sc.nextLine();
			if (numeroVolume.equals("")) {
				numeroVolume = null;
			}
			LocalDate dateParution = LocalDate.of(anneeParution, moisParution, jourParution);
			categorie = new Livres(isbn, auteur, maisonEdition, genre, dateParution, numeroEdition, numeroVolume);

		} else if (choix == 2) {
			TypeRessource type;
			System.out.println("\nISBN du produit : ");
			String isbn = sc.nextLine();
			System.out.println("\nAuteur :");
			String auteur = sc.nextLine();
			System.out.println("\nMaison d'edition : ");
			System.out.println("\nOrganisation : ");
			String organisation = sc.nextLine();
			System.out.println("\nAnnee de parution (AAAA): ");
			int anneeParution = sc.nextInt();
			System.out.println("\nMois de parution (numerique): ");
			int moisParution = sc.nextInt();
			System.out.println("\nJour de parution (numerique): ");
			int jourParution = sc.nextInt();
			System.out.println("\n1. Imprimé\n2. Electronique");
			int choix2 = sc.nextInt();
			sc.nextLine();
			if (choix2 == 1) {
				type = TypeRessource.Imprime;
			} else if (choix2 == 2) {
				type = TypeRessource.Electronique;
			} else {
				IllegalArgumentException exception = new IllegalArgumentException("Argument invalide");
				throw exception;
			}
			System.out.println("\nNumero d'edition (laisser vide pour passer): ");
			String numeroEdition = sc.nextLine();
			if (numeroEdition.equals("")) {
				numeroEdition = null;
			}
			categorie = new Ressource(isbn, auteur, organisation, type, numeroEdition);
		} else if (choix == 3) {
			PapeterieCategorie sousCategorie;
			System.out.println("\nMarque du produit : ");
			String marque = sc.nextLine();
			System.out.println("\nModèle du produit : ");
			String modele = sc.nextLine();
			System.out.println("\nSous-catégorie du produit : ");
			System.out.println("1. Stylo");
			System.out.println("2. Cahier");
			System.out.println("3. Classeur");
			System.out.println("4. Feuille de papier");
			System.out.println("5. Calculatrice");
			System.out.println("6. Surligneur");
			System.out.println("7. Autre");
			System.out.print("\nVeuillez choisir une option : ");
			int choix2 = sc.nextInt();
			sc.nextLine();
			if (choix2 == 1) {
				sousCategorie = PapeterieCategorie.Stylo;
			} else if (choix2 == 2) {
				sousCategorie = PapeterieCategorie.Cahier;
			} else if (choix2 == 3) {
				sousCategorie = PapeterieCategorie.Classeur;
			} else if (choix2 == 4) {
				sousCategorie = PapeterieCategorie.FeuillePapier;
			} else if (choix2 == 5) {
				sousCategorie = PapeterieCategorie.Calculatrice;
			} else if (choix2 == 6) {
				sousCategorie = PapeterieCategorie.Surligneur;
			} else if (choix2 == 7) {
				sousCategorie = PapeterieCategorie.Autre;
			} else {
				IllegalArgumentException exception = new IllegalArgumentException("Argument invalide");
				throw exception;
			}
			categorie = new Papeterie(marque, modele, sousCategorie);
		} else if (choix == 4) {
			InfoCategorie sousCategorie;
			System.out.println("\nMarque du produit : ");
			String marque = sc.nextLine();
			System.out.println("\nModèle du produit : ");
			String modele = sc.nextLine();
			System.out.println("\nAnnee de lancement (AAAA): ");
			int anneeLancement = sc.nextInt();
			System.out.println("\nMois de lancement (numerique): ");
			int moisLancement = sc.nextInt();
			System.out.println("\nJour de lancement (numerique): ");
			int jourLancement = sc.nextInt();
			LocalDate dateLancement = LocalDate.of(anneeLancement, moisLancement, jourLancement);
			System.out.println("\nSous-catégorie du produit : ");
			System.out.println("1. Ordinateur portable");
			System.out.println("2. Souris");
			System.out.println("3. Clavier");
			System.out.println("4. Disque dur externe");
			System.out.println("5. Ecouteurs");
			System.out.println("6. Autres");
			System.out.print("\nVeuillez choisir une option : ");
			int choix2 = sc.nextInt();
			sc.nextLine();
			if (choix2 == 1) {
				sousCategorie = InfoCategorie.OrdinateurPortable;
			} else if (choix2 == 2) {
				sousCategorie = InfoCategorie.Souris;
			} else if (choix2 == 3) {
				sousCategorie = InfoCategorie.Clavier;
			} else if (choix2 == 4) {
				sousCategorie = InfoCategorie.DisqueDurExterne;
			} else if (choix2 == 5) {
				sousCategorie = InfoCategorie.Ecouteurs;
			} else if (choix2 == 6) {
				sousCategorie = InfoCategorie.Autre;
			} else {
				IllegalArgumentException exception = new IllegalArgumentException("Argument invalide");
				throw exception;
			}
			categorie = new MaterielInformatique(marque, modele, dateLancement, sousCategorie);
		} else if (choix == 5) {
			BureauCategorie sousCategorie;
			System.out.println("\nMarque du produit : ");
			String marque = sc.nextLine();
			System.out.println("\nModèle du produit : ");
			String modele = sc.nextLine();
			System.out.println("\nSous-catégorie du produit : ");
			System.out.println("1. Chaise de bureau");
			System.out.println("2. Lampe de bureau");
			System.out.println("3. Support pour ordinateur portable");
			System.out.println("4. Autre");
			System.out.print("\nVeuillez choisir une option : ");
			int choix2 = sc.nextInt();
			sc.nextLine();
			if (choix2 == 1) {
				sousCategorie = BureauCategorie.ChaiseDeBureau;
			} else if (choix2 == 2) {
				sousCategorie = BureauCategorie.LampeDeBureau;
			} else if (choix2 == 3) {
				sousCategorie = BureauCategorie.SupportOrdinateurPortable;
			} else if (choix2 == 4) {
				sousCategorie = BureauCategorie.Autre;
			} else {
				IllegalArgumentException exception = new IllegalArgumentException("Argument invalide");
				throw exception;
			}
			categorie = new EquipementBureau(marque, modele, sousCategorie);
		} else {
			IllegalArgumentException exception = new IllegalArgumentException("Argument invalide");
			throw exception;

		}
		System.out.println("\nDescription du produit : ");
		String description = sc.nextLine();
		System.out.println("\nQuantite du produit : ");
		int quantite = sc.nextInt();
		sc.nextLine();
		System.out.println("\nPrix du produit : ");
		float prix = sc.nextFloat();
		sc.nextLine();
		System.out.println("\nPoint bonus du produit : ");
		int pointBonus = sc.nextInt();
		sc.nextLine();
		System.out.println("\nLien image ou video du produit : ");
		String lienImageOuVideo = sc.nextLine();
		SystemeGeneral systemeGeneral = new SystemeGeneral();
		String identifiant = systemeGeneral.creerID();
		Produit produit = new Produit(titre, categorie, description, quantite, prix, pointBonus, identifiant, lienImageOuVideo);
		_produits.add(produit);
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