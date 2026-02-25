package nimblix.in.HealthCareHub.service;

import nimblix.in.HealthCareHub.model.Department;

import nimblix.in.HealthCareHub.request.HospitalRegistrationRequest;

import java.util.List;

public interface HospitalService {

    String registerHospital(HospitalRegistrationRequest request);

    // ================= DEPARTMENT =================
    Department createDepartment(Department department);

    List<Department> getAllDepartments();

    Department getDepartmentById(Long id);

    Department updateDepartment(Long id, Department department);

    void deleteDepartment(Long id);

}
