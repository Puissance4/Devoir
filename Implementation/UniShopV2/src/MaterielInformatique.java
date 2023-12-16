import java.time.LocalDate;
import java.util.Date;

public class MaterielInformatique extends Categorie {
	public MaterielInformatique(String marque, String modele, LocalDate dateLancement, InfoCategorie sousCategorie) {
		this._marque = marque;
		this._modele = modele;
		this._dateLancement = dateLancement;
		this._sousCategorie = sousCategorie;
    }

	public MaterielInformatique(String marque, String modele, LocalDate dateLancement, String sousCategorie) {
		this._marque = marque;
		this._modele = modele;
		this._dateLancement = dateLancement;

		if (sousCategorie == "OrdinateurPortable") {
			this._sousCategorie = InfoCategorie.OrdinateurPortable;
		} else if (sousCategorie == "Souris") {
			this._sousCategorie = InfoCategorie.Souris;
		} else if (sousCategorie == "Clavier") {
			this._sousCategorie = InfoCategorie.Clavier;
		} else if (sousCategorie == "DisqueDurExterne") {
			this._sousCategorie = InfoCategorie.DisqueDurExterne;
		} else if (sousCategorie == "Ecouteurs") {
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
}