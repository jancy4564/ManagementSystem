package com.ministry.rms.records_management.Repository;

import com.ministry.rms.records_management.Models.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;

public interface DocumentRepository extends JpaRepository<Document, Long> {

  @Query(
      "SELECT d FROM Document d WHERE (:docNum IS NULL OR d.documentNumber LIKE %:docNum%) "
          + "AND (:title IS NULL OR d.title LIKE %:title%) "
          + "AND (:deptCode IS NULL OR d.ownerDepartment.documentCode LIKE %:deptCode%) "
          + "AND (:docType IS NULL OR d.documentType LIKE %:docType%) "
          + "AND (:security IS NULL OR d.securityClassification LIKE %:security%) "
          + "AND (:startDate IS NULL OR d.createDate >= :startDate) "
          + "AND (:endDate IS NULL OR d.createDate <= :endDate) ")
  Page<Document> searchDocuments(
      @Param("docNum") String docNum,
      @Param("title") String title,
      @Param("deptCode") String deptCode,
      @Param("docType") Document.DocumentType docType,
      @Param("security") Document.SecurityClassification security,
      @Param("startDate") LocalDate startDate,
      @Param("endDate") LocalDate endDate,
      Pageable pageable);
}
