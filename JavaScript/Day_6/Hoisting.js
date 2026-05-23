console.log(person); //hosting uplifting the variable give undefined mistake of js 

var person = "om";

say(1);//before declaration allow to call 
function say(call) {
  console.log(`Om Call ${call}`);
}
say(2);

// say1(3) // give error because arrow function not allow to be before declaration 
var say1 = (call) => {
  console.log(`Hello Call ${call}`);
}
say1(4)