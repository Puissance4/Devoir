/**
 * La classe Papeterie représente une catégorie spécifique de produits dans le système, dédiée aux articles de papeterie.
 * Elle hérite de la classe Categorie et ajoute des détails spécifiques à la papeterie tels que la marque, le modèle et la sous-catégorie.
 */
public class Papeterie extends Categorie {

	/**
	 * Constructeur pour créer un article de papeterie avec les détails spécifiés et une sous-catégorie de papeterie typée.
	 *
	 * @param marque La marque de l'article de papeterie.
	 * @param modele Le modèle de l'article de papeterie.
	 * @param sousCategorie La sous-catégorie de l'article de papeterie, fournie en tant qu'objet PapeterieCategorie.
	 */
	public Papeterie(String marque, String modele, PapeterieCategorie sousCategorie) {
		this._marque = marque;
		this._modele = modele;
		this._sousCategorie = sousCategorie;
    }

	/**
	 * Constructeur surchargé pour créer un article de papeterie avec une sous-catégorie spécifiée en tant que chaîne de caractères.
	 *
	 * @param marque La marque de l'article de papeterie.
	 * @param modele Le modèle de l'article de papeterie.
	 * @param sousCategorie La sous-catégorie de l'article de papeterie, fournie en tant que chaîne de caractères.
	 */
	public Papeterie(String marque, String modele, String sousCategorie) {
		this._marque = marque;
		this._modele = modele;

		if (sousCategorie.equals("stylo")) {
			this._sousCategorie = PapeterieCategorie.Stylo;
		} else if (sousCategorie.equals("Cahier")) {
			this._sousCategorie = PapeterieCategorie.Cahier;
		} else if (sousCategorie.equals("Classeur")) {
			this._sousCategorie = PapeterieCategorie.Classeur;
		} else if (sousCategorie.equals("FeuillePapier")) {
			this._sousCategorie = PapeterieCategorie.FeuillePapier;
		} else if (sousCategorie.equals("Calculatrice")) {
			this._sousCategorie = PapeterieCategorie.Calculatrice;
		} else if (sousCategorie.equals("Surligneur")) {
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