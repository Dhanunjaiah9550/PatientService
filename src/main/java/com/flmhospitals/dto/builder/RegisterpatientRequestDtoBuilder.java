package com.flmhospitals.dto.builder;

import org.springframework.beans.BeanUtils;

import com.flmhospitals.dto.PatientAddressRequestDto;
import com.flmhospitals.dto.RegisterPatientRequestDto;
import com.flmhospitals.model.Patient;
import com.flmhospitals.model.PatientAddress;

public class RegisterpatientRequestDtoBuilder {

	public static Patient buildPatientFromRequestDto(RegisterPatientRequestDto registerPatientRequestDto) {

		return Patient.builder().patientName(registerPatientRequestDto.getPatientName())
				.gender(registerPatientRequestDto.getGender()).patientEmail(registerPatientRequestDto.getPatientEmail())
				.patientPhoneNumber(registerPatientRequestDto.getPatientPhoneNumber())
				.dateOfBirth(registerPatientRequestDto.getDateOfBirth())
				.patientAddress(buildAddressFromRequestDto(registerPatientRequestDto.getPatientAddress())).build();
	}

	public static PatientAddress buildAddressFromRequestDto(PatientAddressRequestDto patientAddress) {

		PatientAddress Address = new PatientAddress();

		BeanUtils.copyProperties(patientAddress, Address);

		return Address;
	}
}
