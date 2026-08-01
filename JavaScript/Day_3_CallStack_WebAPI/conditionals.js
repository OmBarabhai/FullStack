// let tab = '/contact';
//
// let login = false;
// if (login == true) {
  // console.log(tab);
// }
// else {
  // console.log("Not Login");
// }
//
// let tab2 = (login == true) ? console.log(tab) : console.log("Not Login");


// let a = 2;
// let b = 4;
// console.log(a**b);


// for (let i = 0; i < 5; i++){
//   for (let j = 0; j <= i; j++){
//     process.stdout.write("*");
//   }
//   process.stdout.write("\n");
// }

// for (let i = 0; i < 5; i++){
//   for (let j = 0; j < 5 - i - 1; j++){
//     process.stdout.write("   ");
    
//   }
//   for (let j = 0; j < 2*i+1; j++){
//     process.stdout.write(" * ");
//   }
//     process.stdout.write("\n");
// }

function sayHi(name='user') {
  console.log('Hello '+name);
}
sayHi('om');
sayHi('sahil');
sayHi('pavan');
sayHi();

function addTwoNum(a,b) {
  console.log(a + b);
}
addTwoNum(2, 5);