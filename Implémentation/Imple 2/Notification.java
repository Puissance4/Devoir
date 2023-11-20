public class Notification {
	// Constructor
	public Notification(CategorieNotif categorie, String description){
		this.description = description;
		this.categorie = categorie;
	}

	// Attributs
	private CategorieNotif categorie;
	private String description;

	// Public methods
	public CategorieNotif getCategorie() {
		return this.categorie;
	}
	public void setCategorie(CategorieNotif aCategorie) {
		throw new UnsupportedOperationException();
	}
	public String getDesc() {
		return this.description;
	}
	public void setDesc(String aDesc) {
		this.description = aDesc;
	}
}