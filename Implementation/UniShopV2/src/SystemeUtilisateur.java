import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class SystemeUtilisateur extends Systeme {
	public String fichierAcheteurs="../Acheteurs.csv";
	public String fichierRevendeurs="../Revendeurs.csv";
	private ArrayList <Acheteur> listeAcheteurs= new ArrayList<Acheteur>();
	private ArrayList <Revendeur> listeRevendeurs= new ArrayList<Revendeur>();
    
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

	public void inscription(Menu menu) {
		System.out.println("1. Inscription en tant qu'acheteur");
		System.out.println("2. Inscription en tant que revendeur");
		int choix = menu.prompt();
		switch (choix) {
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
		listeAcheteurs.add(acheteurnew);
		return acheteurnew;

	}

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
		listeRevendeurs.add(revendeurnew);
		return revendeurnew;}

 //ajouter les filtres
	public Revendeur rechercherRevendeur(String nom) throws Exception {
		for (Revendeur revendeur : listeRevendeurs) {
			if (revendeur.getNom().equals(nom)){
				revendeur.afficherProfil();

				return revendeur;
			}
	}
	throw new Exception("Il n'existe pas de revendeur avec le nom "+ nom);
}
	
	public Acheteur rechercherAcheteur(String pseudo) throws Exception {
		for (Acheteur acheteur : listeAcheteurs) {
			if (acheteur.getPseudo().equals(pseudo)){
				acheteur.afficherProfil();

				return acheteur;
			}
	}
	throw new Exception("Il n'existe pas d'acheteur avec le pseudo "+ pseudo);
}
	public void mettreJourQuantitees(Commande aCom) {
		throw new UnsupportedOperationException();
	}
}