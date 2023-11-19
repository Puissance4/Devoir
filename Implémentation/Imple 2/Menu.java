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
		System.out.println("\n");
		System.out.println("\n---------------------------------------------");
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

	public void afficherPageRevendeur() {
		Revendeur util=(Revendeur)utilisateurConnecte;
		String nom=util.getNom();
		System.out.println("\n");
		System.out.println("\n---------------------------------------------");
		System.out.println("\nBienvenue sur votre page "+nom +" !\n");
        System.out.println("1. Ajouter un nouveau produit");
		System.out.println("2. Offrir une promotion ");
        System.out.println("3. Gérer un signalement");
        System.out.println("4. Modifier le profil");
      	System.out.println("5. Voir mes notifications");
		System.out.println("6. Voir mes métriques");
		System.out.println("7. Confirmer l'arrivée d'un retour");
        System.out.println("8. Deconnexion");
		System.out.println("9. Afficher le catalogue");
        System.out.print("\nVeuillez choisir une option : ");
		this.indexPage=1;
		selectOption(prompt());
	}

	public void afficherMenuPrincipal() {
		System.out.println("\n");
		System.out.println("\n---------------------------------------------");
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
				try{
					utilisateurConnecte=systemeUtilisateur.connexion();
				if(utilisateurConnecte instanceof Revendeur){
					afficherPageRevendeur();
				}
				else{
					afficherPageAcheteur();
				}}
				catch(IllegalArgumentException exception){
					System.out.println(exception);
				}
				break;
			case 3:
				if(systemeCatalogue.getCatalogue().size()==0){
					System.out.println("Désolé nous n'avons pas d'articles disponibles à la vente en ce moment");
				}
				else{
					for(int i=0;i<systemeCatalogue.getCatalogue().size();i++){
					Produit produit=systemeCatalogue.getCatalogue().get(i);
					System.out.println(produit.get_titre()+"..... "+produit.get_prix()+"$");}}

				int choix = 0;	
				while(choix!=1){
				System.out.println("Entrez 1 pour revenir au menu principal");
				choix = prompt();}
				afficherMenuPrincipal();
				break;
			default:
				System.out.println("Choix invalide, veuillez réessayer.");
				break;
	}}
	else if (indexPage==1){
		Revendeur util=(Revendeur)utilisateurConnecte;
	switch (option) {
		case 1:
			util.ajouterProduit();
			System.out.println("\n---------------------------------------------");
			System.out.println("\nProduit ajouté avec succès !");
			System.out.println("\nAppuyez sur une touche pour revenir au menu principal.");
			scanner.nextLine();
			afficherPageRevendeur();
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
		case 9:
		if(systemeCatalogue.getCatalogue().size()==0){
				System.out.println("Désolé nous n'avons pas d'articles disponibles à la vente en ce moment");
			}
			else{
				System.out.println("--------------------------");
				for(int i=0;i<systemeCatalogue.getCatalogue().size();i++){
				Produit produit=systemeCatalogue.getCatalogue().get(i);
				System.out.println(produit.get_titre()+"..... "+produit.get_prix()+"$        ["+i+"]");}
			System.out.println("--------------------------");
			System.out.println("Entrez l'index d'un produit pour obtenir plus d'informations");}

			System.out.println("Entrez ["+(systemeCatalogue.getCatalogue().size()) + "] pour revenir au menu principal");
			int choix;
			choix = prompt();
			if(choix==(systemeCatalogue.getCatalogue().size())){
			afficherPageAcheteur();}
			else if(choix<=systemeCatalogue.getCatalogue().size()){
				Produit produitChoisi=systemeCatalogue.getCatalogue().get(choix);
				systemeCatalogue.afficherProduit(produitChoisi);
				System.out.println("Entrez [1] pour revenir au menu principal");
				choix=prompt();
					if(choix==1){
						afficherPageRevendeur();}}
				else if(choix==2){
					afficherPageRevendeur();
				}
				
			break;
			

		default:
			System.out.println("Choix invalide, veuillez réessayer.");
			break;}}
	else if (indexPage==2){
		Acheteur util=(Acheteur)utilisateurConnecte;
	switch (option) {
		case 1:
			Panier panier=util.getPanier();
			System.out.println("--------------------------");
			System.out.println("cout: "+ panier.getCout() + "$");
			System.out.println("Nombre de points bonus: "+ panier.getNombrePoints() + "$");
			System.out.println("Contenu:");
				for(int i=0;i<panier.getProduits().size();i++){
					Produit produit=panier.getProduits().get(i);
					System.out.println(produit.get_titre()+"..... "+produit.get_prix()+"$        ["+i+"]");}
			System.out.println("--------------------------");
			System.out.println("Entrez l'index d'un produit pour obtenir plus d'informations ou le supprimer");
			System.out.println("Entrez ["+(panier.getProduits().size()) + "] pour commander");
			System.out.println("Entrez ["+(panier.getProduits().size()+1) + "] pour revenir au menu principal");
			int choix = prompt();

			if(choix==(panier.getProduits().size()+1)){
				afficherPageAcheteur();
			}
			else if(choix==panier.getProduits().size()){
				Commande nouvCommande=panier.commander(util,systemeGeneral);
				System.out.println("--------------------------");
				System.out.println("Votre Commande a bien été passée voici son identifiant : "+nouvCommande.getID());
				System.out.println("Entrez [1] pour revenir au menu principal");
					choix=prompt();

					if(choix==1){
						afficherPageAcheteur();
						
					}
			}
			else if(choix<=panier.getProduits().size()){
				Produit produitChoisi=panier.getProduits().get(choix);
				systemeCatalogue.afficherProduit(produitChoisi);
				System.out.println("Entrez [1] pour supprimer l'article de votre panier");
				System.out.println("Entrez [2] pour revenir au menu principal");
				choix=prompt();

				if(choix==1){
					panier.retirerDuPanier(produitChoisi);
					System.out.println("l'article a été supprimé de votre panier!");
					System.out.println("Entrez [1] pour revenir au menu principal");
					choix=prompt();

					if(choix==1){
						afficherPageAcheteur();
						
					}}
				else if(choix==2){
					afficherPageAcheteur();
					
				}}
			
			break;
			
		case 2:
			System.out.println("on entre");
			System.out.println(option);
			if(systemeCatalogue.getCatalogue().size()==0){
				System.out.println("Désolé nous n'avons pas d'articles disponibles à la vente en ce moment");
				
			}
			else{
				System.out.println("--------------------------");
				for(int i=0;i<systemeCatalogue.getCatalogue().size();i++){
					Produit produit=systemeCatalogue.getCatalogue().get(i);
					System.out.println(produit.get_titre()+"..... "+produit.get_prix()+"$        ["+i+"]");}

				System.out.println("--------------------------");
				System.out.println("Entrez l'index d'un produit pour obtenir plus d'informations");
				System.out.println("Entrez ["+(systemeCatalogue.getCatalogue().size()) + "] pour revenir au menu principal");
				choix = prompt();

				if(choix==(systemeCatalogue.getCatalogue().size())){
					afficherPageAcheteur();
					}
				else if(choix<=systemeCatalogue.getCatalogue().size()){
					Produit produitChoisi=systemeCatalogue.getCatalogue().get(choix);
					systemeCatalogue.afficherProduit(produitChoisi);
					System.out.println("Entrez [1] pour ajouter l'article à votre panier");
					System.out.println("Entrez [2] pour revenir au menu principal");
					choix=prompt();
					if(choix==1){
						produitChoisi.ajouterAuPanier(util);
						System.out.println("l'article a été ajouté à votre panier!");
						System.out.println("Entrez [1] pour revenir au menu principal");
						choix=prompt();
							if(choix==1){
							afficherPageAcheteur();
							}}
					else if(choix==2){
						afficherPageAcheteur();
						
				}
				
			}}
			
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