package com.ministry.rms.records_management.Dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocumentDto {
  private String documentNumber;
  private String title;
  private String departmentCode;
  private String departmentType;
  private String securityClassification;
  private String version;
  private LocalDate createdDate;
}
