package LLD.A_OOP_SOLID.A00_Code.C5_Employee;

public class Employee  {
    int id;
    String name;
    double salary;
    String department;
    Employee(){
        this(0,"Unknown",0.0, "Unknown");
    }
    Employee(int id,String name,double salary,String department){
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.department = department;
    }
}
