package utc.k61.cntt2.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utc.k61.cntt2.backend.repository.OrderDetailRepository;

@Service
public class CustomerOrderDetailService {
    private Logger log = LoggerFactory.getLogger(CustomerOrderDetailService.class);
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    public CustomerOrderDetailService(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }
}
