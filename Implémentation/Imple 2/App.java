import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class App {
	private static Menu menu1;

	public static void main(String[] args) {
		menu1=new Menu();
		Acheteur acheteur1= new Acheteur("carlthecat","Cat", "Carl", "carl@cat.org", "poisson", "rue 14", "234564357");
		Acheteur acheteur2= new Acheteur("lapinmalin","Champ", "George", "jadorelescarottes@gmail.com", "carotte", "boulevard Laitue", "121212121");
		Acheteur acheteur3= new Acheteur("Lucie45","Desjardin", "Clara", "clara@outlook.fr", "carambar32", "rue des lauriers", "2387436467");//menu1.systemeUtilisateur.listeAcheteurs
		Acheteur acheteur4= new Acheteur("cathlafofolle","Sainte", "Catherine", "caths@gmail.com", "qwerty", "rue sainte-Catherine", "45089736846");
		Acheteur acheteur5= new Acheteur("Camillou32","Hibou", "Camille", "chibou@yahoo.ca", "coucouhibou", "impasse des arbres", "89026547458");
		
		Revendeur revendeur1=new Revendeur("Marchand","marchand.k@gmail.com","fruits rouges","rue 78","346753887");
		Revendeur revendeur2=new Revendeur("Terrier","tttterrier@gmail.com", "batman67","rue des potiers","83745643786");
		Revendeur revendeur3=new Revendeur("Jackson","jackson.jackson@gmail.com", "ilovenyc","7eme avenue","72348945443");
		Revendeur revendeur4=new Revendeur("Dujardin","jdujardin@gmail.com", "Fleur","boulevard Camelia","5643789292");
		Revendeur revendeur5=new Revendeur("Poirier","perry.poirrier@gmail.com", "jeprefereslespommes","rue du verger","567894657");
		Produit produit1=new Produit("ciseaux", new Papeterie(), "rouge", 4, 5.5f, 5, "55","");
		Produit produit2=new Produit("chaise", new EquipementBureau(), "grande avec accoudoirs", 100, 100f, 100, "56","");
		Produit produit3=new Produit("souris", new MaterielInformatique(), "usb", 10, 10.99f, 10, "57","");
		Produit produit4=new Produit("Calcul 1", new Livres(), "en bon etat", 1, 50f, 50, "58","");
		Produit produit5=new Produit("Guide etude chimie 3", new Ressource(), "20 pages", 80, 9.99f, 9, "59","");
		
		acheteur1.setAcheteurLike(acheteur2);//acheteur 1 suit l'acheteur 2
 
		List<Revendeur> liste =Arrays.asList(revendeur1,revendeur2,revendeur3,revendeur4,revendeur5);
		menu1.systemeUtilisateur.listeRevendeurs.addAll(liste);
		List<Acheteur> liste2 =Arrays.asList(acheteur1,acheteur2,acheteur3,acheteur4,acheteur5);
		menu1.systemeUtilisateur.listeAcheteurs.addAll(liste2);
		menu1.afficherMenuPrincipal();
	}
}