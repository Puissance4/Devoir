public class MetriquesProduit extends Metriques {
	private int _note;
	private int _nombreEvaluation = 0;
	public Produit unnamed_Produit;

	public int getNote() {
		return this._note;
	}

	public void setNote(int aNote) {
		this._note = aNote;
	}

	public int getNombreEvaluation() {
		return this._nombreEvaluation;
	}

	public void setNombreEvaluation(int aNombreEvaluation) {
		this._nombreEvaluation = aNombreEvaluation;
	}
}