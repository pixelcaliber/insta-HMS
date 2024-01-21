package com.console.insta.controllers;

import com.console.insta.Doctor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    private static final Map<String, Doctor> doctorMap = new HashMap<>();

    @GetMapping("/{id}")
    public ResponseEntity<Object> getDoctor(@PathVariable String id) {
        Doctor doctor = doctorMap.get(id);

        if (doctor != null) {
            return ResponseEntity.ok(doctor);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doctor with ID " + id + " not found");
        }
    }

    @PostMapping
    public ResponseEntity<String> addDoctor(@RequestBody Doctor doctor) {
        String doctorId = doctor.getId();
        doctorMap.put(doctorId, doctor);
        return ResponseEntity.ok(doctorId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable String id) {
        doctorMap.remove(id);
        return ResponseEntity.ok("Doctor with Id:" + id + "is deleted from the records!");
    }
}
