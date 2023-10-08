import java.util.ArrayList;
import java.util.Scanner;

public class Revendeur extends Utilisateurs{
    String adresse;
    ArrayList<Produit> produits = new ArrayList<Produit>(); // liste de tout les produits qu'il vend

    public Revendeur (){
        Scanner demande = Main.getScanner();
            System.out.println("Nom :");
            super.nom = demande.nextLine();
            System.out.println("Adresse couriel :");
            super.addresseCourriel = demande.nextLine();
            System.out.println("Numero de téléphone :");
            super.telephone = demande.nextLine();
            System.out.println("Adresse: ");
            adresse= demande.nextLine();

        
    }

    public void modifierProfil (){
        Scanner demande = Main.getScanner();
            System.out.println("Que voulez-vous modifier ?\n"
            +" 1-Nom :" + nom 
            +"\n 3-Adresse :" + adresse 
            + "\n 4-Adresse Courriel :" + addresseCourriel 
            +"\n 5- Numéro de téléphone :" + telephone 
            + "\n Entrez le chiffre correspondant :");
            int choix= demande.nextInt();
            try (Scanner modif = new Scanner(System.in)) {
                if (choix==1 | choix==4 | choix == 5){
                super.modifierProfil(choix);}

                else if (choix == 3) {
                System.out.println("Adresse: ");
                adresse= modif.nextLine();}
            }
        }


    public void ajouterProduit(){
        produits.add(new Produit());
        System.out.println(produits.get(0).titre);
    }
    public void voirProduits(){
        for (int i = 0; i < produits.size(); i++) {
            System.out.println(i+"- "+produits.get(i).titre);
          }
    }
    public void supprimerProduit(){
        voirProduits();
        Scanner demande = Main.getScanner();
        System.out.println("Quel est l'index du produit à supprimer ?");
        int choix= demande.nextInt();
        produits.remove(choix);
        System.out.println("Voici la nouvelle liste des produits:");
        voirProduits();
        
        
    }
    public void voirInfoDuProduit (){
        voirProduits();
        Scanner demande = Main.getScanner();
        System.out.println("Quel est l'index du produit duquel vous voulez les informations ?");
        int choix= demande.nextInt();
        produits.get(choix).voirInfo();

    }
}
