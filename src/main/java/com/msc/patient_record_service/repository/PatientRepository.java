package com.msc.patient_record_service.repository;

import com.msc.patient_record_service.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {
}
