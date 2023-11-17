import java.util.ArrayList;
import java.util.Scanner;

public class SystemeUtilisateur extends Systeme {
	private Scanner sc = new Scanner(System.in);
	public ArrayList<Acheteur> listeAcheteurs;
	public ArrayList<Revendeur> listeRevendeurs;

	public void connexion() {
		System.out.println("1. Connexion en tant qu'acheteur");
		System.out.println("2. Connexion en tant que revendeur");
		int choix = sc.nextInt();
		sc.nextLine();
		switch (choix) {
		case 1:
			if (connexionAcheteur()) {
				System.out.println("Connexion reussie");
			} else {
				System.out.println("Connexion echouee");
			}
			break;
		case 2:
			if (connexionRevendeur()) {
				System.out.println("Connexion reussie");
			} else {
				System.out.println("Connexion echouee");
			}
			break;
		default:
			System.out.println("Choix invalide");
			break;
		}
	}

	public boolean connexionAcheteur() {
		System.out.println("Psuedo : ");
		String pseudo = sc.nextLine();
		System.out.println("Mot de passe : ");
		String mdp = sc.nextLine();
		for (Acheteur acheteur : listeAcheteurs) {
			if (acheteur.getPseudo().equals(pseudo) && acheteur.getMotDePasse().equals(mdp)) {
				return true;
			} 
		} 
		return false;
	}

	public boolean connexionRevendeur() {
		System.out.println("Nom : ");
		String email = sc.nextLine();
		System.out.println("Mot de passe : ");
		String mdp = sc.nextLine();
		for (Revendeur revendeur : listeRevendeurs) {
			if (revendeur.getNom().equals(email) && revendeur.getMotDePasse().equals(mdp)) {
				return true;
			} 
		} 
		return false;
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