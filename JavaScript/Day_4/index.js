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
  for (let i = 0; i < arguments.length; i++){
    sum += arguments[i];
  }
  return sum;
}
addNum(3, 4);
const res = addNum(3, 4, 8);
console.log(res);

