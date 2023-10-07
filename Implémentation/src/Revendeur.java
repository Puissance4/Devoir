import java.util.Scanner;

public class Revendeur extends Utilisateurs{
    String adresse;
    public Revendeur (){
        try (Scanner demande = new Scanner(System.in)) {
            System.out.println("Nom :");
            super.nom = demande.nextLine();
            System.out.println("Adresse couriel :");
            super.addresseCourriel = demande.nextLine();
            System.out.println("Numero de téléphone :");
            super.telephone = demande.nextLine();
            System.out.println("Adresse: ");
            adresse= demande.nextLine();
        }
    }

    public void modifierProfil (){
        try (Scanner demande = new Scanner(System.in)) {
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

    }
    public Produit ajouterProduit(){
       return new Produit();
    }
}
