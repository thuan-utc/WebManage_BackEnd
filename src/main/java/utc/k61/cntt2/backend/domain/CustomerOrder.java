package utc.k61.cntt2.backend.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "customer_order")
public class CustomerOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToOne(mappedBy = "customerOrder", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private Invoice invoice;
    @OneToMany(mappedBy = "customerOrder", cascade = CascadeType.ALL)
    private Set<CustomerOrderDetail> customerOrderDetails;
    @Column(name = "created_date", columnDefinition = "datetime default current_timestamp")
    private LocalDateTime createdDate;

    public CustomerOrder() {
    }

    public CustomerOrder(Long id, Customer customer, Invoice invoice, Set<CustomerOrderDetail> customerOrderDetails, LocalDateTime createdDate) {
        this.id = id;
        this.customer = customer;
        this.invoice = invoice;
        this.customerOrderDetails = customerOrderDetails;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Set<CustomerOrderDetail> getCustomerOrderDetails() {
        return customerOrderDetails;
    }

    public void setCustomerOrderDetails(Set<CustomerOrderDetail> customerOrderDetails) {
        this.customerOrderDetails = customerOrderDetails;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}

