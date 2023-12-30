/**
 * La classe Evaluation représente l'évaluation d'un produit par un acheteur. Elle contient une note et un commentaire,
 * ainsi que des références au produit évalué et à l'acheteur qui a réalisé l'évaluation.
 */
public class Evaluation {
	private int note;
	private String commentaire;
	public Produit produit;
	public Acheteur acheteur;

	/**
	 * Constructeur pour créer une nouvelle évaluation.
	 * @param note La note attribuée au produit. Doit être une valeur entière, généralement sur une échelle de 1 à 5.
	 * @param commentaire Le commentaire détaillé sur le produit. Peut être une chaîne vide si aucun commentaire n'est fourni.
	 * @param produit Le produit qui est évalué.
	 * @param acheteur L'acheteur qui réalise l'évaluation.
	 */
	public Evaluation(int note, String commentaire, Produit produit, Acheteur acheteur) {
		this.note = note;
		this.commentaire = commentaire;
		this.produit = produit;
		this.acheteur= acheteur;
		
	}


	public int getNote() {
		return this.note;
	}

	public void setNote(int aNote) {
		this.note = aNote;
	}

	public String getCommentaire() {
		return this.commentaire;
	}

	public void setCommentaire(String aCommentaire) {
		this.commentaire = aCommentaire;
	}
}