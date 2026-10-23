package gestion_stock.com.repositories;
import gestion_stock.com.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {}