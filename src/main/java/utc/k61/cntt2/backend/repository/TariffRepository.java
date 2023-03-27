package utc.k61.cntt2.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utc.k61.cntt2.backend.domain.Tariff;

@Repository
public interface TariffRepository extends JpaRepository<Tariff, Long> {
}
