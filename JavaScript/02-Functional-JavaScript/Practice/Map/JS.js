const nums = [1,2,3,4];
const double =  nums.map(num => num * 2);
console.log(double);

const nums1 = [5,,15];
const addFive = nums1.map(num => num + 5);
console.log(addFive)

const conStr= nums.map(num=>String(num));
console.log(conStr);

const sq = nums.map(num => num * num);
console.log(sq);


const users = [
    { name: "Om", age: 22 },
    { name: "Raj", age: 25 },
    { name: "Amit", age: 21 }
];

const res = users.map((name) => users.name);
console.log(res);