
/*
Problem 1. Use this URL - https://example.com/post/comments to make a fake fetch call and list out all the
emails of users on the DOM in ordered list. A fakeFetch has been provided. Use HTML, CSS &
JS template in REPL or Vanilla template in CodeSandbox for this question

const fakeFetch = (url) => {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      if (url === "https://example.com/post/comments") {
        resolve({
          status: 200,
          message: "Success",
          data: [
            { email: "xyz@gmail.com", commentBody: "Well done keep it up" },
            {
              email: "hello@outlook.com",
              commentBody: "Good going a lot to learn from you awesome"
            },
            {
              email: "ram99@gmail.com",
              commentBody: "Anyone from Vadodara here"
            }
          ]
        });
      } else {
        reject({
          status: 404,
          message: "No Commentes found."
        });
      }
    }, 2000);
  });
};

fakeFetch("https://example.com/post/comments")
  .then((res) => res.data.map(({ email }) => {
    const list = document.querySelector("#email-list");
    const li = document.createElement("li");
    li.textContent = email;
    list.appendChild(li);
  }))
  .catch((err) => console.log(err.message))
// Output on the DOM should be:
// 1. xyz@gmail.com
// 2. hello@outlook.com
// 3. ram99@gmail.com

Problem 2. Use this URL - https://example.com/winner-team to make a fake fetch call to the get names of
winner group members and show a nice message on the DOM congratulating all of them. Use
HTML, CSS & JS template in REPL or Vanilla template in CodeSandbox for this question.

const fakeFetch = (url) => {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      if (url === "https://example.com/winner-team") {
        resolve({
          status: 200,
          data: {
            message: "Success",
            data: ["Jhon", "Raju", "Anjali", "Sakshi"]
          }
        });
      } else {
        reject({
          status: 404,
          message: "No Users found."
        });
      }
    }, 2000);
  });
};

fakeFetch("https://example.com/winner-team").then((res) => {
  const name = document.querySelector("#name");
  const msg = document.createElement("p");
  msg.textContent = `Congratulation to the members of winning team ${res.data.data.join(", ")}, great work`;
  name.appendChild(msg);
}).catch((err) => console.log(err.message))
// Output on the DOM should be:
// Congratulation to the members of winning team Jhon, Raju, Anjali, Sakshi, great work 


Problem 3. Use this URL - https://example.com/login to make a fake fetch call and show the status like it is
authenticated or not with a message in the DOM. Use HTML, CSS & JS template in REPL or
Vanilla template in CodeSandbox for this question.

const fakeFetch = (url) => {
  return new Promise((resolve, reject) => {
    setTimeout(() => {
      if (url === "https://example.com/login") {
        resolve({
          status: 200,
          data: {
            auth: true
          }
        });
      } else {
        reject({
          status: 404,
          message: "Status not found"
        });
      }
    }, 2000);
  });
};
fakeFetch("https://example.com/login").then((res) => {
  const msg = document.querySelector("#msg");
  if (res.data.auth) {
    msg.textContent = "Verified";
  }
}).catch((err) => console.log(err.message)
)
// your code here
// Output on the DOM should be:
// Verified
10. Use this URL - https://example.com/getImage to make a fake fetch call which takes a url and
dimensions for the photo to be displayed. Dimensions should be passed in the
format [width, height]. Show the image provided in the response on DOM. Use HTML, CSS &
JS template in REPL or Vanilla template in CodeSandbox for this question.
Dimensions can be 200/300/100. For example you can pass [200, 200] or [200, 300], etc.
*/