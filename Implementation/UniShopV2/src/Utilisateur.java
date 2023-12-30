import java.util.ArrayList;

/**
 * La classe Utilisateur représente un utilisateur générique dans le système, incluant ses informations de base et ses fonctionnalités.
 * Elle sert de classe de base pour des utilisateurs plus spécifiques tels que les acheteurs et les revendeurs.
 */
public class Utilisateur {

	/**
	 * Constructeur pour créer un nouvel utilisateur avec ses informations de base.
	 *
	 * @param nom Le nom de l'utilisateur.
	 * @param courriel L'adresse courriel de l'utilisateur.
	 * @param telephone Le numéro de téléphone de l'utilisateur.
	 * @param adresse L'adresse de l'utilisateur.
	 * @param motDePasse Le mot de passe de l'utilisateur pour l'authentification.
	 */
	public Utilisateur(String nom, String courriel, String telephone, String adresse, String motDePasse) {
		this.nom = nom;
		this.courriel = courriel;
		this.telephone = telephone;
		this.adresse = adresse;
		this.motDePasse = motDePasse;
	}
	//protected Scanner sc = new Scanner(System.in);
	private String nom;
	private String courriel;
	private String telephone;
	private String adresse;
	private String motDePasse;
	public ArrayList<Notification> notifications = new ArrayList<>();

	/**
	 * Renvoie le nom de l'utilisateur.
	 *
	 * @return Le nom de l'utilisateur.
	 */
	public String getNom() {
        return this.nom;
    }

	/**
	 * Renvoie le mot de passe de l'utilisateur.
	 *
	 * @return Le mot de passe de l'utilisateur.
	 */
	public String getMotDePasse() {
		return this.motDePasse;
	}

	/**
	 * Renvoie l'adresse de l'utilisateur.
	 *
	 * @return L'adresse de l'utilisateur.
	 */
	public String getAdresse() {
        return this.adresse;
    }

	/**
	 * Renvoie le numéro de téléphone de l'utilisateur.
	 *
	 * @return Le numéro de téléphone de l'utilisateur.
	 */
	public String getTelephone() {
        return this.telephone;
    }

	/**
	 * Renvoie l'adresse courriel de l'utilisateur.
	 *
	 * @return L'adresse courriel de l'utilisateur.
	 */
	public String getCourriel() {
        return this.courriel;
    }

	/**
	 * Permet à l'utilisateur de modifier son profil, y compris le nom, le mot de passe, l'adresse, le courriel et le téléphone.
	 * L'utilisateur est invité à confirmer ou modifier chaque élément de son profil.
	 *
	 * @param menu Le menu interactif utilisé pour recueillir les entrées de l'utilisateur.
	 */
	public void modifierProfil(Menu menu){
		System.out.println("Souhaitez vous conserver le nom: "+this.nom);
		String nouveau=modif("nom",menu);
		if(nouveau!=""){this.nom=nouveau;}

		System.out.println("Souhaitez vous conserver le mot de passe: "+this.motDePasse);
		nouveau=modif("mot de passe",menu);
		if(nouveau!=""){this.motDePasse=nouveau;}

		System.out.println("Souhaitez vous conserver l'adresse: "+this.adresse);
		nouveau=modif("adresse",menu);
		if(nouveau!=""){this.adresse=nouveau;}

		System.out.println("Souhaitez vous conserver le courriel: "+this.courriel);
		nouveau=modif("courriel",menu);
		if(nouveau!=""){this.courriel=nouveau;}

		System.out.println("Souhaitez vous conserver le numero de telephone "+this.telephone);
		nouveau=modif("telephone",menu);
		if(nouveau!=""){this.telephone=nouveau;}

	}

	/**
	 * Fournit une interface pour modifier un élément spécifique du profil de l'utilisateur.
	 *
	 * @param elemModif L'élément du profil à modifier (par exemple, 'nom', 'mot de passe').
	 * @param menu Le menu interactif utilisé pour recueillir les entrées de l'utilisateur.
	 * @return La nouvelle valeur de l'élément modifié, ou une chaîne vide si aucun changement n'est effectué.
	 */
	protected String modif(String elemModif, Menu menu){
		System.out.println("Entrez [1] si oui [2] si non");
		int choix=menu.prompt();
		if (choix==1){
			return "";
		}
		else if (choix==2){
			System.out.println("Entrez votre nouveau "+elemModif);
			String nouveau=menu.promptS();
			return nouveau;
		}
		else {
			System.out.println("Cette entree ne correspond pas a un choix");
			return modif(elemModif,menu);
		}

	}

}