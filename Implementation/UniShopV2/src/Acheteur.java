import java.io.*;
import java.util.ArrayList;

/**
 * Représente un acheteur dans un système de commerce électronique, avec ses informations personnelles, ses préférences, et son historique d'achat.
 */
public class Acheteur extends Utilisateur {

	/**
	 * Construit un nouvel objet Acheteur avec les données fournies, initialise ses attributs, charge son panier et ses listes de revendeurs et produits favoris, et récupère ses commandes précédentes.
	 *
	 * @param donnee Un tableau de chaînes contenant les informations de l'acheteur telles que le pseudo, le prénom, et d'autres détails personnels ainsi que ses préférences.
	 * @param catalogue Une ArrayList de Produit représentant le catalogue des produits disponibles.
	 * @param listeCommandes Une ArrayList de Commande représentant les commandes précédemment passées par l'acheteur.
	 * <p>
	 * Le constructeur décompose le tableau `donnee` pour initialiser les attributs de l'acheteur, notamment :
	 * - `pseudo` : le pseudo de l'acheteur.
	 * - `prenom` : le prénom de l'acheteur.
	 * - `revendeursLike` : une liste des revendeurs favoris.
	 * - `metriques._classementAcheteurSuivis` : un classement des acheteurs suivis basé sur certaines métriques.
	 * - `panier` : le panier d'achat actuel de l'acheteur, soit chargé à partir d'un fichier, soit nouvellement créé.
	 * - `produitsLike` : une liste des produits favoris.
	 * - `nombrePoints` : le nombre de points de fidélité de l'acheteur.
	 * - `commandes` : une liste des commandes passées par l'acheteur.
	 *
	 * Le constructeur gère également le chargement du panier de l'acheteur à partir d'un fichier CSV et la récupération de ses commandes passées.
	 */
	public Acheteur(String[] donnee,ArrayList<Produit> catalogue,ArrayList<Commande> listeCommandes) {
		super(donnee[1], donnee[3], donnee[6], donnee[5], donnee[4]);
		this.pseudo = donnee[0];
		this.prenom = donnee[2];
		String [] liste=donnee[7].split(";");
		if(!(liste[0].equals("null"))){
		for (int i=0;i<liste.length;i++){
			this.revendeursLike.add(liste[i]);
		}}
		String [] liste2=donnee[8].split(";");
		if(!(liste2[0].equals("null"))){
		for (int i=0;i<liste2.length;i++){
			this.metriques._classementAcheteurSuivis.add(liste2[i]) ;

		}}
		Boolean panierInit=false;
		try {
			BufferedReader readerPanier=new BufferedReader(new FileReader("Implementation/UniShopV3/Paniers.csv"));
			String line=readerPanier.readLine();//ignore la ligne des noms de colonnes
			while ((line=readerPanier.readLine())!=null) {
				String[] panier=line.split(",");
				if (panier[0].equals(donnee[0])){
					this.panier=new Panier(panier,catalogue);
					panierInit=true;
				}
			}
			readerPanier.close();
		} catch (Exception e) {
	
			e.printStackTrace();
		}

		if (panierInit==false){this.panier=new Panier(donnee[0]);}

		String[] prod=donnee[10].split(";");
		if(!(prod[0].equals("null"))){
		for (Produit produit : catalogue) {
			for (int i=0;i<prod.length;i++){
				if (produit.getIdentifiant().equals(prod[i])) {
					this.produitsLike.add(produit);}
				}
			}}
		this.nombrePoints=Integer.parseInt(donnee[11]);

		for (Commande commande : listeCommandes){
			if (commande.getAcheteur().equals(donnee[0])){
				this.commandes.add(commande);
			}
		}

	}


	/**
	 * Crée une instance d'Acheteur avec les informations personnelles fournies et initialise un nouveau panier d'achats et un nombre de points de fidélité.
	 *
	 * @param pseudo Le pseudo unique de l'acheteur utilisé pour identifier son compte.
	 * @param nom Le nom de famille de l'acheteur.
	 * @param prenom Le prénom de l'acheteur.
	 * @param email L'adresse email de l'acheteur utilisée pour la communication.
	 * @param motDePasse Le mot de passe sécurisé de l'acheteur pour accéder à son compte.
	 * @param adresse L'adresse postale complète de l'acheteur.
	 * @param telephone Le numéro de téléphone de l'acheteur.
	 *
	 * Ce constructeur appelle le constructeur de la superclasse pour initialiser les attributs communs puis définit les attributs spécifiques à l'acheteur.
	 * Il initialise également le nombre de points de fidélité à 0 et crée un nouveau panier d'achats vide lié au pseudo de l'acheteur.
	 */
	public Acheteur(String pseudo, String nom, String prenom, String email, String motDePasse, String adresse, String telephone) {
		super(nom, email, telephone, adresse, motDePasse);
		this.pseudo = pseudo;
		this.prenom = prenom;
		this.nombrePoints = 0;
		this.panier=new Panier(pseudo);
	}

