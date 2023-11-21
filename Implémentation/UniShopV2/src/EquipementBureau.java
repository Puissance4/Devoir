public class EquipementBureau extends Categorie {
	public EquipementBureau(String marque, String modele, BureauCategorie sousCategorie) {
		this._marque = marque;
		this._modele = modele;
		this._sousCategorie = sousCategorie;
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