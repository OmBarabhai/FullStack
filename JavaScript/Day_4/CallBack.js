const printName = name => console.log(name);
['om', 'rajput'].map(printName);

printName('om');

const printOneAndCallFunc = callback => {
  console.log(1);
  callback();
}