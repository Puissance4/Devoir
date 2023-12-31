public enum CategorieNotif {
    // Pour l'acheteur
    NOUVEL_ACHETEUR_SUIVI("Un nouvel acheteur suit votre profil"),
    REVENDEUR_LIKE_NOUVEAU_PRODUIT("Un de vos revendeurs 'likes' a mit au marché un nouveau produit"),
    PROMOTION_PRODUIT_LIKE("Nouvelle promotion sur un des produits ou revendeurs 'likes'"),
    CHANGEMENT_ETAT_COMMANDE("L'etat d'une commande, d'un retour ou d'un echange a change"),
    PROMOTION_PRODUIT_SUIVI("Promotion sur un produit que vous ou un de vos suiveurs a 'like'"),
    SOLUTION_PROBLEME_SIGNALE("Solution sur un produit signale"),
    PROMOTION_REVENDEUR_LIKE("Promotion sun un de vos renvendeur likes"),

    // Pour le revendeur
    NOUVELLE_COMMANDE("Une nouvelle commande est reçue sur un de vos produits"),
    EVALUATION_PRODUIT("Un de vos produits a reçut une évaluation par un acheteur"),
    PROBLEME_SIGNALE_PRODUIT("Un acheteur signale un problème sur un de vos produits");

    private final String description;

    CategorieNotif(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}