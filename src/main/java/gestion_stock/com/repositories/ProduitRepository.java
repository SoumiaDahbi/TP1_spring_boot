package gestion_stock.com.repositories;
import gestion_stock.com.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProduitRepository extends JpaRepository<Produit, Long> {}