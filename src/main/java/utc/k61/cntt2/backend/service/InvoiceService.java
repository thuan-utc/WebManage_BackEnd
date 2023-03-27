package utc.k61.cntt2.backend.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utc.k61.cntt2.backend.domain.Invoice;
import utc.k61.cntt2.backend.dto.InvoiceDto;
import utc.k61.cntt2.backend.mapper.Mapper;
import utc.k61.cntt2.backend.repository.InvoiceRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InvoiceService {
    private Logger log = LoggerFactory.getLogger(InvoiceService.class);
    private InvoiceRepository invoiceRepository;
    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List<InvoiceDto> getAllInvoice() {
        return invoiceRepository.findAll().stream().map(Mapper::mapToInvoiceDto).collect(Collectors.toList());
    }
}
