import java.util.*;
import javax.xml.transform.Source;
import java.io.*;
import java.lang.reflect.Array;

public class Menu {
	private Utilisateur utilisateurConnecte;
	private HashMap <String,RetourEchange> listeRetour= new HashMap<>();
	private int indexPage = 0;
	public App app;
	public SystemeCatalogue systemeCatalogue=new SystemeCatalogue();

	public SystemeUtilisateur systemeUtilisateur=new SystemeUtilisateur(systemeCatalogue.catalogue,systemeCatalogue.listeCommandes);
	public SystemeGeneral systemeGeneral=new SystemeGeneral();



	private static Scanner scanner = new Scanner(System.in);

	public Menu(){
	}
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
		System.out.println("10. Voir mes retour/echange");
		System.out.println("11. Deconnexion");
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
	else if (indexPage==1){ // REVENDEUR
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
			System.out.println("Veillez selectionner le produit dont vous voulez gerer le signalement");
			// Display all the tickets
			int index = 0;
			for (BilletSignalement billet : util.billets){
				System.out.println(index + "." + billet.getProduit());
				index++;
			}
			System.out.println("ou selectionnez " + util.billets.size() + "pour retourner au menu");
			// Select a ticket to process
			int choix2 = util.billets.size() + 1;
			while (choix2 > util.billets.size()){
				choix2 = prompt();
				if (choix2 == util.billets.size()){
					afficherPageRevendeur();
				}
				if (choix2 > util.billets.size()){
					System.out.println("choix ivalide, veillez selectionner un billet");
				}
			}

			BilletSignalement billet = util.billets.get(choix2);
			// Process the reported product
			System.out.println("Entrez la solution du probleme");
			String solution = promptS();
			System.out.println("Entrez le numero de suivi pour une reexpedition a l'entrepot");
			int numSuivi = prompt();
			System.out.println("Entrez le numero de suivi de remplacement du produit");
			int numSuiviRem = prompt();
			util.gererSignalement(billet, solution, numSuivi, numSuiviRem);

			System.out.println("Le problème signalé a été résolu et corrigé");
			// Send the product directly back to the buyer
			billet.getAcheteur().produitsAchetes.add(billet.getProduit());
			// Back to the menu
			afficherPageRevendeur();
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
			int indexNotif = 0;
			for (Notification notification : notifications){
				System.out.println(indexNotif + ": " + notification.getDesc());
				indexNotif++;
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
						produit.getRevendeur().notifier(notification);
					}

					System.out.println("--------------------------");
					System.out.println("Votre Commande a bien été passée voici son identifiant : "+nouvCommande.getID());
					systemeCatalogue.listeCommandes.add(nouvCommande);
				}

				catch(IllegalStateException e){
					System.out.println(e);
				}

