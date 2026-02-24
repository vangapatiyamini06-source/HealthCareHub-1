package nimblix.in.HealthCareHub.controller;

import nimblix.in.HealthCareHub.model.Department;
import nimblix.in.HealthCareHub.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Department> createDepartment(
            @RequestBody Department department) {

        Department savedDepartment =
                departmentService.createDepartment(department);

        return ResponseEntity.status(201).body(savedDepartment);
    }
}