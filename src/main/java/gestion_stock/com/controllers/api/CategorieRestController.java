package gestion_stock.com.controllers.api;

import gestion_stock.com.entities.Categorie;
import gestion_stock.com.repositories.CategorieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategorieRestController {

    private final CategorieRepository categorieRepository;

    public CategorieRestController(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    // GET /api/categories -> Lister toutes les catégories
    @GetMapping
    public List<Categorie> getAll() {
        return categorieRepository.findAll();
    }

    // GET /api/categories/{id} -> Afficher une catégorie par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Categorie> getById(@PathVariable Long id) {
        return categorieRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/categories -> Ajouter une catégorie
    @PostMapping
    public ResponseEntity<Categorie> create(@RequestBody Categorie categorie) {
        Categorie saved = categorieRepository.save(categorie);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // PUT /api/categories/{id} -> Modifier une catégorie
    @PutMapping("/{id}")
    public ResponseEntity<Categorie> update(@PathVariable Long id, @RequestBody Categorie catDetails) {
        return categorieRepository.findById(id).map(c -> {
            c.setNom(catDetails.getNom());
            c.setDescription(catDetails.getDescription());
            Categorie updated = categorieRepository.save(c);
            return ResponseEntity.ok(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/categories/{id} -> Supprimer une catégorie
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (categorieRepository.existsById(id)) {
            categorieRepository.deleteById(id);
            return ResponseEntity.noContent().build(); // Statut 204 No Content
        }
        return ResponseEntity.notFound().build();
    }
}