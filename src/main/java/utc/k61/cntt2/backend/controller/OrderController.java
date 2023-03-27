package utc.k61.cntt2.backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utc.k61.cntt2.backend.domain.CustomerOrder;
import utc.k61.cntt2.backend.dto.OrderDto;
import utc.k61.cntt2.backend.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/customer-order")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class OrderController {
    private Logger log = LoggerFactory.getLogger(OrderController.class);
    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/get-all")
    public List<OrderDto> getAllCustomerOrder() {
        log.info("Getting all orders");
        return orderService.getAllOrder();
    }

    @GetMapping("/get-by-customer-phone")
    public List<CustomerOrder> getAllCustomerOrderByCustomer(String phoneNumber) {
        return null;
    }
}
