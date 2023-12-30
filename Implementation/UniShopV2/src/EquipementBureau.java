/**
 * Représente un équipement de bureau avec des détails spécifiés et une sous-catégorie typée.
 * Cette classe étend la classe `Categorie`, ce qui signifie que `EquipementBureau` est une sous-classe de `Categorie`.
 */
public class EquipementBureau extends Categorie {

	/**
	 * Constructeur pour créer un équipement de bureau avec les détails spécifiés et une sous-catégorie typée.
	 *
	 * @param marque La marque de l'équipement.
	 * @param modele Le modèle de l'équipement.
	 * @param sousCategorie La sous-catégorie de l'équipement, fournie en tant qu'objet BureauCategorie.
	 */
	public EquipementBureau(String marque, String modele, BureauCategorie sousCategorie) {
		this._marque = marque;
		this._modele = modele;
		this._sousCategorie = sousCategorie;
    }

	/**
	 * Constructeur surchargé pour créer un équipement de bureau avec une sous-catégorie spécifiée en tant que chaîne de caractères.
	 *
	 * @param marque La marque de l'équipement.
	 * @param modele Le modèle de l'équipement.
	 * @param sousCategorie La sous-catégorie de l'équipement, fournie en tant que chaîne de caractères.
	 */
	public EquipementBureau(String marque, String modele, String sousCategorie) {
		this._marque = marque;
		this._modele = modele;
		if (sousCategorie.equals("ChaiseDeBureau")) {
			this._sousCategorie = BureauCategorie.ChaiseDeBureau;
		} else if (sousCategorie.equals("LampeDeBureau")) {
			this._sousCategorie = BureauCategorie.LampeDeBureau;
		} else if (sousCategorie.equals("SupportOrdinateurPortable")) {
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