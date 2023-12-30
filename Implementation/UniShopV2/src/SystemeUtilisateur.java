import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * La classe SystemeUtilisateur gère les fonctionnalités liées aux utilisateurs, y compris les acheteurs et les revendeurs.
 * Elle permet de charger les données utilisateurs à partir de fichiers, de gérer les connexions et les inscriptions, et de sauvegarder les données lors de la déconnexion.
 */
public class SystemeUtilisateur extends Systeme {
	public String fichierAcheteurs="Implementation/UniShopV2/Acheteurs.csv";
	public String fichierRevendeurs="Implementation/UniShopV2/Revendeurs.csv";
	private ArrayList <Acheteur> listeAcheteurs= new ArrayList<Acheteur>();
	private ArrayList <Revendeur> listeRevendeurs= new ArrayList<Revendeur>();

	/**
	 * Constructeur pour initialiser le système utilisateur avec les données des acheteurs et des revendeurs à partir de fichiers.
	 *
	 * @param catalogue Liste des produits disponibles.
	 * @param listeCommandes Liste des commandes effectuées.
	 */
	public SystemeUtilisateur(ArrayList<Produit> catalogue,ArrayList<Commande> listeCommandes){
	
		try {
			BufferedReader readerAcheteur=new BufferedReader(new FileReader(fichierAcheteurs));
			String line=readerAcheteur.readLine();//ignore la ligne des noms de colonnes
			while ((line=readerAcheteur.readLine())!=null) {
				String[] donnee=line.split(",");
				listeAcheteurs.add(new Acheteur(donnee,catalogue,listeCommandes));
			
				
			}
			readerAcheteur.close();
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		try {
			BufferedReader readerRevendeur=new BufferedReader(new FileReader(fichierRevendeurs));
			String line =readerRevendeur.readLine();//ignore la ligne des noms de colonnes
			while ((line=readerRevendeur.readLine())!=null) {
				String[] donnee=line.split(",");
				listeRevendeurs.add(new Revendeur(donnee,catalogue));
		}readerRevendeur.close();
	
	} catch (Exception e) {
		
			e.printStackTrace();}
	}

	/**
	 * Gère le processus de connexion pour un utilisateur, offrant des options pour se connecter en tant qu'acheteur ou revendeur.
	 *
	 * @param menu Instance du menu pour interagir avec l'utilisateur.
	 */
	public void connexion(Menu menu) {
		System.out.println("\n");
		System.out.println("-----------------------------------------------");
		System.out.println("\n");
		System.out.println("1. Connexion en tant qu'acheteur");
		System.out.println("2. Connexion en tant que revendeur");
		System.out.print("\nVeuillez choisir une option : ");
		int choix = menu.prompt();
		switch (choix) {
		case 1:
				connexionAcheteur(menu);
		
		case 2:
				connexionRevendeur(menu);
		default:
			System.out.println("Choix invalide veuillez reessayer:");
			connexion(menu);
		}
	}

	/**
	 * Gère le processus de connexion pour un acheteur.
	 *
	 * @param menu Instance du menu pour interagir avec l'utilisateur.
	 */
	public void connexionAcheteur(Menu menu) {
		System.out.println("Pseudo : ");
		String pseudo = menu.promptS();
		System.out.println("Mot de passe : ");
		String mdp = menu.promptS();
		for (Acheteur acheteur : listeAcheteurs) {
			if (acheteur.getPseudo().equals(pseudo) && acheteur.getMotDePasse().equals(mdp)) {
				menu.setUtilisateurConnecte(acheteur);
				menu.afficherPageAcheteur();
				return;
			} 
		} 
		System.out.println("Cet utilisateur n'existe pas veuillez reessayer");
		connexion(menu);
		
	}

	/**
	 * Gère le processus de connexion pour un revendeur.
	 *
	 * @param menu Instance du menu pour interagir avec l'utilisateur.
	 */
	public void connexionRevendeur(Menu menu) {
		System.out.println("Nom : ");
		String nom = menu.promptS();
		System.out.println("Mot de passe : ");
		String mdp =menu.promptS();
		for (Revendeur revendeur : listeRevendeurs) {
			if (revendeur.getNom().equals(nom) && revendeur.getMotDePasse().equals(mdp)) {
				menu.setUtilisateurConnecte(revendeur);
				menu.afficherPageRevendeur();
				return;
			}
		} 
		System.out.println("Cet utilisateur n'existe pas veuillez reessayer");
		connexion(menu);
	}

	/**
	 * Gère le processus d'inscription pour un nouvel utilisateur, offrant des options pour s'inscrire en tant qu'acheteur ou revendeur.
	 *
	 * @param menu Instance du menu pour interagir avec l'utilisateur.
	 */
	public void inscription(Menu menu) {
		System.out.println("1. Inscription en tant qu'acheteur");
		System.out.println("2. Inscription en tant que revendeur");
		int selection1 = menu.prompt();
		switch (selection1) {
		case 1:
			Acheteur acheteur = inscrireAcheteur(menu);
			menu.systemeUtilisateur.listeAcheteurs.add(acheteur);
			menu.setUtilisateurConnecte(acheteur);
			menu.afficherPageAcheteur();
			break;
		case 2:
			Revendeur revendeur = inscrireRevendeur(menu);
			menu.systemeUtilisateur.listeRevendeurs.add(revendeur);
			menu.setUtilisateurConnecte(revendeur);
			menu.afficherPageRevendeur();
			break;
		default:
			System.out.println("Choix invalide veuillez reessayer:");
			inscription(menu);
			break;
		}
	}

	/**
	 * Inscription d'un nouvel acheteur dans le système.
	 *
	 * @param menu Instance du menu pour recueillir les informations de l'utilisateur.
	 * @return L'acheteur nouvellement inscrit.
	 */
	public Acheteur inscrireAcheteur(Menu menu) {
		System.out.println("Pseudo : ");
		String pseudo = menu.promptS();
		System.out.println("Nom : ");
		String prenom = menu.promptS();
		System.out.println("Prenom : ");
		String nom =menu.promptS();
		System.out.println("Email : ");
		String email = menu.promptS();
		System.out.println("Mot de passe : ");
		String mdp =menu.promptS();
		System.out.println("Adresse : ");
		String adresse = menu.promptS();
		System.out.println("Telephone : ");
		String telephone = menu.promptS();
		Acheteur acheteurnew=new Acheteur(pseudo, nom, prenom, email, mdp, adresse, telephone);
		return acheteurnew;

	}

	/**
	 * Inscription d'un nouveau revendeur dans le système.
	 *
	 * @param menu Instance du menu pour recueillir les informations de l'utilisateur.
	 * @return Le revendeur nouvellement inscrit.
	 */
	public Revendeur inscrireRevendeur(Menu menu) {
		System.out.println("Nom : ");
		String nom = menu.promptS();
		System.out.println("Email : ");
		String email = menu.promptS();
		System.out.println("Mot de passe : ");
		String mdp = menu.promptS();
		System.out.println("Adresse : ");
		String adresse = menu.promptS();
		System.out.println("Telephone : ");
		String telephone = menu.promptS();
		Revendeur revendeurnew=new Revendeur(nom, email, mdp, adresse, telephone);
		return revendeurnew;}

 //ajouter les filtres

	/**
	 * Recherche un revendeur dans le système en utilisant un mot-clé.
	 *
	 * @param motcle Le mot-clé pour la recherche.
	 * @return Le revendeur trouvé ou null si aucun n'est trouvé.
	 */
	public Revendeur rechercherRevendeur(String motcle) {
		for (Revendeur revendeur : listeRevendeurs) {
			if (revendeur.getNom().equals(motcle)){
				revendeur.afficherProfil();
				return revendeur;
			}
			else if (revendeur.getAdresse().contains(motcle)){
				revendeur.afficherProfil();
				return revendeur;
			}
			
		}
		return null;
	}

	/**
	 * Recherche un acheteur dans le système en utilisant son pseudo.
	 *
	 * @param pseudo Le pseudo de l'acheteur à rechercher.
	 * @return L'acheteur trouvé ou lève une exception si aucun n'est trouvé.
	 * @throws Exception Si aucun acheteur avec le pseudo spécifié n'est trouvé.
	 */
	public Acheteur rechercherAcheteur(String pseudo) throws Exception {
		for (Acheteur acheteur : listeAcheteurs) {
			if (acheteur.getPseudo().equals(pseudo)){
				acheteur.afficherProfil();

				return acheteur;
			}
		}
	throw new Exception("Il n'existe pas d'acheteur avec le pseudo "+ pseudo);
	}

	/**
	 * Méthode non supportée pour mettre à jour les quantités.
	 *
	 * @param aCom La commande à traiter.
	 */
	public void mettreJourQuantitees(Commande aCom) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Déconnecte l'utilisateur actuel et enregistre les données des acheteurs et des revendeurs dans les fichiers.
	 */
	public void deconnexion(){
		try {
			BufferedWriter writterAcheteurs=new BufferedWriter(new FileWriter("Implementation/UniShopV2/Acheteurs.csv"));
			BufferedWriter writterPanier=new BufferedWriter(new FileWriter("Implementation/UniShopV2/Paniers.csv"));
			writterPanier.write("pseudo,produits,nbPoints,prix");
			writterAcheteurs.write("pseudo,nom,prenom,email,motDePasse,adresse,telephone,Revendeurslike,Acheteurslike,Notifications,ProduitsLike,NombreDepoints");
			for (Acheteur acheteur: listeAcheteurs){
				writterAcheteurs.newLine();
				writterPanier.newLine();
				String pseudo=acheteur.getPseudo();
				String nom=acheteur.getNom();
				String prenom=acheteur.getPrenom();
				String email=acheteur.getCourriel();
				String motDePasse=acheteur.getMotDePasse();
				String adresse=acheteur.getAdresse();
				String telephone=acheteur.getTelephone();
				String Revendeurslike=acheteur.getRevendeurslikeBuff();
				String Acheteurslike=acheteur.getAcheteurlikeBuff();
				String Notifications=acheteur.getNotificationBuff();
				String ProduitsLike=acheteur.getProduitsLikeBuff();
				int NombreDepoints=acheteur.getNombrePoints();
				String panier= acheteur.getPanier().getPanierBuff();

				writterPanier.write(panier);
				writterAcheteurs.write(pseudo+","+nom+","+prenom+","+email+","+motDePasse+","+adresse+","+telephone+","+Revendeurslike+","+Acheteurslike+","+Notifications+","+ProduitsLike+","+NombreDepoints);
			}
			writterAcheteurs.close();
			writterPanier.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			BufferedWriter writterRevendeurs=new BufferedWriter(new FileWriter("../Revendeurs.csv"));
			writterRevendeurs.write("nom,email,motDePasse,adresse,telephone,likes,ProduitsOfferts,AcheteurLike,Notification");
      
			for (Revendeur revendeur: listeRevendeurs){
				writterRevendeurs.newLine();
				String nom=revendeur.getNom();
				String email=revendeur.getCourriel();
				String motDePasse=revendeur.getMotDePasse();
				String adresse=revendeur.getAdresse();
				String telephone=revendeur.getTelephone();
				int likes= revendeur.getLikes();
				String ProduitsOfferts=revendeur.getProduitsBuff();
				String Acheteurslike=revendeur.getacheteurSuiviBuff();
				String Notifications=revendeur.getRevendeurNotificationBuff();

				writterRevendeurs.write(nom+","+email+","+motDePasse+","+adresse+","+telephone+","+likes+","+ProduitsOfferts+","+Acheteurslike+","+Notifications);
			}
			writterRevendeurs.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Renvoie la liste des acheteurs inscrits dans le système.
	 *
	 * @return Liste des acheteurs.
	 */
	public ArrayList<Acheteur> getListeAcheteurs(){
		return listeAcheteurs;
	}

	/**
	 * Renvoie la liste des revendeurs inscrits dans le système.
	 *
	 * @return Liste des revendeurs.
	 */
	public ArrayList<Revendeur> getListeRevendeurs(){
		return listeRevendeurs;
	}



}