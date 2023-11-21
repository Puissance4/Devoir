public class Papeterie extends Categorie {
	public Papeterie(String marque, String modele, PapeterieCategorie sousCategorie) {
		this._marque = marque;
		this._modele = modele;
		this._sousCategorie = sousCategorie;
    }
    private String _marque;
	private String _modele;
	private PapeterieCategorie _sousCategorie;

	// Getters
	public String getMarque() {
		return _marque;
	}
	public String getModele() {
		return _modele;
	}
	public PapeterieCategorie getSousCategorie() {
		return _sousCategorie;
	}
	public String getSousCategorieString() {
		return _sousCategorie.toString();
	}
}