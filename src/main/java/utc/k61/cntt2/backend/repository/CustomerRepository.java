package utc.k61.cntt2.backend.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import utc.k61.cntt2.backend.domain.Customer;
import utc.k61.cntt2.backend.dto.CustomerDto;
import utc.k61.cntt2.backend.dto.CustomerSearchCriteria;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Customer c SET c.address = :address, c.email = :email, c.phoneNumber = :phoneNumber, c.customerName = :customerName WHERE c.id = :customerId")
    void updateCustomer(@Param("customerId") Long customerId, @Param("address") String address, @Param("email") String email, @Param("phoneNumber") String phoneNumber, @Param("customerName") String customerName);

    Page<Customer> findAllByIsDeletedFalse(Pageable pageable);

    List<Customer> findAllByIsDeletedFalse();
}
