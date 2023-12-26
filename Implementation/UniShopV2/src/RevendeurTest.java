import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.*;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RevendeurTest {
    Revendeur revendeur = new Revendeur("Terrier", "tttterrier@gmail.com", "batman67", "rue des potiers", "83745643786");
    ArrayList<Produit> produitsDuRevendeur = (ArrayList<Produit>) revendeur.get_produits().clone();
    String ajoutLivre= "Ma vie\n1\n13243\nJean\nBeaux livres\n2\n2004\n07\n01\n1\n1\nTres bon etat\n12\n14\n14\nnon\n";
    @Test
    void testAjoutdeLivre() {

        InputStream in = new ByteArrayInputStream(ajoutLivre.getBytes());
        System.setIn(in);
        Menu menu = new Menu();
        ArrayList<Produit> catalogue= (ArrayList<Produit>) menu.systemeCatalogue.getCatalogue().clone();
        revendeur.ajouterProduit(menu);
        ArrayList<Produit> produitsDuRevendeurapres = revendeur.get_produits();
        assertEquals(1, (produitsDuRevendeurapres.size())-(produitsDuRevendeur.size()));
        assertEquals("Ma vie",produitsDuRevendeurapres.get(0).get_titre());
        assertEquals(1,menu.systemeCatalogue.getCatalogue().size()-catalogue.size());
        assertEquals(14,produitsDuRevendeurapres.get(0).getPointsBonusNormal());
    }

    @Test
    void testAjoutdePromomotionPrix(){


    String ajoutPromotion="1\n1\n9\n12\n";
    InputStream in = new ByteArrayInputStream((ajoutLivre+ajoutPromotion).getBytes());
    System.setIn(in);
    Menu menu = new Menu();
    revendeur.ajouterProduit(menu);
    ArrayList<Produit> catalogue= (ArrayList<Produit>) menu.systemeCatalogue.getCatalogue().clone();
    float prixavant=revendeur.get_produits().get(0).get_prix();
    revendeur.menuPromotion(menu);

    //test fonctionnement de la promotion
    assertNotEquals(prixavant,revendeur.get_produits().get(0).get_prix());

    //test de la fin de la promotion
    Clock realClock = Clock.systemDefaultZone();
    Clock clock = Clock.offset(realClock, Duration.ofDays(13));
    LocalDate dateTest = LocalDate.now(clock);

    assertEquals(prixavant,revendeur.get_produits().get(0).get_prix(dateTest));

    //Tests que nous n'ajoutons pas de produit on modifie bien le produit existant
    assertEquals(0,menu.systemeCatalogue.getCatalogue().size()-catalogue.size());
    assertEquals(1, revendeur.get_produits().size());

}
    @Test
    void testAjoutdePromomotionPoints(){
        String ajoutPromotion="1\n2\n30\n5\n";
        InputStream in = new ByteArrayInputStream((ajoutLivre+ajoutPromotion).getBytes());
        System.setIn(in);
        Menu menu = new Menu();
        revendeur.ajouterProduit(menu);
        ArrayList<Produit> catalogue= (ArrayList<Produit>) menu.systemeCatalogue.getCatalogue().clone();
        float pointsAvant=revendeur.get_produits().get(0).getPointsBonus();
        revendeur.menuPromotion(menu);

        //test fonctionnement de la promotion
        assertNotEquals(pointsAvant,revendeur.get_produits().get(0).getPointsBonus());

        //test de la fin de la promotion
        Clock realClock = Clock.systemDefaultZone();
        Clock clock = Clock.offset(realClock, Duration.ofDays(6));
        LocalDate dateTest = LocalDate.now(clock);

        assertEquals(pointsAvant,revendeur.get_produits().get(0).get_prix(dateTest));

        //Tests que nous n'ajoutons pas de produit on modifie bien le produit existant
        assertEquals(0,menu.systemeCatalogue.getCatalogue().size()-catalogue.size());
        assertEquals(1, revendeur.get_produits().size());
    }



}

