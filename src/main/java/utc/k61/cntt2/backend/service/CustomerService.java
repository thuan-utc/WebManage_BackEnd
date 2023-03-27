package utc.k61.cntt2.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import utc.k61.cntt2.backend.domain.Customer;
import utc.k61.cntt2.backend.dto.CustomerDto;
import utc.k61.cntt2.backend.dto.CustomerSearchCriteria;
import utc.k61.cntt2.backend.mapper.Mapper;
import utc.k61.cntt2.backend.repository.CustomerRepository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private Logger log = LoggerFactory.getLogger(CustomerService.class);
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Page<CustomerDto> getAllCustomer(Pageable pageable) {
        Page<Customer> customerPage = customerRepository.findAllByIsDeletedFalse(pageable);
        return customerPage.map(Mapper::mapToCustomerDto);
    }

    public Page<CustomerDto> getAllCustomerWithSearchParam(Pageable pageable, Map<String, String> searchParams) {
//        List<Customer> listFiltered = customerRepository.findAllByIsDeletedFalse();
//        searchParams.forEach((key, value) -> {
//                    switch (key) {
//                        case "id":
//                            Long id = Long.valueOf(value);
//                            listFiltered = listFiltered.stream().filter(customer -> customer.getId().equals(id)).collect(Collectors.toList());
//                            break;
//                        case "name":
//                            Long id = Long.valueOf(value);
//                            listFiltered = listFiltered.stream().filter(customer -> customer.getId().equals(id)).collect(Collectors.toList());
//                            break;
//                        case "phone":
//                            Long id = Long.valueOf(value);
//                            listFiltered = listFiltered.stream().filter(customer -> customer.getId().equals(id)).collect(Collectors.toList());
//                            break;
//                        case "email":
//                            Long id = Long.valueOf(value);
//                            listFiltered = listFiltered.stream().filter(customer -> customer.getId().equals(id)).collect(Collectors.toList());
//                            break;
//                        case "address":
//                            Long id = Long.valueOf(value);
//                            listFiltered = listFiltered.stream().filter(customer -> customer.getId().equals(id)).collect(Collectors.toList());
//                            break;
//                        case "createdDate":
//                            Long id = Long.valueOf(value);
//                            listFiltered = listFiltered.stream().filter(customer -> customer.getId().equals(id)).collect(Collectors.toList());
//                    }
//                }
//                Page < Customer > page = new PageImpl<>(listFiltered, pageable, listFiltered.size());
//        return page.map(Mapper::mapToCustomerDto);
        List<Customer> listFiltered = new ArrayList<>();
        if (searchParams != null) {
            listFiltered = customerRepository.findAllByIsDeletedFalse();
            if (searchParams.get("id") != null) {
                Long id = Long.parseLong(searchParams.get("id"));
                listFiltered = listFiltered.stream().filter(customer -> customer.getId().equals(id)).collect(Collectors.toList());
            }
            if (searchParams.get("name") != null) {
                String name = searchParams.get("name");
                listFiltered = listFiltered.stream().filter(customer -> customer.getCustomerName().equals(name)).collect(Collectors.toList());
            }
            if (searchParams.get("phone") != null) {
                String phone = searchParams.get("phone");
                listFiltered = listFiltered.stream().filter(customer -> customer.getPhoneNumber().equals(phone)).collect(Collectors.toList());
            }
            if (searchParams.get("email") != null) {
                String email = searchParams.get("email");
                listFiltered = listFiltered.stream().filter(customer -> customer.getEmail().equals(email)).collect(Collectors.toList());
            }
            if (searchParams.get("address") != null) {
                String address = searchParams.get("address");
                listFiltered = listFiltered.stream().filter(customer -> customer.getAddress().equals(address)).collect(Collectors.toList());
            }
            if (searchParams.get("createdDate") != null) {
                LocalDate createdDate = LocalDate.parse(searchParams.get("createdDate"));
                listFiltered = listFiltered.stream().filter(customer -> customer.getCreatedDate().toLocalDate().isEqual(createdDate)).collect(Collectors.toList());
            }
        }
        Page<Customer> page = new PageImpl<>(listFiltered, pageable, listFiltered.size());
        return page.map(Mapper::mapToCustomerDto);
    }

    public Page<CustomerDto> getAllCustomer(Pageable pageable, CustomerSearchCriteria searchCriteria) {
        List<Customer> listFiltered = new ArrayList<>();
        if (searchCriteria != null) {
            listFiltered = customerRepository.findAllByIsDeletedFalse();
            if (searchCriteria.getId() != null) {
                listFiltered = listFiltered.stream().filter(customer -> customer.getId().equals(searchCriteria.getId())).collect(Collectors.toList());
            }
            if (searchCriteria.getName() != null && !Objects.equals(searchCriteria.getName(), "")) {
                listFiltered = listFiltered.stream().filter(customer -> customer.getCustomerName().equals(searchCriteria.getName())).collect(Collectors.toList());
            }
            if (searchCriteria.getPhone() != null && !Objects.equals(searchCriteria.getPhone(), "")) {
                listFiltered = listFiltered.stream().filter(customer -> customer.getPhoneNumber().equals(searchCriteria.getPhone())).collect(Collectors.toList());
            }
            if (searchCriteria.getEmail() != null && !Objects.equals(searchCriteria.getEmail(), "")) {
                listFiltered = listFiltered.stream().filter(customer -> customer.getEmail().equals(searchCriteria.getEmail())).collect(Collectors.toList());
            }
            if (searchCriteria.getAddress() != null && !Objects.equals(searchCriteria.getAddress(), "")) {
                listFiltered = listFiltered.stream().filter(customer -> customer.getAddress().equals(searchCriteria.getAddress())).collect(Collectors.toList());
            }
            if (searchCriteria.getCreatedDate() != null) {
                listFiltered = listFiltered.stream().filter(customer -> customer.getCreatedDate().toLocalDate().isEqual(searchCriteria.getCreatedDate())).collect(Collectors.toList());
            }
        }
        Page<Customer> page = new PageImpl<>(listFiltered, pageable, listFiltered.size());
        return page.map(Mapper::mapToCustomerDto);
    }


    public Customer addCustomer(CustomerDto customerDto) {
        Customer customer = new Customer(customerDto);
        return customerRepository.save(customer);
    }

    public void editCustomer(CustomerDto customerDto) {
        customerRepository.updateCustomer(customerDto.getId(), customerDto.getAddress(),
                customerDto.getEmail(), customerDto.getPhoneNumber(), customerDto.getCustomerName());
    }

    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }
}
