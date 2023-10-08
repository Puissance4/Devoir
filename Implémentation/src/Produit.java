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
        Scanner prod = Main.getScanner();
         
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
            System.out.println("Quantité: ");
           quantite= prod.nextInt();
            System.out.println("Prix: ");
            prix= prod.nextFloat();
            prod.nextLine();
        }
       
    public void voirInfo(){
        System.out.println("Titre: "+ titre
            +"\ncatégorie: " + categorie 
            +"\ndescription: " + description 
            +"\nmarque: " + marque 
            + "\nmodèle: " + modele
            +"\nquantité: " + quantite 
            +"\nprix: " + prix);
    }
    }

