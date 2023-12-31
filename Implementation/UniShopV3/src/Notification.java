/**
 * Représente une notification générique dans le système UniShop.
 * Chaque notification est associée à une catégorie qui définit son type et sa description.
 */
public class Notification {
	private String description;
	private CategorieNotif categorie;

	/**
	 * Constructeur pour créer une notification avec une catégorie spécifiée.
	 *
	 * @param categorie La catégorie de la notification, qui définit le type et la description de la notification.
	 */
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