import java.util.Vector;

import javax.sound.midi.MidiDevice.Info;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Revendeur extends Utilisateur {
	public Revendeur(String nom, String email, String motDePasse, String adresse, String telephone) {
		super(nom, email, telephone, adresse, motDePasse);

	}
	
	//private Scanner sc = new Scanner(System.in);
	private ArrayList<Produit> _produits = new ArrayList<Produit>();
	private int _likes = 0;
	public Vector<Acheteur> _suit = new Vector<Acheteur>();
	public MetriquesRevendeurs _unnamed_MetriquesRevendeurs_;

	public void ajouterProduit(Menu menu) {
		System.out.println("\n");
		System.out.println("-----------------------------------------------");
		System.out.println("\nTitre du produit : ");
		String titre = menu.promptS();
		Categorie categorie = new Categorie();
		Boolean cat=false;
		while(cat==false){
		System.out.println("\nCategorie du produit : ");
		System.out.println("1. Livres et manuels");
		System.out.println("2. Ressources d'apprentissage");
		System.out.println("3. Articles de papeterie");
		System.out.println("4. Matériel informatique");
		System.out.println("5. Équipement de bureau");
		System.out.print("\nVeuillez choisir une option : ");
		
	
		int choix = menu.prompt();
		if (choix == 1) {
			Genre genre=null;
			System.out.println("\nISBN du produit : ");
			String isbn = menu.promptS();
			System.out.println("\nAuteur :");
			String auteur = menu.promptS();
			System.out.println("\nMaison d'edition : ");
			String maisonEdition = menu.promptS();
			while (genre==null) {
			System.out.println("\nGenre :");
			System.out.println("1. Manuel");
			System.out.println("2. Roman");
			System.out.println("3. Bande dessinee");
			System.out.println("4. Documentaire");
			System.out.println("5. Autre");
			int choix2 = menu.prompt();
			if (choix2 == 1) {
				genre = Genre.Manuel;
			} else if (choix2 == 2) {
				genre = Genre.Roman;
			} else if (choix2 == 3) {
				genre = Genre.BandeDessinee;
			} else if (choix2 == 4) {
				genre = Genre.Documentaire;
			} else if (choix2 == 5) {
				genre = Genre.Autre;
			} else {
				System.out.println("Choix invalide veuillez choisir une option entre 1 et 5");
			}}
			System.out.println("\nAnnee de parution (AAAA): ");
			int anneeParution = menu.prompt();
			System.out.println("\nMois de parution (numerique): ");
			int moisParution = menu.prompt();;
			System.out.println("\nJour de parution (numerique): ");
			int jourParution = menu.prompt();
			System.out.println("\nNumero d'edition (laisser vide pour passer): ");
			String numeroEdition = menu.promptS();
			if (numeroEdition.equals("")) {
				numeroEdition = null;
			}
			System.out.println("\nNumero de volume (laisser vide pour passer): ");
			String numeroVolume = menu.promptS();
			if (numeroVolume.equals("")) {
				numeroVolume = null;
			}
			LocalDate dateParution = LocalDate.of(anneeParution, moisParution, jourParution);
			categorie = new Livres(isbn, auteur, maisonEdition, genre, dateParution, numeroEdition, numeroVolume);
			cat=true;
		} else if (choix == 2) {
			TypeRessource type=null;
			System.out.println("\nISBN du produit : ");
			String isbn =menu.promptS();
			System.out.println("\nAuteur :");
			String auteur =menu.promptS();
			System.out.println("\nMaison d'edition : ");
			System.out.println("\nOrganisation : ");
			String organisation =menu.promptS();
			System.out.println("\nAnnee de parution (AAAA): ");
			int anneeParution = menu.prompt();
			System.out.println("\nMois de parution (numerique): ");
			int moisParution = menu.prompt();
			System.out.println("\nJour de parution (numerique): ");
			int jourParution = menu.prompt();
			while(type==null){
			System.out.println("\n1. Imprimé\n2. Electronique");
			int choix2 = menu.prompt();
			if (choix2 == 1) {
				type = TypeRessource.Imprime;
			} else if (choix2 == 2) {
				type = TypeRessource.Electronique;
			} else {
				System.out.println("Choix invalide veuillez choisir 1 ou 2");
			}}
			System.out.println("\nNumero d'edition (entrez [non] si non applicable): ");
			String numeroEdition =menu.promptS();
			if (numeroEdition.equals("non")) {
				numeroEdition = null;
			}
			LocalDate dateParution = LocalDate.of(anneeParution, moisParution, jourParution);
			categorie = new Ressource(isbn, auteur, organisation,dateParution, type, numeroEdition);
			cat=true;
		} else if (choix == 3) {
			PapeterieCategorie sousCategorie=null;
			System.out.println("\nMarque du produit : ");
			String marque =menu.promptS();
			System.out.println("\nModèle du produit : ");
			String modele =menu.promptS();
			while(sousCategorie==null){
			System.out.println("\nSous-catégorie du produit : ");
			System.out.println("1. Stylo");
			System.out.println("2. Cahier");
			System.out.println("3. Classeur");
			System.out.println("4. Feuille de papier");
			System.out.println("5. Calculatrice");
			System.out.println("6. Surligneur");
			System.out.println("7. Autre");
			System.out.print("\nVeuillez choisir une option : ");
	
			int choix2 = menu.prompt();
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
				System.out.println("Choix invalide veuillez choisir une option entre 1 et 7");
			}}
			categorie = new Papeterie(marque, modele, sousCategorie);
			cat=true;
		} else if (choix == 4) {
			InfoCategorie sousCategorie=null;
			System.out.println("\nMarque du produit : ");
			String marque =menu.promptS();
			System.out.println("\nModèle du produit : ");
			String modele =menu.promptS();
			System.out.println("\nAnnee de lancement (AAAA): ");
			int anneeLancement = menu.prompt();
			System.out.println("\nMois de lancement (numerique): ");
			int moisLancement = menu.prompt();
			System.out.println("\nJour de lancement (numerique): ");
			int jourLancement = menu.prompt();
			LocalDate dateLancement = LocalDate.of(anneeLancement, moisLancement, jourLancement);
			while(sousCategorie==null){
			System.out.println("\nSous-catégorie du produit : ");
			System.out.println("1. Ordinateur portable");
			System.out.println("2. Souris");
			System.out.println("3. Clavier");
			System.out.println("4. Disque dur externe");
			System.out.println("5. Ecouteurs");
			System.out.println("6. Autres");
			System.out.print("\nVeuillez choisir une option : ");
			
			int choix2 = menu.prompt();
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
				System.out.println("Choix invalide veuillez choisir une option entre 1 et 6");
			}}
			categorie = new MaterielInformatique(marque, modele, dateLancement, sousCategorie);
			cat=true;
		} else if (choix == 5) {
			BureauCategorie sousCategorie=null;
			System.out.println("\nMarque du produit : ");
			String marque =menu.promptS();
			System.out.println("\nModèle du produit : ");
			String modele =menu.promptS();
			while(sousCategorie==null){
			System.out.println("\nSous-catégorie du produit : ");
			System.out.println("1. Chaise de bureau");
			System.out.println("2. Lampe de bureau");
			System.out.println("3. Support pour ordinateur portable");
			System.out.println("4. Autre");
			System.out.print("\nVeuillez choisir une option : ");
			
			int choix2 = menu.prompt();
			if (choix2 == 1) {
				sousCategorie = BureauCategorie.ChaiseDeBureau;
			} else if (choix2 == 2) {
				sousCategorie = BureauCategorie.LampeDeBureau;
			} else if (choix2 == 3) {
				sousCategorie = BureauCategorie.SupportOrdinateurPortable;
			} else if (choix2 == 4) {
				sousCategorie = BureauCategorie.Autre;
			} else {
				System.out.println("Choix invalide veuillez choisir une option entre 1 et 4");}
			}
			categorie = new EquipementBureau(marque, modele, sousCategorie);
			cat=true;
		} else {
			System.out.println("Choix invalide veuillez choisir une categorie");

		}}
		System.out.println("\nDescription du produit : ");
		String description =menu.promptS();
		System.out.println("\nQuantite du produit : ");
		int quantite = menu.prompt();
		System.out.println("\nPrix du produit : ");
		float prix = menu.promptF();
		System.out.println("\nPoint bonus du produit : ");
		int pointBonus = menu.prompt();
		System.out.println("\nLien image ou video du produit (entrez non si non applicable) : ");
		String lienImageOuVideo =menu.promptS();
		String identifiant = menu.systemeGeneral.creerID();
		Produit produit = new Produit(titre, categorie, description, quantite, prix, pointBonus, identifiant, lienImageOuVideo);
		_produits.add(produit);
		menu.systemeCatalogue.catalogue.add(produit);
	}

	public int getLikes() {
		return this._likes;
	}

	public void setLikes(int aLikes) {
		this._likes = aLikes;
	}


	public void changerEtat(Commande aCommande, String aCompagnieExp, int aNumSuivi) {
		throw new UnsupportedOperationException();
	}

	public void ajouterPromotionPrix(Produit produit, float prix, int duree) {
		produit.setPrixPromotionnel(prix);
		produit.setFinPromotion(LocalDate.now().plusDays(duree));
	}

	public void ajouterPromotionPoints(Produit produit, int points, int duree) {
		produit.setPointBonusPromotionnel(points);
		produit.setFinPromotion(LocalDate.now().plusDays(duree));
	}

    public void menuPromotion(Menu menu) {
		System.out.println("\n---------------------------------------------");
		System.out.println("Sur quel produit voulez-vous ajouter une promotion?");
		//afficher les produits du revendeur
		for (int i = 1; i-1 < _produits.size(); i++) {
			System.out.println(i + ". " + _produits.get(i-1).get_titre());
    	}
		System.out.print("\nVeuillez choisir une option : ");
		int choix = menu.prompt();
		if (choix > 0 && choix <= _produits.size()) {
			boolean cat=false;
			while (cat==false) {
			System.out.println("\n---------------------------------------------");
			System.out.println("\nQuel type de promotion voulez-vous appliquer ?");
			System.out.println("1. Promotion sur le prix");
			System.out.println("2. Promotion sur les points");
			System.out.print("\nVeuillez choisir une option : ");
			int choix2 = menu.prompt();
			if (choix2 == 1) {
				System.out.println("\nQuel sera le nouveau prix du produit?");
				System.out.print("\nVeuillez entrer un prix : ");
				float prix = menu.promptF();
				System.out.println("\nCombien de temps voulez-vous que la promotion soit active?");
				System.out.print("\nVeuillez entrer un nombre de jours : ");
				int duree = menu.prompt();
				ajouterPromotionPrix(_produits.get(choix-1), prix, duree);
				cat=true;
			} else if (choix2 == 2) {
				System.out.println("\nCombien de points voulez-vous que le produit rapporte?");
				System.out.print("\nVeuillez entrer un nombre de points : ");
				int points = menu.prompt();
				System.out.println("\nCombien de temps voulez-vous que la promotion soit active?");
				System.out.print("\nVeuillez entrer un nombre de jours : ");
				int duree = menu.prompt();
				ajouterPromotionPoints(_produits.get(choix-1), points, duree);
				cat=true;
			} else {
				System.out.println("Choix invalide veuillez choisir une option entre 1 et 2");
			}
		}
		} else {
			System.out.println("Choix invalide veuillez choisir une option entre 1 et " + _produits.size());
		}	
	}
}