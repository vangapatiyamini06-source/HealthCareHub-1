package nimblix.in.HealthCareHub.controller;

import lombok.RequiredArgsConstructor;
import nimblix.in.HealthCareHub.request.DoctorAvailabilityRequest;
import nimblix.in.HealthCareHub.request.DoctorRegistrationRequest;
import nimblix.in.HealthCareHub.response.DoctorAvailabilityResponse;
import nimblix.in.HealthCareHub.service.DoctorService;
import nimblix.in.HealthCareHub.serviceImpl.DoctorServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class DoctorController {


    private final DoctorService doctorService;


    @PostMapping("/register")
    public ResponseEntity<?> registerDoctor(@RequestBody DoctorRegistrationRequest request) {

        if (request == null ||
                request.getDoctorName() == null ||
                request.getDoctorEmail() == null ||
                request.getHospitalId() == null ||
                request.getConsultationFee() == null) {

            return ResponseEntity.badRequest().body("Required fields are missing");
        }

    @PutMapping("/updateDoctorDetails")
     public String updateDoctorDetails(@RequestBody DoctorRegistrationRequest request){
        return doctorService.updateDoctorDetails(request);

    }

    @DeleteMapping("/deleteDoctorDetails")
    public String deleteDoctorDetails(@RequestParam Long doctorId){
        return doctorService.deleteDoctorDetails(doctorId);
    }

    @PostMapping("/{doctorId}/timeslots")
    public ResponseEntity<Map<String, Object>> addTimeSlot(
            @PathVariable Long doctorId,
            @RequestBody DoctorAvailabilityRequest request) {

        request.setDoctorId(doctorId);
        DoctorAvailabilityResponse response =
                doctorService.addDoctorTimeSlot( request);

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("status", HttpStatus.CREATED.value());
        result.put("message", "Time slot added successfully");
        result.put("data", response);

        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @PutMapping("/{doctorId}/timeslots/{slotId}")
    public ResponseEntity<Map<String, Object>> updateTimeSlot(
            @PathVariable Long doctorId,
            @PathVariable Long slotId,
            @RequestBody DoctorAvailabilityRequest request) {
        request.setDoctorId(doctorId);
        request.setSlotId(slotId);

        DoctorAvailabilityResponse response =
                doctorService.updateDoctorTimeSlot(request);

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("status", HttpStatus.OK.value());
        result.put("message", "Time slot updated successfully");
        result.put("data", response);

        return ResponseEntity.ok(result);
    }
}
