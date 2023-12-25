public class Notification {
	private String description;
	private CategorieNotif categorie;
	public Notification(CategorieNotif categorie){
		this.description = categorie.getDescription();
		this.categorie = categorie;
	}
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