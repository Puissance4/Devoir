public class Evaluation {
	private int note;
	private String commentaire;
	public Produit produit;
	public Acheteur laisse_evalutation;

	public Evaluation(int note,String commentaire,Produit produit,Acheteur laisse_evaluation) {
		this.note = note;
		this.commentaire = commentaire;
		this.produit = produit;
		this.laisse_evalutation= laisse_evaluation;
		
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