//const {add,sub} = require('./math.js');
//console.log(add(5,4))
//console.log(sub(5,4))

const fs = require('fs');

fs.writeFileSync('Students.txt','Om , sahil');
console.log(fs.readFileSync('Students.txt','utf-8'));
fs.appendFileSync('Students.txt','Om','sahil')
