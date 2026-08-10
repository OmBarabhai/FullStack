class Person{
  constructor(name,age,loc) {
    this.name = name;
    this.age = age;
    this.loc = loc;
  }
  introduce() {
    console.log(`Hi, My Name's ${this.name} and I am ${this.age} and I am from ${this.loc}`);
    
  }
}
const om = new Person('Om', 22, 'Pune');
om.introduce();

class Student extends Person{
  constructor(name, age, loc, grade) {
    super(name, age, loc);
    this.grade = grade;
  }
  gradeInfo() {
    console.log(`Hi, ${this.name} grade is ${this.grade}`);
  }
}
const om1 = new Student('Om', 22, 'Pune',89);
om1.introduce();
om1.gradeInfo();