	private ArrayList<RetourEchange> listRetourEchange = new ArrayList<>();
	private String prenom;
	private String pseudo;
	private int nombrePoints = 0;
	public ArrayList <String> revendeursLike=new ArrayList<String>();
	public ArrayList <Produit> produitsLike=new ArrayList<Produit>();
	public ArrayList <Notification> notifications=new ArrayList<>();
	public ArrayList<Produit> produitsAchetes= new ArrayList<>();
	public ArrayList<Acheteur> acheteursSuivis = new ArrayList<>();
	private Panier panier;
	private ArrayList<Commande> commandes = new ArrayList<Commande>();
	private MetriquesAcheteur metriques = new MetriquesAcheteur(this);
	//public Vector<Carte> _unnamed_Carte_ = new Vector<Carte>();
	//public Vector<Evaluation> _est__laisse_par_acheteur = new Vector<Evaluation>();

	/**
	 * Récupère le panier d'achats actuel de l'acheteur.
	 *
	 * Cette méthode retourne l'objet Panier associé à l'acheteur, permettant l'accès aux produits sélectionnés,
	 * aux quantités, et potentiellement à d'autres informations liées au panier d'achats comme le total du coût.
	 *
	 * @return Le panier d'achats actuel de l'acheteur.
	 */
	public Panier getPanier() {
		return this.panier;
	}

	/**
	 * Génère une représentation sous forme de chaîne des revendeurs favoris de l'acheteur.
	 *
	 * Cette méthode parcourt la liste des revendeurs favoris de l'acheteur et les concatène en une seule chaîne de caractères,
	 * séparant chaque nom de revendeur par un point-virgule. Si l'acheteur n'a aucun revendeur favori,
	 * la méthode retourne le mot "null".
	 *
	 * @return Une chaîne représentant la liste des revendeurs favoris de l'acheteur, séparés par des points-virgules,
	 *         ou "null" si l'acheteur n'a pas de revendeurs favoris.
	 */
	public String getRevendeurslikeBuff(){
		if (revendeursLike.size()==0){return "null";}
		else{
			String liste=revendeursLike.get(0);
			for(int i=1;i<revendeursLike.size();i++){
				liste=liste+";"+revendeursLike.get(i);
			}
			return liste;
		}
	}

	/**
	 * Construit une chaîne de caractères représentant les pseudos des acheteurs suivis.
	 *
	 * Cette méthode vérifie d'abord si la liste des acheteurs suivis est vide. Si c'est le cas, elle retourne "null".
	 * Sinon, elle parcourt la liste et concatène les pseudos de tous les acheteurs suivis, séparés par des points-virgules.
	 * Cette représentation est utile pour stocker ou afficher la liste des acheteurs suivis de manière concise.
	 *
	 * @return Une chaîne représentant la liste des pseudos des acheteurs suivis, séparés par des points-virgules,
	 *         ou "null" si aucun acheteur n'est suivi.
	 */
	public String getAcheteurlikeBuff(){
		if (acheteursSuivis.isEmpty()){return "null";}
		else{
			String liste=acheteursSuivis.get(0).getPseudo();
			for(int i=1;i<acheteursSuivis.size();i++){
				liste=liste+";"+acheteursSuivis.get(i).getPseudo();
			}
			return liste;
		}
	}

	/**
	 * Compile les descriptions des notifications en une seule chaîne de caractères.
	 *
	 * Cette méthode vérifie d'abord si la liste des notifications est vide. Si c'est le cas, elle retourne "null".
	 * Sinon, elle utilise un StringBuilder pour concaténer efficacement les descriptions de toutes les notifications,
	 * séparées par des points-virgules. Cela permet une récupération efficace et une manipulation facile des descriptions de notifications
	 * pour un affichage ou un traitement ultérieur.
	 *
	 * @return Une chaîne représentant les descriptions de toutes les notifications, séparées par des points-virgules,
	 *         ou "null" si la liste des notifications est vide.
	 */
	public String getNotificationBuff(){
		if (notifications.isEmpty()){return "null";}
		else{
			StringBuilder liste= new StringBuilder(notifications.get(0).getDesc());
			for(int i=1;i<notifications.size();i++){
				liste.append(";").append(notifications.get(i).getDesc());
			}
			return liste.toString();
		}
	}

