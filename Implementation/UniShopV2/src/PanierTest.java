import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class PanierTest {

    Menu menu;
    Acheteur acheteur;
    Produit produit;
    Papeterie papeterie;
    // Input stream
    String inputCommander1 = "1\n525512125567\n1124\n234\nnon\n1\n";
    String inputCommander2 = "1\n525512125567\n1124\n234\nnon\n2\n";

    @BeforeEach
    void setUp() {
        // Menu
        menu = new Menu();
        // Create the temporary product
        papeterie = new Papeterie("maped", "kikoupefort", "Autre");
        produit = new Produit("ciseaux", papeterie, "rouge", 4, 5.5f, 5, "55", "null");
        // Create the temporary buyer
        acheteur = new Acheteur("SkyLynx47", "Durand",
                "Emilie", "emilie.durand47@example.com",
                "9Kd3f", "rue 14",
                "0612345678");
        // Add the product to the buyer's cart
        acheteur.getPanier().getProduits().add(produit);
    }

    @Test
    void testCommander() {
        InputStream in = new ByteArrayInputStream(inputCommander1.getBytes());
        System.setIn(in);
        acheteur.getPanier().commander(acheteur,menu);
        assertEquals(acheteur.getPanier().getProduits().size(), 0);
    }
    @Test
    void testCommandeAnnuler(){
        InputStream in = new ByteArrayInputStream(inputCommander2.getBytes());
        System.setIn(in);
        acheteur.getPanier().commander(acheteur,menu);
        assertEquals(acheteur.getPanier().getProduits().size(), 1);
    }

    @Test
    void testRetirerDuPanier() {
        acheteur.getPanier().retirerDuPanier(produit);
        assertEquals(acheteur.getPanier().getProduits().size(), 0);
    }

    @Test
    void testAjouter() {
        acheteur.getPanier().retirerDuPanier(produit);
        assertEquals(acheteur.getPanier().getProduits().size(), 0);
        acheteur.getPanier().ajouter(produit);
        assertEquals(acheteur.getPanier().getProduits().size(), 1);
    }
}