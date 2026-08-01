# Chapter 18 — Dry Runs (Master JavaScript Asynchronous Execution)

> **Goal:** If you can solve every dry run in this chapter, you will be able to answer almost every JavaScript asynchronous interview question confidently.

---

# Table of Contents

1. Why Dry Runs Matter
2. Dry Run Rules
3. Call Stack Dry Runs
4. setTimeout Dry Runs
5. Promise Dry Runs
6. async/await Dry Runs
7. Microtask Queue Dry Runs
8. Callback Queue Dry Runs
9. Event Loop Dry Runs
10. Browser API Dry Runs
11. fetch() Dry Runs
12. Complex Interview Dry Runs
13. Predict the Output (40 Questions)
14. Visual Stack Diagrams
15. Common Mistakes
16. Summary

---

# 1. Why Dry Runs Matter

Interviewers LOVE asking

> Predict the Output.

Example

```javascript
console.log("A");

setTimeout(() => {
    console.log("B");
}, 0);

console.log("C");
```

If you know Call Stack + Event Loop,

you'll answer immediately.

---

# 2. Dry Run Rules

Always follow this order.

```
1. Execute synchronous code.

↓

2. Register async work.

↓

3. Continue synchronous code.

↓

4. Empty Call Stack.

↓

5. Event Loop checks queues.

↓

6. Execute Microtasks.

↓

7. Execute Callback Queue.
```

Remember

```
SYNC

↓

MICROTASK

↓

CALLBACK
```

Always.

---

# 3. Dry Run 1 — Pure Synchronous

```javascript
console.log("A");

console.log("B");

console.log("C");
```

Execution

```
Stack

↓

A

↓

B

↓

C
```

Output

```
A

B

C
```

---

# 4. Dry Run 2 — Single Timer

```javascript
console.log("Start");

setTimeout(() => {
    console.log("Timer");
},1000);

console.log("End");
```

Step 1

```
Start
```

Stack Empty

↓

Timer registered

↓

Continue

```
End
```

1 second later

↓

Callback Queue

↓

Call Stack

↓

Timer

Output

```
Start

End

Timer
```

---

# 5. Dry Run 3 — Timer Zero

```javascript
console.log("A");

setTimeout(() => {
    console.log("B");
},0);

console.log("C");
```

Timeline

```
A

↓

Register Timer

↓

C

↓

Event Loop

↓

B
```

Output

```
A

C

B
```

---

# 6. Dry Run 4 — Promise

```javascript
console.log("Start");

Promise.resolve().then(() => {
    console.log("Promise");
});

console.log("End");
```

Execution

```
Start

↓

Promise registered

↓

End

↓

Microtask Queue

↓

Promise
```

Output

```
Start

End

Promise
```

---

# 7. Dry Run 5 — Promise vs Timer

```javascript
console.log("A");

setTimeout(() => {
    console.log("Timer");
},0);

Promise.resolve().then(() => {
    console.log("Promise");
});

console.log("B");
```

Execution

```
A

↓

Register Timer

↓

Register Promise

↓

B

↓

Microtask

↓

Timer
```

Output

```
A

B

Promise

Timer
```

---

# 8. Dry Run 6 — Multiple Promises

```javascript
console.log("Start");

Promise.resolve().then(() => {
    console.log("P1");
});

Promise.resolve().then(() => {
    console.log("P2");
});

console.log("End");
```

Execution

```
Start

↓

End

↓

P1

↓

P2
```

Output

```
Start

End

P1

P2
```

---

# 9. Dry Run 7 — Nested Timer

```javascript
console.log("Start");

setTimeout(() => {

console.log("A");

setTimeout(()=>{

console.log("B");

},0);

},0);

console.log("End");
```

Execution

```
Start

↓

End

↓

A

↓

B
```

Output

```
Start

End

A

B
```

---

# 10. Dry Run 8 — Promise inside Timer

```javascript
console.log("Start");

setTimeout(() => {

console.log("Timer");

Promise.resolve().then(() => {

console.log("Promise");

});

},0);

console.log("End");
```

