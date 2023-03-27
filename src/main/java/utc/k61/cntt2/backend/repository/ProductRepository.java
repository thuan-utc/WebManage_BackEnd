package utc.k61.cntt2.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utc.k61.cntt2.backend.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
