package LLD.A_OOP_SOLID.A00_Code.C7_College;

public class College {
    int collegeId;
    String collegeName;
    String city;
    int totalStudent;
    College(){
        this(0,"Unknown","Unknown",0);
    }
    College(int collegeId, String collegeName,String city,int totalStudent){
        this.collegeId = collegeId;
        this.collegeName = collegeName;
        this.city = city;
        this.totalStudent = totalStudent;
    }
}
