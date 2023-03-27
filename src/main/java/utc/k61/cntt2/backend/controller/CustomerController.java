package utc.k61.cntt2.backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import utc.k61.cntt2.backend.domain.Customer;
import utc.k61.cntt2.backend.dto.CustomerDto;
import utc.k61.cntt2.backend.dto.CustomerSearchCriteria;
import utc.k61.cntt2.backend.service.CustomerService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class CustomerController {
    private final Logger log = LoggerFactory.getLogger(CustomerController.class);
    private final CustomerService customerService;
    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/get-all-customer")
    @ResponseBody
    public Page<CustomerDto> getAllCustomer(@RequestParam(defaultValue = "0") int pageNumber,
                                            @RequestParam(defaultValue = "10") int pageSize) {
        log.info("Getting all customers without searchCriteria from page: {}", pageNumber);
        return customerService.getAllCustomer(PageRequest.of(pageNumber, pageSize));
    }

    @PostMapping("/get-all-customer-with-search-criteria")
    @ResponseBody
    public Page<CustomerDto> getAllCustomer(@RequestParam(defaultValue = "0") int pageNumber,
                                            @RequestParam(defaultValue = "10") int pageSize,
                                                @RequestBody CustomerSearchCriteria searchCriteria) {
        log.info("Getting all customers from page: {} with searchParam: {}", pageNumber, searchCriteria.toString());
        return customerService.getAllCustomer(PageRequest.of(pageNumber, pageSize), searchCriteria);
    }

    @PutMapping("/edit")
    public ResponseEntity<?> editCustomer(@RequestBody CustomerDto customerDto) {
        log.info("updating customer : {}", customerDto.toString());
        customerService.editCustomer(customerDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addACustomer(@RequestBody CustomerDto customerDto) {
        Customer customer = customerService.addCustomer(customerDto);
        log.info("Added new customer {}", customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long customerId) {
        customerService.deleteCustomer(customerId);
        log.info("Deleted customer with id {}", customerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
