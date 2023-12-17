import java.util.ArrayList;

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

	public Commande commander(Acheteur acheteur,Menu menu) throws IllegalStateException {
		if (produits.size()==0){
			throw new IllegalStateException("il faut que le panier contienne au moins 1 produit pour commander");
		}
		else{
			String adresse= acheteur.getAdresse();
			String telephone= acheteur.getTelephone();
			System.out.println("Souhaitez vous commander avec cette adresse: "+ adresse);
			System.out.println("Et ce numéro de téléphone: "+ telephone);
			System.out.println("Entrez [1] si oui et [2] si non : ");
			int choix = menu.prompt();
			if (choix==2){
				System.out.println("Entrez l'adresse pour la commande: ");
				adresse=menu.promptS();
				System.out.println("Entrez le numéro de téléphone pour la commande: ");
				telephone=menu.promptS();
			}
			if (choix==1 ||choix==2){
				menu.promptS();
				System.out.println("Entrez le numéro de carte pour la commande: ");
				String numCarte=menu.promptS();
				System.out.println("Entrez la date d'expiration de la carte: ");
				String dateExp=menu.promptS();
				System.out.println("Entrez le numéro de confirmation de la carte: ");
				String numConf=menu.promptS();
				System.out.println("Avez vous des informations supplémentaires pour la livraison? (Entrez non si ce n'est pas le cas): ");
				String infoSupp=menu.promptS();
				Carte carte=new Carte(dateExp, numCarte, numConf, acheteur.getPseudo());
				System.out.println("Entrez [1] pour confirmer la commande ou [2] pour annuler et revenir au panier");
				choix=menu.prompt();
				if (choix==2){
					throw new IllegalArgumentException("retour au panier");
				}
				else if (choix==1){
					Boolean verif=menu.systemeGeneral.verifierCarte(carte);
					if (verif==false){}
					else{
						String identifiant=menu.systemeGeneral.creerID();
						Commande commande= new Commande (produits,acheteur,adresse,telephone, carte, identifiant,infoSupp);
						if(menu.systemeGeneral.verifierCommande(commande)==false){
							throw new IllegalStateException("quantite insuffisante");
						}
						else{
							acheteur.addCommande(commande);
							return commande;}
						
					}
				}

			}
		}
		throw new IllegalArgumentException("test");
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
}}