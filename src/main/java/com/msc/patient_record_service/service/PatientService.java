package com.msc.patient_record_service.service;


import com.msc.patient_record_service.model.Patient;

import java.util.List;

public interface PatientService {
    Patient createPatient(Patient patient);

    List<Patient> getAllPatients();

    Patient getPatientById(String id);

    Patient updatePatient(String id, Patient patient);

    void deletePatient(String id);
}
