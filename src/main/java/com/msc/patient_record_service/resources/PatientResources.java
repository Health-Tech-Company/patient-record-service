package com.msc.patient_record_service.resources;

import com.msc.patient_record_service.model.Patient;
import com.msc.patient_record_service.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * PatientResources class handles all HTTP requests related to patient records.
 * It serves as a RESTful API controller for creating, retrieving, updating, and deleting patient records.
 */
@RestController
@RequestMapping("/patients")
public class PatientResources {

    private final PatientService patientService;

    /**
     * Constructor for initializing the PatientResources class with the PatientService.
     *
     * @param patientService The service layer responsible for handling business logic related to patients.
     */
    public PatientResources(PatientService patientService) {
        this.patientService = patientService;
    }

    /**
     * Creates a new patient record.
     * This method is invoked when a POST request is made to the /patients endpoint.
     *
     * @param patient The patient data to be created.
     * @return ResponseEntity containing the created patient record.
     */
    @PostMapping
    public ResponseEntity<Patient> createPatient(@Valid @RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.createPatient(patient));
    }

    /**
     * Retrieves all patient records.
     * This method is invoked when a GET request is made to the /patients endpoint.
     *
     * @return ResponseEntity containing a list of all patients.
     */
    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        return ResponseEntity.ok(patientService.getAllPatients());
    }

    /**
     * Retrieves a specific patient by their ID.
     * This method is invoked when a GET request is made to the /patients/{id} endpoint.
     *
     * @param id The unique identifier of the patient.
     * @return ResponseEntity containing the patient record for the specified ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable String id) {
        return ResponseEntity.ok(patientService.getPatientById(id));
    }

    /**
     * Updates an existing patient record.
     * This method is invoked when a PUT request is made to the /patients/{id} endpoint.
     *
     * @param id The unique identifier of the patient to be updated.
     * @param patient The patient data to update.
     * @return ResponseEntity containing the updated patient record.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable String id, @Valid @RequestBody Patient patient) {
        return ResponseEntity.ok(patientService.updatePatient(id, patient));
    }

    /**
     * Deletes a patient record.
     * This method is invoked when a DELETE request is made to the /patients/{id} endpoint.
     *
     * @param id The unique identifier of the patient to be deleted.
     * @return ResponseEntity with no content (HTTP 204) to indicate successful deletion.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable String id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }
}
