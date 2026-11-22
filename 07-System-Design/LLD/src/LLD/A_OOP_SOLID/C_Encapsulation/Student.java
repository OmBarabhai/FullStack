package LLD.A_OOP_SOLID.C_Encapsulation;

public class Student {
    /*    private String name;
        private int age;
        // Getters ---> private protected public default --> pvt default method protect def which is protected by def met pub para meth def meth with para
        private String getName(){
            return name;
        }
        protected int getAge(){//by default, it is protected we cannot create another int getAge(){}
            return age;
        }
        public String getName(String name){
            return name;
        }
        int getAge(int age){
            return age;
        }


        // Setter
        public void setName(String name){
            this.name = name;
        }
        public void setAge(int age){
            this.age = age;
        }
    */
   /* private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }*/

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


