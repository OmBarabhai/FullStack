package LLD.A_OOP_SOLID.A00_Code.C5_Employee;

public class Employee  {
   private int employeeId;
   private String name;
   private String department;
   private double salary;

   public void setSalary(double salary){
       if(salary>0) {
           this.salary = salary;
       }
   }
   public double getSalary(){
       return salary;
   }
   public void setName(String name){
       this.name = name;
   }
   public String getName(){
       return name;
   }
   public void setEmployeeId(int employeeId){
       this.employeeId = employeeId;
   }
    public int getEmployeeId(){
       return employeeId;
    }
    public void setDepartment(String department){
       this.department = department;
    }
    public String getDepartment(){
       return department;
    }
}
