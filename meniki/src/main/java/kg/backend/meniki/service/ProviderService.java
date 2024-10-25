package kg.backend.meniki.service;

import kg.backend.meniki.model.Product;
import kg.backend.meniki.model.Supplier;

import java.util.List;
import java.util.Optional;

public interface ProviderService {
    // Метод для получения всех поставщиков
    List<Supplier> getAllSuppliers();

    // Метод для получения поставщика по ID
    Optional<Supplier> getSupplierById(Long id);

    // Метод для добавления или обновления поставщика
    Supplier saveOrUpdateSupplier(Supplier supplier);

    // Метод для удаления поставщика
    void deleteSupplier(Long id);

    void addNewProduct(Product product);

//    void addNewProduct2(Product product);
}
