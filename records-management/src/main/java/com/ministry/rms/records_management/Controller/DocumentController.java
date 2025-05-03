package com.ministry.rms.records_management.Controller;

import com.ministry.rms.records_management.Dtos.DocumentDto;
import com.ministry.rms.records_management.Models.Document;
import com.ministry.rms.records_management.Service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {
    @Autowired
    private DocumentService documentService;

    @GetMapping("/search")
    public Page<DocumentDto> searchDocument(@RequestParam(required = false) String docNum,
                                            @RequestParam(required = false) String title,
                                            @RequestParam(required = false) String deptCode,
                                            @RequestParam(required = false) Document.DocumentType docType,
                                            @RequestParam(required = false) Document.SecurityClassification security,
                                            @RequestParam(required = false) LocalDate startDate,
                                            @RequestParam(required = false) LocalDate endDate,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "10") int size,
                                            @RequestParam(defaultValue = "creationDate") String sortBy){
        return  documentService.searchDocuments(docNum,title,deptCode,docType,security,startDate,endDate,page,size,sortBy);
    }
}
