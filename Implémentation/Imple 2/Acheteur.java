import java.util.Vector;

public class Acheteur extends Utilisateur {
	public Acheteur(String nom, String prenom, String email, String motDePasse, String adresse, String telephone) {
		super(nom, prenom, email, motDePasse, adresse, telephone);
		//TODO Auto-generated constructor stub
	}

	private String prenom;
	private String pseudo;
	private int nombrePoints = 0;
	private Revendeur[] revendeursLike;
	private Produit[] produitsLike;
	private Acheteur[] acheteurLike;
	private String[] notification;
	//public Vector<Revendeur> _est_suivi_par = new Vector<Revendeur>();
	//public Panier _unnamed_Panier_;
	//public Vector<Commande> _unnamed_Commande_ = new Vector<Commande>();
	//public Vector<Carte> _unnamed_Carte_ = new Vector<Carte>();
	//public MetriquesAcheteur _unnamed_MetriquesAcheteur_;
	//public Vector<Evaluation> _est__laisse_par_acheteur = new Vector<Evaluation>();

	//public void addCommande(Commande aCom) {
	//	throw new UnsupportedOperationException();
	//}

	//public Panier getPanier() {
	//	throw new UnsupportedOperationException();
	//}

	public int getNombrePoints() {
		return this.nombrePoints;
	}
	public String getPrenom() {
		return this.prenom;
	}

	public void setNombrePoints(int aNombrePoints) {
		this.nombrePoints = aNombrePoints;
	}

	//public void modifRevendeursLike(Revendeur aRevendeur) {
	//	throw new UnsupportedOperationException();
	//}

	public Produit[] getProduitsLike() {
		return this.produitsLike;
	}

	//public void modifProduitsLike(Produit aProduitsLike) {
	//	throw new UnsupportedOperationException();
	//}

	public Acheteur[] getAcheteurLike() {
		return this.acheteurLike;
	}

	//public void modifAcheteurLike(Acheteur aAcheteurLike) {
	//	throw new UnsupportedOperationException();
	//}

	//public Notification[] getNotification() {
	//	throw new UnsupportedOperationException();
	//}

	public void setNotification(String[] aNotification) {
		this.notification = aNotification;
	}

	public void modifierProfil() {
		throw new UnsupportedOperationException();
	}
}