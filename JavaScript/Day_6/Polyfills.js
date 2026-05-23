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
const arr1 = [1, 2, 3];
const res = arr1.map((items) => {
  return items * 2;
});
console.log(arr1);

Array.prototype.myMap = function (callback) {
  const arr2 = [];
  for (let items of this) {
    arr2.push(callback(items));
  }
  // console.log(arr2);
  return arr2;
};

const arr3 = [2, 4, 5, 6, 8];
const res2 = arr3.filter((items) => {
  return items > 5;
});
console.log(res2);

Array.prototype.myFilter = function (callback) {
  const arr4 = [];

  for (let items of this) {
    if (callback(items)) {
      arr4.push(items);
    }
  }
  return arr4;
};
// const arr3 = [2,4,5,6,8];

const res3 = arr3.myFilter((item) => {
  return item > 5;
});

console.log(res3);

const arr5 = [1, 2, 3, 4, 5, 6, 7];
const res5 = arr5.find((items) => {
  return items > 5;
});
console.log(res5);

Array.prototype.myFind = function (callback) {
  for (let items of this) {
    if (callback(items)) {
      return items;
    }
  }
  return undefined;
};
const arr6 = [1, 2, 3, 4, 5, 6, 7, 5, 6];

const ans3 = arr6.myFind((items) => {
  return items > 6;
});
console.log(ans3);
