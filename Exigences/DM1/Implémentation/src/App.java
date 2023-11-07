import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static ArrayList<Utilisateur> utilisateurs = new ArrayList<>();
    private static ArrayList<Produit> catalogue = new ArrayList<>();
    private static ArrayList<Produit> panier = new ArrayList<>();
    private static Utilisateur utilisateurConnecte = null;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initialiserCatalogue();

        while (true) {
            afficherMenuPrincipal();

            int choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    inscription();
                    break;
                case 2:
                    connexion();
                    break;
                case 3:
                    afficherCatalogue();
                    break;
                case 4:
                    consulterPanier();
                    break;
                case 5:
                    passerCommande();
                    break;
                case 6:
                    modifierProfil();
                    break;
                case 7:
                    ajouterProduit();
                    break;
                case 8:
                    quitter();
                    break;
                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
                    break;
            }
        }
    }

    private static void afficherMenuPrincipal() {
        System.out.println("\nBienvenue sur UniShop !\n");
        System.out.println("1. S'inscrire");
        System.out.println("2. Se connecter");
        System.out.println("3. Afficher le catalogue");
        System.out.println("4. Consulter le panier");
        System.out.println("5. Passer commande");
        System.out.println("6. Modifier le profil");
        System.out.println("7. Ajouter un produit");
        System.out.println("8. Quitter");
        System.out.print("\nVeuillez choisir une option : ");
    }
    
    // Ajoute des produits au catalogue lors du démarrage de l'application.
    private static void initialiserCatalogue() {
        catalogue.add(new Produit("Produit 1", "Catégorie 1", "Description 1", "Marque 1", "Modèle 1", "ID-001", 10, 10.0));
        catalogue.add(new Produit("Produit 2", "Catégorie 2", "Description 2", "Marque 2", "Modèle 2", "ID-002", 15, 15.0));
        catalogue.add(new Produit("Produit 3", "Catégorie 3", "Description 3", "Marque 3", "Modèle 3", "ID-003", 20, 20.0));
        catalogue.add(new Produit("Produit 4", "Catégorie 4", "Description 4", "Marque 4", "Modèle 4", "ID-004", 25, 25.0));
    }

    // Permet à un utilisateur de s'inscrire en saisissant ses informations.
    private static void inscription() {
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Prénom : ");
        String prenom = scanner.nextLine();
        System.out.print("Email : ");
        String email = scanner.nextLine();
        System.out.print("Mot de passe : ");
        String motDePasse = scanner.nextLine();
        System.out.println("Adresse : ");
        String adresse = scanner.nextLine();
        System.out.println("Téléphone : ");
        String telephone = scanner.nextLine();

        Utilisateur nouvelUtilisateur = new Utilisateur(nom, prenom, email, motDePasse, adresse, telephone);
        utilisateurs.add(nouvelUtilisateur);

        System.out.println("Inscription réussie !");
    }

    // Permet à un utilisateur de se connecter en saisissant son email et son mot de passe.
    private static void connexion() {
        System.out.print("Email : ");
        String email = scanner.nextLine();
        System.out.print("Mot de passe : ");
        String motDePasse = scanner.nextLine();

        for (Utilisateur utilisateur : utilisateurs) {
            if (utilisateur.seConnecter(email, motDePasse)) {
                utilisateurConnecte = utilisateur;
                System.out.println("Connexion réussie !");
                return;
            }
        }

        System.out.println("Email ou mot de passe incorrect.");
    }
        
    // Affiche le catalogue de produits et permet à l'utilisateur d'en consulter les détails.
    private static void afficherCatalogue() {
        System.out.println("\nCatalogue de produits :");
        for (int i = 0; i < catalogue.size(); i++) {
            System.out.println((i + 1) + ". " + catalogue.get(i).getTitre() + " - " + catalogue.get(i).getPrix() + " CAD");
        }
    
        System.out.print("\nSélectionnez un produit pour consulter ses informations (numéro) : ");
        int choix = scanner.nextInt();
        scanner.nextLine();
    
        if (choix >= 1 && choix <= catalogue.size()) {
            Produit produit = catalogue.get(choix - 1);
            System.out.println("\nInformations sur le produit sélectionné :");
            produit.afficherInfoProduit();
    
            System.out.print("\nVoulez-vous ajouter ce produit au panier ? (Oui/Non) : ");
            String reponse = scanner.nextLine();
            if (reponse.equalsIgnoreCase("Oui")) {
                panier.add(produit);
                System.out.println("\nLe produit a été ajouté au panier.");
            } else {
                System.out.println("\nLe produit n'a pas été ajouté au panier.");
            }
        } else {
            System.out.println("Choix invalide.");
        }
    }    

    // Permet d'ajouter un produit au catalogue.
    public static void ajouterProduit(){
        System.out.println("\nAjouter un produit");
        System.out.println("Titre : ");
        String titre = scanner.nextLine();
        System.out.println("Catégorie : ");
        String categorie = scanner.nextLine();
        System.out.println("Description : ");
        String description = scanner.nextLine();
        System.out.println("Marque : ");
        String marque = scanner.nextLine();
        System.out.println("Modèle : ");
        String modele = scanner.nextLine();
        System.out.println("Identifiant : ");
        String identifiant = scanner.nextLine();
        System.out.println("Quantité : ");
        int quantite = scanner.nextInt();
        System.out.println("Prix : ");
        double prix = scanner.nextDouble();

        Produit nouveauProduit = new Produit(titre, categorie, description, marque, modele, identifiant, quantite, prix);
        catalogue.add(nouveauProduit);

        System.out.println("\nProduit ajouté avec succès !");
    }

    // Permet à l'utilisateur de consulter le contenu de son panier et de vider le panier si nécessaire.
    private static void consulterPanier() {
        System.out.println("\nContenu du panier :");
        for (Produit produit : panier) {
            System.out.println(produit.getTitre() + " - " + produit.getPrix() + " CAD");
        }
        System.out.println("\nMontant total : " + calculerMontantTotal() + " CAD");
        System.out.println("\n Voulez-vous vider le panier ? (Oui/Non) :");
        String reponse = scanner.nextLine();
        if (reponse.equalsIgnoreCase("Oui")) {
            panier.clear();
            System.out.println("\nLe panier a été vidé.");
        } else {
            System.out.println("\nLe panier n'a pas été vidé.");
        }
    }

    // Calcule le montant total des produits dans le panier.
    private static String calculerMontantTotal() {
        double montantTotal = 0.0;
        for (Produit produit : panier) {
            montantTotal += produit.getPrix();
        }
        return String.valueOf(montantTotal);
    }

    // Permet à l'utilisateur de passer une commande et vide le panier.
    private static void passerCommande() {
        System.out.println("\nCommande passée avec succès !");
        panier.clear();
    }

    // Permet à l'utilisateur de modifier son profil.
    private static void modifierProfil() {
        if (utilisateurConnecte == null) {
            System.out.println("\nVous devez vous connecter pour modifier votre profil.");
            return;
        }
    
        System.out.println("Modification de profil pour " + utilisateurConnecte.getNom() + " " + utilisateurConnecte.getPrenom());
    
        System.out.print("Nouveau nom : ");
        String nouveauNom = scanner.nextLine();
        utilisateurConnecte.setNom(nouveauNom);
    
        System.out.print("Nouveau prénom : ");
        String nouveauPrenom = scanner.nextLine();
        utilisateurConnecte.setPrenom(nouveauPrenom);
    
        System.out.print("Nouvel email : ");
        String nouvelEmail = scanner.nextLine();
        utilisateurConnecte.setEmail(nouvelEmail);
    
        System.out.print("Nouveau mot de passe : ");
        String nouveauMotDePasse = scanner.nextLine();
        utilisateurConnecte.setMotDePasse(nouveauMotDePasse);
    
        System.out.println("Profil mis à jour avec succès !");
    }

    // Permet à l'utilisateur de quitter l'application.
    private static void quitter() {
        System.out.println("\nMerci d'avoir utilisé notre site. À bientôt !");
        System.exit(0);
    }
}
