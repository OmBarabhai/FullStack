const person = {
  name: "Om",
  SayHi: function (greet) {
    console.log(`Hello ${greet}, How are you ${this.name} `);
  },
};

const person2 = {
  name: "Sahil",
};
person.SayHi("Good Morning");

// call, apply & bind (Using to changing the context)

// call: it will change this binding to any object
person.SayHi.call(person2, "Good Afternoon");
