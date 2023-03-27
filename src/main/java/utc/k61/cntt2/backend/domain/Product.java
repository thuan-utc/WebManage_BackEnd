package utc.k61.cntt2.backend.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "product_name", length = 30)
    private String productName;
    @Column(name = "product_description", length = 255)
    private String productDescription;
    @ManyToMany(mappedBy = "products")
    private Set<CustomerOrderDetail> customerOrderDetails = new HashSet<>();
    private Double price;

    public Set<CustomerOrderDetail> getCustomerOrderDetails() {
        return customerOrderDetails;
    }

    public void setCustomerOrderDetails(Set<CustomerOrderDetail> customerOrderDetails) {
        this.customerOrderDetails = customerOrderDetails;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    public Product() {
    }

    public Product(Long id, String productName, String productDescription, Set<CustomerOrderDetail> customerOrderDetails, LocalDateTime createdDate, Double price) {
        this.id = id;
        this.productName = productName;
        this.productDescription = productDescription;
        this.customerOrderDetails = customerOrderDetails;
        this.createdDate = createdDate;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Set<CustomerOrderDetail> getOrderDetails() {
        return customerOrderDetails;
    }

    public void setOrderDetails(Set<CustomerOrderDetail> customerOrderDetails) {
        this.customerOrderDetails = customerOrderDetails;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}