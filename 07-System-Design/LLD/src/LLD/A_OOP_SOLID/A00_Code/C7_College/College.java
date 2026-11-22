package LLD.A_OOP_SOLID.A00_Code.C7_College;

public class College {
    private int collegeId;
   private String collegeName;
    private String city;
    private int totalStudent;

    public void setCollege(int collegeId, String collegeName, String city, int totalStudent) {
        if (collegeId > 0) {
            this.collegeId = collegeId;
        }
        this.collegeName = collegeName;
        this.city = city;
        if (totalStudent >= 0) {
            this.totalStudent = totalStudent;
        }
    }

    public int getCollegeId() {
        return collegeId;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public String getCity() {
        return city;
    }

    public int getTotalStudent() {
        return totalStudent;
    }
}
