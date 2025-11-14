package com.flmhospitals.service.impl;

import org.springframework.stereotype.Service;
import com.flmhospitals.builder.PatientBuilder;
import com.flmhospitals.dao.PatientRepository;
import com.flmhospitals.dto.RegisterPatientRequestDto;
import com.flmhospitals.dto.RegisterPatientResponseDto;
import com.flmhospitals.dto.builder.PatientDTOBuilder;
import com.flmhospitals.model.Patient;
import com.flmhospitals.service.PatientService;
import com.flmhospitals.utils.PatientIdGenerator;

@Service
public class PatientServiceImpl implements PatientService {

	public final PatientRepository patientRepository;

	public final PatientIdGenerator patientIdGenerator;

	public PatientServiceImpl(PatientRepository patientRepository, PatientIdGenerator patientIdGenerator) {
		this.patientRepository = patientRepository;
		this.patientIdGenerator = patientIdGenerator;
	}

	@Override
	public RegisterPatientResponseDto regiesterPatient(RegisterPatientRequestDto registerPatientRequestDto) {
		
		Patient patient = PatientBuilder.buildPatientFromRegisterPatientRequestDto(registerPatientRequestDto);

		Patient registedPatient = patientRepository.save(patient);

		return PatientDTOBuilder.fromPatientEntityToRegPatientRespDtO(registedPatient);
	}
}
