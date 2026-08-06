package LLD.A_OOP_SOLID.Code.A_Class_Object;

public class Main {
    public static void main(String[] args) {
        Movie m1 = new Movie();
        m1.duration = "3Hr";
        m1.movieName = "Avenger Endgame";
        m1.rating = 4.9;
        System.out.println(m1.duration + " " + m1.movieName + " " + m1.rating);
        Book b1 = new Book();
        b1.title = "Atomic Habit";
        b1.author = "Jhon";
        b1.price = 600;
        System.out.println(b1.title + " " + b1.author + " " + b1.price);

        Employee e1 = new Employee();
        e1.name = "Om";
        e1.salary = 2200000;
        e1.id = 22;
        System.out.println(e1.name + " " + e1.salary + " " + e1.id);
/*
s1 is reference variable stored in stack memory
new student() is object created in heap memory
same for emplyee
* */
        Student s1 = new Student();

        s1.name = "Om";
        s1.age = 22;
        System.out.println(s1.name);
        System.out.println(s1.age);

        Car c1 = new Car();
        c1.brand = "BMW";
        c1.model = 30;
        c1.price = 3000000;
        Car c2 = new Car();
        Car c3 = new Car();
        System.out.println(c1.brand);
        System.out.println(c1.model);
        System.out.println(c1.price);
    }
}

class Student {
    String name;
    int age;
    int rollNumber;
    String course;

    public void study() {

    }

    public void display() {

    }

    public void updateCourse() {

    }
}

class Car {
    String brand;
    int model;
    int price;
}

class Employee {
    int id;
    String name;
    int salary;
}

class Book {
    String title;
    String author;
    int price;
}

class Movie {
    String movieName;
    String duration;
    double rating;
}