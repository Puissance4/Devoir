public class MetriquesRevendeurs extends Metriques {
	private float _revenu;
	private int _nombreArticles;
	private int _nombreProduitsVendus;
	public Revendeur _unnamed_Revendeur_;

	public float getRevenu() {
		return this._revenu;
	}

	public void setRevenu(float aRevenu) {
		this._revenu = aRevenu;
	}

	public int getNombreArticles() {
		return this._nombreArticles;
	}

	public void setNombreArticles(int aNombreArticles) {
		this._nombreArticles = aNombreArticles;
	}

	public int getNombreProduitsVendus() {
		return this._nombreProduitsVendus;
	}

	public void setNombreProduitsVendus(int aNombreProduitsVendus) {
		this._nombreProduitsVendus = aNombreProduitsVendus;
	}
}