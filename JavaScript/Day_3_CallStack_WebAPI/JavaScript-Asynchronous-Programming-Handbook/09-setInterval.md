# Chapter 9 — setInterval()

> **"setInterval() repeatedly executes a callback after every specified interval until you stop it."**

Unlike `setTimeout()`, which runs **once**, `setInterval()` keeps running continuously.

---

# Table of Contents

1. What is setInterval()?
2. Syntax
3. How setInterval() Works
4. Internal Execution Flow
5. Browser Timer
6. Event Loop Interaction
7. setInterval() vs setTimeout()
8. clearInterval()
9. Common Mistakes
10. Nested Intervals
11. Recursive setTimeout()
12. Performance Issues
13. Real-Life Examples
14. Dry Runs
15. Interview Questions
16. Coding Exercises
17. Summary

---

# 1. What is setInterval()?

`setInterval()` is a Browser (or Node.js) API that executes a callback **again and again** after a fixed delay.

Unlike `setTimeout()`

```
setTimeout()

↓

Runs Once
```

`setInterval()`

```
Runs

↓

Runs Again

↓

Runs Again

↓

Runs Again

↓

Until Stopped
```

---

# 2. Syntax

```javascript
setInterval(callback, delay);
```

Example

```javascript
setInterval(() => {
    console.log("Hello");
}, 1000);
```

Output

```
Hello

(after 1 sec)

Hello

(after 1 sec)

Hello

(after 1 sec)

...
```

---

# 3. How setInterval() Works

Example

```javascript
console.log("Start");

setInterval(() => {
    console.log("Tick");
}, 2000);

console.log("End");
```

Execution

Step 1

```
Start
```

Step 2

Browser starts an interval timer.

Step 3

```
End
```

Step 4

Every 2 seconds

Browser places callback into the Task Queue.

Step 5

Event Loop

↓

Call Stack

↓

Execute callback

Repeat forever.

Output

```
Start

End

Tick

Tick

Tick

Tick

...
```

---

# 4. Internal Execution Flow

```
JavaScript

↓

setInterval()

↓

Browser Timer

↓

Every Delay

↓

Task Queue

↓

Event Loop

↓

Call Stack

↓

Execute Callback

↓

Repeat
```

---

# 5. Browser Timer

Unlike `setTimeout()`

```
Timer

↓

Ends

↓

Destroyed
```

`setInterval()`

```
Timer

↓

Callback

↓

Restart Timer

↓

Callback

↓

Restart Timer

↓

Callback

...
```

The browser automatically restarts the timer after each interval.

---

# 6. Event Loop Interaction

Example

```javascript
setInterval(() => {
    console.log("A");
},1000);
```

Timeline

```
1 sec

↓

Task Queue

↓

Call Stack

↓

A

---------------

1 sec

↓

Task Queue

↓

Call Stack

↓

A

---------------

1 sec

↓

Task Queue

↓

Call Stack

↓

A
```

---

# 7. setInterval() vs setTimeout()

| setTimeout() | setInterval() |
|--------------|---------------|
| Executes once | Executes repeatedly |
| Stops automatically | Runs forever until stopped |
| Uses one timer | Uses repeating timer |
| clearTimeout() | clearInterval() |

Example

### setTimeout()

```javascript
setTimeout(() => {
    console.log("Hi");
},1000);
```

Output

```
Hi
```

Only once.

---

### setInterval()

```javascript
setInterval(() => {
    console.log("Hi");
},1000);
```

Output

```
Hi

Hi

Hi

Hi

...
```

---

# 8. clearInterval()

Every interval returns an ID.

```javascript
const id = setInterval(() => {
    console.log("Running...");
},1000);
```

Stop it

```javascript
clearInterval(id);
```

Now it never executes again.

---

# Example

```javascript
let count = 0;

const id = setInterval(() => {

    console.log(count);

    count++;

    if(count === 5){

        clearInterval(id);

    }

},1000);
```

Output

```
0

1

2

3

4
```

Stops automatically.

---

# 9. Common Mistakes

### Mistake 1

Thinking

```
setInterval

↓

Waits

↓

Runs Once
```

Wrong.

It keeps repeating.

---

