const student = { name: "sahil" };

try {
  if (student.name == "sahil") {
    throw new Error("This is not student");
  }
  // console.log(`${student.name}`);//sahil
  console.log(`${name.name}`);//error
} catch (e) {
  console.log("error" + e + " message " + e.massage);
} finally {
  console.log("This block is completed ");
}
