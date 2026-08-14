const num = [1,20,300,2000];
// total = 232
const sum = num.reduce((total,num) => total + num, 0);
console.log(sum);

// const res = num.reduce((acc,num) => acc + num, 0);
const mul = num.reduce((acc,num) => acc * num, 1)
console.log(mul);
const numbers = [5, 10, 15, 20, 25];
const count = numbers.reduce(acc => {
                return acc + 1
              }, 0);
console.log(count);

const students= [
{name:"Om",marks:90},
{name:"Nakul",marks:73},
{name:"Pavan",marks:88},
];

const totalMarks = students.reduce(
(total,{marks}) => total + marks,0
)
console.log(totalMarks);


const employees = [
{name:"Om",salary:800000},
{name:"Nakul",salary:90000},
{name:"Pavan",salary:90932},
]
const totalSalary = employees.reduce((acc,{salary}) => acc + salary,0);
console.log(totalSalary);

const employeesIsActive = [
{name:"Om",salary:800000,active: true},
{name:"Nakul",salary:90000,active:false},
{name:"Pavan",salary:90932,active:true},
]
const calActiveEmpSal = employeesIsActive.reduce((acc,{salary,active}) => (active) ? salary + acc : 0,0);
const countActiveEmp = employeesIsActive.reduce((acc,{active}) => (active) ? acc + 1: acc,0);
console.log(countActiveEmp);
console.log(calActiveEmpSal);

const names = [
    "Om",
    "Nakul",
    "Om",
    "Pavan",
    "Nakul",
    "Om"
];
const freq = names.reduce((count,name) => (count[name] = count[name] ? count[name] + 1 : 1,count),{});
console.log(freq);
/*
count = {}
name = "Om"
*/