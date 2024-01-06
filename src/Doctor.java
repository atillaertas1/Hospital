public class Doctor extends Staff{
    private String specialization;
    private String licenseNumber;


    public Doctor(String username, String password, String name, String surname, String gender, int age, String ID,
                  String department, String position, String workHours, String specialization, String licenseNumber) {
        super(username, password, name, surname, gender, age, ID, department, position, workHours);
        this.specialization = specialization;
        this.licenseNumber = licenseNumber;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }
}
