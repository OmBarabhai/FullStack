/*
//Promise.resolve().then(() => {
//    console.log(1);
//}).then(()=>{
//    console.log(2);
//}).then(()=>{
//    console.log(3);
//})
//queueMicrotask(() => {
//    console.log("A");
//
//    queueMicrotask(() => {
//        console.log("B");
//    });
//});
//
//queueMicrotask(() => {
//    console.log("C");
//});

*/
/*
then(1)
Promise settles
next reaction becomes eligible
then(2)
then(3)
*//*

//setTimeout(() => {
//    console.log("A");
//}, 0);
//
//Promise.resolve().then(() => {
//    console.log("B");
//});
//
//console.log("C");

//
//console.log(1);
//
//queueMicrotask(() => {
//    console.log(2);
//});
//
//console.log(3);
//
//console.log("Start");
//
//Promise.resolve()
//    .then(() => {
//        console.log("One");
//    })
//    .then(() => {
//        console.log("Two");
//    });
//
//setTimeout(() => {
//    console.log("Timer");
//}, 0);
//
//console.log("End");
//
//console.log("Start");
//
//Promise.resolve()
//    .then(() => {
//        console.log("One");
//    })
//    .then(() => {
//        console.log("Two");
//    });
//
//setTimeout(() => {
//    console.log("Timer");
//}, 0);
//
//console.log("End");
//
//const id = setInterval(()=>{
//console.log("Tick");
//setTimeout(() => {
//    console.log("Timer");
//}, 2000);
//
//},2000);
//
//clearInterval(id);

//let count = 0;
//const id = setInterval(()=>{
//    console.log(count);
//    count++;
//    if(count === 5){
//        clearInterval(id);
//    }
//}, 1000);
*/
/* NOTE: setInterval  (CallBack, Delay);
         console.log("Start");   ---> 1) start --> print(Start)
         setInterval(() => {
            console.log("Tick");---> 4)  -> print(Tick)  -->  6) Delay -> print(Tick)........
         }, 2000);              ---> 2)  -> Interval reg -->  5) Delay -> Interval reg.......
         console.log("End");    ---> 3) End --> print(End)

  NOTE:  JS      --> Start --> Interval Reg --> Timeout Reg --> End -->
         Web Api --> Delay Interval        --> 1 Print(Interval) -->  2 Print(Interval) --> 3  Print(Interval) --> 4  Print(Interval) --> 5  Print(Interval)
                     TimeOut ready execute --> clear(Stop Print(Interval)) --> Print(Stopped)

  TODO: console.log("JS Start");
        let count = 1;
         const interval = setInterval(() => {
              console.log(count + ") Interval");
               count++;
      },1000);
      const timeOut = setTimeout(() => {
            clearInterval(interval);
            console.log("Web Api Stopped");
      },5500)
      console.log("JS End");

   APPROACH : brow --> req --> Ser --> Db --> Ser --> res --> brow
              Fetch() --> Promise<Res>
              Ex: const res = fetch("https://jsonplaceholder.typicode.com/users");
                  print(res);
              Note: Res is a promise;
              Flow: Fetch() --> Promise<Res> --> res --> res.json() --> promise<parsed data> --> data
                   Ex: fetch(url).then(res => { print(res.status) print(res.ok) })
                   Prop: status, ok, headers, url, body
                   Ex:
                       fetch() -> promise<res> res.json() -> promise<parsed data> -> data
                       const res = await fetch(url);
                       const data = await res.json();

   Question : ASYNC / AWAIT
              Note: AWAIT PAUSES THE PROGRESS OF THIS ASYNC FUNCTION;
                    IT DOES NOT FREEZE THE WHOLE JS runtime.
                    EX: async function getUsers(){
                             const res = await fetch( ---> await pauses async progress
                             "https://jsonplaceholder.typicode.com/users"
                             );
                             const data = await res.json();
                             console.log(data);
                        }





*//*

*/
/*
Question:-> Basic Fetch Shape
Note : Gives Response
EX: const res = await fetch(url);
Note : then
EX: const data = await res.json();
Note: Parsed JS Data
*//*

//Approach -> fetch() -> json() -> data

*/
/*
Question:-> Basic GET
            Fetch: https://jsonplaceholder.typicode.com/users
            Print the raw Response.
*//*

async function getUsers(){
    // todo : fetch users
    const res = await fetch("https://jsonplaceholder.typicode.com/users");
    const users = await res.json()
    const first = users.filter(user=> user.id === 10);
    // todo : print response
    console.log(first);
}
//getUsers();
async function getUsersName(){
    const res = await fetch("https://jsonplaceholder.typicode.com/users")
    const users = await res.json();
    const names = users.map((user) => user.name);
    console.log(names);
}
//getUsersName();

async function getUsersPhone(){
    const res = await fetch("https://jsonplaceholder.typicode.com/users");
    const users = await res.json();
    const phones = users.filter(num => (num.id & 1) == 1).map(num => num.phone);
    console.log(phones);

}
//getUsersPhone();

async function getUsersZipCode(){
    const res = await fetch("https://jsonplaceholder.typicode.com/users");
    const users = await res.json();
    const zip = users.filter((user) => (user.id & 1) === 1).map((user) => user.address.zipcode);
    console.log(zip);
}
//getUsersZipCode();

async function getUserWithIdFive(){
    const res = await fetch("https://jsonplaceholder.typicode.com/users");
    const users = await res.json();
    const fiveIdUser = users.find(user => user.id === 5);
    console.log(fiveIdUser);

}
//getUserWithIdFive();

async function getUserWithIdGreaterThanFive(){
    const res = await fetch("https://jsonplaceholder.typicode.com/users");
    const users = await res.json();
    const usersGreaterThanFive = users.filter(user => user.id > 5);
    console.log(usersGreaterThanFive);
}
//getUserWithIdGreaterThanFive();

async function getUsersErrHandle(){
    try{
         const res = await fetch("https://jsonplaceholder.typicode.com/users/name");
         if(!res.ok){
            throw new Error(`HTTP ${res.status}`);
         }
         const users = await res.json();
        console.log(users);

    }catch(err){
        console.log(err.message);
    }
}
//getUsersErrHandle();

async function createUser(){
    const userData = {
        name: "Om",
        email: "om@gmail.com"
    };
    const res = await fetch("https://jsonplaceholder.typicode.com/users",
                {
                    method:"POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify(userData)
                });
    console.log(res);
}
//createUser();
// Approach:-> GET -> JSON -> many  Users -> one value from each -> map
async function getUsersNamePrint(){
try{
    const res = await fetch("https://jsonplaceholder.typicode.com/users")
    const users = await res.json();

    const names = users.map((user) => user.name);
    if(!res.ok){
            throw new Error(`HTTP ${res.status}`);
     }
    console.log(names);
    }catch(err){
        console.log(err.message);
    }
}

//getUsersNamePrint();


//Note: Promise --> A Promise Represent a future result
//           Approach: -> Pending --> Rejected | OR | Pending --> Fulfilled
//Note: A promise settles only once


//   Question: Why Promises?
//   Approach:   Nested CB can become difficult to read :
*/
/*
ex: login(()=> {
          getProfile(()=> {
                getPost(() => {
                      getComments(() => {});
                });
          });
    });

Optimize:-> Promises provide a flatter
    flow:-> login()
                .then(getProfile)
                .then(getPosts)
                .then(getComments);
*//*




const promise = new Promise((res,rej) => {
    const success = false;
    if(success){
        res("Done");
    }else{
        rej(new Error("Failed"));
    }
});

console.log(promise);

//imp:-> Promise executor -> runs immediately -> The .then() reaction runs later through microtask Processing

promise
    .then(value =>{ //imp -> then()    --> Handles fulfillment
        console.log(value);
    })
    .catch(err =>{  //imp -> catch()   --> Handles rejection
        console.log(err.message);
    })
    .finally(()=>{  //imp -> finally() --> Runs after settlement regardless of outcome
        console.log("Finished");
    })

Promise.resolve(2)
    .then(num => num * 2)
    .then(num => num + 5)
    .then(console.log)
//flow --> 2 -> 4 -> 9  imp:--> A returned value becomes the next .then() input.

Promise.resolve(5)
        .then(num =>{
            return Promise.resolve(num * 2);
        })
        .then(console.log);

Promise.resolve()
         .then(()=> {
            throw new Error("Oops");
         })
         .catch(err => {
            console.log(err.message);
         })
// flow --> then -> throw -> rejected Promise -> catch

*/




