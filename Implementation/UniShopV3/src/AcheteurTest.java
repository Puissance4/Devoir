import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AcheteurTest {

    Acheteur acheteur= new Acheteur("carlthecat","Cat", "Carl", "carl@cat.org", "poisson", "rue 14", "234564357");
    Revendeur revendeur=new Revendeur("Marchand","marchand.k@gmail.com","fruits rouges","rue 78","346753887");
    Produit produit=new Produit("ciseaux", new Papeterie("maped","kikoupefort",PapeterieCategorie.Autre), "rouge", 4, 5.5f, 5, "55","");



    @BeforeEach
    void setUp() {
    }

    @Test
    void testLikeRevendeur() {
        acheteur.setRevendeurLike(revendeur);
        assertEquals(1,acheteur.getRevendeursLike().size());
    }

    @Test
    void testLikeProduit() {
        acheteur.setProduitLike(produit);
        assertEquals(1,acheteur.getProduitsLike().size());
    }

    @Test
    void testAjouterPoint() {
        acheteur.ajouterDesPoints(10);
        assertEquals(10, acheteur.getNombrePoints());
    }
}