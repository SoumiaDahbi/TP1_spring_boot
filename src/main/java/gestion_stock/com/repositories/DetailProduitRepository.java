package gestion_stock.com.repositories;
import gestion_stock.com.entities.DetailProduit;
import org.springframework.data.jpa.repository.JpaRepository;
public interface DetailProduitRepository extends JpaRepository<DetailProduit, Long> {}