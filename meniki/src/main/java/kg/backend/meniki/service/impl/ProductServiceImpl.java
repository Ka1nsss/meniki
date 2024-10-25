package kg.backend.meniki.service.impl;

import kg.backend.meniki.dto.ImageDto;
import kg.backend.meniki.dto.ImageResponseDto;
import kg.backend.meniki.model.Product;
import kg.backend.meniki.repo.ProductRepository;
import kg.backend.meniki.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    public Product save(Product product) {
        productRepository.save(product);
        return product;
    }

    public void delete(Long id, Product product) {
        productRepository.delete(product);
    }


    public List<Product> findAll() {
        return productRepository.findAll();
    }



    public void findById(Long id) {
        productRepository.findById(id);
    }


    public void findByName(String name) {
        productRepository.findByName(name);
    }


    public Product findByDescription(String description) {
      return   productRepository.findByDescription(description);
    }

//
//    public List<Product> findByCategory(String category) {
//        return productRepository.findByCategory(category);
//    }
//
//
    public List<Product> findByDescriptionAndCategory(String description, String category) {
        return productRepository.findByDescriptionAndCategory(description, category);
    }

    public void createProduct(Product product) {
        productRepository.save(product);
    }


    public void update(Long id, Product product) {
        Product newProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        newProduct.setName(newProduct.getName());
        newProduct.setDescription(newProduct.getDescription());
        newProduct.setPrice(newProduct.getPrice());
        newProduct.setQuantity(newProduct.getQuantity());
        productRepository.save(newProduct);
    }

    @Override
    public List<ImageResponseDto> getImage() {
        List<ImageDto> imageDtos = productRepository.findAllImageBytesAndName();
        return imageDtos.stream().map(imageDto -> new ImageResponseDto(imageDto.getId(),
                Base64.getEncoder().encodeToString(imageDto.getImageBytes()),
                imageDto.getName())).collect(Collectors.toList());
    }

}


