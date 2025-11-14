package com.flmhospitals.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.flmhospitals.dto.RegisterPatientRequestDto;
import com.flmhospitals.dto.RegisterPatientResponseDto;
import com.flmhospitals.service.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {
	
	public final PatientService patientService;

	public PatientController(PatientService patientService) {
		this.patientService = patientService;
	}

	@PostMapping("/register")
	public ResponseEntity<RegisterPatientResponseDto> regiesterPatient(
			@RequestBody RegisterPatientRequestDto registerPatientRequestDto) {

		RegisterPatientResponseDto regiesterPatientResponse = patientService
				.regiesterPatient(registerPatientRequestDto);

		return ResponseEntity.status(HttpStatus.CREATED).body(regiesterPatientResponse);

	}
}
