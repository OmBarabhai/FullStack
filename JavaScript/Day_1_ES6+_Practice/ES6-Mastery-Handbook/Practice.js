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

const num = [12, 3, 4, 3, 2];

console.log(`${(function(arr) {
    return arr.map(n => n * 3);
})(num)}`);