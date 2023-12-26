import java.util.ArrayList;

public class Utilisateur {

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

	public String getNom() {
        return this.nom;
    }
	public String getMotDePasse() {
		return this.motDePasse;
	}
	public String getAdresse() {
        return this.adresse;
    }
	public String getTelephone() {
        return this.telephone;
    }
	public String getCourriel() {
        return this.courriel;
    }

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