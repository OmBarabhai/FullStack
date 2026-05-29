// fetch("https://icanhazdadjoke.com/ ", {
//   headers: {
//     Accept: "application/json",
//   },
// }).then((res) => {
//   res.json().then((data) => {
//       console.log(data.joke);

//     })
// }).catch((e) => {
//   console.log(e);
// })

async function getJoke() {
  try {
    const response = await fetch("https://icanhazdadjoke.com/ ", {
      headers: {
        Accept: "application/json",
      },
    });
    const data = await response.json();
    console.log(data.joke);
  } catch (e) {
    console.log(e);
  }
}
getJoke();
