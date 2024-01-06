import java.util.Date;
import java.util.List;

public class Prescription {
    private Doctor doctor;
    private Patient patient;
    private Date issueDate;
    private List<Medication> medications;

    public Prescription(Doctor doctor, Patient patient, Date issueDate, List<Medication> medications) {
        this.doctor = doctor;
        this.patient = patient;
        this.issueDate = issueDate;
        this.medications = medications;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public List<Medication> getMedications() {
        return medications;
    }

    public void setMedications(List<Medication> medications) {
        this.medications = medications;
    }
}



