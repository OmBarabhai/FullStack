package LLD.A_OOP_SOLID.A00_Code.C5_Employee;

public class Main {

    public static void main(String[] args) {
        Employee e1 = new Employee();

        e1.setEmployeeId(101);
        e1.setName("Om");
        e1.setDepartment("Engineering");
        e1.setSalary(50000);

        System.out.println(e1.getEmployeeId());
        System.out.println(e1.getName());
        System.out.println(e1.getDepartment());
        System.out.println(e1.getSalary());
    }
}