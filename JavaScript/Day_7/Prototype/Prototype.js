function Person(name) {
  this.name = name;
  this.sayHi = function () {
    console.log(`hi, ${this.name}`);
    
  }
}
// prototype inheritance  passing 
const pavan = new Person("pavan");
pavan.sayHi(); 
const student = Object.create(pavan);
student.name = 'nakul'
student.sayHi()
// console.log(typeof  Person);//function
// console.log(typeof new Person); //object
function sayBye() {
  console.log(`Bye, ${this.name}`);
}
Person.prototype.sayBye = sayBye;
const om = new Person('om');
om.sayBye()
om.sayHi()
console.log(om.__proto__ == Person.prototype);

// console.log(Person.prototype);

// const student = {
//   name: "nakul"
// } 
// sayBye.call(student)
// const om = new Person("om")
// const sahil = new Person("sahil")

// console.log(om);
// console.log(sahil);