	/**
	 * Génère une chaîne de caractères contenant les identifiants des produits aimés par l'utilisateur.
	 *
	 * Cette méthode commence par vérifier si la liste des produits aimés est vide. Si c'est le cas, elle retourne "null".
	 * Autrement, elle parcourt la liste des produits aimés et concatène leurs identifiants en une seule chaîne de caractères,
	 * séparant chaque identifiant par un point-virgule. Cette représentation est pratique pour stocker ou afficher
	 * les préférences de l'utilisateur en matière de produits de manière concise.
	 *
	 * @return Une chaîne de caractères représentant les identifiants des produits aimés, séparés par des points-virgules,
	 *         ou "null" si l'utilisateur n'aime aucun produit.
	 */
	public String getProduitsLikeBuff(){
		if (produitsLike.size()==0){return "null";}
		else{
			String liste=produitsLike.get(0).getIdentifiant();
			for(int i=1;i<produitsLike.size();i++){
				liste=liste+";"+produitsLike.get(i).getIdentifiant();
			}
			return liste;
		}
	}


	/**
	 * Permet à l'utilisateur de mettre à jour son profil, notamment son prénom et son pseudo.
	 *
	 * Cette méthode appelle d'abord `modifierProfil` de la superclasse pour mettre à jour les attributs communs.
	 * Ensuite, elle invite l'utilisateur à décider s'il souhaite conserver ou modifier son prénom et son pseudo.
	 * Si l'utilisateur choisit de modifier, la méthode `modif` est appelée pour chaque attribut,
	 * permettant ainsi la mise à jour des valeurs. Après les modifications, un message de confirmation est affiché.
	 *
	 * @param menu Le menu interactif utilisé pour recueillir les entrées de l'utilisateur.
	 */
	public void modifierProfil(Menu menu) {
		super.modifierProfil(menu);
	
		System.out.println("Souhaitez vous conserver le prenom "+this.prenom);
		String nouveau=modif("prenom",menu);
		if(nouveau!=""){this.prenom=nouveau;}
    
		System.out.println("Souhaitez vous conserver le pseudo "+this.pseudo);
		nouveau=modif("pseudo",menu);
		if(nouveau!=""){this.pseudo=nouveau;}
    
        System.out.println("Profil mis à jour avec succès !");
	}
	public void addCommande(Commande newCommande){
		commandes.add(newCommande);
	}

	/**
	 * Affiche les détails du profil de l'acheteur, incluant le pseudo, le prénom, le nom, les points accumulés,
	 * et les listes des produits, acheteurs, et revendeurs aimés.
	 */
	public void afficherProfil(){
		System.out.println("--------------------------");
		System.out.println("Pseudo " + pseudo );
		System.out.println("Prenom " + prenom);
		System.out.println("Nom " + super.getNom());
		System.out.println("Nombre de points " + nombrePoints);
		System.out.println("------Articles Like---------- " );
		for (int i=0;i<produitsLike.size();i++){
			System.out.println(produitsLike.get(i).get_titre());
		}
		System.out.println("------Acheteurs Like---------- " );
		for (int i=0;i<acheteursSuivis.size();i++){
			System.out.println(acheteursSuivis.get(i).getPseudo());
		}
		System.out.println("------Revendeurs Like---------- " );
		for (int i=0;i<revendeursLike.size();i++){
			System.out.println(revendeursLike.get(i));
		}
		System.out.println("--------------------------");

	}

	/**
	 * Ajoute une notification à la liste des notifications de l'acheteur.
	 *
	 * @param notification L'objet Notification à ajouter à la liste.
	 */
	public void notifier(Notification notification) {
		this.notifications.add(notification);
	}

	//getters

	/**
	 * Renvoie le pseudo de l'acheteur.
	 *
	 * @return Le pseudo de l'acheteur.
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * Renvoie le nombre total de points de fidélité de l'acheteur.
	 *
	 * @return Le nombre de points de l'acheteur.
	 */
	public int getNombrePoints() {
		return this.nombrePoints;
	}

	/**
	 * Renvoie le prénom de l'acheteur.
	 *
	 * @return Le prénom de l'acheteur.
	 */
	public String getPrenom() {
		return this.prenom;
	}

