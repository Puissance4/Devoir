public class Produit {
    private String titre;
    private String categorie;
    private String description;
    private String marque;
    private String modele;
    private String identifiant;
    private int quantite;
    private double prix;

    public Produit(String titre, String categorie, String description, String marque, String modele, String identifiant, int quantite, double prix) {
        this.titre = titre;
        this.categorie = categorie;
        this.description = description;
        this.marque = marque;
        this.modele = modele;
        this.identifiant = identifiant;
        this.quantite = quantite;
        this.prix = prix;
    }

    // Getters
    public String getTitre() {
        return titre;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getDescription() {
        return description;
    }

    public String getMarque() {
        return marque;
    }

    public String getModele() {
        return modele;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public int getQuantite() {
        return quantite;
    }

    public double getPrix() {
        return prix;
    }

    // Afficher les informations du produit
    public void afficherInfoProduit() {
        System.out.println("Titre : " + titre);
        System.out.println("Catégorie : " + categorie);
        System.out.println("Description : " + description);
        System.out.println("Marque : " + marque);
        System.out.println("Modèle : " + modele);
        System.out.println("Identifiant : " + identifiant);
        System.out.println("Quantité : " + quantite);
        System.out.println("Prix : " + prix + " CAD");
    }
}
