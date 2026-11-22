package LLD.A_OOP_SOLID.A00_Code.C1_Student;

public class Student {
    /*Class Object*/

//    int rollNumber;
//    String name;
//    int age;
//    String course;
//
//    /*Constructor*/
//    Student(){
//
//    }
//    Student(int rollNumber,String name,int age,String course){
//        this.name = name;
//        this.age = age;
//        this.rollNumber = rollNumber;
//        this.course = course;
//    }
private int rollNumber;
    private String name;
    private int age;
    private String course;


    public int getRollNumber(){
        return rollNumber;
    }
    public void setRollNumber(int rollNumber){
        this.rollNumber = rollNumber;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return age;
    }
    public void setAge(int age){
        if(age >= 0){
            this.age = age;
        }
    }

    public String getCourse(){
        return course;
    }
    public void setCourse(String course){
        this.course = course;
    }

}
