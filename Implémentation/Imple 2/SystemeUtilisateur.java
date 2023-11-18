import java.util.ArrayList;
import java.util.Scanner;

public class SystemeUtilisateur extends Systeme {
	private Scanner sc = new Scanner(System.in);
	public ArrayList<Acheteur> listeAcheteurs=new ArrayList<Acheteur>();
	public ArrayList<Revendeur> listeRevendeurs=new ArrayList<Revendeur>();

	public Utilisateur connexion() throws IllegalArgumentException {
		System.out.println("\n");
		System.out.println("-----------------------------------------------");
		System.out.println("\n");
		System.out.println("1. Connexion en tant qu'acheteur");
		System.out.println("2. Connexion en tant que revendeur");
		System.out.print("\nVeuillez choisir une option : ");
		int choix = sc.nextInt();
		sc.nextLine();
		switch (choix) {
		case 1:
				return connexionAcheteur();
		
		case 2:
				return connexionRevendeur();
		default:
			IllegalArgumentException exception=new IllegalArgumentException("choix Invalide");
		throw exception;
		}
	}

	public Acheteur connexionAcheteur() throws IllegalArgumentException {
		System.out.println("Pseudo : ");
		String pseudo = sc.nextLine();
		System.out.println("Mot de passe : ");
		String mdp = sc.nextLine();
		for (Acheteur acheteur : listeAcheteurs) {
			if (acheteur.getPseudo().equals(pseudo) && acheteur.getMotDePasse().equals(mdp)) {
				return acheteur;
			} 
		} 
		IllegalArgumentException exception=new IllegalArgumentException("cet utilisateur n'existe pas");
		throw exception;
	}

	public Revendeur connexionRevendeur() throws IllegalArgumentException{
		System.out.println("\nNom : ");
		String nom = sc.nextLine();
		System.out.println("\nMot de passe : ");
		String mdp = sc.nextLine();
		for (Revendeur revendeur : listeRevendeurs) {
			if (revendeur.getNom().equals(nom) && revendeur.getMotDePasse().equals(mdp)) {
				return revendeur;
			}
		} 
		IllegalArgumentException exception=new IllegalArgumentException("cet utilisateur n'existe pas");
		throw exception;
	}

	public void inscription() {
		System.out.println("1. Inscription en tant qu'acheteur");
		System.out.println("2. Inscription en tant que revendeur");
		int choix = sc.nextInt();
		sc.nextLine();
		switch (choix) {
		case 1:
			Acheteur acheteur = inscrireAcheteur();
			break;
		case 2:
			Revendeur revendeur = inscrireRevendeur();
			break;
		default:
			System.out.println("Choix invalide");
			break;
		}
	}

	public Acheteur inscrireAcheteur() {
		System.out.println("Pseudo : ");
		String pseudo = sc.nextLine();
		System.out.println("Nom : ");
		String prenom = sc.nextLine();
		System.out.println("Prenom : ");
		String nom = sc.nextLine();
		System.out.println("Email : ");
		String email = sc.nextLine();
		System.out.println("Mot de passe : ");
		String mdp = sc.nextLine();
		System.out.println("Adresse : ");
		String adresse = sc.nextLine();
		System.out.println("Telephone : ");
		String telephone = sc.nextLine();
		Acheteur acheteurnew=new Acheteur(pseudo, nom, prenom, email, mdp, adresse, telephone);
		listeAcheteurs.add(acheteurnew);
		return acheteurnew;

	}

	public Revendeur inscrireRevendeur() {
		System.out.println("Nom : ");
		String nom = sc.nextLine();
		System.out.println("Email : ");
		String email = sc.nextLine();
		System.out.println("Mot de passe : ");
		String mdp = sc.nextLine();
		System.out.println("Adresse : ");
		String adresse = sc.nextLine();
		System.out.println("Telephone : ");
		String telephone = sc.nextLine();
		Revendeur revendeurnew=new Revendeur(nom, email, mdp, adresse, telephone);
		listeRevendeurs.add(revendeurnew);
		return revendeurnew;}

	public Revendeur[] rechercherRevendeur(String aMotcle, FiltresRevendeur[] aFiltres) {
		throw new UnsupportedOperationException();
	}

	public void mettreJourQuantitees(Commande aCom) {
		throw new UnsupportedOperationException();
	}
}