import java.time.LocalDate;
import java.util.Date;

/**
 * Représente du matériel informatique avec des détails spécifiés et une sous-catégorie de matériel informatique typée.
 * Cette classe étend la classe `Categorie`, ce qui signifie que `MaterielInformatique` est une sous-classe de `Categorie`.
 */
public class MaterielInformatique extends Categorie {

	/**
	 * Constructeur pour créer du matériel informatique avec les détails spécifiés et une sous-catégorie de matériel informatique typée.
	 *
	 * @param marque La marque du matériel informatique.
	 * @param modele Le modèle du matériel informatique.
	 * @param dateLancement Date de lancement du matériel informatique.
	 * @param sousCategorie La sous-catégorie du matériel informatique, fournie en tant qu'objet InfoCategorie.
	 */
	public MaterielInformatique(String marque, String modele, LocalDate dateLancement, InfoCategorie sousCategorie) {
		this._marque = marque;
		this._modele = modele;
		this._dateLancement = dateLancement;
		this._sousCategorie = sousCategorie;
    }

	/**
	 * Constructeur surchargé pour créer du matériel informatique avec une sous-catégorie spécifiée en tant que chaîne de caractères.
	 *
	 * @param marque La marque du matériel informatique.
	 * @param modele Le modèle du matériel informatique.
	 * @param dateLancement Date de lancement du matériel informatique.
	 * @param sousCategorie La sous-catégorie du matériel informatique, fournie en tant que chaîne de caractères.
	 */
	public MaterielInformatique(String marque, String modele, LocalDate dateLancement, String sousCategorie) {
		this._marque = marque;
		this._modele = modele;
		this._dateLancement = dateLancement;

		if (sousCategorie.equals("OrdinateurPortable")) {
			this._sousCategorie = InfoCategorie.OrdinateurPortable;
		} else if (sousCategorie.equals("Souris")) {
			this._sousCategorie = InfoCategorie.Souris;
		} else if (sousCategorie.equals("Clavier")) {
			this._sousCategorie = InfoCategorie.Clavier;
		} else if (sousCategorie.equals("DisqueDurExterne")) {
			this._sousCategorie = InfoCategorie.DisqueDurExterne;
		} else if (sousCategorie.equals("Ecouteurs")) {
			this._sousCategorie = InfoCategorie.Ecouteurs;
		} else {
			this._sousCategorie = InfoCategorie.Autre;}
    }

    private String _marque;
	private String _modele;
	private LocalDate _dateLancement;
	private InfoCategorie _sousCategorie;

	// Getters
	public String getMarque() {
		return _marque;
	}
	public String getModele() {
		return _modele;
	}
	public LocalDate getDateLancement() {
		return _dateLancement;
	}
	public InfoCategorie getSousCategorie() {
		return _sousCategorie;
	}
	public String getSousCategorieString() {
		return _sousCategorie.toString();
	}
	public String getDateLancementBuff(){
		return _dateLancement.getYear()+";"+_dateLancement.getMonthValue()+";"+_dateLancement.getDayOfMonth();
	}
}