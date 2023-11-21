
import javax.xml.transform.Source;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {
    private Utilisateur utilisateurConnecte;
    private HashMap <String,RetourEchange> listeRetour= new HashMap<>();
    private int indexPage = 0;
    public App app;
    public SystemeCatalogue systemeCatalogue = new SystemeCatalogue();
    public SystemeUtilisateur systemeUtilisateur = new SystemeUtilisateur();
    public SystemeGeneral systemeGeneral = new SystemeGeneral();

    private static Scanner scanner = new Scanner(System.in);


    public void afficherMessage(String message) {
        System.out.println(message);
    }

    public void afficherPageAcheteur() {
        Acheteur util = (Acheteur) utilisateurConnecte;
        String prenom = util.getPrenom();
        System.out.println("\n");
        System.out.println("\n---------------------------------------------");
        System.out.println("\nBienvenue sur votre page " + prenom + " !\n");
        System.out.println("1. Consulter le panier");
        System.out.println("2. Afficher le catalogue");
        System.out.println("3. Faire une recherche de produit ");
        System.out.println("4. Faire une recherche de revendeur");
        System.out.println("5. Modifier le profil");
        System.out.println("6. Voir mes notifications");
        System.out.println("7. Voir mes métriques");
        System.out.println("8. Voir mes commandes");
        System.out.println("9. Voir mes retour/echange");
        System.out.println("10. Deconnexion");
        System.out.print("\nVeuillez choisir une option : ");
        this.indexPage = 2;
        selectOption(prompt());
    }

    public void afficherPageRevendeur() {
        Revendeur util = (Revendeur) utilisateurConnecte;
        String nom = util.getNom();
        System.out.println("\n");
        System.out.println("\n---------------------------------------------");
        System.out.println("\nBienvenue sur votre page " + nom + " !\n");
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
        this.indexPage = 1;
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
        this.indexPage = 0;
        selectOption(prompt());
    }

    public void afficherCatalogue() {
        if (systemeCatalogue.getCatalogue().isEmpty()) {
            System.out.println("Désolé nous n'avons pas d'articles disponibles à la vente en ce moment");
        } else {
            System.out.println("--------------------------");
            for (int i = 0; i < systemeCatalogue.getCatalogue().size(); i++) {
                Produit produit = systemeCatalogue.getCatalogue().get(i);
                System.out.println(produit.get_titre() + "..... " + produit.get_prix() + "$        [" + i + "]");
            }

            System.out.println("--------------------------");
            System.out.println("Entrez l'index d'un produit pour obtenir plus d'informations");
        }
    }

    public void selectOption(int option) {
        if (indexPage == 0) {
            switch (option) { // inscription
                case 1:
                    systemeUtilisateur.inscription();
                    break;
                case 2: // connextion
                    try {
                        utilisateurConnecte = systemeUtilisateur.connexion();
                        if (utilisateurConnecte instanceof Revendeur) {
                            afficherPageRevendeur();
                        } else {
                            afficherPageAcheteur();
                        }
                    } catch (IllegalArgumentException exception) {
                        System.out.println(exception);
                    }
                    break;
                case 3: // afficher catalog
                    if (systemeCatalogue.getCatalogue().size() == 0) {
                        System.out.println("Désolé nous n'avons pas d'articles disponibles à la vente en ce moment");
                    } else {
                        for (int i = 0; i < systemeCatalogue.getCatalogue().size(); i++) {
                            Produit produit = systemeCatalogue.getCatalogue().get(i);
                            System.out.println(produit.get_titre() + "..... " + produit.get_prix() + "$");
                        }
                    }

                    int choix = 0;
                    while (choix != 1) {
                        System.out.println("Entrez 1 pour revenir au menu principal");
                        choix = prompt();
                    }
                    afficherMenuPrincipal();
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
                    break;
            }
        } else if (indexPage == 1) { // revendeur
            Revendeur util = (Revendeur) utilisateurConnecte;
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
                        ((Revendeur)utilisateurConnecte).confirmerReceptionRetour(saisirIDCommande());
                        retournerMenuRevendeur();

                    break;
                case 8:
                    afficherCatalogue();
                    System.out.println("Entrez [" + (systemeCatalogue.getCatalogue().size()) + "] pour revenir au menu principal");

                    int choix;
                    choix = prompt();
                    if (choix == (systemeCatalogue.getCatalogue().size())) {
                        afficherPageAcheteur();
                    } else if (choix <= systemeCatalogue.getCatalogue().size()) {
                        Produit produitChoisi = systemeCatalogue.getCatalogue().get(choix);
                        systemeCatalogue.afficherProduit(produitChoisi);
                        System.out.println("Entrez [1] pour revenir au menu principal");
                        choix = prompt();
                        if (choix == 1) {
                            afficherPageRevendeur();
                        }
                    } else if (choix == 2) {
                        afficherPageRevendeur();
                    }

                    break;
                case 9:
                    System.out.println("Merci d'avoir magasine sur UniShop");
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
                    break;
            }
        } else if (indexPage == 2) { // Acheteur
            Acheteur util = (Acheteur) utilisateurConnecte;
            switch (option) {
                case 1:
                    Panier panier = util.getPanier();
                    System.out.println("--------------------------");
                    System.out.println("cout: " + panier.getCout() + "$");
                    System.out.println("Nombre de points bonus: " + panier.getNombrePoints() + "$");
                    System.out.println("Contenu:");
                    for (int i = 0; i < panier.getProduits().size(); i++) {
                        Produit produit = panier.getProduits().get(i);
                        System.out.println(produit.get_titre() + "..... " + produit.get_prix() + "$        [" + i + "]");
                    }
                    System.out.println("--------------------------");
                    System.out.println("Entrez l'index d'un produit pour obtenir plus d'informations ou le supprimer");
                    System.out.println("Entrez [" + (panier.getProduits().size()) + "] pour commander");
                    System.out.println("Entrez [" + (panier.getProduits().size() + 1) + "] pour revenir au menu principal");
                    int choix = prompt();
                    if (choix == (panier.getProduits().size() + 1)) {
                        afficherPageAcheteur();
                    } else if (choix == panier.getProduits().size()) {
                        Commande nouvCommande = panier.commander(util, systemeGeneral);
                        System.out.println("--------------------------");
                        System.out.println("Votre Commande a bien été passée voici son identifiant : " + nouvCommande.getID());
                        System.out.println("Entrez [1] pour revenir au menu principal");
                        choix = prompt();

                        if (choix == 1) {
                            afficherPageAcheteur();

                        }
                    } else if (choix <= panier.getProduits().size()) {
                        Produit produitChoisi = panier.getProduits().get(choix);
                        systemeCatalogue.afficherProduit(produitChoisi);
                        System.out.println("Entrez [1] pour supprimer l'article de votre panier");
                        System.out.println("Entrez [2] pour revenir au menu principal");

                        choix = prompt();

                        if (choix == 1) {
                            panier.retirerDuPanier(produitChoisi);
                            System.out.println("l'article a été supprimé de votre panier!");
                            System.out.println("Entrez [1] pour revenir au menu principal");
                            choix = prompt();

                            if (choix == 1) {
                                afficherPageAcheteur();

                            }
                        } else if (choix == 2) {
                            afficherPageAcheteur();

                        }
                    }

                    break;

                case 2:
                    afficherCatalogue();
                    System.out.println("Entrez [" + (systemeCatalogue.getCatalogue().size()) + "] pour revenir au menu principal");

                    choix = prompt();
                    if (choix == (systemeCatalogue.getCatalogue().size())) {
                        afficherPageAcheteur();
                    } else if (choix <= systemeCatalogue.getCatalogue().size()) {
                        Produit produitChoisi = systemeCatalogue.getCatalogue().get(choix);
                        systemeCatalogue.afficherProduit(produitChoisi);

                        System.out.println("Entrez [1] pour ajouter l'article à votre panier");
                        System.out.println("Entrez [2] pour revenir au menu principal");
                        choix = prompt();
                        if (choix == 1) {
                            produitChoisi.ajouterAuPanier(util);
                            System.out.println("l'article a été ajouté à votre panier!");
                            System.out.println("Entrez [1] pour revenir au menu principal");
                            choix = prompt();
                            if (choix == 1) {
                                afficherPageAcheteur();
                            }
                        } else if (choix == 2) {
                            afficherPageAcheteur();

                        }

                    }

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
                    ArrayList<Commande> listeCommandes = util.getCommande();

                    if (listeCommandes.isEmpty()) {
                        System.out.println("Vous n'avez pas encore passé de commandes");
                    } else {
                        afficherListCommande(listeCommandes);

                        System.out.println("--------------------------");
                        System.out.println("Entrez l'index d'une commande pour obtenir plus d'informations");
                        System.out.println("Entrez [" + (listeCommandes.size()) + "] pour revenir au menu principal");

                        choix = prompt();

                        if (choix == (listeCommandes.size())) {
                            afficherPageAcheteur();
                        } else if (choix <= listeCommandes.size()) {
                            Commande commandeChoisie = listeCommandes.get(choix);
                            ArrayList<Produit> prodAcht = commandeChoisie.getProduits();
                            System.out.println("--------------------------");
                            System.out.println("     Commande    ");
                            System.out.println("Identifiant" + commandeChoisie.getID());
                            System.out.println("Prix: " + commandeChoisie.getCout());
                            System.out.println("Etat: " + commandeChoisie.getEtatsCommande());
                            System.out.println("");
                            System.out.println("Adresse de livraison: " + commandeChoisie.getAdresse());
                            System.out.println("Telephone: " + commandeChoisie.getTelephone());
                            System.out.println("Numero de carte ayant payé: " + commandeChoisie.getCarte().getNumero());
                            System.out.println("Information additionelles de livraison: " + commandeChoisie.getInfoLivraison());
                            if (commandeChoisie.getEtatsCommande() == EtatsCommande.EnLivraison) {
                                System.out.println("Numero de suivi de la commande: " + commandeChoisie.getNumSuivi());
                                System.out.println("Compagnie d'expedition: " + commandeChoisie.getCompagnieExp());
                            }
                            System.out.println("");
                            System.out.println("     Produits:        ");
                            for (int i = 0; i < prodAcht.size(); i++) {
                                System.out.println(prodAcht.get(i).get_titre());
                            }
                            System.out.println("--------------------------");

                            System.out.println("Entrez [1] pour confirmer la reception de la commande");
                            System.out.println("Entrez [2] pour signaler la commande ou un produit de la commande");
                            System.out.println("Entrez [3] pour effectuer un retour ou un echange");
                            System.out.println("Entrez [4] pour evaluer un produit de la commande");
                            System.out.println("Entrez [5] pour revenir au menu principal");

                            choix = prompt();

                            if (choix == 1) { // confirmer la reception de la commande
                                util.confirmerReceptionCommande(commandeChoisie);
                                System.out.println("la reception est confirme ");
                                System.out.println("l'etat de la commande "+ commandeChoisie.getID()+ " est mis a livre ");

                                retournerMenuAcheteur();

                            } else if (choix == 2) {// Signaler une commande

                            } else if (choix == 3) { // retour echange

                                afficherRetourEchange(choix, commandeChoisie);
                                retournerMenuAcheteur();

                            } else if (choix == 4) {
                                System.out.println("--------------------------");
                                for (int i = 0; i < prodAcht.size(); i++) {
                                    System.out.println(i + ". " + prodAcht.get(i).get_titre() + "..... " + prodAcht.get(i).get_prix() + "$");
                                }
                                System.out.println("--------------------------");
                                System.out.println("Entrez l'index d'un produit pour obtenir plus d'informations");
                                System.out.println("Entrez [" + (prodAcht.size()) + "] pour revenir au menu principal");
                                choix = prompt();
                                // Revenir au menu
                                if (choix == prodAcht.size()) afficherPageAcheteur();

                                    // Afficher la page du produit
                                else if (choix < prodAcht.size()) {
                                    Produit produit = prodAcht.get(choix);
                                    systemeCatalogue.afficherProduit(produit);
                                    System.out.println("Entrez [1] pour evaluer le produit");
                                    System.out.println("Entrez [2] pour revenir au menu principal");
                                    choix = prompt();
                                    if (choix == 1) {
                                        System.out.println("Entrez une note sur 5 au produit");
                                        int note = prompt();
                                        System.out.println("Voulez-vous ajouter un commentaire?");
                                        System.out.println("1. Oui");
                                        System.out.println("2. Non");
                                        int ajouterCom = prompt();
                                        // Ne pas ajouter de commentaire
                                        if (ajouterCom == 2) produit.evaluer(note, "", util);
                                            // Ajouter un commentaire
                                        else if (ajouterCom == 1) {
                                            System.out.println("Veuillez ecrire votre commentaire ci-dessous");
                                            produit.evaluer(note, promptS(), util);
                                        } else System.out.println("Option invalide!");
                                        System.out.println("Votre evaluation a etee ajoutee!");
                                        System.out.println("Entrez [1] pour revenir au menu principal");
                                        choix = prompt();
                                        // Revenir au menu
                                        if (choix == 1) {
                                            afficherPageAcheteur();
                                        }
                                    }
                                    // Revenir au menu
                                    else if (choix == 3) {
                                        afficherPageAcheteur();
                                    }
                                }
                            } else if (choix == 5) {
                                afficherPageAcheteur();
                            }

                        }
                    }


                    break;
                case 9:
                    if (((Acheteur) utilisateurConnecte).getListRetourEchange().isEmpty()) {
                        System.out.println(" vous n'avez aucun retour ou echange en cours");
                    }
                    for (RetourEchange retourEchange: ((Acheteur) utilisateurConnecte).getListRetourEchange()) {
                        retourEchange.afficherEtat();
                        retournerMenuAcheteur();
                    }
                    break;
                case 10:
                    System.out.println("Merci d'avoir magasine sur UniShop");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
                    break;
            }
        }
    }

    // public methods
    public int prompt() {
        int choix = 0;
        try {
            choix = scanner.nextInt();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Veuillez saisir un numero valide ");
        }

        return choix;
    }
    public String promptS() {
        return scanner.nextLine();
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

    public void afficherListCommande(ArrayList<Commande> listeCommandes){
        for (int i = 0; i < listeCommandes.size(); i++) {
            Commande commande = listeCommandes.get(i);
            System.out.println("Commande: " + commande.getID() + "..... contenant " + commande.getProduits().size() + " articles ..... Etat:" + commande.getEtatsCommande() + "         [" + i + "]");
        }
    }

    public void setUtilisateurConnecte(Utilisateur aNouveau) {
        this.utilisateurConnecte = aNouveau;
    }

    public void entrerInfo(String aTexteEntre) {
        throw new UnsupportedOperationException();
    }

    public HashMap<String, RetourEchange> getListeRetour() {
        return listeRetour;
    }
}