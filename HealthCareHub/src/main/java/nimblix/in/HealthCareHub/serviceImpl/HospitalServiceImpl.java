package nimblix.in.HealthCareHub.serviceImpl;

import lombok.RequiredArgsConstructor;
import nimblix.in.HealthCareHub.model.Hospital;
import nimblix.in.HealthCareHub.model.Department;
import nimblix.in.HealthCareHub.repository.HospitalRepository;
import nimblix.in.HealthCareHub.repository.DepartmentRepository;
import nimblix.in.HealthCareHub.request.HospitalRegistrationRequest;
import nimblix.in.HealthCareHub.service.HospitalService;
import org.springframework.stereotype.Service;



import java.util.List;

@RequiredArgsConstructor
@Service
public class HospitalServiceImpl implements HospitalService {

    private final HospitalRepository hospitalRepository;
    private final DepartmentRepository departmentRepository;

    @Override
    public String registerHospital(HospitalRegistrationRequest request) {

        // Check if hospital already exists
        if (hospitalRepository.findByName(request.getName()).isPresent()) {
            return "Hospital already exists";
        }

        Hospital hospital = Hospital.builder()
                .name(request.getName())
                .address(request.getAddress())
                .city(request.getCity())
                .state(request.getState())
                .phone(request.getPhone())
                .email(request.getEmail())
                .totalBeds(request.getTotalBeds())
                .build();

        hospitalRepository.save(hospital);

        return "Hospital Registered Successfully";
    }
    @Override
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
    }

    @Override
    public Department updateDepartment(Long id, Department updatedDepartment) {
        Department department = getDepartmentById(id);
        department.setDepartmentName(updatedDepartment.getDepartmentName());
        department.setDescription(updatedDepartment.getDescription());
        return departmentRepository.save(department);
    }

    @Override
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
