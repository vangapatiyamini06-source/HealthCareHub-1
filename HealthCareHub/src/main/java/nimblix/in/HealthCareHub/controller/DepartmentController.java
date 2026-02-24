package nimblix.in.HealthCareHub.controller;

import nimblix.in.HealthCareHub.request.CreateDepartmentRequest;
import nimblix.in.HealthCareHub.response.DepartmentResponse;
import nimblix.in.HealthCareHub.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public DepartmentResponse createDepartment(
            @RequestBody CreateDepartmentRequest request) {

        return departmentService.createDepartment(request);
    }
}