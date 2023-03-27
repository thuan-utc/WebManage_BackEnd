package utc.k61.cntt2.backend.mapper;

import utc.k61.cntt2.backend.domain.Customer;
import utc.k61.cntt2.backend.domain.CustomerOrder;
import utc.k61.cntt2.backend.domain.Invoice;
import utc.k61.cntt2.backend.domain.Product;
import utc.k61.cntt2.backend.dto.CustomerDto;
import utc.k61.cntt2.backend.dto.InvoiceDto;
import utc.k61.cntt2.backend.dto.OrderDto;
import utc.k61.cntt2.backend.dto.ProductDto;

public class Mapper {
    public static CustomerDto mapToCustomerDto (Customer c) {
        CustomerDto cDto = new CustomerDto();
        cDto.setCustomerName(c.getCustomerName());
        cDto.setAddress(c.getAddress());
        cDto.setEmail(c.getEmail());
        cDto.setId(c.getId());
        cDto.setCreatedDate(c.getCreatedDate());
        cDto.setPhoneNumber(c.getPhoneNumber());
        return cDto;
    }
    public static ProductDto mapToProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setProductName(product.getProductName());
        productDto.setProductDescription(product.getProductDescription());
        productDto.setId(product.getId());
        productDto.setPrice(product.getPrice());
        return productDto;
    }

    public static OrderDto mapToOrderDto(CustomerOrder customerOrder) {
        OrderDto orderDto = new OrderDto();
        orderDto.setCustomerName(customerOrder.getCustomer().getCustomerName());
        orderDto.setId(customerOrder.getId());
        orderDto.setInvoice(customerOrder.getInvoice());
        orderDto.setCreatedDate(customerOrder.getCreatedDate());
        return orderDto;
    }

    public static InvoiceDto mapToInvoiceDto(Invoice invoice) {
        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setCreatedDate(invoice.getCreatedDate());
        invoiceDto.setCustomerOrder(invoice.getCustomerOrder());
        invoiceDto.setTotalMoney(invoice.getTotalMoney());
        invoiceDto.setId(invoice.getId());
        return invoiceDto;
    }
}
