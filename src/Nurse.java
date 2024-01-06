public class Nurse extends Staff{
    private String nursingLicenseNumber;

    public Nurse(String username, String password, String name, String surname, String gender, int age, String ID,
                 String department, String position, String workHours, String nursingLicenseNumber) {
        super(username, password, name, surname, gender, age, ID, department, position, workHours);
        this.nursingLicenseNumber = nursingLicenseNumber;
    }

    public String getNursingLicenseNumber() {
        return nursingLicenseNumber;
    }

    public void setNursingLicenseNumber(String nursingLicenseNumber) {
        this.nursingLicenseNumber = nursingLicenseNumber;
    }
}
