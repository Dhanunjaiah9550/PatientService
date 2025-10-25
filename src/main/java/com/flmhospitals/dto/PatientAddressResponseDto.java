package com.flmhospitals.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientAddressResponseDto {

	private String doorNumber;
	
	private String landmark;
	
	private String city;
	
	private String state;
	
	private String country;
	
	private String pinCode;
	
}
