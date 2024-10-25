package kg.backend.meniki.controller;

import kg.backend.meniki.model.Product;
import kg.backend.meniki.model.Supplier;
import kg.backend.meniki.service.ProviderService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/supplier")
@AllArgsConstructor
@Slf4j
public class SupplierController {

    private final ProviderService providerService;

    // Получить всех поставщиков
    @GetMapping("/getall")
    public List<Supplier> getAllSuppliers() {
        return providerService.getAllSuppliers();
    }

    // Получить поставщика по ID
    @GetMapping("/getSupplier/{id}")
    public ResponseEntity<Supplier> getSupplierById(@PathVariable Long id) {
        Optional<Supplier> supplier = providerService.getSupplierById(id);
        return supplier.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Добавить или обновить поставщика
    @PostMapping("/add-or-update")
    public Supplier saveOrUpdateSupplier(@RequestBody Supplier supplier) {
        return providerService.saveOrUpdateSupplier(supplier);
    }

    // Удалить поставщика по ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSupplier(@PathVariable Long id) {
        providerService.deleteSupplier(id);
        return ResponseEntity.ok().build();
    }

    // Добавить новый продукт
    @PostMapping("/add/product")
    public ResponseEntity<Product> addNewProduct(@RequestBody Product product) {
        providerService.addNewProduct(product);
        log.info("Проверка какой метод работает: это с помощью продукт репы");
        return ResponseEntity.ok(product);
    }


//    @PostMapping("/product")
//    public ResponseEntity<Product> addNewProduct2(@RequestBody Product product) {
//        providerService.addNewProduct2(product);
//        log.info("Проверка какой метод работает: это с помощью репы провайдер");
//        return ResponseEntity.ok(product);
//
//    }




}
