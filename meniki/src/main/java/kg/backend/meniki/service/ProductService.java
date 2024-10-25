package kg.backend.meniki.service;

import kg.backend.meniki.dto.ImageResponseDto;
import kg.backend.meniki.model.Product;

import java.util.List;

public interface ProductService {

    Product save(Product product);

    void update(Long id, Product product);

    void delete(Long id, Product product);

    List<Product> findAll();

    void findById(Long id);

    void findByName(String name);

    Product findByDescription(String description);

//    List<Product> findByCategory(String category);
//
    List<Product> findByDescriptionAndCategory(String description, String category);

    void createProduct(Product product);

    List<ImageResponseDto> getImage();
}
