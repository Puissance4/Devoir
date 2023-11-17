import java.util.Scanner;

public class Menu {
	private Utilisateur utilisateurConnecte;
	private int indexPage = 0;
	public App app;
	public SystemeCatalogue systemeCatalogue=new SystemeCatalogue();
	public SystemeUtilisateur systemeUtilisateur=new SystemeUtilisateur();
	public SystemeGeneral systemeGeneral=new SystemeGeneral();

	private static Scanner scanner = new Scanner(System.in);


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
		System.out.println("7. Voir mes métriques");
		System.out.println("8. Confirmer l'arrivée d'une commande");
        System.out.println("9. Deconnexion");
        System.out.print("\nVeuillez choisir une option : ");
		this.indexPage=2;
		selectOption(prompt());
	}

	public void AfficherPageRevendeur() {
		Revendeur util=(Revendeur)utilisateurConnecte;
		String nom=util.getNom();
		System.out.println("\nBienvenue sur votre page "+nom +" !\n");
        System.out.println("1. Ajouter un nouveau produit");
		System.out.println("2. Offrir une promotion ");
        System.out.println("3. Gérer un signalement");
        System.out.println("4. Modifier le profil");
      	System.out.println("5. Voir mes notifications");
		System.out.println("6. Voir mes métriques");
		System.out.println("7. Confirmer l'arrivée d'un retour");
        System.out.println("8. Deconnexion");
        System.out.print("\nVeuillez choisir une option : ");
		this.indexPage=1;
		selectOption(prompt());
	}

	public void afficherMenuPrincipal() {
        System.out.println("\nBienvenue sur UniShop !\n");
        System.out.println("1. S'inscrire");
        System.out.println("2. Se connecter");
        System.out.println("3. Afficher le catalogue");
        System.out.print("\nVeuillez choisir une option : ");
		this.indexPage=0;
		selectOption(prompt());
    }

	public void selectOption(int option) {
		if (indexPage==0){
		switch (option) {
			case 1:
				systemeUtilisateur.inscription();
				break;
			case 2:
				systemeUtilisateur.connexion();
				break;
			case 3:
				System.out.println(systemeCatalogue.getCatalogue());
				break;
			default:
				System.out.println("Choix invalide, veuillez réessayer.");
				break;
	}}
	if (indexPage==1){
		Revendeur util=(Revendeur)utilisateurConnecte;
	switch (option) {
		case 1:
			util.ajouterProduit();
			break;
		case 2:
			//ajouterPromotion();
			break;
		case 3:
			//gerer signalement;
			break;
		case 4:
			//modifier profil;
			break;
		case 5:
			//notifications;
			break;
		case 6:
			//metriques	;
			break;
		case 7:
			//confirmer retour;
			break;
		case 8:
			//deconnexion;
			break;
		default:
			System.out.println("Choix invalide, veuillez réessayer.");
			break;}}
	if (indexPage==2){
	switch (option) {
		case 1:
			//consulter panier;
			break;
		case 2:
			System.out.println(systemeCatalogue.getCatalogue());
			break;
		case 3:
			//recherche produit;
			break;
		case 4:
			//recherche revendeur;
			break;
		case 5:
			//modifier profil;
			break;
		case 6:
			//notifications;
			break;
		case 7:
			//metriques;
			break;
		case 8:
			//confirmer arrivee commande
			break;
		case 9:
			//deconnexion;
			break;
		default:
			System.out.println("Choix invalide, veuillez réessayer.");
			break;}}}

	public int prompt() {
		int choix = scanner.nextInt();
		scanner.nextLine();
		return choix;


		
	}

	public void setUtilisateurConnecte(Utilisateur aNouveau) {
		this.utilisateurConnecte = aNouveau;
	}

	public void entrerInfo(String aTexteEntre) {
		throw new UnsupportedOperationException();
	}
}