Execution

```
Start

↓

End

↓

Timer

↓

Promise
```

Output

```
Start

End

Timer

Promise
```

---

# 11. Dry Run 9 — async/await

```javascript
async function test(){

console.log("A");

await Promise.resolve();

console.log("B");

}

test();

console.log("C");
```

Execution

```
A

↓

await

↓

C

↓

B
```

Output

```
A

C

B
```

---

# 12. Dry Run 10 — fetch()

```javascript
console.log("Start");

fetch("/users")
.then(() => {

console.log("Users");

});

console.log("End");
```

Execution

```
Start

↓

Browser

↓

End

↓

Response

↓

Microtask

↓

Users
```

Output

```
Start

End

Users
```

---

# 13. Visual Stack Diagram

Example

```javascript
console.log("A");

setTimeout(()=>{

console.log("B");

},0);

console.log("C");
```

Initial

```
Stack

main()
```

↓

```
console.log(A)
```

↓

```
setTimeout()
```

↓

Browser

↓

```
console.log(C)
```

↓

Stack Empty

↓

Callback Queue

↓

Event Loop

↓

```
console.log(B)
```

---

# 14. Predict the Output (40 Questions)

## Q1

```javascript
console.log(1);

console.log(2);
```

Answer

```
1

2
```

---

## Q2

```javascript
console.log(1);

setTimeout(()=>console.log(2),0);

console.log(3);
```

Answer

```
1

3

2
```

---

## Q3

```javascript
console.log("A");

Promise.resolve().then(()=>console.log("B"));

console.log("C");
```

Answer

```
A

C

B
```

---

## Q4

```javascript
console.log("A");

Promise.resolve().then(()=>console.log("B"));

setTimeout(()=>console.log("C"),0);

console.log("D");
```

Answer

```
A

D

B

C
```

---

## Q5

```javascript
setTimeout(()=>console.log(1),0);

Promise.resolve().then(()=>console.log(2));

console.log(3);
```

Answer

```
3

2

1
```

---

## Q6

```javascript
console.log("Hello");

setTimeout(()=>{

console.log("World");

},1000);
```

Answer

```
Hello

World
```

(after 1 second)

---

## Q7

```javascript
Promise.resolve().then(()=>{

console.log(1);

});

Promise.resolve().then(()=>{

console.log(2);

});
```

Answer

```
1

2
```

---

## Q8

```javascript
async function demo(){

console.log(1);

await Promise.resolve();

console.log(2);

}

demo();

console.log(3);
```

Answer

```
1

3

2
```

---

## Q9

```javascript
console.log("X");

fetch("/api")
.then(()=>console.log("Y"));

console.log("Z");
```

Answer

```
X

Z

Y
```

---

## Q10

```javascript
setTimeout(()=>{

console.log("A");

Promise.resolve().then(()=>{

console.log("B");

});

},0);
```

Answer

```
A

B
```

---

> Continue practicing by changing the order yourself and predicting the output before running the code. This is exactly what interviewers expect.

---

# 15. Common Mistakes

❌ Thinking `setTimeout(fn, 0)` runs immediately.

It runs **after the current Call Stack is empty**.

---

❌ Thinking Promises wait for timers.

They don't.

Promises (Microtasks) always execute **before** Callback Queue tasks.

---

❌ Thinking `await` blocks JavaScript.

It pauses only the current async function.

---

❌ Thinking `fetch()` returns data immediately.

It returns a Promise immediately and the data arrives later.

---

# 16. Summary

Remember this golden rule:

```
Synchronous Code

↓

Microtask Queue
(Promise, await)

↓

Callback Queue
(setTimeout, setInterval)
```

If you can mentally simulate this order, you can solve almost every JavaScript asynchronous dry run asked in interviews.

---

# Next Chapter

➡️ **19-Interview-Questions.md**

Topics include:

- 50+ JavaScript asynchronous interview questions
- Beginner → Advanced → FAANG level
- Detailed answers
- Common follow-up questions
- Whiteboard explanations
- Real interview scenarios
```