public class Promotion extends Produit {
	private float _prix;
	private int _nombrePointsRapporte;
	private date _dateFin;

	public float getPrix() {
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

	public date getDateFin() {
		return this._dateFin;
	}

	public void setDateFin(date aDateFin) {
		this._dateFin = aDateFin;
	}
}