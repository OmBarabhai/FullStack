const arr1 = [1, 2, 3];
const arr2 = [4, 5, 6];

const combinedArr1 = [];
for (let i in arr1) {
  combinedArr1.push(i);
}
for (let j of arr2) {
  combinedArr1.push(j);
}
console.log(combinedArr1);

//spread the array using ...
const combinedArr2 = [...arr1, ...arr2];
console.log(combinedArr2);

const Obj1 = {
  name: "Om",
  age : 22
}
const Obj2 = {
  name: "Om",
  age : 22
}

const combinedObj = { ...Obj1, ...Obj2 };
console.log(combinedObj);

const combinedArr3 = [];
for (let i of arr1) {
  combinedArr3.push(i);
}
for (let j of arr2) {
  combinedArr3.push(j);
}
console.log(combinedArr3);