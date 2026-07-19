// // 1. Write an ES6 function that accepts an array of integers and returns the maximum element in the array. Avoid using in-built methods.
// const getMaxElement = (array) => {
//   let max = 0;
//   for (let i = 0; i < array.length; i++){
//     if (max < array[i]) {
//       max = array[i];
//     }
//   }
//   return max;
// }

// let array = [4, 78, 8, 3, 6, 0, 12, 34]
// console.log(getMaxElement(array)) // 78

// // 2. Write an ES6 function that takes an array of numbers and returns the average of all the numbers. Avoid using in-built methods.
// //mistake
// // const calculateAverage = (array) => {
// //   let avg = 0;
// //   for (let i = 0; i < array.length; i++){
// //     avg = (array[i] + avg) / 2;
// //   }
// //   return avg;
// // }
// // console.log(calculateAverage([1, 2, 3, 4, 5])) // 3

// const calculateAverage = (array) => {
//   let sum = 0;
//   for (let i = 0; i < array.length; i++){
//     sum += array[i];
//   }

//   return sum/array.length;
// }
// console.log(calculateAverage([1, 2, 3, 4, 5])) // 3

// // 3. write an ES6 function that takes an array of numbers and converts even numbers to odd numbers by adding 1 to that number.
// const convertEvenToOdd = (array) => {
//   for (let i = 0; i < array.length; i++){
//     if ((array[i] & 1) !== 1) {
//       array[i] += 1;
//      }
//   }
//   return array;
// }

// var numArr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
// console.log(convertEvenToOdd(numArr))
// // [1, 3, 3, 5, 5, 7, 7, 9, 9]

// // 4. write an ES6 function that takes an array of words and returns an array with all its elements whose length is greater than 5.

// const filterWords = (array) => {
//   let str = [];
//   for (let i = 0; i < array.length; i++){
//       if (array[i].length > 5) {
//         str.push(array[i]);
//       }
//   }
//   return  str;
// }
// var words = ['eat', 'sleep', 'code', 'repeat', 'neog', 'community']
// console.log(filterWords(words)) // ["repeat", "community"]

// // 5. Write an ES6 function that takes an array of strings and returns a new array with each string capitalized.

// const capitalizeWords = (array) => {
//   let str = [];
//   for (let i = 0; i < array.length; i++){
//     str.push(array[i].toUpperCase());
//   }
//   return str;
// }
// console.log(capitalizeWords(['eat', 'sleep', 'code', 'repeat']))
// // ["EAT", "SLEEP", "CODE", "REPEAT"]

// // 6. Write an ES6 function that takes an array of objects and a property name and returns a new array with only the values of that property. Avoid using in-built methods.

// //i stuck here
// // const getValues = (array, {value}) => {
// //   let newArray = [];
// //   for (let i = 0; i < array.length; i++){
// //     newArray.push(value);
// //   }
// //   return newArray;
// // }
// // console.log(
// // getValues(
// // [
// // { name: 'John', age: 21 },
// // { name: 'Mary', age: 22 },
// // { name: 'Peter', age: 23 },
// // ],
// // 'name',
// // ),
// // ) // ["John", "Mary", "Peter"]

// // 6. Write an ES6 function that takes an array of objects and a property name and returns a new array with only the values of that property. Avoid using in-built methods.

// const getValues = (array, value) => {
//   let newArray = [];
//   for (let i = 0; i < array.length; i++){
//     newArray.push(array[i][value]);
//   }
//   return newArray;
// }
// console.log(
// getValues(
// [
// { name: 'John', age: 21 },
// { name: 'Mary', age: 22 },
// { name: 'Peter', age: 23 },
// ],
// 'name',
// ),
// ) // ["John", "Mary", "Peter"]

// // 8. Write an ES6 function which checks if a student already has a team. If team is not given then add them to team “A” and return the object else do nothing and return the same object. Avoid using in-built methods.

// const checkForTeam = ({ firstName, lastName, team }) => {

//   // //i stuck here then i cnhat gpt this

//   if (!team) {
//     return {
//       firstName,
//       lastName,
//       team:'A',
//     }
//   };
//   return {
//     firstName,
//     lastName,
//     team,
//   };
// };

// console.log(checkForTeam({ firstName: "Penn", lastName: "Ma" }));
// // {firstName: 'Penn', lastName: 'Ma', team: A}
// console.log(checkForTeam({ firstName: "John", lastName: "Dee", team: 'B' }));
// // {firstName: 'John', lastName: 'Dee', team: B}
// console.log(checkForTeam({ firstName: "Priya", lastName: "Raj" }));
// // {firstName: 'Priya', lastName: 'Raj', team: A}


// // 9. Destructure the following code to get the desired outputs. Avoid using in-built methods.
// //i stuck here then i cnhat gpt this
// // const book = {
// //   title: "JavaScript: The Definitive Guide",
// //   authors: [
// //     { name: "David Flanagan", age: 49 },
// //     { name: "Yukihiro Matsumoto", age: 57 },
// //   ],
// //   publisher: { name: "O'Reilly Media", location: "CA" },
// // };

// // const destructure = ({ title, authors:[author1 ,author2], publisher }) => {
// //   title, author1, author2, publisher.name;
// // }
// // console.log(title) // JavaScript: The Definitive Guide
// // console.log(author1) // David Flanagan
// // console.log(author2) // Yukihiro Matsumoto
// // console.log(publisherName) // O'Reilly Media

// // 9. Destructure the following code to get the desired outputs. Avoid using in-built methods.

// const book = {
//   title: "JavaScript: The Definitive Guide",
//   authors: [
//     { name: "David Flanagan", age: 49 },
//     { name: "Yukihiro Matsumoto", age: 57 },
//   ],
//   publisher: { name: "O'Reilly Media", location: "CA" },
// };

// const destructure = ({ title, authors:[{name:author1} ,{name:author2}],publisher: {name: publisherName} }) => {
//   return { title, author1, author2, publisherName };
// }

// const { title, author1, author2, publisherName } = destructure(book);
// console.log(title) // JavaScript: The Definitive Guide
// console.log(author1) // David Flanagan
// console.log(author2) // Yukihiro Matsumoto
// console.log(publisherName) // O'Reilly Media

// // // 10. Write an ES6 function that takes an array of objects and returns the sum of all ages.

// // const sumOfAges = (array[{ age }]) => {
// //   //i stuck here then i cnhat gpt this
// //   const sum = 0;
// //   for (let i = 0; i < array.length; i++){
// //     sum += array[{age }];
// //   }

// // };
// // var array = [
// // {
// // name: 'Jay',
// // age: 60,
// // },
// // {
// // name: 'Gloria',
// // age: 36,
// // },
// // {
// // name: 'Manny',
// // age: 16,
// // },
// // {
// // name: 'Joe',
// // age: 9,
// // },
// // ]
// // console.log(sumOfAges(array)) // 121

// // Well Done! You have completed all the practice sets for ES6.

// // 10. Write an ES6 function that takes an array of objects and returns the sum of all ages.

// const sumOfAges = (array) => {
//   //i stuck here then i cnhat gpt this
//   let sum = 0;
//   for (let i = 0; i < array.length; i++){
//     sum += array[i].age;
//   }
//   return sum;
// };
// var array = [
// {
// name: 'Jay',
// age: 60,
// },
// {
// name: 'Gloria',
// age: 36,
// },
// {
// name: 'Manny',
// age: 16,
// },
// {
// name: 'Joe',
// age: 9,
// },
// ]
// console.log(sumOfAges(array)) // 121

// // Well Done! You have completed all the practice sets for ES6.