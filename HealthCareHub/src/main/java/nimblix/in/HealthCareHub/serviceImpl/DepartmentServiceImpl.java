package nimblix.in.HealthCareHub.serviceImpl;

import nimblix.in.HealthCareHub.model.Department;
import nimblix.in.HealthCareHub.repository.DepartmentRepository;
import nimblix.in.HealthCareHub.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }
}