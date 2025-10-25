package com.flmhospitals.dto;

import java.util.Date;
import java.util.List;

import com.flmhospitals.constants.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientResponseDto {
	
	private String patientName;
	
	//Gender is ENUM, it is created in separate package
	//Gender ENUM Consist of MALE, FEMALE, OTHER
	
	private Gender patientGender;
	
	private String patientEmail;
	
	private String patientPhoneNumber;
	
	private Date patientDateOfBirth;

	private List<PatientAddressResponseDto> patientAddress;
	
}
