public class Staff extends Person{
    private String department;
    private String position;
    private String workHours;

    public Staff(String username, String password, String name, String surname, String gender, int age, String ID,
                 String department, String position, String workHours) {
        super(username, password, name, surname, gender, age, ID);
        this.department = department;
        this.position = position;
        this.workHours = workHours;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getWorkHours() {
        return workHours;
    }

    public void setWorkHours(String workHours) {
        this.workHours = workHours;
    }
}
