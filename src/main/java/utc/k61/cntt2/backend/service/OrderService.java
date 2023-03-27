package utc.k61.cntt2.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utc.k61.cntt2.backend.dto.OrderDto;
import utc.k61.cntt2.backend.mapper.Mapper;
import utc.k61.cntt2.backend.repository.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private Logger log = LoggerFactory.getLogger(OrderService.class);
    private OrderRepository orderRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderDto> getAllOrder() {
        return orderRepository.findAll().stream().map(Mapper::mapToOrderDto).collect(Collectors.toList());
    }
}
