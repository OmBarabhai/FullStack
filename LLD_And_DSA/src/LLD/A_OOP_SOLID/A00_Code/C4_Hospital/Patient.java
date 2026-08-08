package LLD.A_OOP_SOLID.A00_Code.C4_Hospital;

public class Patient{
    int patientId;
    String name;
    int age;
    String disease;
    Patient(){
        this(0,"Unknown",0,"Unknown");
    }
    Patient(int patientId,String name,int age,String disease){
        this.age = age;
        this.patientId =patientId;
        this.name = name;
        this.disease = disease;
    }


}
