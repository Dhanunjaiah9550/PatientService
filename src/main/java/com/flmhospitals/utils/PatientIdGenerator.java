package com.flmhospitals.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.flmhospitals.dao.PatientRepository;

@Component
public class PatientIdGenerator {

    private final PatientRepository patientRepository;

    public PatientIdGenerator(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public String generateNextPatientId() {
        String prefix = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String lastId = patientRepository.findLastPatientId();

        int nextNumber = 1;

        if (lastId != null) {
            
            String numberPart = lastId.substring(8);
            nextNumber = Integer.parseInt(numberPart) + 1;
            
            String suffix = String.format("%06d", nextNumber);
            
            return prefix + suffix;
            
        }

       
        String suffix = String.format("%06d", nextNumber);

        return prefix + suffix;
    }
}
