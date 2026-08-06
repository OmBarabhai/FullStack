package LLD.A_OOP_SOLID.Practice.P1_Student;

public class Main{
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Om";
        s1.rollNumber = 21;
        s1.age = 22;
        s1.course = "CSE";
        System.out.println(s1.name + " "+ s1.age+" "+s1.rollNumber+" "+ s1.course);
        Student s2 = new Student();
        s2.name = "sahil";
        s2.rollNumber = 22;
        s2.age = 22;
        s2.course = "CSE";
        System.out.println(s2.name + " "+ s2.age+" "+s2.rollNumber+" "+ s2.course);

        Student s3 = new Student();
        s3.name = "pavan";
        s3.rollNumber = 23;
        s3.age = 22;
        s3.course = "CSE";
        System.out.println(s3.name + " "+ s3.age+" "+s3.rollNumber+" "+ s3.course);

        Student s4 = new Student();
        s4.name = "nakul";
        s4.rollNumber = 24;
        s4.age = 22;
        s4.course = "CSE";
        System.out.println(s4.name + " "+ s4.age+" "+s4.rollNumber+" "+ s4.course);

        Student s5 = new Student();
        s5.name = "shiva";
        s5.rollNumber = 25;
        s5.age = 24;
        s5.course = "CSE";
        System.out.println(s5.name + " "+ s5.age+" "+s5.rollNumber+" "+ s5.course);
    }

}