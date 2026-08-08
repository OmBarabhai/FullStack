// // // var lang = "js";
// // // lang = "ts";
// // // console.log(lang);

// // const company = "google";
// // function printCompany() {
// //   console.log(company);
// // }

// // printCompany();
// // console.log(company);


// // /*
// // Program Starts
// // Global Execution Context Created
// // company = "Google"
// // Function Created
// // printCompany()
// // console.log(company)
// // */

// let age = 22;
// if (true) {
//   console.log(age);
// }
// console.log(age);


// function test() {
//   var x = 10;
//   console.log(x);
// }
// test();
// console.log(x);

// function add() {
//   var a = 5;
//   var b = 10;
//   console.log(a+b);
// }
// add();
// console.log(a);

// {
//   let age = 20;
// // }
// // console.log(age);

// // if (true) {
// //   var city = "Pune";
// //   console.log(city);
// // }
// // console.log(city);
// // function scope() {
// //   var a = 39;

// // }
// // console.log(a);

// const country = "India";
// function outer() {
//   const state = "Maharashtra";
//   function inner() {
//     const city = "Pune";
//     console.log(country);
//     console.log(state);
//     console.log(city);
//   }
//   inner();
// }
// outer();


// var country1 = "India";
// if (true){
//   var state1 = "Maharashtra";
//   function inner() {
//     let city1 = "Pune";
//     console.log(city1);
//   }
//   inner();
// }
// console.log(country1);
// console.log(state1);

// console.log(a);
// var a = 10;
// console.log(a);

// console.log(age);

// let a = 10;

// console.log(age);
// var a1 = 10;

// console.log(a);
// var age = 10;
// function greet(name) {
//   return "Hello" + name;
// }
// console.log(greet(" Om"));

// const greet = function (name) {
//   return "Hello " + name;
// }
// console.log(greet(" Om"));


// const greet = (name) => "Hello " + name;

// console.log(greet(" Om"));


// const Square = (x) => x * x;
// console.log(Square(7));

// const add = (a, b) => a + b;
// console.log(add(21,32));

// const cube = n => n * n * n;
// console.log((cube((BigInt)(84234321231234454145443244334342343434433224324232422342342334823847923889485723427838937194983429392342344234234123423432123123445414544))));

// const greet = (name = "guest") => `Hello ${name}`;

// console.log(greet());

// const sum = (...n) => {
//   let total = 0;
//   for (const num of n) {
//     total += num;
//   }
//   return total;
// };
// console.log(sum(1,2,3,4));

// const substact = (a, b) =>  a - b;

// console.log(substact(10,3));

//const createUser = (name, age) => ({
//  name,
//  age
//});
//console.log(createUser("Om", 22));
//
////const num = [1, 2, 3,47,3,2,1,2,9,2];
//const doubled = num.map(
//  function (num) {
//  return num * 2;
//});
//console.log(doubled);
//
//const triple = num.map(num => num * 3);
//console.log(triple);
//
//const even = num.filter(num => (num & 1) === 0);
//
//console.log(even);
//
//console.log(`${10>29}`);
//const  age = 22;
//
//console.log(`${age >= 19}`);
//
//console.log(`${age >= 19 ? "Adult" : "Minor"}`);
//
//
//const lang = "javascript";
//console.log(`${lang.toUpperCase()}`);
//
//const num = [12, 3, 4, 3, 2];
//
//console.log(`${(function(arr) {
//    return arr.map(n => n * 3);
//})(num)}`);
//
//function sum(...val){
////console.log(arguments);
//console.log(val);
//}
//sum(12,21,"b");
//sum("A","B","C");
//
//function greet(...age,...names){
//console.log(`${names,age}`);
////console.log(`${names[],age}`);
//
//}
//greet("Om","Sahil","Pavan");
//greet(21,22, {Om:"Hello"},{Sahil:"Hii"});

//function test(...val){
//console.log(val);
//}
//test(12,22,21);
//function logger(...msg){
//console.log(msg);
//}
//const messages = `${"Hello"} ${"Hii, How"} `
//logger(messages);
//
//function multiply(mul, ...num){
//return num.map(num => num * mul);
//}
//console.log(multiply(2,1,2,3));

//const sum = (...num) => num.reduce((tot,num) => tot + num,0);
//console.log(sum(10,20,30));
//
//
////const num =[10,21,12,33,12];
////const [first,...rem] = num;
////console.log(first);
////console.log(rem);
////
////
////
////
////const user = {
////name:"om",
////age: 22,
////city: "pune"
////}
////const {name,...details} = user;
////console.log(name);
////console.log(details);
//
//
//const fruits = ["Mango","Apple","Strawberry","Banana"];
//const [first,...rem] = fruits;
//console.log(first);
//console.log(rem);
//
//const emp = {
//name:"Sahil",
//age:21,
//city:"Mum",
//id:27,
//sal:  22000.0078,
//}
//const {id,...remDetail} = emp;
//console.log(id);
//console.log(remDetail);
//
//function max(...nums){
//return Math.max(...nums);
//}
//console.log(max(10,23,21,21231,2));
//
//function avg(...nums){
//const tot = nums.reduce((sum,nums) => sum+nums,0);
//  return tot / nums.length;
//}
//
//console.log(avg(12,21,93,21));
//
//
//function stud(...names){
//names.map(name => console.log(name))
//};
////stud("Om","Sahil","Pavan");
//
//const {name,...details} = {
//name:"Om",
//age:22,
//city:"Pune",
//};
//console.log(name);
//
//console.log(details);

