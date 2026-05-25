// ======================================================
// POLYFILL NOTES
// ======================================================

/*
Polyfill:
A custom implementation of a feature
for older browsers that do not support it.

Example:
Browser  : 2015
Feature  : 2016
Method   : Array.includes()
*/

// ======================================================
// NATIVE includes() POLYFILL
// ======================================================

/*
This checks:

IF browser does NOT support includes(),
THEN create our own version.

Modern browsers already have includes(),
so this block usually does NOT run.
*/

// if (!Array.prototype.includes) {

//   Array.prototype.includes = function (element) {

//     // "this" refers to current array
//     // Example:
//     // nums.includes(3)
//     // this => [1,2,3,4,5]

//     for (let item of this) {

//       // if element found
//       if (item === element) {
//         return true;
//       }

//     }

//     // if loop finishes
//     // element not found
//     return false;
//   }

// }

// ======================================================
// CUSTOM POLYFILL FOR LEARNING
// ======================================================

/*
Creating our own method:
myIncludes()
*/

Array.prototype.myIncludes = function (element) {
  // loop through array
  for (let item of this) {
    // if element matches
    if (item === element) {
      return true;
    }
  }

  // if no match found
  return false;
};

// ======================================================
// TESTING
// ======================================================

const nums = [1, 2, 3, 4, 5];

// Native JavaScript method
console.log(nums.includes(1));
// true

// Custom polyfill method
console.log(nums.myIncludes(1));
// true

console.log(nums.myIncludes(3));
// true

console.log(nums.myIncludes(10));
// false

// ======================================================
// IMPORTANT NOTE
// ======================================================

/*
WRONG:

for(let item of this){

   if(item === element){
      return true;
   }

   return false;
}

Problem:
return false is INSIDE loop.

So loop stops after checking only first item.



CORRECT:

for(let item of this){

   if(item === element){
      return true;
   }

}

return false;

Now all elements are checked.
*/
const arr1 = [1, 2, 3, 4, 5];
console.log("includes Feature: " + arr1.includes(7));
//call back behaviour
Array.prototype.myIncludes = function (callback) {
  for (let item of this) {
    if (callback(item) ) {
      return true;
    }
  }
  return false;
}
const res1 = arr1.myIncludes((item) => {
  return item == 6;
})
console.log(res1);

Array.prototype.mySome = function (element) {
  for (let item of this) {
    if (item == element) {
      return true;
    }
  }
  return false;
}

console.log(arr1.mySome(2));

const res2 = arr1.map((item) => {
  return item * 2;
})
console.log(res2);

Array.prototype.myMap = function (callback) {
  let num = [];
  for (let item of this) {
      num.push(callback(item));
  }
  return num
}

let res3 = arr1.myMap((item) => {
  return item * 2;
})
console.log(res3);
