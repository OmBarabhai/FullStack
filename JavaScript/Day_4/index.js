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

function sayHi() {
  console.log("Hi");
}

sayHi();

// ======================================================
// 2. FUNCTION WITH PARAMETERS
// ======================================================

function addTwoNum(a, b) {
  return a + b;
}

const sum = addTwoNum(2, 3);
console.log(sum);

// ======================================================
// 3. FUNCTION EXPRESSION
// ======================================================

const greet = function () {
  console.log("Hello");
};

greet();

// ======================================================
// 4. ARROW FUNCTION
// ======================================================

const multiply = (a, b) => {
  return a * b;
};

console.log(multiply(2, 3));

// ======================================================
// 5. IMPLICIT RETURN
// ======================================================

const sub = (a, b) => a - b;

console.log(sub(10, 4));

// ======================================================
// 6. THIS KEYWORD
// ======================================================

// Arrow Function

var name = "Global";

const person = {
  name: "Om",

  sayName: () => {
    console.log(this.name);
  },
};

person.sayName();

// OUTPUT:
// undefined OR Global

// Regular Function

const person1 = {
  name: "Om",

  sayName: function () {
    console.log(this.name);
  },
};

person1.sayName();

// OUTPUT:
// Om

// ======================================================
// 7. RECURSION
// ======================================================

function printNum(n) {
  if (n == 0) {
    return;
  }

  console.log(n);

  printNum(n - 1);
}

printNum(5);

// ======================================================
// 8. FUNCTION CHAINING
// ======================================================

const calculator = {
  value: 0,

  add: function (x) {
    this.value += x;
    return this;
  },

  sub: function (x) {
    this.value -= x;
    return this;
  },

  mul: function (x) {
    this.value *= x;
    return this;
  },

  result: function () {
    return this.value;
  },
};

const ans = calculator.add(10).sub(6).mul(3).result();

console.log(ans);

// ======================================================
// 9. IIFE
// Immediately Invoked Function Expression
// ======================================================

(function () {
  console.log("IIFE Executed");
})();

// ======================================================
// 10. PURE FUNCTION
// Same input => Same output
// ======================================================

function add(a, b) {
  return a + b;
}

console.log(add(2, 3));
console.log(add(2, 3));

// ======================================================
// 11. IMPURE FUNCTION
// Depends on outside value
// ======================================================

let count = 0;

function counter() {
  count++;
  return count;
}

console.log(counter());
console.log(counter());
console.log(counter());

// ======================================================
// 12. CALLBACK FUNCTION
// ======================================================

function printValue(value) {
  console.log(value);
}

function addNum(a, b) {
  return a + b;
}

function calculate(x, y, callback) {
  const res = addNum(x, y);

  callback(res);
}

calculate(2, 3, printValue);

// ======================================================
// 13. HIGHER ORDER FUNCTION
// Pass function OR return function
// ======================================================

function addAndPrint(a, b) {
  const res = a + b;

  return function () {
    console.log(res);
  };
}

const output = addAndPrint(7, 5);

output();

// ======================================================
// 14. FUNCTION CURRYING
// ======================================================

function addThreeNumbers(a) {
  return function (b) {
    return function (c) {
      return a + b + c;
    };
  };
}

console.log(addThreeNumbers(1)(2)(3));