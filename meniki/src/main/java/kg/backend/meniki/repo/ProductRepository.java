package kg.backend.meniki.repo;

import kg.backend.meniki.dto.ImageDto;
import kg.backend.meniki.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
     Product findByName(String name);
     Product findByDescription(String description);
     @Query("SELECT new kg.backend.meniki.dto.ImageDto(b.id, b.imageBytes, b.name) FROM Product b")
     List<ImageDto> findAllImageBytesAndName();

     @Query("SELECT new kg.backend.meniki.dto.ProductDto(b.id, b.description, b.name) FROM Product b")
     List<Product> findByDescriptionAndCategory(String description, String category);
//     List<Product> findByCategory(String category);
}
