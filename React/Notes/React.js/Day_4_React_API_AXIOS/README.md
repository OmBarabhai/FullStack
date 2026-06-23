# ⚛️ Day 4 - React API, Axios & React Query

> Goal: Understand API communication, Axios fetching, and React Query state management.

---

# Topics Covered

```text
1. API Basics
2. Fetch vs Axios
3. Axios GET Request
4. useEffect + useState
5. React Query
6. QueryClient
7. QueryClientProvider
8. useQuery
9. queryKey
10. queryFn
11. Loading & Error Handling
12. Caching
13. Auto Refetch
```

---

# 1. What is API?

API = Application Programming Interface

Used for communication between frontend and backend.

Flow:

```text
React App
   ↓ Request
Server
   ↓ Response
React UI Updates
```

Think:

```text
API = Messenger between frontend and backend
```

---

# API Flow Diagram

![API Flow](./Images/API.png)

---

# 2. Fetch vs Axios

Both fetch data from API.

---

## Fetch

```js
const res = await fetch(url);
const data = await res.json();
```

Problems:

❌ Manual JSON parsing
❌ More code
❌ Less clean

---

## Axios

```js
const res = await axios(url);
console.log(res.data);
```

Benefits:

✅ Auto JSON parsing
✅ Cleaner
✅ Better error handling
✅ Easier syntax

Think:

```text
Axios = Better fetch
```

---

# Axios Flow

```text
App
 ↓
Axios
 ↓
API
 ↓
Response
 ↓
State update
```

---

# 3. Axios Project (Old Way)

Code:

```jsx
const [quote, setQuote] = useState("");
const [author, setAuthor] = useState("");

async function getQuote() {
  const res = await axios("https://dummyjson.com/quotes/random");

  setQuote(res.data.quote);
  setAuthor(res.data.author);
}
```

---

# Why useEffect?

```jsx
useEffect(() => {
  getQuote();
}, []);
```

Purpose:

```text
Runs API call on first render
```

Flow:

```text
Render
 ↓
useEffect
 ↓
API call
 ↓
State update
 ↓
Re-render
```

---

# Project Output (Axios)

![Project Output](./Images/Project.png)

---

# Problem with Axios + useEffect

Manual work:

❌ Manage loading
❌ Manage error
❌ Manage caching
❌ Refetch manually
❌ Duplicate requests

This is where React Query comes.

---

# 4. What is React Query?

React Query manages server data.

Handles:

```text
Lifecycle
States
Caching
Auto-refetch
Real-time sync
```

Think:

```text
Axios fetches data

React Query manages data
```

---

# React Query Diagram

![React Query](./Images/Qproject.png)

---

# Full Query Architecture

![Query Flow](./Images/Query.png)

---

# 5. Installing React Query

```bash
npm install @tanstack/react-query
```

---

# 6. QueryClient

Creates cache manager.

```jsx
const queryClient = new QueryClient();
```

Purpose:

```text
Stores and manages API cache
```

---

# 7. QueryClientProvider

Wraps app.

```jsx
<QueryClientProvider client={queryClient}>
   <Quote />
</QueryClientProvider>
```

Purpose:

```text
Provides query system globally
```

---

# 8. useQuery

Main hook.

```jsx
const { data, status } = useQuery({
  queryKey: ["quote"],
  queryFn: fetchQuote,
});
```

Purpose:

✅ API call
✅ Loading state
✅ Error state
✅ Cache data
✅ Auto refetch

---

# 9. queryKey

Unique cache id.

```jsx
queryKey: ["quote"]
```

Think:

```text
queryKey = unique storage key
```

---

# 10. queryFn

Actual function to fetch data.

Code:

```jsx
async function fetchQuote() {
  const res = await axios({
    method: "GET",
    url: "https://dummyjson.com/quotes/random",
  });

  return res.data.quote + " - " + res.data.author;
}
```

Flow:

```text
queryFn
 ↓
Axios
 ↓
API
 ↓
Return data
```

---

# 11. Status Handling

React Query gives:

```text
pending
success
error
```

Code:

```jsx
if (status === "error") return <p>Error</p>;
if (status === "pending") return <p>Pending</p>;
```

---

# Axios vs React Query

| Axios          | React Query  |
| -------------- | ------------ |
| Fetches data   | Manages data |
| Manual loading | Automatic    |
| Manual error   | Automatic    |
| No caching     | Caching      |
| No refetch     | Auto refetch |

Think:

```text
Axios = Engine

React Query = Driver
```

---

# Final Project (React Query)

Features:

✅ Random quote fetch
✅ Author fetch
✅ Loading state
✅ Error state
✅ Caching
✅ Auto refetch
✅ Cleaner than useEffect

---

# Full Flow

```text
App
 ↓
Provider
 ↓
useQuery
 ↓
queryFn
 ↓
axios
 ↓
API
 ↓
cache
 ↓
UI render
```

---

# Interview Questions

## What is API?

Communication layer between frontend and backend.

---

## What is Axios?

Library for making API requests.

---

## Difference between fetch and axios?

```text
Fetch → manual JSON

Axios → auto JSON
```

---

## What is React Query?

Library for fetching and managing server state.

---

## What is QueryClient?

Manages cache and queries.

---

## What is queryKey?

Unique identifier for caching.

---

## What is queryFn?

Function used for API call.

---

# Quick Revision

```text
API = communication

Fetch = manual API call

Axios = cleaner API call

useEffect = trigger API

useState = store API data

React Query = manage server data

QueryClient = cache manager

Provider = global access

useQuery = API + cache + loading + error

queryKey = cache ID

queryFn = fetch function
```

---

# What You Finished Today

✅ API Basics
✅ Fetch
✅ Axios
✅ useEffect
✅ useState
✅ React Query
✅ QueryClient
✅ QueryClientProvider
✅ useQuery
✅ queryKey
✅ queryFn
✅ Loading State
✅ Error State
✅ Caching
✅ Auto Refetch

Next:

```text
Mutations
POST API
DELETE API
PUT API
Pagination
Infinite Scroll
Optimistic Updates
```

Folder:

```text
Day_4_React_API_AXIOS/
└── Images/
    ├── API.png
    ├── Project.png
    ├── Qproject.png
    └── Query.png
```
