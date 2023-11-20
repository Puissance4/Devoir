public enum CategorieNotif {
    // Catégories pour l'acheteur
    NOUVEL_ACHETEUR_SUITE("Un nouvel acheteur suit son profil"),
    NOUVEAU_PRODUIT_REVENDEUR_LIKE("Un de ses revendeurs « likés » met au marché un nouveau produit"),
    NOUVELLE_PROMOTION("Il y a une nouvelle promotion sur un de ses produits ou ses revendeurs « likés »"),
    CHANGEMENT_ETAT_COMMANDE("L'état (en production, en livraison, livré) d'une commande, d'un retour ou d'un échange a changé"),
    PROMOTION_SUR_PRODUIT_LIKE("Il y a une promotion sur un des produits que l'acheteur, ou un de ses suiveurs, a « liké »"),
    SOLUTION_PROPOSE("Un revendeur propose une solution sur un produit que l'acheteur a signalé un problème"),

    // Catégories pour le revendeur
    NOUVELLE_COMMANDE_RECUE("Un acheteur a effectue un nouvelle commande"),
    EVALUATION_PRODUIT("Un acheteur a evalue l'un de vos produit"),
    SIGNALEMENT_PROBLEME("Un acheteur signale un problème sur un de vos produits");

    private final String description;

    CategorieNotif(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
