package LLD.A_OOP_SOLID.A00_Code.C4_Hospital;

public class Patient {
    private int patientId;
    private String name;
    private int age;
    private String disease;

    public void setPatient(int patientId, String name, int age, String disease) {
        if (age >= 0) {
            this.age = age;
        }
        this.patientId = patientId;
        this.name = name;
        this.disease = disease;
    }
    public int getAge(){
        return age;
    }
    public String getName(){
        return name;
    }
    public int getPatientId(){
        return patientId;
    }
    public String getDisease(){
        return disease;
    }

}
