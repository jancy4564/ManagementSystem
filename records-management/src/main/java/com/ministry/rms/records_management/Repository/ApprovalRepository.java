package com.ministry.rms.records_management.Repository;

import com.ministry.rms.records_management.Models.Approval;
import com.ministry.rms.records_management.Models.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ApprovalRepository extends JpaRepository<Approval, Long> {

  @Query(
      "SELECT a.documentWorkflow.document from Approval a "
          + "WHERE a.approverDepartment.departmentCode =:deptCode AND a.approvalState = 'PENDING'")
  Page<Document> findPendingApprovalsByDepartment(
      @Param("deptCode") String deptCode, Pageable pageable);
}