	/**
	 * Renvoie la liste des produits aimés par l'acheteur.
	 *
	 * @return Une ArrayList des Produits aimés.
	 */
	public ArrayList<Produit> getProduitsLike() {
		return this.produitsLike;
	}

	/**
	 * Renvoie les métriques associées à l'acheteur, incluant le classement des acheteurs suivis.
	 *
	 * @return Les métriques de l'acheteur.
	 */
	public MetriquesAcheteur getMetriques(){
		return this.metriques;
	}

	/**
	 * Renvoie la liste des retours et échanges associés à l'acheteur.
	 *
	 * @return Une ArrayList des RetoursEchange de l'acheteur.
	 */
	public ArrayList<RetourEchange> getListRetourEchange() {
		return listRetourEchange;
	}

	/**
	 * Renvoie la liste des commandes passées par l'acheteur.
	 *
	 * @return Une ArrayList des Commandes de l'acheteur.
	 */
	public ArrayList<Commande> getCommande(){
		return this.commandes;
	}

	// Setters

	/**
	 * Ajoute ou retire un acheteur de la liste des acheteurs suivis et ajuste les points de fidélité en conséquence.
	 * Notifie l'acheteur suivi et met à jour les métriques.
	 *
	 * @param acheteur L'acheteur à suivre ou à ne plus suivre.
	 * @throws IOException En cas d'erreur lors de l'ajout ou la suppression de l'acheteur.
	 */
	public void setAcheteursSuivis(Acheteur acheteur) throws IOException {
			if(!acheteursSuivis.isEmpty() && acheteursSuivis.contains(acheteur)){
			acheteursSuivis.remove(acheteur);
			acheteur.retirerDesPoints(5);
			this.retirerDesPoints(5);
			
		}
		else{
			acheteursSuivis.add(acheteur);
			acheteur.ajouterDesPoints(5);
			this.ajouterDesPoints(5);
			// Send a notification to the followed user
			Notification notification = new Notification(CategorieNotif.NOUVEL_ACHETEUR_SUIVI);
			acheteur.notifier(notification);
			// Update buyer's list of followed users
			this.metriques._classementAcheteurSuivis.add(acheteur.getPseudo());
		}
	}

	/**
	 * Définit la liste des retours et échanges pour l'acheteur.
	 *
	 * @param listRetourEchange La nouvelle liste des RetoursEchange à attribuer à l'acheteur.
	 */
	public void setListRetourEchange(ArrayList<RetourEchange> listRetourEchange) {
		this.listRetourEchange = listRetourEchange;
	}

	/**
	 * Ajoute ou retire un produit de la liste des produits aimés par l'acheteur.
	 *
	 * @param produit Le produit à aimer ou à ne plus aimer.
	 */
	public void setProduitLike(Produit produit) {
		if(!produitsLike.isEmpty() && produitsLike.contains(produit)){
			produitsLike.remove(produit);
		}
		else{
			produitsLike.add(produit);
		}
	}

	/**
	 * Ajoute ou retire un revendeur de la liste des revendeurs aimés et ajuste les likes du revendeur en conséquence.
	 *
	 * @param revendeur Le revendeur à aimer ou à ne plus aimer.
	 */
	public void setRevendeurLike(Revendeur revendeur) {
		if(!revendeursLike.isEmpty() && revendeursLike.contains(revendeur.getNom())){
			revendeursLike.remove(revendeur.getNom());
			revendeur.retirerDesLikes(1);
		}
		else{
			revendeursLike.add(revendeur.getNom());
			revendeur.ajouterDesLikes(1);
		}
	}

	/**
	 * Définit le nombre total de points de fidélité de l'acheteur.
	 *
	 * @param aNombrePoints Le nouveau nombre de points à attribuer à l'acheteur.
	 */
	public void setNombrePoints(int aNombrePoints) {
		this.nombrePoints = aNombrePoints;
	}

	/**
	 * Retire un certain nombre de points de fidélité de l'acheteur, sans aller en dessous de zéro.
	 *
	 * @param points Le nombre de points à retirer.
	 */
	public void retirerDesPoints(int points){
		nombrePoints=nombrePoints-points;
		if (nombrePoints<0){nombrePoints=0;}
	}

	/**
	 * Ajoute un certain nombre de points de fidélité à l'acheteur.
	 *
	 * @param points Le nombre de points à ajouter.
	 */
	public void ajouterDesPoints(int points){
		nombrePoints=nombrePoints+points;
	}

	public ArrayList<String> getRevendeursLike() {
		return revendeursLike;
	}
}