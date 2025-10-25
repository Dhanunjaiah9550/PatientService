package com.flmhospitals.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientAddressRequestDto {

	private String patientAddressHouseNumber;
	
	private String patientAddresslandmark;
	
	private String patientAddressCity;
	
	private String patientAddressState;
	
	private String patientAddressCountry;
	
	private int patientAddressPinCode;
	
}
