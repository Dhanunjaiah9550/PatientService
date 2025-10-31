package com.flmhospitals.service;

import org.springframework.web.bind.annotation.RequestBody;

import com.flmhospitals.dto.RegisterPatientRequestDto;
import com.flmhospitals.dto.RegisterPatientResponseDto;

public interface PatientService {

	RegisterPatientResponseDto regiesterPatient(@RequestBody RegisterPatientRequestDto registerPatientRequestDto);
}
