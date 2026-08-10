// document is provided by browser not by JavaScript

console.log(document);

// getElementById -> select single element using id

const heading_id = document.getElementById("Heading-id");
const heading_id_1 = document.getElementById("Heading-id-1");


console.log("getElementById: id is singular");
console.log(heading_id);

// getElementsByClassName -> select multiple elements using class

const para_class = document.getElementsByClassName("para-class");

console.log("getElementsByClassName: class is plural");
console.log(para_class);

// querySelector -> works like CSS selector
// gives first matching element

const om = document.querySelector('[name="OM-info"]');

console.log("querySelector: first matching element");
console.log(om);

// querySelectorAll -> gives all matching elements

const omAllInfo = document.querySelectorAll('[name="OM-info"]');

console.log("querySelectorAll: all matching elements");
console.log(omAllInfo);

const innerText = document.querySelector('[name="OM-info"]');
console.log(heading_id.innerText);
console.log(heading_id_1.textContent);


