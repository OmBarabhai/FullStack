package LLD.A_OOP_SOLID.A00_Code.C4_Hospital;

public class Main {

    public static void main(String[] args) {
        Patient p = new Patient();

        p.setPatient(32, "Kim", 35, "Headache");

        System.out.println(p.getAge());
        System.out.println(p.getPatientId());
        System.out.println(p.getName());
        System.out.println(p.getDisease());

        //this is default constructor if we create object without their details it should be automatically initialize or we can create without parameters in patient class
     /*   Patient p1 = new Patient(32,"Kim",35,"Headache");//this is parameterizes constructor which we intitialize when we creating object
        Patient p2 = new Patient(33,"John",42,"Fever");
        Patient p3 = new Patient(34,"Sara",28,"Cold");
        Patient p4 = new Patient(35,"Rahul",31,"Fracture");

        System.out.println(STR."\{p0.patientId} \{p0.name} \{p0.age} \{p0.disease}");
        System.out.println(STR."\{p1.patientId} \{p1.name} \{p1.age} \{p1.disease}");
        System.out.println(STR."\{p2.patientId} \{p2.name} \{p2.age} \{p2.disease}");
        System.out.println(STR."\{p3.patientId} \{p3.name} \{p3.age} \{p3.disease}");
        System.out.println(STR."\{p4.patientId} \{p4.name} \{p4.age} \{p4.disease}");
*/
        // Print p2, p3, and p4 in the same way

        /*
         * p1, p2, p3, and p4 are reference variables stored in Stack Memory.
         * Each Patient object is created separately in Heap Memory.
         * Every object stores its own independent data.
         */

    }
}