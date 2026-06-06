const simranPromise = new Promise((resolve,reject) => {
  const dadAgree = false;
  setTimeout(() => {
    if (dadAgree) {
      resolve("Shhadi");
    } else {
      reject("Dad Not Agree Shhadi not possible")
    }
  },3000)
})
simranPromise.then((msg) => {
  console.log("Message from Simran " + msg);
  console.log("Yay Happy");
}).catch((msg) => {
  console.log("Dad Ko Manao");
  console.log("Ab Shadi nhi ho skti kuch krna padenga "+msg);
})