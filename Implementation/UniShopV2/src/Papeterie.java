public class Papeterie extends Categorie {
	public Papeterie(String marque, String modele, PapeterieCategorie sousCategorie) {
		this._marque = marque;
		this._modele = modele;
		this._sousCategorie = sousCategorie;
    }

	public Papeterie(String marque, String modele, String sousCategorie) {
		this._marque = marque;
		this._modele = modele;

		if (sousCategorie == "stylo") {
			this._sousCategorie = PapeterieCategorie.Stylo;
		} else if (sousCategorie == "Cahier") {
			this._sousCategorie = PapeterieCategorie.Cahier;
		} else if (sousCategorie == "Classeur") {
			this._sousCategorie = PapeterieCategorie.Classeur;
		} else if (sousCategorie == "FeuillePapier") {
			this._sousCategorie = PapeterieCategorie.FeuillePapier;
		} else if (sousCategorie == "Calculatrice") {
			this._sousCategorie = PapeterieCategorie.Calculatrice;
		} else if (sousCategorie == "Surligneur") {
			this._sousCategorie = PapeterieCategorie.Surligneur;
		} else {
			this._sousCategorie = PapeterieCategorie.Autre;}
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