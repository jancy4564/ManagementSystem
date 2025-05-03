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
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Document {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(unique = true, nullable = false)
  private String documentNumber;

  @Column(nullable = false)
  private String title;

  private String description;

  @Column(nullable = false)
  private LocalDate createDate;

  @ManyToOne(optional = false)
  private Department ownerDepartment;

  @Enumerated(EnumType.STRING)
  private DocumentType documentType;

  @Enumerated(EnumType.STRING)
  private SecurityClassification securityClassification;

  private String digitalFileLocation;

  private String version;

  public enum DocumentType {
    MEMO,
    LETTER,
    REPORT,
    POLICY,
    ORDER
  }

  public enum SecurityClassification {
    PUBLIC,
    INTERNAL,
    CONFIDENTIAL,
    RESTRICTED
  }
}
