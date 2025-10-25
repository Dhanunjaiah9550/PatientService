package com.flmhospitals.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "patients_address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long patientAddressId;

	private String doorNumber;

	private String landmark;

	private String city;

	private String state;

	private String pinCode;

	private String country;

}
