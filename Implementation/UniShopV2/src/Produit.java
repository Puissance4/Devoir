import com.sun.source.tree.BreakTree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Produit {

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
	private Revendeur revendeur;
	//public MetriquesProduit unnamedMetriquesProduit;
	public ArrayList<Evaluation> listeEvaluation = new ArrayList<>();
	public ArrayList<Acheteur> utilisateursLikes = new ArrayList<>();

	public boolean isPromotionValide() {
		if (this.dateFinPromotion == null) {
			return false;
		} else {
			return LocalDate.now().isBefore(this.dateFinPromotion);
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
		if (this.isPromotionValide()) {
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
		if (this.isPromotionValide()) {
			return this.pointBonusPromotionnel;
		} else {
			return this.pointBonus;
		}
	}
	public String getPrixPromobuff(){
		if (this.isPromotionValide()) {
			return ""+this.prixPromotionnel;}
		else{return "null";}	
	}

	public int getPointsBonusNormal(){
		return this.pointBonus;
	}
	public String getPointsBonusPromoBuff(){
		if (this.isPromotionValide()) {
			return ""+this.pointBonusPromotionnel;}
		else{return "null";}	
	}
	public String getDateFinPromotionBuff(){
		if (this.isPromotionValide()) {
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
	public Revendeur getRevendeur(){return revendeur;};

	public void setFinPromotion(LocalDate dateFin) {
		this.dateFinPromotion = dateFin;
	}

	public void setPrixPromotionnel(float prix) {
		this.prixPromotionnel = prix;
	}

	public void setPointBonusPromotionnel(int pointBonus) {
		this.pointBonusPromotionnel = pointBonus;
	}
}