import java.util.Vector;

public class Utilisateur {
	private String nom;
	private String courriel;
	private String telephone;
	private String adresse;
	private String motDePasse;
	public Vector<Notification> _unnamed_Notification_ = new Vector<Notification>();

	public String getNom() {
        return this.nom;
    }

}