public class Patient extends Person{
    private String medicalRecordNumber;
    private String bloodType;
    private String currentCondition;


    public Patient(String username, String password, String name, String surname, String gender, int age, String ID,
                   String medicalRecordNumber, String bloodType, String currentCondition) {
        super(username, password, name, surname, gender, age, ID);
        this.medicalRecordNumber = medicalRecordNumber;
        this.bloodType = bloodType;
        this.currentCondition = currentCondition;
    }

    public String getMedicalRecordNumber() {
        return medicalRecordNumber;
    }

    public void setMedicalRecordNumber(String medicalRecordNumber) {
        this.medicalRecordNumber = medicalRecordNumber;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getCurrentCondition() {
        return currentCondition;
    }

    public void setCurrentCondition(String currentCondition) {
        this.currentCondition = currentCondition;
    }
}
