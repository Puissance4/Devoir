import jdk.jshell.execution.Util;

import java.util.ArrayList;

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
	private ArrayList<Notification> notifications = new ArrayList<>();

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


	public ArrayList<Notification> getNotifications(){
		return notifications;
	}
	public void notifier(Notification notification) {
		getNotifications().add(notification);
	}

}