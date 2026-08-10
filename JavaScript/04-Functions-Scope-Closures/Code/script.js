let sum = 0;

console.log(sumndSub(3, 4, 2)); //possible

function sumndSub(a, b, c) {
  sum = a + b;
  return sum - c;
}

// mul(2,3,4);// not possible
let mul = function (a, b, c) {
  console.log(a * b * c);
};
mul(2, 3, 4);

let isEven = function (value) {
  // return value % 2 == 0;
};
console.log(isEven(46));

// isEven = (value) => value % 2 == 0;
// console.log(isEven(49));
// 
let num = (n) => {
  for (let i = 1; i <= n; i++) {
    console.log(i);
  }
};
num(30);

isEven = (n) => {
  for (let i = 1; i <= n; i++) {

    return n % 2 == 0;
  }
};
console.log(isEven(47));
