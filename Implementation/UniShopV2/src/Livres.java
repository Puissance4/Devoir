import java.time.LocalDate;

public class Livres extends Categorie {
	public Livres(String isbn, String auteur, String maisonEdition, Genre genre, LocalDate dateParution,
            String numeroEdition, String numeroVolume) {
				this._isbn = isbn;
				this._auteur = auteur;
				this._maisonEdition = maisonEdition;
				this._genre = genre;
				this._dateParution = dateParution;
				this._numEdition = Integer.parseInt(numeroEdition);
				this._numVolume = Integer.parseInt(numeroVolume);
    }


	public Livres(String isbn, String auteur, String maisonEdition, String genre, LocalDate dateParution,
            String numeroEdition, String numeroVolume) {
				this._isbn = isbn;
				this._auteur = auteur;
				this._maisonEdition = maisonEdition;
				this._dateParution = dateParution;
				this._numEdition = Integer.parseInt(numeroEdition);
				this._numVolume = Integer.parseInt(numeroVolume);
				if (genre == "Manuel") {
					this._genre = Genre.Manuel;
				} else if (genre == "Roman") {
					this._genre = Genre.Roman;
				} else if (genre == "BandeDessinee") {
					this._genre = Genre.BandeDessinee;
				} else if (genre == "Documentaire") {
					this._genre = Genre.Documentaire;
				} else {
					this._genre = Genre.Autre;}

    }

    private String _isbn;
	private String _auteur;
	private String _maisonEdition;
	private Genre _genre;
	private LocalDate _dateParution;
	private int _numEdition;
	private int _numVolume;

	// Getters
	public String getIsbn() {
		return _isbn;
	}
	public String getAuteur() {
		return _auteur;
	}
	public String getMaisonEdition() {
		return _maisonEdition;
	}
	public Genre getGenre() {
		return _genre;
	}
	public String getGenreString() {
		return _genre.toString();
	}
	public LocalDate getDateParution() {
		return _dateParution;
	}
	public int getNumEdition() {
		return _numEdition;
	}
	public int getNumVolume() {
		return _numVolume;
	}
}