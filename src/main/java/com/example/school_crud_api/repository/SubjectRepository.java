package com.example.school_crud_api.repository;

import com.example.school_crud_api.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
}
