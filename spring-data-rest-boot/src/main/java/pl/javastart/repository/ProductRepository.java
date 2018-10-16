package pl.javastart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.javastart.model.Product;

@RepositoryRestResource(
        path = "products",
        collectionResourceRel = "products",
        exported = false
)
public interface ProductRepository extends JpaRepository<Product, Long> {
}
