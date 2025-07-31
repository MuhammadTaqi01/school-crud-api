package com.example.school_crud_api.controller;

import com.example.school_crud_api.model.Assessment;
import com.example.school_crud_api.repository.AssessmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/assessments")
public class AssessmentController {

    @Autowired
    private AssessmentRepository assessmentRepository;

    @GetMapping
    public List<Assessment> getAll() {
        return assessmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assessment> getById(@PathVariable Long id) {
        return assessmentRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Assessment create(@RequestBody Assessment assessment) {
        return assessmentRepository.save(assessment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Assessment> update(@PathVariable Long id, @RequestBody Assessment updated) {
        return assessmentRepository.findById(id)
                .map(assessment -> {
                    assessment.setTitle(updated.getTitle());
                    assessment.setDescription(updated.getDescription());
                    assessment.setDate(updated.getDate());
                    assessment.setTotalMarks(updated.getTotalMarks());
                    assessment.setSubject(updated.getSubject());
                    return ResponseEntity.ok(assessmentRepository.save(assessment));
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return assessmentRepository.findById(id)
                .map(assessment -> {
                    assessmentRepository.delete(assessment);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
