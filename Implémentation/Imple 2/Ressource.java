public class Ressource extends Categorie {
	public Ressource(String isbn, String auteur, String organisation, TypeRessource type, String numeroEdition) {
		this._isbn = isbn;
		this._auteur = auteur;
		this._organisation = organisation;
		this._type = type;
		this._numEdition = numeroEdition;
	}
	private String _isbn;
	private String _auteur;
	private String _organisation;
	private TypeRessource _type;
	private String _numEdition;

	// Getters
	public String getIsbn() {
		return _isbn;
	}
	public String getAuteur() {
		return _auteur;
	}
	public String getOrganisation() {
		return _organisation;
	}
	public TypeRessource getType() {
		return _type;
	}
	public String getTypeString() {
		return _type.toString();
	}
	public String getNumEdition() {
		return _numEdition;
	}
}