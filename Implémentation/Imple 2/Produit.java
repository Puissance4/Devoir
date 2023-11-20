import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

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
	private int prixPromotionnel;
	private int pointBonusPromotionnel;
	private LocalDate dateFinPromotion;
	public ArrayList<Panier> _contient = new ArrayList<>();
	public ArrayList<Commande> _comporter = new ArrayList<Commande>();
	public Categorie _unnamed_Categorie_;
	public MetriquesProduit _unnamed_MetriquesProduit_;
	public ArrayList<Evaluation> listeEvaluation = new ArrayList<>();

	public boolean isPromotionValide() {
    	return this.getFinPromotion().isAfter(LocalDate.now());
	}


	private LocalDate getFinPromotion() {
		return this.dateFinPromotion;
	}


	public void modifier() {
		throw new UnsupportedOperationException();
	}

	public int getNombreLike() {
		return this._nombreLike;
	}

	public String get_titre() {
		return this._titre;
	}
	public float get_prix() {
		if (this.isPromotionValide()) {
			return this.prixPromotionnel;
		} else {
			return this._prix;
		}
	}

	public String getCategorieString(){
		if (this._categorie instanceof Papeterie){
			return "Papeterie";
		}
		if (this._categorie instanceof Livres){
			return "Livres et manuels";
		}
		if (this._categorie instanceof Ressource){
			return "Ressource d'apprentissage";
		}
		if (this._categorie instanceof MaterielInformatique){
			return "Matériel Informatique";
		}
		if (this._categorie instanceof EquipementBureau){
			return "Équipement de bureau";
		}
		else{
			return "Pas de catégorie";
		}
	}
	public void setNombreLike(int aNombreLike) {
		this._nombreLike = aNombreLike;
	}

	public void ajouterAuPanier(Acheteur acheteur) {
		acheteur.getPanier().ajouter(this);
	}

	public Evaluation evaluer(int note, String commentaire, Acheteur acheteur) {
		Evaluation evaluation = new Evaluation(note, commentaire, this, acheteur);
		// Ajouter l'evaluation a la liste
		listeEvaluation.add(evaluation);
		return evaluation;
	}

	public String getIdentifiant() {
		return this._identifiant;
	}
	public String getDesc() {
		return this._description;
	}
	public int getQuantite() {
		return this._quantite;
	}
	public void setQuantite(int q) {
		 this._quantite=q;
	}
	public int getPointsBonus() {
		if (this.isPromotionValide()) {
			return this.pointBonusPromotionnel;
		} else {
			return this._pointBonus;
		}
	}
	public String getLien() {
		return this._lienImageOuVideo;
	}
	public void setevaluation(Evaluation evaluation) {
		if(!listeEvaluation.isEmpty() && listeEvaluation.contains(evaluation)){
			listeEvaluation.remove(evaluation);
		}
		else{
			listeEvaluation.add(evaluation);
		}
	}

    public Categorie get_categorie() {
        return _categorie;
    }

    public String get_description() {
        return _description;
    }

    public String get_lienImageOuVideo() {
        return _lienImageOuVideo;
    }

	public void setFinPromotion(LocalDate dateFin) {
		this.dateFinPromotion = dateFin;
	}

	public void setPrixPromotionnel(float prix) {
		this.prixPromotionnel = (int) prix;
	}

	public void setPointBonusPromotionnel(int pointBonus) {
		this.pointBonusPromotionnel = pointBonus;
	}
}