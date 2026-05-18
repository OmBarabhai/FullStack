
// let name = "Rajput";
// console.log(name.split(''));


// let name1 = "Rajput";
// let UseIn = "rajput";
// console.log(name1 == UseIn);//false
// console.log(name1.toLowerCase == UseIn.toLowerCase);//true
// console.log(name1.concat(" Om"));
// console.log(name1.indexOf("u"));



let arr = ["Om", 22, "Rajput"];
// for (let i = 0; i < arr.length; i++){
//   console.log(arr[i]);
  
// }
// for (let i of arr) {
//    console.log(i);//data
//  }
// for (let i in arr) {
//    console.log(i);//index
// }
arr.push("End Element");
arr.unshift("First Element");
console.log(arr);

arr.pop();
arr.shift();
console.log(arr);

let arr1 = [1, 2, 3, 4, 5, 6];
console.log(arr1.slice(2, 4));//[ 3, 4 ]
console.log(arr1); //[ 1, 2, 3, 4, 5, 6 ]

console.log(arr1.splice(3, 4));//[ 4, 5, 6 ] //(Start , Dele no of Ele from Start)
console.log(arr1);//[ 1, 2, 3 ]

console.log(arr1.splice(0,1,40));//[ 4, 5, 6 ] //(Start , Dele no of Ele from Start , insert value of the remove index)

console.log(arr1);//[ 1, 2, 3 ]

