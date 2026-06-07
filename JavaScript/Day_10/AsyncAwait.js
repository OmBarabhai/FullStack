// "use strict";

// x = 5;
// console.log(x);
"use strict";

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

async function handleSimranPromise() {
  try {
    const msg = await simranPromise;
    console.log(msg);
    console.log("Lets Talk TO my parent");
  } catch (err) {
    console.log(err);
  }
}
handleSimranPromise();
"use strict"; //this should be on top then it works otherwise it treats as a string

y = 5;
console.log(y);
