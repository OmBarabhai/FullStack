function addTwoNum(a, b) {
  console.log(a + b);
}

// addTwoNum(2, 3);

function addThreeNum(a, b, c) {
  console.log(a + b + c);
}
// addThreeNum(4, 5, 3);

function addNum() {
  let sum = 0;
  for (let i = 0; i < arguments.length; i++) {
    sum += arguments[i];
  }
  return sum;
}
// addNum(3, 4);
// const res = addNum(3, 4, 8);
// console.log(res);
// ======================================================
// FUNCTIONS IN JAVASCRIPT
// ======================================================

// Functions are FIRST-CLASS CITIZENS in JavaScript
// Means functions can:
// 1. Store in a variable
// 2. Pass as an argument
// 3. Return from another function

// ======================================================
// 1. FUNCTION DECLARATION
// ======================================================

function hey() {
  console.log("Hey!");
}

// Calling Function
hey();

// ======================================================
// 2. FUNCTION EXPRESSION
// ======================================================

// Function stored inside a variable

const sayHello = function () {
  console.log("Hello!");
};

sayHello();

// ======================================================
// 3. ARROW FUNCTION
// ======================================================

const heyOm = (name) => {
  console.log(`Hello ${name}`);
};

heyOm("Om");

// ======================================================
// EXPLICIT RETURN vs IMPLICIT RETURN
// ======================================================

// ======================================================
// 4. EXPLICIT RETURN
// ======================================================

// Using {} requires RETURN keyword
// Multiple operations can be performed

const HeyOm = () => {
  return "Hey Om, How are you?";
};

const res = HeyOm();

console.log(res);

// ======================================================
// 5. IMPLICIT RETURN
// ======================================================

// No {} and no RETURN keyword needed
// Used for single-line return

const HeyOmHowru = () => "Hey, I am Good";

const res1 = HeyOmHowru();

console.log(res1);

// ======================================================
// THIS BINDING
// ======================================================

// Arrow functions and regular functions
// behave differently with "this"

// ======================================================
// 6. THIS IN ARROW FUNCTION
// ======================================================

var name = "Om Global";

const person = {
  name: "Om R",

  // Arrow function
  sayHey: () => {
    console.log(`Hey ${this.name}`);
  },
};

person.sayHey();

// OUTPUT:
// Hey undefined
// OR
// Hey Om Global
//
// WHY?
// Arrow functions do NOT have their own "this".
// They take "this" from the outer/global scope.

// ======================================================
// 7. THIS IN REGULAR FUNCTION
// ======================================================

const person1 = {
  name: "Om R",

  // Regular function
  sayHey1: function () {
    console.log(`Hey ${this.name}`);
  },
};

person1.sayHey1();

// OUTPUT:
// Hey Om R
//
// WHY?
// Regular functions get their own "this".
// Here "this" refers to person1 object.

// ======================================================
// IMPORTANT INTERVIEW POINTS
// ======================================================

// Arrow Function:
// ❌ No own "this"

// Regular Function:
// ✅ Has own "this"

// Use Arrow Function:
// ✅ Callbacks
// ✅ Short functions
// ✅ Array methods

// Use Regular Function:
// ✅ Object methods
// ✅ Constructors
// ✅ When using "this"

// Recursion
function printNum(n) {
  if (n == 0) {
    return;
  }
  console.log(n);
  printNum(n - 1);
}

printNum(7);
