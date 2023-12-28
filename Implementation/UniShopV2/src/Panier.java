import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.InputMismatchException;

public class Panier {
	private float cout=0f;
	private int nombreDePoints=0;
	private ArrayList<Produit> produits=new ArrayList<Produit>();
	private String acheteur;
	public Panier(String acheteur) {
		this.acheteur=acheteur;
	}
	public Panier(String [] donnee,ArrayList<Produit> catalogue){
		this.acheteur=donnee[0];
		String[] prod=donnee[1].split(";");
		if (!(prod[0].equals("null"))){
		for (Produit produit : catalogue) {
			for (int i=0;i<prod.length;i++){
				if (produit.getIdentifiant().equals(prod[i])) {
					this.produits.add(produit);}
				}
			}}
		this.nombreDePoints=Integer.parseInt(donnee[2]);
		this.cout=Float.parseFloat(donnee[3]);
				
		}

	public Commande commander(Acheteur acheteur,Menu menu){
		if (produits.isEmpty()){
			throw new IllegalStateException("il faut que le panier contienne au moins 1 produit pour commander");
		}
		else{
			String adresse= acheteur.getAdresse();
			String telephone= acheteur.getTelephone();
			System.out.println("Souhaitez vous commander avec cette adresse: "+ adresse);
			System.out.println("Et ce numéro de téléphone: "+ telephone);
			System.out.println("Entrez [1] si oui et [2] si non : ");
			int choix = nextChoixI(menu);
			if (choix==2){
				System.out.println("Entrez l'adresse pour la commande: ");
				adresse=nextChoixS(menu);
				System.out.println("Entrez le numéro de téléphone pour la commande: ");
				telephone=nextChoixS(menu);
			}
			if (choix==1 || choix==2){
				System.out.println("Entrez le numéro de carte pour la commande: ");
				String numCarte=nextChoixS(menu);
				System.out.println("Entrez la date d'expiration de la carte: ");
				String dateExp=nextChoixS(menu);
				System.out.println("Entrez le numéro de confirmation de la carte: ");
				String numConf=nextChoixS(menu);
				System.out.println("Avez vous des informations supplémentaires pour la livraison? (Entrez non si ce n'est pas le cas): ");
				String infoSupp=nextChoixS(menu);
				Carte carte=new Carte(dateExp, numCarte, numConf, acheteur.getPseudo());

				System.out.println("Entrez [1] pour confirmer la commande ou [2] pour annuler et revenir au panier");
				int choix1=nextChoixI(menu);

				if (choix1==2){
					return null;
				}
				else if (choix1==1){
					boolean verif=menu.systemeGeneral.verifierCarte(carte);
					while (verif){
						if (!verif){
							System.out.println("Carte invalide, veillez ressayer");
							System.out.println("Entrez le numéro de carte pour la commande: ");
							numCarte=nextChoixS(menu);
							System.out.println("Entrez la date d'expiration de la carte: ");
							dateExp=nextChoixS(menu);
							System.out.println("Entrez le numéro de confirmation de la carte: ");
							numConf=nextChoixS(menu);
							// Create new card
							carte = new Carte(dateExp, numCarte, numConf, acheteur.getPseudo());
							// Verify the card
							verif = menu.systemeGeneral.verifierCarte(carte);
						}
						else{
							String identifiant = menu.systemeGeneral.creerID();
							Commande commande = new Commande(produits, acheteur, adresse, telephone, carte, identifiant, infoSupp);
							if (!menu.systemeGeneral.verifierCommande(commande)) {
								System.out.println("Aucun produit dans la commande");
							}
							else{
								acheteur.addCommande(commande);
								// Update buyer's metrics
								// Update order number
								int nombreDeCommande = acheteur.getMetriques().getNombreCommandes();
								acheteur.getMetriques().setNombreCommandes(nombreDeCommande + 1);
								// Update purchased products number
								int nombreProduitAchete = acheteur.getMetriques().getNombreArticles();
								acheteur.getMetriques().setNombreArticles(nombreProduitAchete + produits.size());

								// Update sellers metrics
								for (Produit produit : produits) {
									// Update number of products sold
									int nombreAricleVendu = produit.getRevendeur().getMetriques().getNombreProduitsVendus();
									produit.getRevendeur().getMetriques().setNombreProduitsVendus(nombreAricleVendu + 1);
									// Update number of products offered
									int nombreArticleOffert = produit.getRevendeur().getMetriques().getNombreArticles();
									produit.getRevendeur().getMetriques().setNombreArticles(nombreArticleOffert - 1);
									// Update reseller's revenue
									float prixProduit = produit.get_prix();
									float revenuRevendeur = produit.getRevendeur().getMetriques().getRevenu();
									produit.getRevendeur().getMetriques().setRevenu(revenuRevendeur + prixProduit);
								}

								// Remove all the products from the list after they have been ordered
								// starting from the last element to prevent indexing errors
								for (int i = acheteur.getPanier().getProduits().size() - 1; i >= 0; i--){
									acheteur.getPanier().retirerDuPanier(acheteur.getPanier().getProduits().get(i));
								}
								verif = false;
								return commande;
							}
						}
					}
				}
				else System.out.println("Choix invalide");
				return null;
			}
		}
		System.out.println("test");
        return null;
    }

	public ArrayList<Produit> getProduits() {
		return this.produits;
	}
	public float getCout(){
		return this.cout;
	}
	public int getNombrePoints(){
		return this.nombreDePoints;
	}


	public void retirerDuPanier(Produit produit) {
		this.produits.remove(produit);
		cout=cout-produit.get_prix();
		nombreDePoints=nombreDePoints-produit.getPointsBonus();
		
	}
	public void ajouter(Produit produit){
		this.produits.add(produit);
		this.cout=cout+produit.get_prix();
		this.nombreDePoints=nombreDePoints+produit.getPointsBonus();
	}

	public String getPanierBuff(){
		//pseudo,produits,nbPoints,prix
		String liste="null";
		if (produits.size()!=0){
			liste=produits.get(0).getIdentifiant();
			for (int i=1;i<produits.size();i++) {
				liste=liste+";"+produits.get(i).getIdentifiant();
				}
			}
		return (acheteur+","+liste+","+nombreDePoints+","+cout);
	}
	protected String nextChoixS(Menu menu){
        return menu.promptS();
	}
	protected int nextChoixI(Menu menu){
		return menu.prompt();
	}
}