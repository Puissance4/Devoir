import java.util.Vector;

public class Utilisateur {

	public Utilisateur(String nom, String courriel, String telephone, String adresse, String motDePasse) {
		this.nom = nom;
		this.courriel = courriel;
		this.telephone = telephone;
		this.adresse = adresse;
		this.motDePasse = motDePasse;
	}

	private String nom;
	private String courriel;
	private String telephone;
	private String adresse;
	private String motDePasse;
	public Vector<Notification> _unnamed_Notification_ = new Vector<Notification>();

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


}