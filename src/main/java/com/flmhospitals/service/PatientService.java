package com.flmhospitals.service;

import com.flmhospitals.dto.RegisterPatientRequestDto;
import com.flmhospitals.dto.RegisterPatientResponseDto;

public interface PatientService {

	RegisterPatientResponseDto regiesterPatient(RegisterPatientRequestDto registerPatientRequestDto);
	
	RegisterPatientResponseDto updatePatient(RegisterPatientRequestDto patientRequestDto ,String patientId);
	
	RegisterPatientResponseDto getPatientById(String patientId);
	
}
