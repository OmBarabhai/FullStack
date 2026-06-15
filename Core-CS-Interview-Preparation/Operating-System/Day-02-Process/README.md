# 🚀 Day 02 - Process

> Permanent OS Notes for Interviews, Revision, and Career Use

---

# 📌 What is a Process?

A Process is a program in execution.

When a program is loaded into memory and starts running, it becomes a process. A process contains program code, current execution state, memory, and system resources.

### Interview Answer

A process is an active instance of a program that is currently being executed by the CPU.

### One-Liner

Program + Execution = Process

---

# 📌 Why does it matter?

The Operating System executes processes, not programs.

Without processes:

* Programs cannot run
* CPU scheduling is impossible
* Memory allocation cannot be managed
* Resource sharing becomes difficult

---

# 📌 Core Idea

```text
Program (Disk)
      ↓ Execute
Process (Memory)
      ↓
CPU + Memory + Resources
```

### Real Example

```text
chrome.exe
      ↓ Open
Chrome Process
      ↓
CPU + RAM + Files
```

Program is passive.

Process is active.

---

# 📌 Process States

A process moves through different states during its lifecycle.

## Process State Diagram

```text
        New
         ↓
       Ready
         ↓
      Running
      ↙     ↘
Waiting     Ready
   ↓
 Ready
   ↓
Running
   ↓
Terminated
```

---

## 1. New

Process has just been created.

Example:
Opening Chrome.

---

## 2. Ready

Process is ready to execute but waiting for CPU.

Example:
Chrome is loaded in memory and waiting for CPU time.

---

## 3. Running

CPU is executing the process.

Example:
You are actively browsing a website.

---

## 4. Waiting / Blocked

Process is waiting for I/O or some event.

Example:
Chrome waiting for internet data.

---

## 5. Terminated

Process execution has completed.

Example:
You closed Chrome.

---

# 📌 Process Control Block (PCB)

PCB is a data structure maintained by the Operating System to store all information related to a process. Every process has its own PCB.

### Interview Answer

PCB is a data structure used by the OS to manage and track a process.

---

## PCB Structure

```text
PCB
│
├── Process ID (PID)
├── Process State
├── Program Counter
├── CPU Registers
├── Scheduling Information
├── Memory Information
├── I/O Information
└── Accounting Information
```

### Easy Memory Trick

```text
PID
State
PC
Registers
Memory
Scheduling
I/O
```

---

## Why PCB is Important?

Without PCB:

* OS cannot manage processes
* Context switching cannot happen
* Scheduling becomes impossible

### One-Liner

PCB is the identity card of a process.

---

# 📌 Process Memory Layout

Every process generally contains four sections.

```text
Code (Text)
      ↓
Data
      ↓
Heap
      ↓
Stack
```

## Code Section

Stores program instructions.

---

## Data Section

Stores global and static variables.

---

## Heap

Stores dynamically allocated memory.

Examples:

* malloc()
* calloc()
* realloc()

---

## Stack

Stores:

* Local variables
* Function calls
* Return addresses

### Interview Question

What are the sections of a process?

Answer:
Code, Data, Heap, and Stack.

---

# 📌 Program vs Process

| Feature        | Program | Process   |
| -------------- | ------- | --------- |
| Nature         | Passive | Active    |
| Stored In      | Disk    | Memory    |
| Resource Usage | No      | Yes       |
| Lifetime       | Longer  | Temporary |
| Type           | Static  | Dynamic   |

### Example

```text
VSCode.exe
      ↓ Open
VS Code Process
```

### One-Liner

Program is passive; Process is active.

---

# 📌 Types of Processes

## CPU Bound Process

Spends most of its time using CPU.

### Examples

* Video Rendering
* Matrix Calculations
* AI Training

### Interview Point

Needs more CPU power than I/O.

---

## I/O Bound Process

Spends most of its time waiting for I/O operations.

### Examples

* File Reading
* Database Queries
* Network Requests

### Interview Point

Needs more I/O than CPU.

---

# 📌 Multiprogramming

Multiple programs stay in memory simultaneously.

When one process waits for I/O, CPU executes another process.

```text
Process A Waiting
        ↓
CPU Switches
        ↓
Process B Runs
```

### Goal

Increase CPU utilization.

