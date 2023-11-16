public class Menu {
	private Utilisateur utilisateurConnecte;
	private int indexPage = 0;
	public App app;
	public Systeme syteme;

	public void afficherMessage(String message) {
		System.out.println(message);
	}

	public void afficherPageAcheteur() {
		Acheteur util=(Acheteur)utilisateurConnecte;
		String prenom=util.getPrenom();
		System.out.println("\nBienvenue sur votre page "+prenom +" !\n");
        System.out.println("1. Consulter le panier");
        System.out.println("2. Afficher le catalogue");
        System.out.println("3. Faire une recherche de produit ");
        System.out.println("4. Faire une recherche de revendeur");
        System.out.println("5. Modifier le profil");
		System.out.println("6. Voir mes notifications");
		System.out.println("8. Confirmer l'arrivée d'une commande");
        System.out.println("9. Deconnexion");
        System.out.print("\nVeuillez choisir une option : ");
		this.indexPage=2;
	}

	public void AfficherPageRevendeur() {
		Revendeur util=(Revendeur)utilisateurConnecte;
		String nom=util.getNom();
		System.out.println("\nBienvenue sur votre page "+nom +" !\n");
        System.out.println("1. Consulter le panier");
        System.out.println("2. Afficher le catalogue");
        System.out.println("3. Faire une recherche de produit ");
        System.out.println("4. Faire une recherche de revendeur");
        System.out.println("5. Modifier le profil");
        System.out.println("6. Deconnexion");
        System.out.print("\nVeuillez choisir une option : ");
		this.indexPage=2;
	}

	public void afficherPageLogin() {
		throw new UnsupportedOperationException();
	}

	public void afficherMenuPrincipal() {
        System.out.println("\nBienvenue sur UniShop !\n");
        System.out.println("1. S'inscrire");
        System.out.println("2. Se connecter");
        System.out.println("3. Afficher le catalogue");
        System.out.print("\nVeuillez choisir une option : ");
		this.indexPage=0;
    }

	public void selectOption(int aOption) {
		throw new UnsupportedOperationException();
	}

	public void prompt() {
		throw new UnsupportedOperationException();
	}

	public void setUtilisateurConnecte(Utilisateur aNouveau) {
		this.utilisateurConnecte = aNouveau;
	}

	public void entrerInfo(String aTexteEntre) {
		throw new UnsupportedOperationException();
	}
}