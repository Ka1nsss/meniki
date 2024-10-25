package kg.backend.meniki.controller;


import io.swagger.v3.oas.annotations.Operation;
import kg.backend.meniki.dto.AuthRequest;
import kg.backend.meniki.dto.AuthResponse;
import kg.backend.meniki.dto.ImageResponseDto;
import kg.backend.meniki.model.Product;
import kg.backend.meniki.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/get/{id}")
    public void getProductById(@PathVariable Long id) {
         productService.findById(id);


    }

    @PostMapping("/create-product")
    public void createProduct(@RequestBody Product product) {
        productService.save(product);
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        productService.update(id, product);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id, @RequestBody Product product) {
        productService.delete(id,product);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/findByName")
    public void findByName(@RequestParam String name) {
        productService.findByName(name);
    }

    @GetMapping("/findByDescription")
    public Product findByDescription(@RequestParam String description) {
        return productService.findByDescription(description);
    }

//    @GetMapping("/findByCategory")
//    public List<Product> findByCategory(@RequestParam String category) {
//        return productService.findByCategory(category);
//    }
//
    @GetMapping("/findByCategoryAndDescription")
    public List<Product> findByCategoryAndDescription(@RequestParam String category, @RequestParam String description) {
        return productService.findByDescriptionAndCategory(category, description);
    }

    @GetMapping("/get-image")
    public ResponseEntity<List<ImageResponseDto>> getImage() {
        List<ImageResponseDto> image = productService.getImage();
        if (!image.isEmpty()) {
            return ResponseEntity.ok(image);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

}

