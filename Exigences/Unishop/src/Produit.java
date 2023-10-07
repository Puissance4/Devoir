import java.util.Scanner;

public class Produit {
    String titre ;
    String categorie;
    String description;
    String marque;
    String modele;
    String identifiant;
    int quantite;
    float prix;

    public Produit (){
        try (Scanner prod = new Scanner(System.in)) {
            System.out.println("Titre: ");
            titre= prod.nextLine();
            System.out.println("catégorie :");
            categorie = prod.nextLine();
            System.out.println("Description: ");
            description= prod.nextLine();
            System.out.println("Marque :");
            marque = prod.nextLine();
            System.out.println("Modèle :");
            modele= prod.nextLine();
            //System.out.println("Quantité: ");
           // quantite= demande.nextInt();
           // System.out.println("Prix: ");
           // prix= demande.nextFloat();
        }

    }
}
