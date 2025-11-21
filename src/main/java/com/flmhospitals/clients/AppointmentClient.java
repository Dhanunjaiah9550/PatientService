package com.flmhospitals.clients;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="AppointmentManagement")
public interface AppointmentClient {

	@GetMapping("/appointments/getDoctorPatients/{staffId}/{startDate}/{endDate}")
	public List<String> getPatientsVisitedByDoctor(@PathVariable(name="staffId") String staffId, @PathVariable("startDate") String startdate,@PathVariable("endDate") String enddate);
}
