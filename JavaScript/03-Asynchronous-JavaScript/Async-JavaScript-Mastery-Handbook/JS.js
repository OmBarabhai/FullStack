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

console.log("Start");

Promise.resolve()
    .then(() => {
        console.log("One");
    })
    .then(() => {
        console.log("Two");
    });

setTimeout(() => {
    console.log("Timer");
}, 0);

console.log("End");