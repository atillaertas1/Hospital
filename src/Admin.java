import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Admin {
    private static List<Doctor> doctors = new ArrayList<>();
    private static List<Patient> patients = new ArrayList<>();
    private static List<Nurse> nurses = new ArrayList<>();
    private static List<Appointment> appointments = new ArrayList<>();

    private static List<Prescription> prescriptions = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public Admin(){
        loadDoctorsFromJson("doctors.json");
        loadPatientFromJson("patients.json");
        loadNursesFromJson("nurses.json");
        loadPrescriptionsFromJson("prescriptions.json");
        loadAppointmentsFromJson("appointments.json");
    }

    public void createDoctor() {

        System.out.println("Doktor Ekleme");
        System.out.print("Kullanıcı adı: ");
        String username = scanner.next();
        System.out.print("Şifre: ");
        String password = scanner.next();
        System.out.print("İsim: ");
        String name = scanner.next();
        System.out.print("Soyisim: ");
        String surname = scanner.next();
        System.out.print("Cinsiyet: ");
        String gender = scanner.next();
        System.out.print("Yaş: ");
        int age = scanner.nextInt();
        System.out.print("Departman: ");
        String department = scanner.next();
        System.out.print("Unvan: ");
        String position = scanner.next();
        System.out.print("ID: ");
        String ID = scanner.next();
        System.out.print("Çalışma Saatleri: ");
        String workHours = scanner.next();
        System.out.print("Uzmanlık: ");
        String specialization = scanner.next();
        System.out.print("Lisans Numarası: ");
        String licenseNumber = scanner.next();

        Doctor newDoctor = new Doctor(username, password, name, surname, gender, age, ID, department, position, workHours, specialization, licenseNumber);
        doctors.add(newDoctor);
        saveDoctorsToJson("doctors.json");

        System.out.println("Doktor başarıyla eklendi.");
    }

    public void listDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("Kayıtlı doktor yok.");
        } else {
            System.out.println("Doktor Listesi:");
            for (Doctor doctor : doctors) {
                System.out.println("Kullanıcı Adı: " + doctor.getUsername() +
                        ", İsim: " + doctor.getName() +
                        ", Soyisim: " + doctor.getSurname() +
                        ", Cinsiyet: " + doctor.getGender() +
                        ", Yaş: " + doctor.getAge() +
                        ", Departman: " + doctor.getDepartment() +
                        ", Unvan: " + doctor.getPosition() +
                        ", ID: " + doctor.getID() +
                        ", Çalışma Saatleri: " + doctor.getWorkHours() +
                        ", Uzmanlık: " + doctor.getSpecialization() +
                        ", Lisans Numarası: " + doctor.getLicenseNumber());
            }
        }
    }

    public void saveDoctorsToJson(String filename) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(doctors, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadDoctorsFromJson(String filename) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileReader reader = new FileReader(filename)) {
            Type listOfDoctorsType = new TypeToken<ArrayList<Doctor>>() {}.getType();
            doctors = gson.fromJson(reader, listOfDoctorsType);
        } catch (IOException e) {
            e.printStackTrace();
            doctors = new ArrayList<>(); // Eğer dosya okunamazsa boş liste oluştur
        }
    }

    private Doctor findDoctorById(String id) {
        // ID ile doktor bulma mantığı
        // Örneğin:
        return doctors.stream()
                .filter(doctor -> doctor.getID().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void createPatient() {
        System.out.println("Hasta Ekleme");
        System.out.print("Kullanıcı adı: ");
        String username = scanner.next();
        System.out.print("Şifre: ");
        String password = scanner.next();
        System.out.print("İsim: ");
        String name = scanner.next();
        System.out.print("Soyisim: ");
        String surname = scanner.next();
        System.out.print("Cinsiyet: ");
        String gender = scanner.next();
        System.out.print("Yaş: ");
        int age = scanner.nextInt();
        System.out.println("ID: ");
        String ID = scanner.next();
        System.out.print("Tıbbi Kayıt Numarası: ");
        String medicalRecordNumber = scanner.next();
        System.out.print("Kan Grubu: ");
        String bloodType = scanner.next();
        System.out.print("Mevcut Durum: ");
        String currentCondition = scanner.next();

        Patient newPatient = new Patient(username, password, name, surname, gender, age, ID, medicalRecordNumber, bloodType, currentCondition);
        patients.add(newPatient);
        savePatientToJson("patients.json");

        System.out.println("Hasta başarıyla eklendi.");
    }

    public void listPatients() {
        if (patients.isEmpty()) {
            System.out.println("Kayıtlı hasta yok.");
        } else {
            System.out.println("Hasta Listesi:");
            for (Patient patient : patients) {
                System.out.println("Kullanıcı Adı: " + patient.getUsername() +
                        ", İsim: " + patient.getName() +
                        ", Soyisim: " + patient.getSurname() +
                        ", Cinsiyet: " + patient.getGender() +
                        ", Yaş: " + patient.getAge() +
                        ", ID: " + patient.getID() +
                        ", Tıbbi Kayıt Numarası: " + patient.getMedicalRecordNumber() +
                        ", Kan Grubu: " + patient.getBloodType() +
                        ", Mevcut Durum: " + patient.getCurrentCondition());
            }
        }
    }

    public void savePatientToJson(String filename) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(patients, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadPatientFromJson(String filename) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileReader reader = new FileReader(filename)) {
            Type listOfPatientType = new TypeToken<ArrayList<Patient>>() {}.getType();
            patients = gson.fromJson(reader, listOfPatientType);
        } catch (IOException e) {
            e.printStackTrace();
            patients = new ArrayList<>(); // Eğer dosya okunamazsa boş liste oluştur
        }
    }

    private Patient findPatientById(String id) {
        // ID ile hasta bulma mantığı
        // Örneğin:
        return patients.stream()
                .filter(patient -> patient.getID().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void createNurse(){
        System.out.println("Hemşire Ekleme");
        System.out.print("Kullanıcı adı: ");
        String username = scanner.next();
        System.out.print("Şifre: ");
        String password = scanner.next();
        System.out.print("İsim: ");
        String name = scanner.next();
        System.out.print("Soyisim: ");
        String surname = scanner.next();
        System.out.print("Cinsiyet: ");
        String gender = scanner.next();
        System.out.print("Yaş: ");
        int age = scanner.nextInt();
        System.out.print("Departman: ");
        String department = scanner.next();
        System.out.print("Unvan: ");
        String position = scanner.next();
        System.out.print("ID: ");
        String ID = scanner.next();
        System.out.print("Çalışma Saatleri: ");
        String workHours = scanner.next();
        System.out.println("Lisans Numarası: ");
        String nursingLicenseNumber = scanner.next();

        Nurse newNurse = new Nurse(username, password, name, surname, gender, age, ID, department, position, workHours, nursingLicenseNumber);
        nurses.add(newNurse);
        saveNursesToJson("nurses.json");

        System.out.println("Hemşire başarıyla eklendi.");

    }

    public void listNurses() {
        if (nurses.isEmpty()) {
            System.out.println("Kayıtlı hemşire yok.");
        } else {
            System.out.println("Hemşire Listesi:");
            for (Nurse nurse : nurses) {
                System.out.println("Kullanıcı Adı: " + nurse.getUsername() +
                        ", İsim: " + nurse.getName() +
                        ", Soyisim: " + nurse.getSurname() +
                        ", Cinsiyet: " + nurse.getGender() +
                        ", Yaş: " + nurse.getAge() +
                        ", Departman: " + nurse.getDepartment() +
                        ", Unvan: " + nurse.getPosition() +
                        ", ID: " + nurse.getID() +
                        ", Çalışma Saatleri: " + nurse.getWorkHours() +
                        ", Lisans Numarası: " + nurse.getNursingLicenseNumber());
            }
        }
    }

    public void saveNursesToJson(String filename) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(nurses, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadNursesFromJson(String filename) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileReader reader = new FileReader(filename)) {
            Type listOfNursesType = new TypeToken<ArrayList<Nurse>>() {}.getType();
            nurses = gson.fromJson(reader, listOfNursesType);
        } catch (IOException e) {
            e.printStackTrace();
            nurses = new ArrayList<>(); // Eğer dosya okunamazsa boş liste oluştur
        }
    }

    public void createPrescription() {
        System.out.println("Reçete Oluşturma");

        // Doktorları listele
        listDoctors();
        System.out.print("Doktor ID'yi girin: ");
        String doctorId = scanner.next();

        // Hastaları listele
        listPatients();
        System.out.print("Hasta ID'yi girin: ");
        String patientId = scanner.next();

        // Doktor ve hastayı bul
        Doctor doctor = findDoctorById(doctorId);
        Patient patient = findPatientById(patientId);
        System.out.println(doctor);
        System.out.println(patient);

        // İlaç bilgilerini al
        List<Medication> medications = new ArrayList<>();
        boolean addingMore = true;
        while (addingMore) {
            System.out.print("İlaç adı: ");
            String medName = scanner.next();
            System.out.print("Dozaj: ");
            String dosage = scanner.next();
            System.out.print("Talimatlar: ");
            String instructions = scanner.next();

            medications.add(new Medication(medName, dosage, instructions));

            System.out.print("Başka ilaç eklemek istiyor musunuz? (evet/hayır): ");
            addingMore = scanner.next().equalsIgnoreCase("evet");
        }

        // Reçete oluştur ve listeye ekle
        Prescription newPrescription = new Prescription(doctor, patient, new Date(), medications);
        prescriptions.add(newPrescription);
        savePrescriptionsToJson("prescriptions.json");

        System.out.println("Reçete başarıyla oluşturuldu.");
    }

    public void savePrescriptionsToJson(String filename) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(prescriptions, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadPrescriptionsFromJson(String filename) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileReader reader = new FileReader(filename)) {
            Type listOfPrescriptionsType = new TypeToken<ArrayList<Prescription>>() {}.getType();
            prescriptions = gson.fromJson(reader, listOfPrescriptionsType);
        } catch (IOException e) {
            e.printStackTrace();
            prescriptions = new ArrayList<>(); // Eğer dosya okunamazsa boş liste oluştur
        }
    }

    public void queryPrescriptionsByPatientId(String patientId) {
        List<Prescription> filteredPrescriptions = new ArrayList<>();
        String patientName = "";

        for (Prescription prescription : prescriptions) {
            Patient patient = prescription.getPatient();
            if (patient.getID().equals(patientId)) {
                if (patientName.isEmpty()) {
                    patientName = patient.getName(); // İlk eşleşen hastanın adını al
                }
                filteredPrescriptions.add(prescription);
            }
        }

        if (filteredPrescriptions.isEmpty()) {
            System.out.println("Bu hastaya ait reçete bulunamadı.");
        } else {
            System.out.println(patientName + " isimli hastanın Reçeteleri:");
            for (Prescription pres : filteredPrescriptions) {
                System.out.println("Reçete Tarihi: " + pres.getIssueDate());
                System.out.println("Doktor: " + pres.getDoctor().getName() + " " + pres.getDoctor().getSurname());
                System.out.println("İlaçlar:");

                for (Medication med : pres.getMedications()) {
                    System.out.println("  İlaç Adı: " + med.getName());
                    System.out.println("  Dozaj: " + med.getDosage());
                    System.out.println("  Talimatlar: " + med.getInstructions());
                    System.out.println();
                }

                System.out.println("-----------------------------------");
            }
        }
    }

    public void createAppointment() {
        System.out.println("Randevu Oluşturma");

        // Doktorları listele ve seçim yap
        listDoctors();
        System.out.print("Doktor ID'yi girin: ");
        String doctorId = scanner.next();
        Doctor doctor = findDoctorById(doctorId);

        // Hastaları listele ve seçim yap
        listPatients();
        System.out.print("Hasta ID'yi girin: ");
        String patientId = scanner.next();
        Patient patient = findPatientById(patientId);
        scanner.nextLine();

        // Randevu tarihi al
        System.out.print("Randevu tarihi (yyyy-MM-dd HH:mm formatında): ");
        String dateString = scanner.nextLine();
        System.out.println(dateString);
        Date appointmentDate = parseDate(dateString);

        // Randevu amacını al
        System.out.print("Randevu amacı: ");
        String purpose = scanner.nextLine();

        // Randevu oluştur ve listeye ekle
        Appointment newAppointment = new Appointment(doctor, patient, appointmentDate, purpose);
        appointments.add(newAppointment);

        System.out.println("Randevu başarıyla oluşturuldu.");
        saveAppointmentsToJson("appointments.json");
    }

    private Date parseDate(String dateString) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(dateString);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void saveAppointmentsToJson(String filename) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(appointments, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadAppointmentsFromJson(String filename){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileReader reader = new FileReader(filename)) {
            Type listOfPrescriptionsType = new TypeToken<ArrayList<Prescription>>() {}.getType();
            appointments = gson.fromJson(reader, listOfPrescriptionsType);
        } catch (IOException e) {
            e.printStackTrace();
            appointments = new ArrayList<>(); // Eğer dosya okunamazsa boş liste oluştur
        }
    }

}

