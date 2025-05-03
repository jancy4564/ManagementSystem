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
public class DocumentWorkflow {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ManyToOne(optional = false)
  private Document document;

  @Enumerated(EnumType.STRING)
  private WorkFlowState currentState;

  @Column(nullable = false)
  private LocalDateTime lastModifiedDate;

  private Long lastModifiedBy;

  private String comments;

  public enum WorkFlowState {
    DRAFT,
    REVIEW,
    APPROVED,
    PUBLISHED,
    ARCHIVED
  }
}
