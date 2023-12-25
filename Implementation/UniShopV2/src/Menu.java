
import javax.xml.transform.Source;
import java.sql.SQLOutput;
import java.util.*;

public class Menu {
	private Utilisateur utilisateurConnecte;
	private int indexPage = 0;
	public App app;
	public SystemeCatalogue systemeCatalogue=new SystemeCatalogue();
	public SystemeUtilisateur systemeUtilisateur=new SystemeUtilisateur(systemeCatalogue.catalogue,systemeCatalogue.listeCommandes);
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
		System.out.println("5. Faire une recherche d'acheteur");
        System.out.println("6. Modifier le profil");
		System.out.println("7. Voir mes notifications");
		System.out.println("8. Voir mes métriques");
		System.out.println("9. Voir mes commandes");
        System.out.println("10. Deconnexion");
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
		System.out.println("6. Voir mes metriques");
		System.out.println("7. Confirmer l'arrivée d'un retour");
		System.out.println("8. Afficher le catalogue");
        System.out.println("9. Deconnexion");
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
		System.out.println("4. Afficher les acheteurs");
		System.out.println("5. Afficher les revendeurs");
        System.out.print("\nVeuillez choisir une option : ");
		this.indexPage=0;
		selectOption(prompt());
    }

	public void afficherCatalogue() {
		if(systemeCatalogue.getCatalogue().isEmpty()){
			System.out.println("Désolé nous n'avons pas d'articles disponibles à la vente en ce moment");
		}
		else{
			System.out.println("--------------------------");
			for(int i=0;i<systemeCatalogue.getCatalogue().size();i++){
				Produit produit=systemeCatalogue.getCatalogue().get(i);
				System.out.println(produit.get_titre()+"..... "+produit.get_prix()+"$        ["+i+"]");
			}

			System.out.println("--------------------------");
			System.out.println("Entrez l'index d'un produit pour obtenir plus d'informations");}
	}

	public void selectOption(int option) {
		int choix;
		if (indexPage==0){
		switch (option) {
			case 1:
				systemeUtilisateur.inscription(this);
				break;
			case 2:
					systemeUtilisateur.connexion(this);
				break;
			case 3:
				if(systemeCatalogue.getCatalogue().size()==0){
					System.out.println("Desole nous n'avons pas d'articles disponibles à la vente en ce moment");
				}
				else{
					for(int i=0;i<systemeCatalogue.getCatalogue().size();i++){
					Produit produit=systemeCatalogue.getCatalogue().get(i);
					System.out.println(produit.get_titre()+"..... "+produit.get_prix()+"$");}}

				choix = 0;	
				while(choix!=1){
				System.out.println("Entrez 1 pour revenir au menu principal");
				choix = prompt();}
				afficherMenuPrincipal();
				break;

			case 4:
				//afficher les acheteurs
				if(systemeUtilisateur.getListeAcheteurs().isEmpty()){
				System.out.println("Desole nous n'avons pas d'acheteurs inscrits en ce moment");
				retourAuMenu(1, "principal");
				}
				else{
					System.out.println("--------------------------");
					for(int i=0;i<systemeUtilisateur.getListeAcheteurs().size();i++){
						Acheteur acheteur=systemeUtilisateur.getListeAcheteurs().get(i);
						System.out.println("["+i+"]   "+acheteur.getPseudo()+"..... Nombre de points: "+acheteur.getNombrePoints());
					}
				int taille=systemeUtilisateur.getListeAcheteurs().size();
				System.out.println("--------------------------");
				System.out.println("Entrez l'index d'un acheteur pour voir son profil");
				System.out.println("Entrez ["+(taille)+"] pour retourner au menu principal");
				choix=prompt();
				if(choix<taille){
					systemeUtilisateur.getListeAcheteurs().get(choix).afficherProfil();
					System.out.println("Connectez-vous pour pouvoir suivre cet acheteur ou rechercher des acheteurs");
					retourAuMenu(1, "principal");
				}
				else if(choix>taille){
					System.out.println("Choix invalide");
					retourAuMenu(1, "principal");
				}
				}
				afficherMenuPrincipal();
				break;

			case 5:
				//afficher les revendeurs
				if(systemeUtilisateur.getListeRevendeurs().isEmpty()){
				System.out.println("Desole nous n'avons pas de revendeurs inscrits en ce moment");
				retourAuMenu(1, "principal");
				}
				else{
					System.out.println("--------------------------");
					for(int i=0;i<systemeUtilisateur.getListeRevendeurs().size();i++){
						Revendeur revendeur=systemeUtilisateur.getListeRevendeurs().get(i);
						System.out.println("["+i+"]   "+revendeur.getNom()+"..... Nombre de likes: "+revendeur.getLikes());
					}
				int taille=systemeUtilisateur.getListeRevendeurs().size();
				System.out.println("--------------------------");
				System.out.println("Entrez l'index d'un revendeur pour voir son profil");
				System.out.println("Entrez ["+(taille)+"] pour retourner au menu principal");
				choix=prompt();
				if(choix<taille){
					systemeUtilisateur.getListeRevendeurs().get(choix).afficherProfil();
					System.out.println("Connectez-vous pour pouvoir suivre ce revendeur ou rechercher des revendeurs");
					retourAuMenu(1, "principal");
				}
				else if(choix>taille){
					System.out.println("Choix invalide");
					retourAuMenu(1, "principal");
				}
				}
				afficherMenuPrincipal();
				break;

			default:
				System.out.println("Choix invalide, veuillez réessayer.");
				afficherMenuPrincipal();
				break;
	}}
	else if (indexPage==1){
		Revendeur util=(Revendeur)utilisateurConnecte;
		
	switch (option) {
		case 1:
			util.ajouterProduit(this);
			System.out.println("\n---------------------------------------------");
			System.out.println("\nProduit ajouté avec succès !");
			System.out.println("\nAppuyez sur une touche pour revenir au menu principal.");
			scanner.nextLine();
			afficherPageRevendeur();
			break;
		case 2:
			util.menuPromotion(this);
			System.out.println("\n---------------------------------------------");
			System.out.println("\nPromotion ajouté avec succès !");
			System.out.println("\nAppuyez sur une touche pour revenir au menu principal.");
			scanner.nextLine();
			afficherPageRevendeur();
			break;
		case 3:
			//gerer signalement;
			break;
		case 4:
			util.modifierProfil(this);
			System.out.println("Votre profil a bien ete modifie!");
			choix = 0;	
				while(choix!=1){
				System.out.println("Entrez [1] pour revenir au menu principal");
				choix = prompt();}
			afficherPageRevendeur();
			break;
		case 5:
			ArrayList<Notification> notifications = util.notifications;
			for (Notification notification : notifications){
				System.out.println(notification.getCategorie() + ":     " + notification.getDesc());
			}
			// Return to menu
			choix=0;
			while (choix!=1){
				System.out.println("Entrez [1] pour revenir au menu principal");
				choix=prompt();
			}
			afficherPageRevendeur();
			break;
		case 6:
			MetriquesRevendeurs metriques = util.getMetriques();
			System.out.println("1. Revenus: " + metriques.getRevenu());
			System.out.println("2. Nombre d'article mis en vente: " + metriques.getNombreArticles());
			System.out.println("3. Nombre de produits vendus: " + metriques.getNombreProduitsVendus());
			// Return to menu
			choix=0;
			while (choix!=1){
				System.out.println("Entrez [1] pour revenir au menu principal");
				choix=prompt();
			}
			afficherPageRevendeur();
			break;
		case 7:
			//confirmer retour;
			break;
		case 8:
			afficherCatalogue();
			System.out.println("Entrez ["+(systemeCatalogue.getCatalogue().size()) + "] pour revenir au menu principal");
			choix=prompt();
			if(choix==(systemeCatalogue.getCatalogue().size())){
				afficherPageRevendeur();
			}
			else if(choix<=systemeCatalogue.getCatalogue().size()){
				Produit produitChoisi=systemeCatalogue.getCatalogue().get(choix);
				systemeCatalogue.afficherProduit(produitChoisi);
				System.out.println("Entrez [1] pour revenir au menu principal");
				choix=prompt();
					if(choix==1){
						afficherPageRevendeur();}
				}
			else if(choix==2){
				afficherPageRevendeur();
			}
				
			break;
		case 9:
			systemeCatalogue.deconnexion();
			systemeUtilisateur.deconnexion();
			System.out.println("Merci d'avoir magasine sur UniShop");
			System.exit(0);
			break;
		default:
			System.out.println("Choix invalide, veuillez réessayer.");
			afficherPageRevendeur();
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
			int choix1=panier.getProduits().size()+2;
			while(choix1>panier.getProduits().size()+1){
			System.out.println("Entrez l'index d'un produit pour obtenir plus d'informations ou le supprimer");
			System.out.println("Entrez ["+(panier.getProduits().size()) + "] pour commander");
			System.out.println("Entrez ["+(panier.getProduits().size()+1) + "] pour revenir au menu principal");
			choix1 = prompt();
			if(choix1==(panier.getProduits().size()+1)){
				afficherPageAcheteur();
			}
			else if(choix1==panier.getProduits().size()){
				try{
				Commande nouvCommande=panier.commander(util,this);

				// Notify the resellers that a new command is incoming
				Notification notification = new Notification(CategorieNotif.NOUVELLE_COMMANDE);
				for (Produit produit : panier.getProduits()){
					produit.getRevendeur().notifications.add(notification);
				}

				System.out.println("--------------------------");
				System.out.println("Votre Commande a bien été passée voici son identifiant : "+nouvCommande.getID());
				systemeCatalogue.listeCommandes.add(nouvCommande);}
				catch(IllegalStateException e){System.out.println(e);}
				finally{
					int choix2=0;
					while(choix2!=1){
						System.out.println("Entrez [1] pour revenir au menu principal");
						choix2=prompt();
						if(choix2==1){
							afficherPageAcheteur();}}
						}}
			else if(choix1<=panier.getProduits().size()){
				Produit produitChoisi=panier.getProduits().get(choix1);
				systemeCatalogue.afficherProduit(produitChoisi);
				System.out.println("Entrez [1] pour supprimer l'article de votre panier");
				System.out.println("Entrez [2] pour revenir au menu principal");

				int choix2=prompt();

				if(choix2==1){
					panier.retirerDuPanier(produitChoisi);
					System.out.println("l'article a été supprimé de votre panier!");}
			
				while(choix2!=2){
						System.out.println("Entrez [2] pour revenir au menu principal");
						choix2=prompt();}
				afficherPageAcheteur();
					
				}
			else{
				System.out.println("Choix invalide veuillez reessayer");
			}}
			
			break;
			
		case 2:
			
			int choix4=systemeCatalogue.getCatalogue().size()+1;

			while(choix4>systemeCatalogue.getCatalogue().size()){

				afficherCatalogue();
				System.out.println("Entrez ["+(systemeCatalogue.getCatalogue().size()) + "] pour revenir au menu principal");
				choix4 = prompt();

				if(choix4==(systemeCatalogue.getCatalogue().size())){
					afficherPageAcheteur();}
				else if(choix4<=systemeCatalogue.getCatalogue().size()){
					Produit produitChoisi=systemeCatalogue.getCatalogue().get(choix4);

					systemeCatalogue.afficherProduit(produitChoisi);

					System.out.println("Entrez [1] pour ajouter l'article à votre panier");
					System.out.println("Entrez [2] pour revenir au menu principal");
					int choix5=prompt();
					if(choix5==1){
						produitChoisi.ajouterAuPanier(util);
						System.out.println("l'article a été ajouté à votre panier!");}
					while(choix5!=2){
						System.out.println("Entrez [2] pour revenir au menu principal");
						choix5=prompt();}
					afficherPageAcheteur();}
				else{
				System.out.println("Choix invalide veuillez reessayer");
			}}		
			
			break;
		case 3:
			//recherche produit;
			break;
		case 4:
			//recherche revendeur;
			System.out.println("Entrez le nom a rechercher");
			String nom=promptS();
			try {
				Revendeur revendeurRech = systemeUtilisateur.rechercherRevendeur(nom);

			} catch (Exception e) {
				System.out.println(e);
			}
			retourAuMenu(1, "d'acheteur");
			afficherPageAcheteur();
			break;
		case 5:
			//recherche acheteur;
			System.out.println("Entrez le pseudo a rechercher");
			String pseudo=promptS();
			try {
				Acheteur acheteurRech=systemeUtilisateur.rechercherAcheteur(pseudo);
				if(!(util.acheteursSuivis.isEmpty()) && (util.acheteursSuivis.contains(acheteurRech))){
					System.out.println("Entrez [1] pour supprimer cet acheteur de vos acheteurs suivis");
				}
				else{System.out.println("Entrez [1] pour suivre cet acheteur");}
			
			System.out.println("Entrez [2] pour retourner au menu d'acheteur");
			int select=prompt();
			if(select==1){
				util.setAcheteursSuivis(acheteurRech);
				System.out.println("modification effectue avec succes!");
				retourAuMenu(1, "d'acheteur");
				
			}
			else if (select==2){

			}
			else{
				System.out.println("Choix invalide");
				retourAuMenu(1, "d'acheteur");
			}
			} catch (Exception e) {
				System.out.println(e);
				retourAuMenu(1, "d'acheteur");
			}
			afficherPageAcheteur();
			
			break;

		case 6:
			util.modifierProfil(this);
			System.out.println("Votre profil a bien ete modifie!");
			choix=0;
			while(choix!=1){
						System.out.println("Entrez [1] pour revenir au menu principal");
						choix=prompt();}
			afficherPageAcheteur();
			break;
		case 7:
			ArrayList<Notification> notifications = util.notifications;
			for (Notification notification : notifications){
				System.out.println(notification.getCategorie() + ":     " + notification.getDesc());
			}
			choix=0;
			while (choix!=1){
				System.out.println("Entrez [1] pour revenir au menu principal");
				choix=prompt();
			}
			afficherPageAcheteur();
			break;
		case 8:
			MetriquesAcheteur metriques = util.getMetriques();
			System.out.println("1. Nombre de commande: " + metriques.getNombreCommandes());
			System.out.println("2. Nombre d'articles: " + metriques.getNombreArticles());
			System.out.println("3. Acheteurs suivis: ");
			for (String acheteur : util.getMetriques()._classementAcheteurSuivis){
				System.out.println("    " + acheteur);
			}
			// Return to menu
			choix=0;
			while (choix!=1){
				System.out.println("Entrez [1] pour revenir au menu principal");
				choix=prompt();
			}
			afficherPageAcheteur();
			break;
		case 9:
			ArrayList<Commande> listeCommandes=util.getCommande();
			if(listeCommandes.isEmpty()){
				System.out.println("Vous n'avez pas encore passé de commandes");
				choix=0;
				while(choix!=1){
						System.out.println("Entrez [1] pour revenir au menu principal");
						choix=prompt();}
			afficherPageAcheteur();
			}
			else{
			System.out.println("--------------------------");
				for(int i=0;i<listeCommandes.size();i++){
					Commande commande=listeCommandes.get(i);
					System.out.println("Commande: "+ commande.getID() +"..... contenant "+commande.getProduits().size()+" articles ..... Etat:" +commande.getEtatsCommande()+"         ["+i+"]");}

				System.out.println("--------------------------");

				int choix6=listeCommandes.size()+1;

			while(choix6>listeCommandes.size()){
				System.out.println("Entrez l'index d'une commande pour obtenir plus d'informations");
				System.out.println("Entrez ["+(listeCommandes.size()) + "] pour revenir au menu principal");
				choix6 = prompt();

				if(choix6==(listeCommandes.size())){
					afficherPageAcheteur();
					}
				else if(choix6<= listeCommandes.size()){
					Commande commandeChoisie=listeCommandes.get(choix6);
					ArrayList<Produit> prodAcht = commandeChoisie.getProduits();
					System.out.println("--------------------------");
					System.out.println("     Commande    ");
					System.out.println("Identifiant"+commandeChoisie.getID());
					System.out.println("Prix: "+commandeChoisie.getCout());
					System.out.println("Etat: "+commandeChoisie.getEtatsCommande());
					System.out.println("");
					System.out.println("Adresse de livraison: "+commandeChoisie.getAdresse());
					System.out.println("Telephone: "+commandeChoisie.getTelephone());
					System.out.println("Numero de carte ayant payé: "+commandeChoisie.getCarte().getNumero());
					System.out.println("Information additionelles de livraison: "+commandeChoisie.getInfoLivraison());
					if (commandeChoisie.getEtatsCommande()==EtatsCommande.EnLivraison){
						System.out.println("Numero de suivi de la commande: "+commandeChoisie.getNumSuivi());
						System.out.println("Compagnie d'expedition: "+commandeChoisie.getCompagnieExp());
					}
					System.out.println("");
					System.out.println("     Produits:        ");
					for(int i = 0; i < prodAcht.size(); i++){
							System.out.println(prodAcht.get(i).get_titre());}
					int choix7=6;
					while(choix7>5 || choix7==0){
					System.out.println("--------------------------");

					System.out.println("Entrez [1] pour modifier l'etat de la commande");
					System.out.println("Entrez [2] pour signaler la commande ou un produit de la commande");
					System.out.println("Entrez [3] pour effectuer un retour ou un echange");
					System.out.println("Entrez [4] pour evaluer un produit de la commande");
					System.out.println("Entrez [5] pour revenir au menu principal");
					choix7=prompt();
					if(choix7==1){
						if (commandeChoisie.getEtatsCommande()==EtatsCommande.EnLivraison){
						int choix2=2;
						while(choix2>1){
							System.out.println("Entrez [0] pour confirmer l'arrivee de la commande");
							System.out.println("Entrez [1] pour revenir au menu principal");
							choix2=prompt();
							if(choix2==0){
								commandeChoisie.setEtatsCommande(EtatsCommande.Livre);

								// Notify buyer that order state has been modified
								Notification notification = new Notification(CategorieNotif.CHANGEMENT_ETAT_COMMANDE);
								util.notifications.add(notification);

								// Update buyer's order count in metrics
								int nombreDeCommande = util.getMetriques().getNombreCommandes();
								util.getMetriques().setNombreCommandes(nombreDeCommande - 1);

								System.out.println("Livraison confirme!");
							}
							while (choix2!=1) {
								System.out.println("Entrez [1] pour revenir au menu principal");
								choix2=prompt();}
							afficherPageAcheteur();}}
						else{
							System.out.println("L'etat de cette commande n'est pas modifiable");
							int choix2=2;
							while(choix2!=1){
								System.out.println("Entrez [1] pour revenir au menu principal");
								choix2=prompt();}
						}}

								
							
						
			
					else if(choix7==2){}
					else if(choix7==3){}
					else if(choix7==4){
						System.out.println("--------------------------");
						for(int i = 0; i < prodAcht.size(); i++){
							System.out.println(i + ". " + prodAcht.get(i).get_titre()+"..... "+prodAcht.get(i).get_prix()+"$");}
				 		System.out.println("--------------------------");
						
						int choix8=prodAcht.size()+1;
						while(choix8>prodAcht.size()){
							System.out.println("Entrez l'index d'un produit pour obtenir plus d'informations");
							System.out.println("Entrez ["+ (prodAcht.size()) + "] pour revenir au menu principal");
						choix8 = prompt();
						// Revenir au menu
						if(choix8 == prodAcht.size()) afficherPageAcheteur();

						// Afficher la page du produit
						else if (choix8 < prodAcht.size()) {
						Produit produit = prodAcht.get(choix8);
						systemeCatalogue.afficherProduit(produit);
						System.out.println("Entrez [1] pour evaluer le produit");
						System.out.println("Entrez [2] pour revenir au menu principal");
						int choix5=prompt();
						if(choix5==1){
							System.out.println("Entrez une note sur 5 au produit");
							int note = prompt();
							System.out.println("Voulez-vous ajouter un commentaire?");
							System.out.println("1. Oui");
							System.out.println("2. Non");
							int ajouterCom = 3;
							while(ajouterCom>2){
							ajouterCom = prompt();
							// Ne pas ajouter de commentaire
							if(ajouterCom == 2){
								produit.evaluer(note, "", util);
								// Notify the reseller that there is a new evaluation on his product
								Notification notification = new Notification(CategorieNotif.EVALUATION_PRODUIT);
								produit.getRevendeur().notifications.add(notification);
							}
							// Ajouter un commentaire
							else if (ajouterCom == 1){
								System.out.println("Veuillez ecrire votre commentaire ci-dessous");
								produit.evaluer(note, promptS(), util);
								// Notify the reseller that there is a new evaluation on his product
								Notification notification = new Notification(CategorieNotif.EVALUATION_PRODUIT);
								produit.getRevendeur().notifications.add(notification);
							}
							else{System.out.println("Choix invalide veuillez choisir 1 ou 2");}}
							System.out.println("Votre evaluation a etee ajoutee!");}

						while(choix5!=2){
							System.out.println("Entrez [2] pour revenir au menu principal");
							choix5=prompt();}
						afficherPageAcheteur();}
					
						else{System.out.println("Choix invalide veuillez reessayer");}
						}}
					else{System.out.println("Choix invalide choisir une option entre 1 et 5");}}}
				else{System.out.println("Choix invalide veuillez reessayer");}}}
			
			break;
		case 10:
			systemeCatalogue.deconnexion();
			systemeUtilisateur.deconnexion();
			System.out.println("Merci d'avoir magasine sur UniShop");
			System.exit(0);
			break;
		default:
			System.out.println("Choix invalide, veuillez réessayer.");
			afficherPageAcheteur();
			break;}}}

	// public methods
	public int prompt() {
		try{int choix = scanner.nextInt();
			if (choix<0){throw new InputMismatchException();}
			scanner.nextLine();
			return choix;}
		catch(InputMismatchException e){
			System.out.println("Choix invalide, veuillez réessayer.");
			System.out.println("Entrez le chiffre correspondant a votre choix: ");
			scanner.nextLine();
			return prompt();
		}
	}

	public float promptF() {
		try{float choix = scanner.nextFloat();
			if (choix<0){throw new InputMismatchException();}
			scanner.nextLine();
			return choix;}
		catch(InputMismatchException e){
			System.out.println("Choix invalide, veuillez réessayer.");
			System.out.println("Entrez le chiffre correspondant a votre choix: ");
			scanner.nextLine();
			return prompt();
		}
	}

	public String promptS() {
		try{
			String texte = scanner.nextLine();
			if (texte.length()==0){throw new InputMismatchException();}
			else{
			return texte;}}
		catch(InputMismatchException e){
			System.out.println("Choix invalide, veuillez réessayer.");
			System.out.println("Entrez le texte correspondant à votre reponse: ");
			return promptS();
		}
	}



	public void setUtilisateurConnecte(Utilisateur aNouveau) {
		this.utilisateurConnecte = aNouveau;
	}

	public void entrerInfo(String aTexteEntre) {
		throw new UnsupportedOperationException();
	}
	public void retourAuMenu(int index,String menu){
		try{
		System.out.println("Entrez ["+ index+"] pour revenir au menu "+ menu);
		int choix=prompt();
		if (choix!=index){throw new InputMismatchException();}}

		catch(InputMismatchException e){
			System.out.println("Choix invalide, veuillez réessayer.");
			retourAuMenu(index, menu);
		}
	}
}