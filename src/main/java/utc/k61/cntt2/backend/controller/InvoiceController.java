package utc.k61.cntt2.backend.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utc.k61.cntt2.backend.domain.Invoice;
import utc.k61.cntt2.backend.dto.InvoiceDto;
import utc.k61.cntt2.backend.mapper.Mapper;
import utc.k61.cntt2.backend.service.InvoiceService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/invoice")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class InvoiceController {
    private Logger log = LoggerFactory.getLogger(InvoiceController.class);
    private InvoiceService invoiceService;
    @Autowired
    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/get-all")
    public List<InvoiceDto> getAllInvoice() {
        log.info("Getting all invoices");
        return invoiceService.getAllInvoice();
    }

    @GetMapping("/get-by-customer-phone")
    public List<Invoice> getAllInvoiceByCustomerNumber(String customerNumber) {
        return null;
    }

    @GetMapping("/get-by-date")
    public List<Invoice> getAllInvoiceByDate(LocalDate localDate) {
        return null;
    }
}
