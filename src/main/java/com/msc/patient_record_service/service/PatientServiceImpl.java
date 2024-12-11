package com.msc.patient_record_service.service;

import com.msc.patient_record_service.model.Patient;
import com.msc.patient_record_service.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {


    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(String id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
    }

    @Override
    public Patient updatePatient(String id, Patient patient) {
        Patient existingPatient = getPatientById(id);
        existingPatient.setName(patient.getName());
        existingPatient.setAge(patient.getAge());
        existingPatient.setGender(patient.getGender());
        existingPatient.setMedicalHistory(patient.getMedicalHistory());
        existingPatient.setPrescriptions(patient.getPrescriptions());
        existingPatient.setLabResults(patient.getLabResults());
        return patientRepository.save(existingPatient);
    }

    @Override
    public void deletePatient(String id) {
        patientRepository.deleteById(id);
    }
}
