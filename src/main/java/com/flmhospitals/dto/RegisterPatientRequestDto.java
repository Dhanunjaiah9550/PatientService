package com.flmhospitals.dto;

import java.time.LocalDate;
import java.util.List;

import com.flmhospitals.utils.Gender;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterPatientRequestDto {

	private String patientName;
	
	private Gender gender; 		
	
	private String patientEmail;
	
	private String patientPhoneNumber;
	
	private LocalDate dateOfBirth;

	private List<PatientAddressRequestDto> patientAddress;
	
}
