import java.util.Scanner;

public class Utilisateurs {
    String nom ;
    String addresseCourriel;
    String telephone;

    public void modifierProfil (int choix){
        try (Scanner modif = new Scanner(System.in)) {
            if (choix==1){
                System.out.println("Nom :");
                nom = modif.nextLine();}
            else if (choix==4){
                System.out.println("Adresse couriel :");
                addresseCourriel = modif.nextLine();}
            else if (choix==5){
                System.out.println("Numero de téléphone");
                telephone = modif.nextLine();}
        }


    }
}
