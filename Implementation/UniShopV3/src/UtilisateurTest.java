import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class UtilisateurTest {
    Utilisateur utilisateur=new Utilisateur("Tom","tommy@outlook.com","4504448859594","boulevard des lauriers","756trio");
    String modification1="2\nJean\n1\n2\nboulevard de la mer\n2\njean@outlook.com\n2\n1111111\n";
    String modification2="1\n1\n1\n1\n1\n";

    String modification3="2\nTom\n1\n2\nboulevard des lauriers\n2\ntommy@outlook.com\n2\n4504448859594\n";

    @Test
    void TestmodifierProfil(){
        InputStream in = new ByteArrayInputStream((modification1).getBytes());
        System.setIn(in);
        Menu menu = new Menu();
        utilisateur.modifierProfil(menu);
        assertNotEquals("Tom",utilisateur.getNom());
        assertNotEquals("tommy@outlook.com",utilisateur.getCourriel());
        assertNotEquals("4504448859594",utilisateur.getTelephone());
        assertNotEquals("boulevard des lauriers",utilisateur.getAdresse());
        assertEquals("756trio",utilisateur.getMotDePasse());
        assertEquals("Jean",utilisateur.getNom());
        assertEquals("jean@outlook.com",utilisateur.getCourriel());
        assertEquals("1111111",utilisateur.getTelephone());
        assertEquals("boulevard de la mer",utilisateur.getAdresse());

    }
    @Test
    void TestNePasModifierLeProfil(){
        InputStream in = new ByteArrayInputStream((modification2).getBytes());
        System.setIn(in);
        Menu menu = new Menu();
        utilisateur.modifierProfil(menu);
        assertEquals("Tom",utilisateur.getNom());
        assertEquals("tommy@outlook.com",utilisateur.getCourriel());
        assertEquals("4504448859594",utilisateur.getTelephone());
        assertEquals("boulevard des lauriers",utilisateur.getAdresse());
        assertEquals("756trio",utilisateur.getMotDePasse());


    }
    @Test
    void TestModifierLeProfilDeFaconSuccessive(){
        InputStream in = new ByteArrayInputStream((modification2+modification1+modification2+modification1+modification3).getBytes());
        System.setIn(in);
        Menu menu = new Menu();
        for(int i=0;i<5;i++){
        utilisateur.modifierProfil(menu);}
        assertEquals("Tom",utilisateur.getNom());
        assertEquals("tommy@outlook.com",utilisateur.getCourriel());
        assertEquals("4504448859594",utilisateur.getTelephone());
        assertEquals("boulevard des lauriers",utilisateur.getAdresse());
        assertEquals("756trio",utilisateur.getMotDePasse());
    }




}