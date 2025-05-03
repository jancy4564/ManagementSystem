package com.ministry.rms.records_management.Service;

import com.ministry.rms.records_management.Dtos.DocumentDto;
import com.ministry.rms.records_management.Models.Document;
import com.ministry.rms.records_management.Repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@Transactional
public class DocumentService {
  @Autowired private DocumentRepository documentRepository;

  public Page<DocumentDto> searchDocuments(
      String docNum,
      String title,
      String deptCode,
      Document.DocumentType docType,
      Document.SecurityClassification security,
      LocalDate startDate,
      LocalDate endDate,
      int page,
      int size,
      String sortBy) {
    Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());
    return documentRepository
        .searchDocuments(docNum, title, deptCode, docType, security, startDate, endDate, pageable)
        .map(this::toDTO);
  }

  private DocumentDto toDTO(Document doc) {
    return DocumentDto.builder()
        .documentNumber(doc.getDocumentNumber())
        .title(doc.getTitle())
        .departmentCode(doc.getOwnerDepartment().getDocumentCode())
        .departmentType(doc.getDocumentType().name())
        .securityClassification(doc.getSecurityClassification().name())
        .version(doc.getVersion())
        .createdDate(doc.getCreateDate())
        .build();
  }
}
