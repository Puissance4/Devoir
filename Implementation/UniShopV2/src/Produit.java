import java.time.LocalDate;
import java.util.ArrayList;

/**
 * La classe Produit représente un article disponible à la vente sur la plateforme.
 * Elle contient des informations sur le titre, la catégorie, la description, la quantité, le prix,
 * les points bonus associés, l'identifiant unique, et le lien vers une image ou vidéo représentative.
 * La classe gère également les promotions et les évaluations liées au produit.
 */
public class Produit {

	/**
	 * Constructeur complet pour créer un produit avec toutes les informations spécifiées.
	 *
	 * @param titre Le titre du produit.
	 * @param categorie La catégorie du produit.
	 * @param description La description du produit.
	 * @param quantite La quantité disponible du produit.
	 * @param prix Le prix du produit.
	 * @param pointBonus Les points bonus associés à l'achat du produit.
	 * @param identifiant L'identifiant unique du produit.
	 * @param lienImageOuVideo Le lien vers l'image ou la vidéo du produit.
	 */
	public Produit(String titre, Categorie categorie, String description, int quantite, float prix, int pointBonus, String identifiant, String lienImageOuVideo) {
		this.titre = titre;
		this.categorie = categorie;
		this.description = description;
		this.quantite = quantite;
		this.prix = prix;
		this.pointBonus = pointBonus;
		this.identifiant = identifiant;
		this.lienImageOuVideo = lienImageOuVideo;
	}

