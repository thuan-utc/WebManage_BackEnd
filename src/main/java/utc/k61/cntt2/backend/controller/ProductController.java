package utc.k61.cntt2.backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utc.k61.cntt2.backend.domain.Product;
import utc.k61.cntt2.backend.dto.ProductDto;
import utc.k61.cntt2.backend.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class ProductController {
    private Logger log = LoggerFactory.getLogger(ProductController.class);
    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("/get-all-products")
    public List<ProductDto> getAllProduct() {
        log.info("Getting all products");
        return productService.getAllProduct();
    }
    @PostMapping("/add-product")
    public void addProduct(Product newProduct) {
        productService.addProduct(newProduct);
        log.info("Added new Product");
    }
    @DeleteMapping("/delete-product")
    public void deleteProduct(Product product) {

    }

}