//const num = [10,23,12];
//console.log(...num);
//
//const arr1 = [1,2,3];
//const arr2 = [4,5,6];
//const res = arr1.concat(arr2);
//console.log(res);
//
//const copy = [...num];
//const updatedAddLast = [...num,40];
//console.log(updatedAddLast);
//const updatedAddFirstAndLast = [00,...num,40];
//console.log(updatedAddFirstAndLast);
//
//const spread = [...arr1,...updatedAddFirstAndLast,...arr2,];
//
//
//
//console.log(spread);
//
//
//const lang = "JavaScript";
//const ch = [...lang];
//console.log(ch);
//
//
//

//const user = {name:"Om",age: 22};
//const copy = {...user};
//console.log(copy);

//const org = {
//name: "Om",age:22, address:{city:"Pune"}
//};
//
//const copy2 = {
//...org
//};
//copy2.name = "sahil";
//console.log(org.name);
//console.log(copy2.name);
//copy2.address.city = "Mumbai";
//console.log(org.address.city);
//console.log(copy2.address.city);
//console.log(Math.max(...spread));
//
//function reverse(input) {
//  return input.split(" ")
//    .map(word => [...word]
//    .reverse().join(""))
//    .join(" ");
//}
//console.log(reverse("Always indent your code"));
//
//const marks = [90,32,70];
//const updated = [...marks];
//updated[1] =97;
////console.log(updated);
//
//const person = {
//name:"Om",age:22
//};
//console.log(person.name);
//console.log(person.age);
//const {name,age} = person;
//console.log(name);
//console.log(age);
//
//const {name:Sahil} = person;
//console.log(Sahil);
//let {name} = person;
//name = "Sahil";
//console.log(name);
//const num = [1,2,3,4,5,6,7,8];
//const [first,sec,thir,four,...rem] = num;
//console.log(first);
//console.log(sec);
//console.log(thir);
//console.log(four);
//console.log(rem);

//const user ={
//name:"OM",
//age:22,
//add:"pune"
//}
//
//const {name,...rem} = user;
//
//const updated = {...user,role:"Dev"};
//console.log(updated);
//console.log(rem);





//const color = ["Red","Green","Blue"];
//const [first,second,third] = color;
//console.log(first);
//console.log(second);
//console.log(third);

//const color1 = ["Red","Green","Blue"];
//const [first, ,third] = color1;
//console.log(first);
//console.log(third);


//const color1 = ["Red","Green","Blue"];
//const [first, ...others] = color1;
//console.log(first);
//console.log(others);

//const user ={
//name:"Om",
//age:22,
//city:"Pune"
//}
//const {name,city} = user;
//console.log(name);
//console.log(city);
//
//const user ={
//name:"Om",
//age:22,
//city:"Pune"
//}
////const { name:fullName } = user;
////console.log(fullName);
//const {name,age} = user;
//console.log(name);
//console.log(age);
//
//const num = [1,[2,3]];
//const [a,[b,c]] = num;
//console.log(a);
//console.log(b,c);
//
//const employee = {
//
//    name:"Om",
//
//    address:{
//
//        city:"Pune",
//
//        pin:411001
//
//    }
//
//};
//
//const {
//
//    address:{
//
//        city
//
//    }
//
//} = employee;
//
//console.log(city);
//
//
//const lang = "JAVASCRIPT";
//const[...letters] = lang;
//console.log(letters);
//
//const [...f] = "JAVASCRIPT";
////console.log(f);
//const [first , ...rem] = f;
//console.log(first);
//console.log(f.join("").substring(1));
//
//
//
//
//
//
//
//
//const user = {
//
//    name: "Om",
//
//    age: 22,
//
//    city: "Pune"
//
//};
//
//const {
//
//    name,
//
//    city
//
//} = user;
//
//console.log(name);
//console.log(city);
//
//function printUser(user){
//console.log(user.name);
//console.log(user.age);
//}
//printUser({name:"Om",age:22});
//
//
//
//let a = 20;
//let b =40;
//[a,b] = [b,a];
//console.log(a);
//console.log(b);





const key = "Lang";
const key2= "Lang2";

const cours ={
[key] :"JS",
[key2] :"JS2",
};
const {k,k2} = cours;
console.log(cours);


const p ={
greet : function(){
console.log("Hi")

}
}
p.greet();

const p1 = {
greet(){
console.log("Hwll")

}
}

p1.greet();


const cal = {
add(a,b){
return a+ b;
}
}
console.log(cal.add(3,2))



const id = 101;
const st = {
["st_"+id] : "Om"
}
console.log(st)

function crCourse(name,field,val){
return {
name,[field] : val
};
}
const cr = crCourse("Js","Lang","Java")
console.log(cr)
