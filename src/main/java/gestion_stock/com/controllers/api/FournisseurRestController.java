package gestion_stock.com.controllers.api;

import gestion_stock.com.entities.Fournisseur;
import gestion_stock.com.repositories.FournisseurRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fournisseurs")
public class FournisseurRestController {

    private final FournisseurRepository fournisseurRepository;

    public FournisseurRestController(FournisseurRepository fournisseurRepository) {
        this.fournisseurRepository = fournisseurRepository;
    }

    // GET /api/fournisseurs -> Lister tous les fournisseurs[cite: 4]
    @GetMapping
    public List<Fournisseur> getAll() {
        return fournisseurRepository.findAll();
    }

    // GET /api/fournisseurs/{id} -> Afficher un fournisseur par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Fournisseur> getById(@PathVariable Long id) {
        return fournisseurRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/fournisseurs -> Ajouter un fournisseur[cite: 5]
    @PostMapping
    public ResponseEntity<Fournisseur> create(@RequestBody Fournisseur fournisseur) {
        Fournisseur saved = fournisseurRepository.save(fournisseur);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    // PUT /api/fournisseurs/{id} -> Modifier un fournisseur[cite: 6]
    @PutMapping("/{id}")
    public ResponseEntity<Fournisseur> update(@PathVariable Long id, @RequestBody Fournisseur fDetails) {
        return fournisseurRepository.findById(id).map(f -> {
            f.setNom(fDetails.getNom());
            f.setContact(fDetails.getContact());
            f.setAdresse(fDetails.getAdresse());
            Fournisseur updated = fournisseurRepository.save(f);
            return ResponseEntity.ok(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/fournisseurs/{id} -> Supprimer un fournisseur[cite: 4]
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (fournisseurRepository.existsById(id)) {
            fournisseurRepository.deleteById(id);
            return ResponseEntity.noContent().build(); // Statut 204 No Content[cite: 4]
        }
        return ResponseEntity.notFound().build();
    }
}