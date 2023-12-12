public class Evaluation {
	private int note;
	private String commentaire;
	public Produit produit;
	public Acheteur acheteur;

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