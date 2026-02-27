package nimblix.in.HealthCareHub.controller;

import lombok.RequiredArgsConstructor;
import nimblix.in.HealthCareHub.request.HospitalRegistrationRequest;
import nimblix.in.HealthCareHub.service.HospitalService;
import nimblix.in.HealthCareHub.model.Specialization;
import nimblix.in.HealthCareHub.request.SpecializationRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hospital")
@RequiredArgsConstructor
public class HospitalController {

    private final HospitalService hospitalService;

    @PostMapping("/register")
    public String registerHospital(@RequestBody HospitalRegistrationRequest request) {
        return hospitalService.registerHospital(request);
    }

    //  CREATE SPECIALIZATION API
    @PostMapping("/specializations")
    public Specialization createSpecialization(@RequestBody SpecializationRequest request) {
        return hospitalService.createSpecialization(request);
    }
}
