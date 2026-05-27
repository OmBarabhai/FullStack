const choclateAvil = false;
const gifting = new Promise(function (res, rej) {
  if (choclateAvil) {
    res(`I can Give choclate`);
  } else {
    rej(`I cannot give choclate`);
  }
});

// gifting.then(
//  data => console.log(data)
// ).catch(
// reject =>console.log(reject)
// )

async function result() {
  try {
    const result = await gifting;
    console.log(result);
  } catch (e) {
    console.log(e);
  }
 } 
result();