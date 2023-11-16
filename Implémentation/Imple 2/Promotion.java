import java.util.Date;

public class Promotion extends Produit {
	public Promotion(String titre, String categorie, String description, String marque, String modele,
			String identifiant, int quantite, double prix) {
		super(titre, categorie, description, marque, modele, identifiant, quantite, prix);
		//TODO Auto-generated constructor stub
	}

	private float _prix;
	private int _nombrePointsRapporte;
	private Date _dateFin;

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