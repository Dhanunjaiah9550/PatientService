package com.flmhospitals.model;

import java.time.LocalDate;

import com.flmhospitals.utils.Gender;
import com.flmhospitals.utils.PatientIdGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
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
	@Column(name = "patient_id", nullable = false, unique = true)
	private String patientId;

	private String patientName;

	private Gender gender;

	private String patientEmail;

	private String patientPhoneNumber;

	private LocalDate dateOfBirth;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "patient_address_id")
	private PatientAddress patientAddress;
	
	@Transient
	private PatientIdGenerator patientIdGenerator;
	
	@PrePersist
	public void generateStaffId(){
		if (this.patientId == null || this.patientId.isEmpty()) {
			this.patientId = patientIdGenerator.generateNextPatientId(); 
			} }

}
