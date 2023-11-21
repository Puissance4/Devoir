import java.util.ArrayList;
import java.util.List;

public class Revendeur extends Utilisateur {
    private List<Produit> produits;

    public Revendeur(String nom, String prenom, String email, String motDePasse, String adresse, String telephone) {
        super(nom, prenom, email, motDePasse, adresse, telephone);
        produits = new ArrayList<>();
    }

    public void ajouterProduit(Produit produit) {
        produits.add(produit);
    }

    public void modifierProduit(int index, Produit nouveauProduit) {
        if (index >= 0 && index < produits.size()) {
            produits.set(index, nouveauProduit);
        }
    }

    public void supprimerProduit(int index) {
        if (index >= 0 && index < produits.size()) {
            produits.remove(index);
        }
    }

    public List<Produit> getProduits() {
        return produits;
    }
}
