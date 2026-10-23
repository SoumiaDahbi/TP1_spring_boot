package gestion_stock.com.repositories;
import gestion_stock.com.entities.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TagRepository extends JpaRepository<Tag, Long> {}