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

/*
then(1)
Promise settles
next reaction becomes eligible
then(2)
then(3)
*/
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




*/
