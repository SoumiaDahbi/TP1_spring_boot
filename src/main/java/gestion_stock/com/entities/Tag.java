package gestion_stock.com.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle;

    @ManyToMany(mappedBy = "tags")
    @JsonIgnore
    private List<Produit> produits;

    public Tag() {}

    public Tag(Long id, String libelle, List<Produit> produits) {
        this.id = id;
        this.libelle = libelle;
        this.produits = produits;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getLibelle() { return libelle; }
    public void setLibelle(String libelle) { this.libelle = libelle; }

    public List<Produit> getProduits() { return produits; }
    public void setProduits(List<Produit> produits) { this.produits = produits; }
}