				finally{
					int choix2=0;
					while(choix2!=1){
						System.out.println("Entrez [1] pour revenir au menu principal");
						choix2=prompt();
						if(choix2==1){
							afficherPageAcheteur();}}
						}
			}
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
			System.out.println("Entrez un mot clé");
			String motcle=promptS();
			try {
				Produit[] resultat=systemeCatalogue.recherche(motcle);
			} catch (Exception e) {
				System.out.println(e);
			}
			retourAuMenu(1, "d'acheteur");
			afficherPageAcheteur();
			break;
		case 4:
			//recherche revendeur;
			System.out.println("Entrez un nom ou une adresse de recherche");
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
				afficherPageAcheteur();
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
			int indexNotif = 0;
			for (Notification notification : notifications){
				System.out.println(indexNotif + ": " + notification.getDesc());
				indexNotif++;
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
								util.notifier(notification);

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
					else if(choix7==2){
						boolean signaler = true;
						BilletSignalement billet = new BilletSignalement();
						billet.setAcheteur(util);

						System.out.println("Veillez selectionner la commande a signaler:");
						// Display all orders
						for (int i = 0; i < listeCommandes.size(); i++) {
							System.out.println(i + "." + listeCommandes.get(i));
						}
						System.out.println("ou entrez " + listeCommandes.size() + "pour revenir au menu");
						// Choose an order to report or comeback to menu
						int choix2 = listeCommandes.size() + 1;
						while (choix2 > listeCommandes.size()) {
							choix2 = prompt();
							if (choix2 == listeCommandes.size()) {
								afficherPageAcheteur();
							}
							if (choix2 > listeCommandes.size()){
								System.out.println("choix invalide, veillez selectionner une commande");
							}
						}
						// Select the order
						Commande commandeSignale = listeCommandes.get(choix2);
						while(signaler) {
							System.out.println("Choisissez le produit que vous voulez signaler: ");
							ArrayList<Produit> listeProd = commandeSignale.getProduits();
							for (int j = 0; j < listeProd.size(); j++){
								System.out.println(j + "." + listeProd.get(j));
							}
							System.out.println("ou entrez" + listeProd.size() + "pour revenir au menu");
							// Choose a product to report or comeback to menu
							choix2 = listeProd.size() + 1;
							while (choix2 > listeProd.size()){
								choix2 = prompt();
								if (choix2 == listeProd.size()){
									afficherPageAcheteur();
								}
								if (choix2 > listeProd.size()){
									System.out.println("choix invalide, veillez selectionner un produit present dans la commande");
								}
							}
							Produit produitSignale = listeProd.get(choix2);
							// Create the report ticket
							billet.setProduit(produitSignale);
							System.out.println("Veillez decrire le motif de votre sigalement:");
							String description = promptS();
							billet.setDescProbleme(description);

							// Send the report to the reseller
							produitSignale.getRevendeur().billets.add(billet);
							System.out.println("voulez-vous siganler un autre produit de votre commande?");
							System.out.println("1.OUI");
							System.out.println("2.NON");
							choix2 = prompt();
							if (choix2 == 2) signaler = false;
						}
						System.out.println("Votre signalement a ete envoye");
						afficherPageAcheteur();
					}
					else if(choix7==3){
						afficherRetourEchange(choix7, commandeChoisie);
						retournerMenuAcheteur();

					}
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
								produit.getRevendeur().notifier(notification);
							}
							// Ajouter un commentaire
							else if (ajouterCom == 1){
								System.out.println("Veuillez ecrire votre commentaire ci-dessous");
								produit.evaluer(note, promptS(), util);
								// Notify the reseller that there is a new evaluation on his product
								Notification notification = new Notification(CategorieNotif.EVALUATION_PRODUIT);
								produit.getRevendeur().notifier(notification);
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
			if (((Acheteur) utilisateurConnecte).getListRetourEchange().isEmpty()) {
				System.out.println(" vous n'avez aucun retour ou echange en cours");
			}
			for (RetourEchange retourEchange: ((Acheteur) utilisateurConnecte).getListRetourEchange()) {
				retourEchange.afficherEtat();
				retournerMenuAcheteur();
			}
			break;
		case 11:
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
		try{
			 int choix = scanner.nextInt();
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
		try{
			float choix = scanner.nextFloat();
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
	public void afficherRetourEchange(int choix, Commande commande) {
		System.out.println(" veuillez choisir les choix suivants: ");
		System.out.println("Entrez [1] pour faire un retour ");
		System.out.println("Entrez [2] pour faire une echange ");
		System.out.println("Entrez [3] pour revenir au menu principal ");
		choix = prompt();
		switch (choix) {
			case 1:
				retour(commande);
				break;
			case 2:

				echange(commande);
				break;
			case 3:
				afficherPageAcheteur();
				break;
			default:
				System.out.println("veuillez saisir un nombre valide : numero 1 ou 2");
				afficherRetourEchange(choix, commande);
		}
	}
	public int[] choisirProduitRetour(Commande commande) {
		System.out.println("     Produits:        ");
		for (int i = 0; i < commande.getProduits().size(); i++) {
			System.out.println(commande.getProduits().get(i).get_titre() + "-------" + i);
		}
		String choix = promptS();
		int[] choixMultiple = new int[0];
		try {
			String temp [] = (choix.split(" "));
			choixMultiple = new int[temp.length];
			for (int i = 0; i < temp.length; i++) {
				if (Integer.parseInt(temp[i]) > commande.getProduits().size() || Integer.parseInt(temp[i]) < 0) {
					System.out.println(" Veuillez choisir un numero valide entre 0 et "+ (commande.getProduits().size() - 1) );
					choisirProduitRetour(commande);
				}else {
					choixMultiple[i] = Integer.parseInt(temp[i]);
				}
			}
		} catch (Exception e) {
			System.out.println("Veuillez saisir un numero valide ");
		}
		return choixMultiple;

	}
	public Produit [] choisirProduitEchange(Commande commande){

		int choix =0;
		Produit [] produits = new Produit[0];
		if (systemeCatalogue.getCatalogue().isEmpty()) {
			System.out.println("Désolé nous n'avons pas d'articles disponibles à la vente en ce moment");
			System.out.println("Entrez [1] pour faire un retour seulement au lieu ");
			System.out.println("Entrez [2] revenir a la page principal  ");
			choix = prompt();
			switch (choix) {
				case 1:
					retour(commande);
					break;
				case 2:
					afficherPageAcheteur();
					break;
				default:
					System.out.println(" Veuillez saisir une nombre valide ");
					choisirProduitEchange(commande);
					break;
			}
		} else {

			// affichage catalogue
			System.out.println("--------------------------");
			System.out.println("Veuillez choisir le(s) produits pour qu'on vous retourne, un espace entre chaque nombre pour prendre plusieurs ");
			for (int i = 0; i < systemeCatalogue.getCatalogue().size(); i++) {
				Produit produit = systemeCatalogue.getCatalogue().get(i);
				System.out.println(produit.get_titre() + "..... " + produit.get_prix() + "$        [" + i + "]");
			}
			System.out.println("--------------------------");


			String choixS = promptS();
			int[] choixMultiple = new int[0];
			try {
				String temp [] = (choixS.split(" "));
				choixMultiple = new int[temp.length];
				for (int i = 0; i < temp.length; i++) {
					if (Integer.parseInt(temp[i]) > systemeCatalogue.getCatalogue().size() || Integer.parseInt(temp[i]) < 0) {
						System.out.println(" Veuillez choisir un numero valide entre 0 et "+ (systemeCatalogue.getCatalogue().size() - 1) );
						choisirProduitRetour(commande);
					}else {
						choixMultiple[i] = Integer.parseInt(temp[i]);
					}
				}
				produits = new Produit[choixMultiple.length];

				for (int i = 0; i < choixMultiple.length ; i++) {
					produits[i] =  systemeCatalogue.getCatalogue().get(choixMultiple[i]);
				}
			} catch (Exception e) {
				System.out.println("Veuillez saisir un numero valide ");
			}
		}
		return produits ;
	}
	public void retour(Commande commande){
		System.out.println(" Choisir un produit pour le retour , pour le retour de plusieurs produits, mettre une espace entre chaque nombre");
		Retour retour = new Retour(commande, choisirProduitRetour(commande));
		retour.effectuerRetour();
		listeRetour.put(retour.getCommande().getID(), retour);
		((Acheteur) utilisateurConnecte).getListRetourEchange().add(retour);
	}
	public void echange(Commande commande){
		System.out.println(" Choisir un produit pour le echange, , pour l'echange de plusieurs produits, mettre une espace entre chaque nombre");
		Echange echange = new Echange(commande,choisirProduitRetour(commande ), choisirProduitEchange(commande));
		echange.effectuerEchange();
		listeRetour.put(echange.getCommande().getID(), echange);
		((Acheteur) utilisateurConnecte).getListRetourEchange().add(echange);
	}
	public RetourEchange saisirIDCommande(){
		System.out.println(" Veuillez saisir ID de la commande : ");
		String ID = promptS();
		try{
			if ( listeRetour.get(ID) == null) {
				System.out.println("ID non valide ");
				System.out.println("Entrez [1] pour reessayer ");
				System.out.println("Entrez [2] pour retourner au menu principal");
				int choix = prompt();
				switch(choix) {
					case 1:
						saisirIDCommande();
						break;
					case 2:
						afficherPageRevendeur();
						break;
					default:
						System.out.println("choix invalide , veuillez reesayer");
						break;
				}
				saisirIDCommande();
			} else if (listeRetour.isEmpty()) {
				System.out.println(" il y a aucune retour ou echange");
			}

		}catch (Exception e) {
			System.out.println(" Erreur input , veuillez reessayer" );
		}

		return listeRetour.get(ID);
	}

	public void retournerMenuAcheteur(){
		System.out.println(" voulez vous retourner au menu principal ou quitter ");
		System.out.println("Entrez [1] pour retourner au menu principal ");
		System.out.println("Entrez [2] pour quitter ");
		int choix = prompt();
		switch (choix) {
			case 1:
				afficherPageRevendeur();
				break;
			case 2:
				System.out.println("Merci d'avoir magasine sur UniShop");
				System.exit(0);
				break;
			default:
				System.out.println(" Veuillez saisir une nombre valide ");
				retournerMenuAcheteur();
				break;
		}
	}

	public void retournerMenuRevendeur(){
		System.out.println(" voulez vous retourner au menu principal ou quitter ");
		System.out.println("Entrez [1] pour retourner au menu principal ");
		System.out.println("Entrez [2] pour quitter ");
		int choix = prompt();
		switch (choix) {
			case 1:
				afficherPageRevendeur();
				break;
			case 2:
				System.out.println("Merci d'avoir magasine sur UniShop");
				System.exit(0);
				break;
			default:
				System.out.println(" Veuillez saisir une nombre valide ");
				retournerMenuAcheteur();
				break;
		}
	}
}