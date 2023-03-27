package utc.k61.cntt2.backend.domain;

import utc.k61.cntt2.backend.dto.CustomerDto;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "phone_number", nullable = false)
        private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    private boolean isDeleted;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<CustomerOrder> customerOrders;
    @Column(name = "created_date", columnDefinition = "datetime default current_timestamp")
    private LocalDateTime createdDate;
    public Customer() {
    }

    public Customer(Long id, String customerName, String phoneNumber, String email, String address, Set<CustomerOrder> customerOrders) {
        this.id = id;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.customerOrders = customerOrders;
    }

    public Customer(CustomerDto customerDto) {
        this.customerName = customerDto.getCustomerName();
        this.phoneNumber = customerDto.getPhoneNumber();
        this.email = customerDto.getEmail();
        this.address = customerDto.getAddress();
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<CustomerOrder> getCustomerOrders() {
        return customerOrders;
    }

    public void setCustomerOrders(Set<CustomerOrder> customerOrders) {
        this.customerOrders = customerOrders;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}