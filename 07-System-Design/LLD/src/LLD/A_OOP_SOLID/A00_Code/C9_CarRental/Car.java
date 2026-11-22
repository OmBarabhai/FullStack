package LLD.A_OOP_SOLID.A00_Code.C9_CarRental;

public class Car {
    private String brand;
   private String model;
    private String color;
    private double rentPerDay;
    public void getCar(String brand,String model,String color,double rentPerDay){
        this.brand = brand;
        this.model = model;
        this.color = color;
        if(rentPerDay > 0) {
            this.rentPerDay = rentPerDay;
        }
    }
    public String getBrand(){
        return brand;
    }
    public String getModel(){
        return model;
    }
    public String getColor(){
        return color;
    }
    public double getRentPerDay(){
        return rentPerDay;
    }
}
