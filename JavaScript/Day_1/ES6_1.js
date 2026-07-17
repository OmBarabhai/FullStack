// 1. Write a function that takes a user's age and determines if they are old enough to vote (age 18 or older)

// function isEligibleToVote(age) {
//   if (age < 18) {
//     console.log("Not eligible to vote");
//   }
//   else if (age => 18) {
//     console.log("Eligible to vote");
//   }
// }

// console.log(isEligibleToVote(20)) // Eligible to vote
// console.log(isEligibleToVote(18)) // Eligible to vote
// console.log(isEligibleToVote(17)) // Not eligible to vote

// 2. Write a function that takes two numbers as input and determines which one is greater.

// function isGreater(num1, num2) {
//   if (num1 < num2) {
//     console.log(`${num1} is greater than ${num2}`);
//   } else if (num1 > num2) {
//     console.log(`${num1} is greater than ${num2}`);
//   }
// }
// console.log(isGreater(2, 5)) // 5 is greater than 2
// console.log(isGreater(10, 5)) // 10 is greater than 5

// 3. Write a function that takes a number as input and determines if it is positive or negative.

// function checkNum(numIsPosOrNeg) {
//   if (numIsPosOrNeg < 0) {
//     console.log(`${numIsPosOrNeg} is Negative`);
//   } else {
//     console.log(`${numIsPosOrNeg} is Postive`);
//   }
// }

// console.log(checkNum(9)) // Positive Number
// console.log(checkNum(-8)) // Negative Number
// console.log(checkNum(22)) // Positive Number

// 4. Write a function that takes a number as input and determines if it is even or odd.

// function isEvenOdd(numIsOddOrEven) {
//   if ((numIsOddOrEven & 1) === 1) {
//     console.log(`${numIsOddOrEven} is Odd`);
//   } else {
//     console.log(`${numIsOddOrEven} is Even`);
//   }
// }

// console.log(isEvenOdd(5)) // Odd Number
// console.log(isEvenOdd(8)) // Even Number
// console.log(isEvenOdd(10)) // Even Number

// 5. Write a function that takes a string as input and determines if it contains the letter 'a' or ‘A’.

// function checkForAlphabetA(str) {
//   for (let i = 0; i < str.length; i++){
//     if (str[i] == 'a') {
//       return `${str} Includes a`;
//     }
//   }
//   return `${str} Does Not Includes a`;
// }
// console.log(checkForAlphabetA('Tanay')) // Includes a
// console.log(checkForAlphabetA('Jeep')) // Does not include a
// console.log(checkForAlphabetA('Jane')) // Includes a

//6. Write a function that takes a string as input and determines if it is longer than 5 characters.
// function checkLength(str) {
//   if (str.length > 5) {
//     console.log(` ${str} more than 5 characters`);
//   } else {
//     console.log(` ${str} less than 5 characters`);
//   }
// }
// console.log(checkLength('Programming')) // more than 5 characters
// console.log(checkLength('Jeep')) // less than 5 characters

//7. Write a function that takes a number as input and determines if it is between 1 and 10.
// function isBetweenOneAndTen(num) {
//   if (num <= 10 && num > 1) {
//     return true;
//   } else {
//     return false;
//   }
// }

// console.log(isBetweenOneAndTen(5)) // true
// console.log(isBetweenOneAndTen(11)) // false

// 8. Write a function that takes a string as input and determines if it contains the word "hello".
// function isHelloPresent(str) {
//   str = str.toLowerCase();
//   for (let i = 0; i <= str.length - 5; i++) {
//     if (
//       str[i] === "h" &&
//       str[i + 1] === "e" &&
//       str[i + 2] === "l" &&
//       str[i + 3] === "l" &&
//       str[i + 4] === "o"
//     ) {
//       return true;
//     }
//   }

//   return false;
// }
// console.log(isHelloPresent("Hello World")); // true
// console.log(isHelloPresent("World")); // false
// console.log(isHelloPresent("Say hello"));   // true
// console.log(isHelloPresent("HELLO"));       // true

// 9. Write a function that takes a number as input and determines if it is a multiple of 3.

// function isMultipleOfThree(num) {
//   if (num % 3 === 0) {
//     return true;
//   }
//   return false;
// }
// console.log(isMultipleOfThree(5)) // false
// console.log(isMultipleOfThree(9)) // true
// console.log(isMultipleOfThree(29)) // false

// 10. Write a function which takes in a number as input and returns it after multiplying by 10.

// function multiplyByTen(num) {
//   if (num % 10 === 0) {
//     return num * 10;
//   }
// }
// console.log(multiplyByTen(20)) // 200
// console.log(multiplyByTen(40)) // 400

// 11. Console individual values of the product object using object destructuring.

// const product = {
// title: 'iPhone',
// price: 5999,
// description: 'The iPhone is a smartphone developed by Apple',
// }
// // Your ES6 code here
// const { title, price, description } = product;

// console.log(title) // iPhone
// console.log(price) // 5999
// console.log(description) // The iPhone is a smartphone developed by Apple