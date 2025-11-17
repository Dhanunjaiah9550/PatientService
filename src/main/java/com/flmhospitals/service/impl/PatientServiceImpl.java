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
		
		Patient patient= patientRepository.findById(patientId).orElseThrow(()->new PatientNotFoundException("No patient found with ID "+patientId));
		
		PatientAddressRequestDto requestAddressDto = patientRequestDto.getPatientAddress();
	    PatientAddress address = patient.getPatientAddress();

	    if (requestAddressDto != null) {

	        if (requestAddressDto.getDoorNumber() != null) {
	        	address.setDoorNumber(requestAddressDto.getDoorNumber());
	        }
	        if (requestAddressDto.getLandmark() != null) {
	        	address.setLandmark(requestAddressDto.getLandmark());
	        }
	        if (requestAddressDto.getCity() != null) {
	        	address.setCity(requestAddressDto.getCity());
	        }
	        if (requestAddressDto.getState() != null) {
	        	address.setState(requestAddressDto.getState());
	        }
	        if (requestAddressDto.getPinCode() != null) {
	        	address.setPinCode(requestAddressDto.getPinCode());
	        }
	        if (requestAddressDto.getCountry() != null) {
	        	address.setCountry(requestAddressDto.getCountry());
	        }
	    }

	    if (patientRequestDto.getPatientName() != null) {
	        patient.setPatientName(patientRequestDto.getPatientName());
	    }

	    if (patientRequestDto.getGender() != null) {
	        patient.setGender(patientRequestDto.getGender());
	    }

	    if (patientRequestDto.getPatientEmail() != null) {
	        patient.setPatientEmail(patientRequestDto.getPatientEmail());
	    }

	    if (patientRequestDto.getPatientPhoneNumber() != null) {
	        patient.setPatientPhoneNumber(patientRequestDto.getPatientPhoneNumber());
	    }

	    if (patientRequestDto.getDateOfBirth() != null) {
	        patient.setDateOfBirth(patientRequestDto.getDateOfBirth());
	    }

	    Patient updatedPatient = patientRepository.save(patient);
	    return PatientDTOBuilder.fromPatientEntityToRegPatientRespDtO(updatedPatient);
	}

	@Override
	public RegisterPatientResponseDto getPatientById(String patientId) {
		// TODO Auto-generated method stub
		
		Patient patient=patientRepository.findById(patientId).orElseThrow(()->new PatientNotFoundException("No patient found with ID "+patientId));
		
		return PatientDTOBuilder.fromPatientEntityToRegPatientRespDtO(patient);
	}
	
}
