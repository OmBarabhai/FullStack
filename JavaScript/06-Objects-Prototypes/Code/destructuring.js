const num = [1, 2, 3, 4, 5];
 let [a, b, c, e, f, g] = num; // 1 2 3 4 5 undefined
console.log(a, b, c, e, f, g);

[a, b, c, e, f, g = 7] = num; // destructuring 1 2 3 4 5 7
console.log(a, b, c, e, f, g);

