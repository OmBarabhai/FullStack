# 🚀 Day 02 - Process

> Permanent OS Notes for Interviews, Revision, and Career Use

---

# 📌 Why do we need Process?

Programs stored on disk cannot execute directly.

They must be loaded into memory and managed by the OS.

That running form is called a **Process**.

Without process abstraction:

* OS cannot schedule work
* CPU cannot execute tasks
* Memory allocation becomes impossible
* Resource tracking becomes impossible

---

# 🏢 Real World Analogy

Think of a restaurant.

```text
Recipe Book = Program
Chef Cooking = Process
Kitchen = CPU
Ingredients = Memory
```

Recipe exists.

But only when chef starts cooking, work starts.

Same:

Program exists.

Process runs.

---

# 📌 Core Concept

A **Process** is a program in execution.

It contains:

* code
* data
* memory
* registers
* execution state
* resources

### Formula

```text
Program + Execution = Process
```

---

# 🔄 Worked Example

You open Chrome.

What happens?

```text
chrome.exe
    ↓
Loaded into RAM
    ↓
OS creates PCB
    ↓
CPU schedules process
    ↓
Chrome starts running
```

Now Chrome becomes a process.

If you open:

* Chrome
* VS Code
* Spotify

then OS manages multiple processes.

---

# ⚙ Internal Working (Step by Step)

When a process starts:

```text
Program (Disk)
      ↓
OS loads program into RAM
      ↓
Creates Process Control Block (PCB)
      ↓
Allocates resources
      ↓
Scheduler assigns CPU
      ↓
Execution starts
```

OS tracks everything through PCB.

---

# 📌 Process States

A process changes states while running.

## Flow Diagram

```text
        New
         ↓
       Ready
         ↓
      Running
      ↙     ↘
 Waiting    Ready
    ↓
Running
   ↓
Terminated
```

---

## New

Process is created.

Example:
Opening Chrome.

---

## Ready

Waiting for CPU.

Example:
Chrome loaded but waiting.

---

## Running

CPU executing.

Example:
Watching YouTube.

---

## Waiting / Blocked

Waiting for I/O.

Example:
Chrome waiting for network response.

---

## Terminated

Process finished.

Example:
Closed Chrome.

---

# 📌 Process Control Block (PCB)

PCB stores all process information.

Think of PCB as:

```text
Identity Card of Process
```

Contains:

```text
PCB
│
├── PID
├── State
├── Program Counter
├── CPU Registers
├── Scheduling Info
├── Memory Info
├── I/O Info
```

---

## Why PCB?

Without PCB:

* OS loses track of process
* Scheduling impossible
* Context switching impossible

---

# 📌 Program vs Process

| Program        | Process       |
| -------------- | ------------- |
| Passive        | Active        |
| Stored on Disk | Loaded in RAM |
| Static         | Dynamic       |
| No execution   | Running       |

---

Example:

```text
node server.js = Program
Running API Server = Process
```

Backend interviews ask this often.

---

# 📌 Process Memory Layout

Each process contains:

```text
Code
 ↓
Data
 ↓
Heap
 ↓
Stack
```

---

## Code Section

Stores instructions.

---

## Data Section

Stores global/static variables.

---

## Heap

Dynamic memory.

Examples:

* malloc()
* new

---

## Stack

Stores:

* function calls
* local variables
* return addresses

---

# 📌 CPU Bound vs I/O Bound

## CPU Bound

Uses CPU most.

Examples:

* Video rendering
* AI model training

---

## I/O Bound

Waits for input/output.

Examples:

* Database query
* File reading
* API call

---

# 📌 Message Passing

Processes communicate without shared memory.

```text
Process A
   ↓
OS
   ↓
Process B
```

Used in:

* distributed systems
* microservices
* containers

Important in system design.

---

# 📌 Zombie Process

Process finished.

But parent didn’t collect result.

So process stays in table.

```text
Finished
   ↓
Not cleaned
   ↓
Zombie
```

---

# 🐧 Linux Connection

Check processes:

```bash
ps
top
htop
```

Kill process:

```bash
kill PID
```

Background process:

```bash
jobs
```

Find process:

```bash
ps aux | grep chrome
```

Very important for DevOps.

---

# ☁ AWS / Cloud Connection

Inside EC2:

```text
Node Server = Process
Nginx = Process
MySQL = Process
Docker = Process
```

CloudWatch monitors these processes.

If process crashes:

* app goes down
* server unhealthy
* auto scaling may trigger

---

# 🌐 Backend Connection

Backend servers create processes.

Examples:

```text
Node.js API server
Java Spring server
Python Flask server
PostgreSQL server
Redis server
```

Understanding process helps in:

* concurrency
* worker queues
* scaling
* load balancing

---

# 🎯 Interview Questions

### What is a Process?

A process is a program in execution.

---

### Process vs Program?

Program is passive.

Process is active.

---

### What is PCB?

Data structure storing process info.

---

### Why PCB?

To manage process and context switching.

---

### Process States?

New, Ready, Running, Waiting, Terminated.

---

### Zombie Process?

Finished process whose entry still exists.

---

### CPU Bound vs I/O Bound?

CPU Bound uses CPU more.

I/O Bound waits for I/O more.

---

# ⚠ Common Mistakes

Process ≠ Program

PCB ≠ Process

Zombie ≠ Running Process

CPU Bound ≠ I/O Bound

---

# ⚡ Quick Revision

* Process = Program in execution
* Program = Passive
* Process = Active
* PCB = Process data
* New → Ready → Running → Waiting → Terminated
* Stack = Function calls
* Heap = Dynamic memory
* CPU Bound = More CPU
* I/O Bound = More waiting
* Zombie = Finished but not cleaned

---

# 🧠 Memory Trick

```text
Program = Recipe
Process = Cooking
PCB = Order Slip
CPU = Chef
```

Easy to remember.

---

# 🎯 Career Takeaway

This chapter is one of the most important in OS.

Master:

✅ Process
✅ Process States
✅ PCB
✅ Program vs Process
✅ Process Memory Layout
✅ Zombie Process
✅ CPU Bound vs I/O Bound

These are heavily asked in:

* OS interviews
* backend interviews
* Linux interviews
* DevOps interviews
* system design discussions

---

# 📈 Progress

* [x] Day 01 - Introduction to OS
* [x] Day 02 - Process
* [ ] Day 03 - Threads

Next Topic: **Threads**
