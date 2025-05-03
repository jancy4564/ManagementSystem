package com.ministry.rms.records_management.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Approval {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne(optional = false)
  private Document documentWorkFlow;

  @ManyToOne(optional = false)
  private Department approverDepartment;

  @Enumerated(EnumType.STRING)
  private ApprovalState approvalState;

  @Column(nullable = false)
  private LocalDateTime approvalDate;

  private Long approvalId;

  private String comments;

  public enum ApprovalState {
    PENDING,
    APPROVED,
    REJECTED
  }
}
