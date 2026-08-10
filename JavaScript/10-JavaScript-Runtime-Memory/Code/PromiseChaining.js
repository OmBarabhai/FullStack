const simranPromise = new Promise((resolve, reject) => {
  const salary = 150000;
  let dadAgree = true;
  if (salary < 90000) dadAgree = false;
  else dadAgree = true;
  setTimeout(() => {
    if (dadAgree) {
      resolve("Shhadi");
    } else {
      reject("Dad Not Agree Shhadi not possible");
    }
  }, 3000);
});
simranPromise
  .then((msg) => {
    console.log("Message from Simran " + msg);
    console.log("Yay Happy");
    return "Let Me Tell My Parent";
  })
  .then((nextPromise) => {
    console.log(nextPromise);
  })
  .catch((msg) => {
    console.log("Dad Ko Manao");
    console.log("Ab Shadi nhi ho skti kuch krna padenga " + msg);
  });
