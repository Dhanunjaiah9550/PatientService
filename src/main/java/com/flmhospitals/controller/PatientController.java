package com.flmhospitals.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.flmhospitals.clients.AppointmentClient;
import com.flmhospitals.dto.RegisterPatientRequestDto;
import com.flmhospitals.dto.RegisterPatientResponseDto;
import com.flmhospitals.model.Patient;
import com.flmhospitals.service.PatientService;

@RestController
@RequestMapping("/patients")
public class PatientController {
	
	public final PatientService patientService;
	
	public final AppointmentClient appointmentClient;


	public PatientController(PatientService patientService,AppointmentClient appointmentClient) {
		
		this.patientService = patientService;
		
		this.appointmentClient = appointmentClient;
	}

	@PostMapping("/register")
	public ResponseEntity<RegisterPatientResponseDto> regiesterPatient(
			@RequestBody RegisterPatientRequestDto registerPatientRequestDto) {

		RegisterPatientResponseDto regiesterPatientResponse = patientService
				.regiesterPatient(registerPatientRequestDto);

		return ResponseEntity.status(HttpStatus.CREATED).body(regiesterPatientResponse);

	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<RegisterPatientResponseDto> updatePatient(@RequestBody  RegisterPatientRequestDto registerPatientRequestDto, @PathVariable(name="id") String patientId){
		
		RegisterPatientResponseDto updatedPatientResponse =patientService.updatePatient(registerPatientRequestDto, patientId);
		
		return ResponseEntity.status(HttpStatus.OK).body(updatedPatientResponse);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<RegisterPatientResponseDto> getPatientById(@PathVariable(name="id") String patientId){
		
		RegisterPatientResponseDto patientResponse=patientService.getPatientById(patientId);
		
		return ResponseEntity.status(HttpStatus.OK).body(patientResponse);
		
	}
	
	@GetMapping("/getDoctorPatients/{staffId}/{startDate}/{endDate}")
	public List<Patient> getPatientsVisitedByDoctor(@PathVariable(name="staffId") String staffId, @PathVariable("startDate") LocalDate startDate,@PathVariable("endDate") LocalDate endDate){

		String startdate = startDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		String enddate = endDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		List<String> listOfPatientIds = appointmentClient.getPatientsVisitedByDoctor(staffId, startdate, enddate);
		
		return patientService.getPatientsByDoctor(listOfPatientIds);
		
	}
}