	/**
	 * Constructeur pour créer un produit à partir d'un tableau de chaînes représentant ses attributs.
	 *
	 * @param donnee Le tableau de chaînes contenant les informations du produit.
	 */
	public Produit (String [] donnee){

		this.titre=donnee[0];

		// categorie
		String[] cate=donnee[1].split(";");
		if (cate[0].equals("Papeterie")){this.categorie=new Papeterie(cate[1], cate[2], cate[3]);}
		
		else if (cate[0].equals("Livres")){
			LocalDate dateParution= LocalDate.of(Integer.parseInt(cate[5]), Integer.parseInt(cate[6]), Integer.parseInt(cate[7]));
			this.categorie=new Livres(cate[1], cate[2], cate[3],cate[4],dateParution,cate[8],cate[9]);}

		else if (cate[0].equals("EquipementBureau")){this.categorie=new EquipementBureau(cate[1], cate[2], cate[3]);}

		else if (cate[0].equals("Ressource")){
			LocalDate dateressource= LocalDate.of(Integer.parseInt(cate[4]), Integer.parseInt(cate[5]), Integer.parseInt(cate[6]));
			TypeRessource type;
			if (cate[7].equals("Imprime")) {
				type = TypeRessource.Imprime;
			} else {
				type = TypeRessource.Electronique;}
			this.categorie=new Ressource(cate[1], cate[2], cate[3],dateressource,type,cate[8]);}
		else if (cate[0].equals("MaterielInformatique")){
			LocalDate datelancement= LocalDate.of(Integer.parseInt(cate[3]), Integer.parseInt(cate[4]), Integer.parseInt(cate[5]));
			this.categorie=new MaterielInformatique(cate[1], cate[2],datelancement, cate[6]);}
		

		this.description =donnee[2];
		this.quantite =Integer.parseInt(donnee[3]);
		this.prix =Float.parseFloat(donnee[4]);
		this.pointBonus =Integer.parseInt(donnee[5]);
		this.identifiant =donnee[6];
		this.lienImageOuVideo =donnee[7];
		this.nombreLike=Integer.parseInt(donnee[8]);
		if (!(donnee[9].equals("null"))){
			System.out.println(donnee[9]);
			this.prixPromotionnel=Float.parseFloat(donnee[9]);}
		if (!(donnee[10].equals("null"))){this.pointBonusPromotionnel=Integer.parseInt(donnee[10]);}
		if (!(donnee[11].equals("null"))){
			String[] date=donnee[1].split(";");	
			this.dateFinPromotion=LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));

		}
		// a faire evaluation
	}

	private Revendeur revendeur;
	private String titre;
	public Categorie categorie;
	private String description;
	private int quantite;
	private float prix;
	private int pointBonus;
	private String identifiant;
	private String lienImageOuVideo;
	private int nombreLike = 0;
	private Float prixPromotionnel;
	private int pointBonusPromotionnel;
	private LocalDate dateFinPromotion;
	//public MetriquesProduit unnamedMetriquesProduit;
	public ArrayList<Evaluation> listeEvaluation = new ArrayList<>();
	public ArrayList<Acheteur> utilisateursLikes = new ArrayList<>();

	/**
	 * Vérifie si la promotion associée au produit est toujours valide à la date spécifiée.
	 *
	 * @param date La date à laquelle la validité de la promotion doit être vérifiée.
	 * @return true si la promotion est valide (c'est-à-dire, la date actuelle est antérieure à la date de fin de promotion); sinon, false.
	 */
	public boolean isPromotionValide(LocalDate date) {

		if (this.dateFinPromotion == null) {
			return false;
		} else {
			return date.isBefore(this.dateFinPromotion);
		}
	}

	public void modifier() {
		throw new UnsupportedOperationException();
	}

	public int getNombreLike() {
		return this.nombreLike;
	}

	public String get_titre() {
		return this.titre;
	}
	public float get_prix() {
		return get_prix(LocalDate.now());}


	public float get_prix(LocalDate date) {
		if (this.isPromotionValide(date)) {
			return this.prixPromotionnel;
		} else {
			return this.prix;
		}
	}

	public String getCategorieBuff() throws Exception{

		if (this.categorie instanceof Papeterie){
			Papeterie cat=(Papeterie) this.categorie;
			return "Papeterie"+";"+cat.getMarque()+";"+cat.getModele()+";"+cat.getSousCategorieString();
		}
		if (this.categorie instanceof Livres){
			Livres cat=(Livres) this.categorie;
			return "Livres"+";"+cat.getIsbn()+";"+cat.getAuteur()+";"+cat.getMaisonEdition()+";"+cat.getGenreString()+";"+cat.getDateParutionBuff()+";"+cat.getNumEdition()+";"+cat.getNumVolume();
		}

		if (this.categorie instanceof Ressource){
			Ressource cat=(Ressource) this.categorie;
			return "Ressource"+";"+cat.getIsbn()+";"+cat.getAuteur()+";"+cat.getOrganisation()+";"+cat.getDateParutionBuff()+";"+cat.getTypeString()+";"+cat.getNumEdition();
		}
		if (this.categorie instanceof MaterielInformatique){
			MaterielInformatique cat=(MaterielInformatique) this.categorie;
			return "MaterielInformatique"+";"+cat.getMarque()+";"+cat.getModele()+";"+cat.getDateLancementBuff()+";"+cat.getSousCategorieString();
		}
		if (this.categorie instanceof EquipementBureau){
			EquipementBureau cat=(EquipementBureau) this.categorie;
			return "EquipementBureau"+";"+cat.getMarque()+";"+cat.getModele()+";"+cat.getSousCategorieString();
		}
		else{
			throw new Exception("pas de catégorie");
		}
	}

	public String getCategorieString(){
		if (this.categorie instanceof Papeterie){
			return "Papeterie";
		}
		if (this.categorie instanceof Livres){
			return "Livres et manuels";
		}
		if (this.categorie instanceof Ressource){
			return "Ressource d'apprentissage";
		}
		if (this.categorie instanceof MaterielInformatique){
			return "Matériel Informatique";
		}
		if (this.categorie instanceof EquipementBureau){
			return "Équipement de bureau";
		}
		else{
			return "Pas de catégorie";
		}
	}
	
	public void setNombreLike(int aNombreLike) {
		this.nombreLike = aNombreLike;
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
		return this.identifiant;
	}
	public String getDesc() {
		return this.description;
	}
	public int getQuantite() {
		return this.quantite;
	}
	public void setQuantite(int q) {
		 this.quantite=q;
	}
	public int getPointsBonus() {
		return getPointsBonus(LocalDate.now());
	}

	public int getPointsBonus(LocalDate date) {
		if (this.isPromotionValide(date)) {
			return this.pointBonusPromotionnel;
		} else {
			return this.pointBonus;
		}
	}
	public String getPrixPromobuff(){
		if (this.isPromotionValide(LocalDate.now())) {
			return ""+this.prixPromotionnel;}
		else{return "null";}	
	}

	public int getPointsBonusNormal(){
		return this.pointBonus;
	}
	public String getPointsBonusPromoBuff(){
		if (this.isPromotionValide(LocalDate.now())) {
			return ""+this.pointBonusPromotionnel;}
		else{return "null";}	
	}
	public String getDateFinPromotionBuff(){
		if (this.isPromotionValide(LocalDate.now())) {
			return this.dateFinPromotion.getYear()+";"+this.dateFinPromotion.getMonth()+";"+this.dateFinPromotion.getDayOfMonth();}
		else{return "null";}
	}
	
	public String getLien() {
		return this.lienImageOuVideo;
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
        return categorie;
    }

    public String get_description() {
        return description;
    }

    public String get_lienImageOuVideo() {
        return lienImageOuVideo;
    }

	public void setFinPromotion(LocalDate dateFin) {
		this.dateFinPromotion = dateFin;
	}

	public void setPrixPromotionnel(float prix) {
		this.prixPromotionnel = prix;
	}

	public void setPointBonusPromotionnel(int pointBonus) {
		this.pointBonusPromotionnel = pointBonus;
	}

	public Revendeur getRevendeur() {
		return revendeur;
	}

	public void setRevendeur(Revendeur revendeur) {
		this.revendeur = revendeur;
	}
}