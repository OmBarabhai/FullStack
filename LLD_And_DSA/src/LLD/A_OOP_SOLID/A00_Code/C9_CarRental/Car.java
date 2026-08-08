package LLD.A_OOP_SOLID.A00_Code.C9_CarRental;

public class Car {
    String brand;
    String model;
    String color;
    double rentPerDay;
    Car(){
        this("Unknown","Unknown","Unknown",0.0);
    }
    Car(String brand,String model,String color,double rentPerDay){
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.rentPerDay = rentPerDay;
    }
}
