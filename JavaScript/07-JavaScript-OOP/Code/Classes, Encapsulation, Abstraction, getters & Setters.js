// console.log(om2); // error because we used in this const  that why before execuition not possible because it is in tdz

console.log(om3); // undefined because var is hoisted and initialized with undefined

// console.log(Person);// this is not possible before exection of class it is in tdz zone

class Person {
  constructor(name = "UserName", age = null, location = "N/A") {
    this.name = name;
    this.age = age;
    this.location = location;
  }
  sayHi() {
    console.log(`hi, ${this.name}`);
  }
}

const om = new Person("Om");
console.log(om);
const om1 = new Person("Om", 22, "pune");
console.log(om1);

// console.log(om2); // error because we used in this const  that why before execuition not possible because it is in tdz
const Student = class {
  constructor(name) {
    this.name = name;
  }
  sayHello() {
    console.log(`Hello, ${this.name}`);
  }
};
const om2 = new Student("om");
console.log(om2);

console.log(om3); //undefined because we use var it will give in tdz undefined
var Student1 = class {
  constructor(name) {
    this.name = name;
  }
  sayHello() {
    console.log(`Hello, ${this.name}`);
  }
};
var om3 = new Student1("om");
console.log(om3);

//private conventions

//private _name

// Like putting a sticker:

// “Private - please don't open.”

// But anyone still CAN open it.
class Person2 {
  constructor(name) {
    this._name = "MsDhoni";
  }
  get getName() {
    return this._name;
  }
}
const om4 = new Person2("Om");
console.log(om4);

//private encapsulation
class Person3 {
  #name;
  constructor(name) {
    this.#name = name;
  }
  sayBye() {
    console.log(`Bye, ${this.#name}`);
  }
  get getName() {
    return this.#name;
  }
  set setName(name) {
    this.#name = name;
  }
}
const om5 = new Person3("Om"); // Person3 {}
console.log(om5.getName);
om5.setName = "virat";
console.log(om5.getName);

//abstraction
class CoffeeMachine {
  makeCoffee() {
    this.#boilingWater();
    this.#addCoffee();
    console.log("Coffee is Ready");
  }
  #boilingWater() {
    console.log("Boiling Water For Coffee...");
  }
  #addCoffee() {
    console.log("Adding Coffee in Water...");
  }
}
const Customer = new CoffeeMachine();
Customer.makeCoffee();

//encapsulation

class EmployeeSalary {
  #salary;
  constructor(em1Name, salary) {
    this.em1Name = em1Name;
    this.#salary = salary;
  }
  //getter and setter
  get getSalary() {
    //use emp1.getSalary;
    return this.#salary;
  }
  set setSalary(amount) {
    //use emp1.setSalary = 6700;
    if (amount > 0) {
      this.#salary = amount;
    }
  }
  //normal method
  //    getSalary() {//use emp1.getSalary();
  //     return this.#salary;
  //   }
  //  setSalary(amount) {//use emp1.getSalary(6700);
  //     if (amount > 0) {
  //       this.#salary = amount;

  //     }
  //   }
}
const emp1 = new EmployeeSalary("Om", 700000);
console.log(emp1.getSalary);

emp1.setSalary = 6700;
console.log(emp1.getSalary);
