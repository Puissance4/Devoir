public class BilletSignalement {
	private String _descProbleme;
	private String _descSolution;
	private int _numSuiviDefectueux;
	private String _confirmationLivraisonProdDef;
	private String _descProdRem;
	private int _numSuiviProdRem;
	private String _confirmationLivraisonProdRem;
	public Commande _unnamed_Commande_;

	public void setDescProbleme(String aDescriptionProbleme) {
		this._descProbleme = aDescriptionProbleme;
	}

	public void setDescSolution(String aDescriptionSolution) {
		this._descSolution = aDescriptionSolution;
	}

	public void setNumSuiviProdDef(int aNumeroSuivi) {
		throw new UnsupportedOperationException();
	}

	public void setConfirmationLivraisonProdDef(String aConfirmation) {
		this._confirmationLivraisonProdDef = aConfirmation;
	}

	public void setDescProdRem(String aDescription) {
		this._descProdRem = aDescription;
	}

	public void setNumSuiviProdRem(int aNumero) {
		this._numSuiviProdRem = aNumero;
	}

	public void setConfirmationLivraisonProdRem(String aConfirmation) {
		this._confirmationLivraisonProdRem = aConfirmation;
	}
}