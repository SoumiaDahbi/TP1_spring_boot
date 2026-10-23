package gestion_stock.com.repositories;
import gestion_stock.com.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CategorieRepository extends JpaRepository<Categorie, Long> {}