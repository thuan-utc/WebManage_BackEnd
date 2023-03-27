package utc.k61.cntt2.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utc.k61.cntt2.backend.domain.Product;
import utc.k61.cntt2.backend.dto.ProductDto;
import utc.k61.cntt2.backend.mapper.Mapper;
import utc.k61.cntt2.backend.repository.ProductRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private Logger log = LoggerFactory.getLogger(ProductService.class);
    private ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDto> getAllProduct() {
        return productRepository.findAll().stream().map(Mapper::mapToProductDto).collect(Collectors.toList());
    }

    public void addProduct(Product newProduct) {
        productRepository.save(newProduct);
    }
}