---

# 📌 Multitasking

CPU rapidly switches between multiple tasks.

```text
Chrome
   ↓
VS Code
   ↓
Spotify
   ↓
CPU Switching
```

### Goal

Improve responsiveness.

---

# 📌 Multiprocessing

System contains multiple CPUs.

```text
CPU 1 → Chrome
CPU 2 → VS Code
```

### Goal

Improve performance and throughput.

---

# 📌 Message Passing System

Message Passing allows processes to communicate without sharing the same address space.

### Flow

```text
Process A
    ↓ Message
Operating System
    ↓ Message
Process B
```

### Interview Answer

Message Passing is an IPC mechanism where processes exchange messages through the OS. It allows communication without shared memory.

---

# 📌 Zombie Process

A Zombie Process is a process that has finished execution but still has an entry in the process table because the parent process has not collected its exit status.

### Flow

```text
Process Finishes
        ↓
Terminated
        ↓
Entry Still Exists
        ↓
Zombie Process
```

### One-Liner

Zombie = Dead process with a living entry.

---

# 📌 Modern Operating Systems

### Interview Question

Modern Operating Systems are?

### Answer

Interrupt Driven Operating Systems.

### Why?

CPU responds whenever an interrupt occurs instead of continuously checking devices.

---

# 📌 Thread File Sharing

### Interview Question

If one thread opens a file with read permission, can another thread read it?

### Answer

Yes.

Threads in the same process share resources, so other threads in that process can access the file.

---

# 📌 Comparison

## Multiprogramming vs Multitasking vs Multiprocessing

| Feature   | Multiprogramming | Multitasking        | Multiprocessing    |
| --------- | ---------------- | ------------------- | ------------------ |
| CPU       | Single           | Single              | Multiple           |
| Goal      | CPU Utilization  | User Responsiveness | Performance        |
| Switching | On Waiting       | Frequent            | Parallel Execution |

### One-Liner

Multiprogramming keeps CPU busy, multitasking improves responsiveness, and multiprocessing improves performance.

---

# 🎯 Most Asked Interview Questions

### Q1. What is a Process?

A process is a program in execution.

---

### Q2. What are the states of a process?

New, Ready, Running, Waiting, and Terminated.

---

### Q3. What is PCB?

PCB is a data structure used by the OS to store process information.

---

### Q4. Why is PCB required?

PCB helps the OS manage, schedule, and switch processes.

---

### Q5. What is the difference between Program and Process?

Program is passive; Process is active.

---

### Q6. What is Zombie Process?

A terminated process whose entry still exists in the process table.

---

### Q7. What are CPU Bound and I/O Bound processes?

CPU Bound spends more time using CPU, while I/O Bound spends more time waiting for I/O.

---

### Q8. What is Message Passing?

An IPC mechanism where processes communicate through messages.

---

# ⚡ Quick Revision

* Process = Program in execution
* Program = Passive
* Process = Active
* PCB = Process information
* New → Ready → Running → Waiting → Terminated
* Stack = Local variables
* Heap = Dynamic memory
* CPU Bound = More CPU
* I/O Bound = More I/O
* Multiprogramming = CPU utilization
* Multitasking = Responsiveness
* Multiprocessing = Multiple CPUs
* Zombie = Dead process with PCB entry

---

# 🎤 Interview One-Liners

### What is a Process?

A running program.

### What is PCB?

Identity card of a process.

### What is Zombie Process?

A terminated process whose entry still exists.

### What is Message Passing?

Communication between processes without shared memory.

### What is CPU Bound Process?

Process that spends most time using CPU.

### What is I/O Bound Process?

Process that spends most time waiting for I/O.

---

# 📌 Practical / Industry Notes

Every application creates processes:

* Chrome
* VS Code
* Docker
* Spotify

Operating systems manage thousands of processes using PCBs, scheduling algorithms, and process states.

---

# 🎯 Career Takeaway

Master these topics:

✅ Process

✅ Process States

✅ PCB

✅ Program vs Process

✅ CPU Bound vs I/O Bound

✅ Message Passing

✅ Zombie Process

✅ Multiprogramming vs Multitasking vs Multiprocessing

These concepts are heavily used in Threads, Scheduling, Synchronization, Deadlocks, and System Design discussions.