/*
const promise = new Promise((res,rej)=>{
    const success = true;
    if(success){
        res("Success");
    }else{
        rej(new Error("Failed"))
    }
});

promise.then(value =>{
    console.log(value);
});

const promise = new Promise((res,rej) =>{
    const success = false;
    if(success){
        res("Success");
    }else{
        rej(new Error("Network Error"));
    }
})
promise.catch(value => {
    console.log(value);
})

*/

//const promise = new Promise((res,rej) => {
//       const success = false;
//       if(success){
//           res("Login successful");
//       }else{
//           rej(new Error("Login failed"));
//       }
//})
//
//promise.then(value =>{
//       console.log(value);
//}).catch(err => {
//       console.log(err);
//})
//
//

//
//const promise = new Promise((res,rej)=>{
//     setTimeout(()=>{
//        res("Resolved");
//     },2000);
//});
//
//promise.then(value =>{
//    console.log(value);
//})
//
//
//
//

//
//const promise = new Promise((resolve, reject) => {
//    console.log("Executor");
//    resolve("Done");
//});
//
//promise.then(value => {
//    console.log(value);
//});
//
//Promise.resolve(5)
//            .then((value)=>{
//                return Promise.resolve(5);
//            })
//            .then((value)=>{
//                return value * 2;
//            })
//            .then((value)=>{
//                console.log(value);
//            })
//





Promise.resolve(5)
    .then(value => {
        return Promise.resolve(value * 2);
    })
    .then(value => {
        console.log(value);
    });