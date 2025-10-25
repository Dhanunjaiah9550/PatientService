package com.flmhospitals.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "patients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String patientId;

	private String patientName;

	private String gender;

	private String patientEmail;

	private String patientPhoneNumber;

	private LocalDate dateOfBirth;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "patient_address_id")
	private PatientAddress patientAddress;

}
