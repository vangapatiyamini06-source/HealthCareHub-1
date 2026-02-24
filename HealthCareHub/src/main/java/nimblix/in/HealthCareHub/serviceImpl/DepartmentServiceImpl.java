package nimblix.in.HealthCareHub.service.impl;

import nimblix.in.HealthCareHub.entity.Department;
import nimblix.in.HealthCareHub.repository.DepartmentRepository;
import nimblix.in.HealthCareHub.request.CreateDepartmentRequest;
import nimblix.in.HealthCareHub.response.DepartmentResponse;
import nimblix.in.HealthCareHub.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentResponse createDepartment(CreateDepartmentRequest request) {

        Department department = new Department();
        department.setDepartmentName(request.getDepartmentName());
        department.setDescription(request.getDescription());

        Department savedDepartment = departmentRepository.save(department);

        return new DepartmentResponse(
                savedDepartment.getId(),
                savedDepartment.getDepartmentName(),
                savedDepartment.getDescription()
        );
    }
}