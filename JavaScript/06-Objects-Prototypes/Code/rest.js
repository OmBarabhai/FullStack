function addNumber() {
  let sum = 0;
  for (let i = 0; i < arguments.length; i++) {
    sum += arguments[i];
  }
  return sum;
}
console.log(addNumber(4, 5));
console.log(addNumber(3, 4, 3));

function addTwoNumRest(...nums) {
  return nums.reduce((acc, data) => acc + data);
}
console.log("addTwoNumRest: " + addTwoNumRest(7, 5));
console.log("addTwoNumRest: " + addTwoNumRest(9, 4, 3));
