
public class Main {
    public static void main(String[] args) {
        
        System.out.println(" hello" );
        //Acheteur test= new Acheteur();
        //test.modifierProfil();
        Revendeur test2= new Revendeur();
        Produit nouveau=test2.ajouterProduit();
        System.out.println(nouveau.titre);
    }

}