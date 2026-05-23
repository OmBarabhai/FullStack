const person = {
  name: "Om",
  age : 22,
  city: "pune"
}
for (let key in person) {
  console.log(person[key]);
}
console.log(Object.keys(person));
console.log(Object.values(person));
console.log(Object.entries(person));
console.log(person?.name);
