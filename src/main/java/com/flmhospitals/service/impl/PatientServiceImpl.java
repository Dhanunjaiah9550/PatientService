package com.flmhospitals.service.impl;

import org.springframework.stereotype.Service;

import com.flmhospitals.builder.PatientBuilder;
import com.flmhospitals.dao.PatientRepository;
import com.flmhospitals.dto.PatientAddressRequestDto;
import com.flmhospitals.dto.RegisterPatientRequestDto;
import com.flmhospitals.dto.RegisterPatientResponseDto;
import com.flmhospitals.dto.builder.PatientDTOBuilder;
import com.flmhospitals.exception.PatientNotFoundException;
import com.flmhospitals.model.Patient;
import com.flmhospitals.model.PatientAddress;
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

	@Override
	public RegisterPatientResponseDto updatePatient(RegisterPatientRequestDto patientRequestDto,
			String patientId) {
		
		Patient existingPatient= patientRepository.findById(patientId).orElseThrow(()->new PatientNotFoundException("No patient found with ID "+patientId));
		
		Patient updatedPatient=PatientBuilder.buildPatientFromRegisterPatientRequestDto(patientRequestDto);
		
		updatedPatient.setPatientId(patientId);
		
		if(existingPatient.getPatientAddress()!=null && updatedPatient.getPatientAddress() !=null) {
			
			updatedPatient.getPatientAddress().setPatientAddressId(existingPatient.getPatientAddress().getPatientAddressId());
		}
		
		Patient savedPatient= patientRepository.save(updatedPatient);
		
		return PatientDTOBuilder.fromPatientEntityToRegPatientRespDtO(savedPatient);
		
	}

	@Override
	public RegisterPatientResponseDto getPatientById(String patientId) {
		// TODO Auto-generated method stub
		
		Patient patient=patientRepository.findById(patientId).orElseThrow(()->new PatientNotFoundException("No patient found with ID "+patientId));
		
		return PatientDTOBuilder.fromPatientEntityToRegPatientRespDtO(patient);
	}
	
}
