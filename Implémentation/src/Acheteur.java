import java.util.Scanner;

public class Acheteur extends Utilisateurs{

    String prenom;
    String pseudo;
    String addresseExpedition;

    public Acheteur (){
        try (Scanner demande = new Scanner(System.in)) {
            System.out.println("Prénom: ");
            prenom= demande.nextLine();
            System.out.println("Nom :");
            super.nom = demande.nextLine();
            System.out.println("Pseudo: ");
            pseudo= demande.nextLine();
            System.out.println("Adresse couriel :");
            super.addresseCourriel = demande.nextLine();
            System.out.println("Numero de téléphone");
            super.telephone = demande.nextLine();
            System.out.println("Adresse d'expedition: ");
            addresseExpedition= demande.nextLine();
        }

       // System.out.println(nom + " " + prenom + " " + pseudo + " " + addresseCourriel + " " + telephone + " " + addresseExpedition);


    }

    public void modifierProfil (){
        try (Scanner demande = new Scanner(System.in)) {
            System.out.println("Que voulez-vous modifier ?\n"
            +"1-Nom :" + nom 
            +"\n 2-Prenom :" + prenom 
            +"\n 3-Pseudo :" + pseudo 
            + "\n 4-Adresse Courriel :" + addresseCourriel 
            +"\n 5- Numéro de téléphone :" + telephone 
            +"\n 6- L'adresse d'expédition :" + addresseExpedition 
            + "\n Entrez le chiffre correspondant :");
            int choix= demande.nextInt();
            try (Scanner modif = new Scanner(System.in)) {
                if (choix==1 | choix==4 | choix == 5){
                super.modifierProfil(choix);}

                else if (choix == 2) {
                System.out.println("Prénom: ");
                prenom= modif.nextLine();}

                else if (choix==3){
                System.out.println("Pseudo: ");
                pseudo= modif.nextLine();}
     
                else if (choix==6){
                System.out.println("Adresse d'expedition: ");
                addresseExpedition= modif.nextLine();}
            }
        }

    }

    public void likeProduit (){

    }
    public void recherche (){

    }
    public void evaluation (){

    }
    public void commander (){

    }

}
