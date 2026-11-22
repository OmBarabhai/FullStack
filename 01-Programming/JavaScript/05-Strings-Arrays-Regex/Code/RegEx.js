let str = "Om@gmailc3432om";
let pattern = /^[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[a-zA-Z0-9]+$/;
let res = pattern.test(str);
console.log(res);//false

let str1 = "Om@gmailc.3432om";
let pattern1 = /^[a-zA-Z0-9]+@[a-zA-Z0-9]+\.[a-zA-Z0-9]+$/;
let res1 = pattern1.test(str1);
console.log(res1);//true