### Mistake 2

Forgetting

```javascript
clearInterval()
```

Result

```
Infinite execution
```

Memory leak.

---

### Mistake 3

Heavy callback

```javascript
setInterval(() => {

    // Heavy work

},100);
```

If callback takes longer than 100ms

Intervals start piling up.

Performance becomes poor.

---

# 10. Nested Intervals

```javascript
setInterval(() => {

    console.log("Outer");

    setInterval(() => {

        console.log("Inner");

    },1000);

},3000);
```

This creates **multiple inner intervals**.

Avoid doing this.

---

# 11. Recursive setTimeout()

Instead of

```javascript
setInterval(task,1000);
```

Many developers prefer

```javascript
function repeat(){

    console.log("Running");

    setTimeout(repeat,1000);

}

repeat();
```

Why?

Because the next timer starts **after the previous task finishes**.

No overlapping execution.

---

# Comparison

### setInterval()

```
Timer

↓

Task

↓

Timer

↓

Task

↓

Timer
```

Can overlap if the task is slow.

---

### Recursive setTimeout()

```
Task

↓

Timer

↓

Task

↓

Timer

↓

Task
```

Safer.

---

# 12. Performance Issues

Example

```javascript
setInterval(() => {

    while(true){

    }

},1000);
```

The callback never finishes.

Result

```
UI freezes

Browser hangs

Timers delayed
```

Keep interval callbacks lightweight.

---

# 13. Real-Life Examples

### Clock

```javascript
setInterval(() => {

    console.log(new Date());

},1000);
```

---

### Stopwatch

Update every second.

---

### Countdown Timer

Decrease remaining seconds every second.

---

### Live Stock Prices

Poll server every 10 seconds.

---

### Weather Updates

Refresh every 30 minutes.

---

# 14. Dry Runs

## Example 1

```javascript
let count = 1;

const id = setInterval(() => {

    console.log(count);

    count++;

    if(count>3){

        clearInterval(id);

    }

},1000);
```

Output

```
1

2

3
```

---

## Example 2

```javascript
console.log("Start");

setInterval(() => {

    console.log("Tick");

},1000);

console.log("End");
```

Output

```
Start

End

Tick

Tick

Tick
```

---

# 15. Interview Questions

### What is setInterval()?

A Browser (or Node.js) API that repeatedly schedules a callback after a fixed interval.

---

### Does setInterval() stop automatically?

No.

Use

```javascript
clearInterval()
```

---

### Difference between setTimeout() and setInterval()?

`setTimeout()` executes once.

`setInterval()` executes repeatedly.

---

### Why use recursive setTimeout() instead of setInterval()?

To avoid overlapping executions and gain better control over scheduling.

---

### Can setInterval() cause memory leaks?

Yes.

If not cleared, it keeps running and consuming resources.

---

### What does clearInterval() do?

Stops future executions of the interval.

---

# 16. Coding Exercises

## Exercise 1

Print

```
Hello
```

every second.

---

## Exercise 2

Print numbers

```
1

2

3

4

5
```

then stop.

---

## Exercise 3

Create a digital clock updating every second.

---

## Exercise 4

Replace

```javascript
setInterval()
```

with recursive

```javascript
setTimeout()
```

---

# 17. Summary

- `setInterval()` repeatedly executes callbacks.
- The browser manages the interval timer.
- Each execution goes through the Task Queue and Event Loop.
- `clearInterval()` stops the interval.
- Long-running callbacks can delay future executions.
- Recursive `setTimeout()` is often a safer alternative when execution time is unpredictable.

---

# Visual Memory Trick

```
setInterval()

      │
      ▼

 Browser Timer

      │

 Every Delay

      ▼

 Task Queue

      ▼

 Event Loop

      ▼

 Call Stack

      ▼

 Execute Callback

      │
      └───────────────┐
                      │
                      ▼
              Repeat Forever
```

---

# Next Chapter

➡️ **10-fetch.md**

You'll learn:

- What is the Fetch API?
- How browsers make HTTP requests
- Request → Response lifecycle
- JSON parsing
- Why `fetch()` returns a Promise
- GET vs POST requests
- Error handling
- Interview questions and real-world examples