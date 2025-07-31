package com.example.school_crud_api.repository;

import com.example.school_crud_api.model.Assessment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssessmentRepository extends JpaRepository<Assessment, Long> {
}
