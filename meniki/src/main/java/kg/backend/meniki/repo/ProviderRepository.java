package kg.backend.meniki.repo;

import kg.backend.meniki.model.Product;
import kg.backend.meniki.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProviderRepository extends JpaRepository<Supplier, Long> {

//    void addProduct(Product product);
}
