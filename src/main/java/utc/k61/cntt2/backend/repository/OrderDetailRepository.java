package utc.k61.cntt2.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utc.k61.cntt2.backend.domain.CustomerOrderDetail;

@Repository
public interface OrderDetailRepository extends JpaRepository<CustomerOrderDetail, Long> {
}
