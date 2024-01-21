package com.console.insta.controllers;

import com.console.insta.Patient;
import com.console.insta.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/patient")
public class PatientController {

    public void setDoctorService(PatientService patientService) {
    }

    private static final Map<String, Patient> patientMap = new HashMap<>();

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPatient(@PathVariable String id) {
        Patient patient = patientMap.get(id);

        if (patient != null) {
            return ResponseEntity.ok(patient);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient with ID " + id + " not found");
        }
    }

    @PostMapping
    public ResponseEntity<String> addPatient(@RequestBody Patient patient) {
        String nextId = patient.getId();
        patientMap.put(nextId, patient);
        return ResponseEntity.ok(nextId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable String id) {
        patientMap.remove(id);
        return ResponseEntity.ok("Patient with Id:" + id + "is deleted from the records!");
    }
}
