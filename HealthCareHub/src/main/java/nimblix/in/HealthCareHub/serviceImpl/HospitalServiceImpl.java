package nimblix.in.HealthCareHub.serviceImpl;

import lombok.RequiredArgsConstructor;
import nimblix.in.HealthCareHub.model.Hospital;
import nimblix.in.HealthCareHub.model.Specialization;
import nimblix.in.HealthCareHub.repository.HospitalRepository;
import nimblix.in.HealthCareHub.repository.SpecializationRepository;
import nimblix.in.HealthCareHub.request.HospitalRegistrationRequest;
import nimblix.in.HealthCareHub.request.SpecializationRequest;
import nimblix.in.HealthCareHub.service.HospitalService;
import org.springframework.stereotype.Service;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class HospitalServiceImpl implements HospitalService {

    private final HospitalRepository hospitalRepository;

    // Specialization
    private final SpecializationRepository specializationRepository;

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

    //  added method
    @Override
    public Specialization createSpecialization(SpecializationRequest request) {

        if (request.getName() == null || request.getName().trim().isEmpty()) {
            throw new RuntimeException("Specialization name cannot be empty");
        }

        Optional<Specialization> existing =
                specializationRepository.findByName(request.getName());

        if (existing.isPresent()) {
            throw new RuntimeException("Specialization already exists");
        }

        Specialization specialization = Specialization.builder()
                .name(request.getName())
                .build();

        return specializationRepository.save(specialization);
    }
}
