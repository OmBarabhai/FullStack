package LLD.A_OOP_SOLID.Practice.P4_Hospital;

public class Main {

    public static void main(String[] args) {

        Patient p1 = new Patient();
        p1.patientId = 32;
        p1.name = "Kim";
        p1.age = 35;
        p1.disease = "Headache";

        Patient p2 = new Patient();
        p2.patientId = 33;
        p2.name = "John";
        p2.age = 42;
        p2.disease = "Fever";

        Patient p3 = new Patient();
        p3.patientId = 34;
        p3.name = "Sara";
        p3.age = 28;
        p3.disease = "Cold";

        Patient p4 = new Patient();
        p4.patientId = 35;
        p4.name = "Rahul";
        p4.age = 31;
        p4.disease = "Fracture";

        System.out.println(STR."\{p1.patientId} \{p1.name} \{p1.age} \{p1.disease}");

        // Print p2, p3, and p4 in the same way

        /*
         * p1, p2, p3, and p4 are reference variables stored in Stack Memory.
         * Each Patient object is created separately in Heap Memory.
         * Every object stores its own independent data.
         */

    }
}