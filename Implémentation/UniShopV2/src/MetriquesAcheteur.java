public class MetriquesAcheteur extends Metriques {
	private int _nombreCommandes;
	private int _nombreArticles;
	private Acheteur[] _classementAcheteurSuivis;
	public Acheteur _unnamed_Acheteur_;

	public int getNombreCommandes() {
		return this._nombreCommandes;
	}

	public void setNombreCommandes(int aNombreCommandes) {
		this._nombreCommandes = aNombreCommandes;
	}

	public int getNombreArticles() {
		return this._nombreArticles;
	}

	public void setNombreArticles(int aNombreArticles) {
		this._nombreArticles = aNombreArticles;
	}

	public Acheteur[] getClassementAcheteurSuivis() {
		return this._classementAcheteurSuivis;
	}

	public void setClassementAcheteurSuivis(Acheteur[] aClassementAcheteurSuivis) {
		this._classementAcheteurSuivis = aClassementAcheteurSuivis;
	}
}