import java.util.Date;
import java.util.Vector;

public class Commande {
	private float _cout;
	private String _adresse;
	private String _telephone;
	private Produit[] _produits;
	private Carte _carte;
	private String _id;
	private EtatsCommande _etat;
	private Date _dateArrivee;
	private String _infoLivraison;
	private int _numSuivi;
	private String _compagnieExp;
	public Acheteur _unnamed_Acheteur_;
	public Vector<BilletSignalement> _peut_avoir = new Vector<BilletSignalement>();
	public Vector<Produit> _comporter = new Vector<Produit>();

	public Retour retour() {
		throw new UnsupportedOperationException();
	}

	public Echange echange() {
		throw new UnsupportedOperationException();
	}

	public void annuler() {
		throw new UnsupportedOperationException();
	}

	public void confirmerReception() {
		throw new UnsupportedOperationException();
	}

	public void setCout(Object aFloat_36) {
		throw new UnsupportedOperationException();
	}

	public void setAdresse(String aAdr) {
		this._adresse = aAdr;
	}

	public void setTelephone(String aTel) {
		this._telephone = aTel;
	}

	public void setCarte(Carte aCarte) {
		this._carte = aCarte;
	}

	public void setInfoLivraison(String aInfo) {
		this._infoLivraison = aInfo;
	}

	public void setID(String aId) {
		throw new UnsupportedOperationException();
	}

	public BilletSignalement signaler() {
		throw new UnsupportedOperationException();
	}

	public int getNumSuivi() {
		return this._numSuivi;
	}

	public void setNumSuivi(int aNumSuivi) {
		this._numSuivi = aNumSuivi;
	}

	public String getCompagnieExp() {
		return this._compagnieExp;
	}

	public void setCompagnieExp(String aCompagnieExp) {
		this._compagnieExp = aCompagnieExp;
	}

	public Date getDateArrivee() {
		return this._dateArrivee;
	}

	public void setDateArrivee(Date aDateArrivee) {
		this._dateArrivee = aDateArrivee;
	}
}