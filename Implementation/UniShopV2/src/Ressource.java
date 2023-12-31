import java.time.LocalDate;

public class Ressource extends Categorie {
	public Ressource(String isbn, String auteur, String organisation, LocalDate dateParution, TypeRessource type, String numeroEdition) {
		this._isbn = isbn;
		this._auteur = auteur;
		this._organisation = organisation;
		this._dateParution = dateParution;
		this._type = type;
		this._numEdition = numeroEdition;
	}
	private String _isbn;
	private String _auteur;
	private String _organisation;
	private LocalDate _dateParution;
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
	public LocalDate getDateParution() {
		return _dateParution;
	}
	public String getDateParutionBuff(){
		return (_dateParution.getYear()+";"+ _dateParution.getMonthValue()+";"+ _dateParution.getDayOfMonth());

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