public class EquipementBureau extends Categorie {
	public EquipementBureau(String marque, String modele, BureauCategorie sousCategorie) {
		this._marque = marque;
		this._modele = modele;
		this._sousCategorie = sousCategorie;
    }

	public EquipementBureau(String marque, String modele, String sousCategorie) {
		this._marque = marque;
		this._modele = modele;
		if (sousCategorie == "ChaiseDeBureau") {
			this._sousCategorie = BureauCategorie.ChaiseDeBureau;
		} else if (sousCategorie == "LampeDeBureau") {
			this._sousCategorie = BureauCategorie.LampeDeBureau;
		} else if (sousCategorie == "SupportOrdinateurPortable") {
			this._sousCategorie = BureauCategorie.SupportOrdinateurPortable;
		} else {
			this._sousCategorie = BureauCategorie.Autre;}
	}



    private String _marque;
	private String _modele;
	private BureauCategorie _sousCategorie;

	// Getters
	public String getMarque() {
		return _marque;
	}
	public String getModele() {
		return _modele;
	}
	public BureauCategorie getSousCategorie() {
		return _sousCategorie;
	}
	public String getSousCategorieString() {
		return _sousCategorie.toString();
	}
	
}