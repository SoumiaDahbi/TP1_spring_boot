package gestion_stock.com.controllers.api;

import gestion_stock.com.entities.Produit;
import gestion_stock.com.repositories.ProduitRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/produits")
public class ProduitRestController {

    private final ProduitRepository produitRepository;

    public ProduitRestController(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @GetMapping
    public List<Produit> getAll() { return produitRepository.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Produit> getById(@PathVariable Long id) {
        return produitRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Produit> create(@RequestBody Produit produit) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produitRepository.save(produit));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produit> update(@PathVariable Long id, @RequestBody Produit pDetails) {
        return produitRepository.findById(id).map(p -> {
            p.setNom(pDetails.getNom());
            p.setDescription(pDetails.getDescription());
            p.setPrix(pDetails.getPrix());
            p.setCodeBarre(pDetails.getCodeBarre());
            p.setDateExpiration(pDetails.getDateExpiration());
            if (pDetails.getCategorie() != null) p.setCategorie(pDetails.getCategorie());
            if (pDetails.getFournisseur() != null) p.setFournisseur(pDetails.getFournisseur());
            if (pDetails.getDetailProduit() != null) p.setDetailProduit(pDetails.getDetailProduit());
            if (pDetails.getTags() != null) p.setTags(pDetails.getTags());
            return ResponseEntity.ok(produitRepository.save(p));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (produitRepository.existsById(id)) {
            produitRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}