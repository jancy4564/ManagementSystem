package com.ministry.rms.records_management.Repository;

import com.ministry.rms.records_management.Models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {}
