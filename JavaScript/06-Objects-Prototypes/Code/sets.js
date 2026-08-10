const person = new Set();

person.add(434);
person.add(434);//provide uniqe value it will not stored 
person.add(32);
person.add(22);
console.log(person);
const itr = person.values();
console.log(itr);
console.log(itr.next().value);
console.log(itr.next().value);
console.log(itr.next().value);
console.log((person.has(22)));
person.forEach((data) => {
  console.log(data);
})
console.log((person.delete(22)));
console.log((person));
console.log((person.clear()));
console.log((person));