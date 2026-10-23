package gestion_stock.com;

import gestion_stock.com.entities.*;
import gestion_stock.com.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {

    private final CategorieRepository categorieRepo;
    private final FournisseurRepository fournisseurRepo;
    private final DetailProduitRepository detailRepo;
    private final TagRepository tagRepo;
    private final ProduitRepository produitRepo;

    public DataInitializer(CategorieRepository categorieRepo, FournisseurRepository fournisseurRepo,
                           DetailProduitRepository detailRepo, TagRepository tagRepo, ProduitRepository produitRepo) {
        this.categorieRepo = categorieRepo;
        this.fournisseurRepo = fournisseurRepo;
        this.detailRepo = detailRepo;
        this.tagRepo = tagRepo;
        this.produitRepo = produitRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        if (produitRepo.count() > 0) return;

        // Catégories
        Categorie c1 = categorieRepo.save(new Categorie(null, "Antibiotiques", "Médicaments utilisés pour traiter les infections bactériennes.", null));
        Categorie c2 = categorieRepo.save(new Categorie(null, "Antalgiques", "Médicaments pour soulager la douleur.", null));
        Categorie c3 = categorieRepo.save(new Categorie(null, "Vitamines", "Compléments nutritionnels et fortifiants.", null));
        Categorie c4 = categorieRepo.save(new Categorie(null, "Antiseptiques", "Produits désinfectants pour usage externe.", null));

        // Fournisseurs
        Fournisseur f1 = fournisseurRepo.save(new Fournisseur(null, "PharmaMaroc", "contact@pharmamaroc.ma", "Casablanca, Maroc", null));
        Fournisseur f2 = fournisseurRepo.save(new Fournisseur(null, "Medisup France", "info@medisup.fr", "Paris, France", null));
        Fournisseur f3 = fournisseurRepo.save(new Fournisseur(null, "Sandoz", "export@sandoz.com", "Bâle, Suisse", null));
        Fournisseur f4 = fournisseurRepo.save(new Fournisseur(null, "Cooper Pharma", "support@cooperpharma.ma", "Rabat, Maroc", null));

        // Détails Produits
        DetailProduit d1 = detailRepo.save(new DetailProduit(null, "Sanofi", "France", "Amoxicilline trihydratée 500 mg", "500 mg", "Infections ORL et respiratoires"));
        DetailProduit d2 = detailRepo.save(new DetailProduit(null, "Bayer", "Allemagne", "Paracétamol 500mg", "500 mg", "Douleurs légères à modérées, fièvre"));
        DetailProduit d3 = detailRepo.save(new DetailProduit(null, "Pfizer", "États-Unis", "Vitamine C 1000 mg", "1000 mg", "Renforcement immunitaire"));
        DetailProduit d4 = detailRepo.save(new DetailProduit(null, "Johnson & Johnson", "Maroc", "Povidone iodée 10%", "10%", "Désinfection des plaies"));
        DetailProduit d5 = detailRepo.save(new DetailProduit(null, "GSK", "Royaume-Uni", "Ibuprofène 400 mg", "400 mg", "Inflammations et douleurs musculaires"));

        // Tags
        Tag t1 = tagRepo.save(new Tag(null, "Sans ordonnance", null));
        Tag t2 = tagRepo.save(new Tag(null, "Prescription obligatoire", null));
        Tag t3 = tagRepo.save(new Tag(null, "En promotion", null));
        Tag t4 = tagRepo.save(new Tag(null, "Stock limité", null));
        Tag t5 = tagRepo.save(new Tag(null, "Importé", null));

        // Produits
        Produit p1 = new Produit();
        p1.setNom("Amoxicilline 500mg");
        p1.setDescription("Antibiotique à large spectre.");
        p1.setPrix(new BigDecimal("45.00"));
        p1.setCodeBarre("AMX500-2025");
        p1.setDateExpiration(LocalDate.parse("2026-03-10"));
        p1.setCategorie(c1);
        p1.setFournisseur(f1);
        p1.setDetailProduit(d1);
        p1.setTags(List.of(t2));
        produitRepo.save(p1);

        Produit p2 = new Produit();
        p2.setNom("Doliprane 500mg");
        p2.setDescription("Antalgique et antipyrétique.");
        p2.setPrix(new BigDecimal("25.50"));
        p2.setCodeBarre("DLP500-2025");
        p2.setDateExpiration(LocalDate.parse("2025-11-01"));
        p2.setCategorie(c2);
        p2.setFournisseur(f2);
        p2.setDetailProduit(d2);
        p2.setTags(List.of(t1, t3));
        produitRepo.save(p2);

        Produit p3 = new Produit();
        p3.setNom("Vitamine C 1000mg");
        p3.setDescription("Complément pour renforcer les défenses.");
        p3.setPrix(new BigDecimal("30.00"));
        p3.setCodeBarre("VITC1000-2025");
        p3.setDateExpiration(LocalDate.parse("2026-06-15"));
        p3.setCategorie(c3);
        p3.setFournisseur(f3);
        p3.setDetailProduit(d3);
        p3.setTags(List.of(t1, t5));
        produitRepo.save(p3);

        Produit p4 = new Produit();
        p4.setNom("Bétadine Solution 10%");
        p4.setDescription("Désinfectant pour usage externe.");
        p4.setPrix(new BigDecimal("18.00"));
        p4.setCodeBarre("BETADINE10-2025");
        p4.setDateExpiration(LocalDate.parse("2027-01-30"));
        p4.setCategorie(c4);
        p4.setFournisseur(f4);
        p4.setDetailProduit(d4);
        p4.setTags(List.of(t1, t4));
        produitRepo.save(p4);

        Produit p5 = new Produit();
        p5.setNom("Nurofen 400mg");
        p5.setDescription("Soulage la douleur et la fièvre.");
        p5.setPrix(new BigDecimal("42.00"));
        p5.setCodeBarre("NURO400-2025");
        p5.setDateExpiration(LocalDate.parse("2026-02-20"));
        p5.setCategorie(c2);
        p5.setFournisseur(f3);
        p5.setDetailProduit(d5);
        p5.setTags(List.of(t1, t5));
        produitRepo.save(p5);
    }
}