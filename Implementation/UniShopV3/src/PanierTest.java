import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PanierTest {

    Acheteur acheteur;
    Produit produit;
    Papeterie papeterie;
    // Input stream
    String inputCommander1 = "1\n525512125567\n1124\n234\nnon\n1\n";
    String inputCommander2 = "1\n525512125567\n1124\n234\nnon\n2\n";
    private InputStream oldIn;

    @BeforeEach
    void setUp() {
        // Save System.in state
        oldIn = System.in;
        // Create product's reseller
        Revendeur revendeur = new Revendeur("Bob", "bob@gmail.com","boB","1 rue bob", "123");
        // Create the temporary product
        papeterie = new Papeterie("maped", "kikoupefort", "Autre");
        produit = new Produit("ciseaux", papeterie, "rouge", 4, 5.5f, 5, "55", "null");
        produit.setRevendeur(revendeur);
        // Create the temporary buyer
        acheteur = new Acheteur("SkyLynx47", "Durand",
                "Emilie", "emilie.durand47@example.com",
                "9Kd3f", "rue 14",
                "0612345678");
        // Add the product to the buyer's cart
        acheteur.getPanier().getProduits().add(produit);
    }
    @AfterEach
    public void tearDown() {
        System.setIn(oldIn);
    }
    @Test
    void testCommander() {
        InputStream in = new ByteArrayInputStream(inputCommander1.getBytes());
        System.setIn(in);
        Menu menu = new Menu();
        acheteur.getPanier().commander(acheteur,menu);
        assertEquals(acheteur.getPanier().getProduits().size(), 0);
    }
    @Test
    void testCommandeAnnuler() throws IOException {
        InputStream in = new ByteArrayInputStream(inputCommander2.getBytes());
        System.setIn(in);
        Menu menu = new Menu();
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