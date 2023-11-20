import java.util.Date;

public class Promotion extends Produit {
	public Promotion(String titre, Categorie categorie, String description, String marque, String modele,
			String identifiant, int quantite, float prix, int pointsBonus, Date dateFin, String lienImageOuVideo, Revendeur revendeur) {
		super(titre, categorie, description, quantite, prix, pointsBonus, identifiant, lienImageOuVideo, revendeur);
	}

	private float _prix;
	private int _nombrePointsRapporte;
	private Date _dateFin;
	private Revendeur revendeur;

	public double getPrix() {
		return this._prix;
	}

	public void setPrix(float aPrix) {
		this._prix = aPrix;
	}

	public int getNombrePointsRapporte() {
		return this._nombrePointsRapporte;
	}

	public void setNombrePointsRapporte(int aNombrePointsRapporte) {
		this._nombrePointsRapporte = aNombrePointsRapporte;
	}

	public Date getDateFin() {
		return this._dateFin;
	}

	public void setDateFin(Date aDateFin) {
		this._dateFin = aDateFin;
	}
}