import java.util.Vector;

public class Produit {

	public Produit(String titre, Categorie categorie, String description, int quantite, float prix, int pointBonus, String identifiant, String lienImageOuVideo) {
		this._titre = titre;
		this._categorie = categorie;
		this._description = description;
		this._quantite = quantite;
		this._prix = prix;
		this._pointBonus = pointBonus;
		this._identifiant = identifiant;
		this._lienImageOuVideo = lienImageOuVideo;
	}

    private String _titre;
	private Categorie _categorie;
	private String _description;
	private int _quantite;
	private float _prix;
	private int _pointBonus;
	private String _identifiant;
	private String _lienImageOuVideo;
	private int _nombreLike = 0;
	public Vector<Panier> _contient = new Vector<Panier>();
	public Vector<Commande> _comporter = new Vector<Commande>();
	public Categorie _unnamed_Categorie_;
	public MetriquesProduit _unnamed_MetriquesProduit_;
	public Vector<Evaluation> evaluation = new Vector<Evaluation>();

	public void modifier() {
		throw new UnsupportedOperationException();
	}

	public int getNombreLike() {
		return this._nombreLike;
	}

	public void setNombreLike(int aNombreLike) {
		this._nombreLike = aNombreLike;
	}

	public void ajouterAuPanier(Acheteur aAcheteur) {
		throw new UnsupportedOperationException();
	}

	public Evaluation evaluer(int aNote, String aCommentaire) {
		throw new UnsupportedOperationException();
	}

	public String getIdentifiant() {
		return this._identifiant;
	}
}