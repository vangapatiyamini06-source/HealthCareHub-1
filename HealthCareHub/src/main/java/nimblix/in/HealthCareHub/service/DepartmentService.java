package nimblix.in.HealthCareHub.service;

import nimblix.in.HealthCareHub.request.CreateDepartmentRequest;
import nimblix.in.HealthCareHub.response.DepartmentResponse;

public interface DepartmentService {

    DepartmentResponse createDepartment(CreateDepartmentRequest request);
}