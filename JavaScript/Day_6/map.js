const person = new Map();
person.set('name', "Om");
person.set('Age', 22);
console.log(person);
console.log(person.get("name"));
console.log(person.get("Age"));

console.log(person.keys());
console.log(person.values());
console.log(person.entries());

person.forEach((value ,key)=> {
  console.log(`key: ${key} = Value: ${value}`);
});

person.delete('name');
console.log(person);

person.clear();
console.log(person);
