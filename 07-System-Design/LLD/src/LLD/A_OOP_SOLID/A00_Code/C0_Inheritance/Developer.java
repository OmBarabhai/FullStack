package LLD.A_OOP_SOLID.A00_Code.C0_Inheritance;


public class Developer extends Employee {
    private String programmingLang;
    private int experience;
    Developer(int employeeId,String name,int salary,String programmingLang,int experience){
        super(employeeId,name,salary);
        this.programmingLang = programmingLang;
        this.experience = experience;
    }
    void displayDev(){
        System.out.println(employeeId);
        System.out.println(name);
        System.out.println(salary);
        System.out.println(experience);
        System.out.println(programmingLang);
    }
}