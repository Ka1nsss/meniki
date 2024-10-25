package kg.backend.meniki.service.impl;

import kg.backend.meniki.model.Product;
import kg.backend.meniki.model.Supplier;
import kg.backend.meniki.repo.ProductRepository;
import kg.backend.meniki.repo.ProviderRepository;
import kg.backend.meniki.service.ProviderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ProviderServiceImpl implements ProviderService {

    private ProviderRepository providerRepository;
    private ProductRepository productRepository;

    // Метод для получения всех поставщиков
    public List<Supplier> getAllSuppliers() {
        return providerRepository.findAll();
    }

    // Метод для получения поставщика по ID
    public Optional<Supplier> getSupplierById(Long id) {
        return providerRepository.findById(id);
    }

    // Метод для добавления или обновления поставщика
    public Supplier saveOrUpdateSupplier(Supplier supplier) {
        return providerRepository.save(supplier);
    }

    // Метод для удаления поставщика
    public void deleteSupplier(Long id) {
        providerRepository.deleteById(id);
    }

    public void addNewProduct(Product product) {
        productRepository.save(product);
    }

//    public void addNewProduct2(Product product) {
//        providerRepository.addProduct(product);
//    }



}



