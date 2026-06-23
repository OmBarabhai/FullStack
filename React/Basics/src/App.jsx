// import { useState } from "react";

// function App() {
//   const [userData, setUserData] = useState({
//     fname: "",
//     email: "",
//     phone: "",
//   });
//   const onSubmit = (e) => {
//     e.preventDefault();
//     console.log(userData);
// }
//   return (
//     <div>
//       <form action="" onSubmit={onSubmit}>
//         <div>
//           <label htmlFor="fname">Name: </label>
//           <input
//             type="text"
//             name="fname"
//             id="fname"
//             value={userData.fname}
//             onChange={(e) => {
//               setUserData({ ...userData, fname: e.target.value });
//             }}
//           />
//         </div>
//         <div>
//           <label htmlFor="email">Email: </label>
//           <input
//             type="email"
//             name="email"
//             id="email"
//             value={userData.email}
//             onChange={(e) => {
//               setUserData({ ...userData, email: e.target.value });
//             }}
//           />
//         </div>
//         <div>
//           <label htmlFor="phone">Phone: </label>
//           <input
//             type="tel"
//             name="phone"
//             id="phone"
//             value={userData.phone}
//             onChange={(e) => {
//               setUserData({ ...userData, phone: e.target.value });
//             }}
//           />
//         </div>
//         <div>
//           <button className="border border-black px-5 py-2">submit</button>
//         </div>
//       </form>
//     </div>
//   );
// }
// export default App;

// import Login from "./pages/Login";
// import CreateUserId from "./pages/CreateUserId";
// import { useEffect, useState } from "react";
import {
  QueryClient,
  QueryClientProvider,
  useQuery,
} from "@tanstack/react-query";
const queryClient = new QueryClient();

import axios from "axios";

function Quote() {
  async function fetchQuote() {
    try {
      const res = await axios({
        method: "GET",
        url: "https://dummyjson.com/quotes/random",
      });
      const quotes = res.data.quote;
      const author = res.data.author;

      return quotes +" - "+author;
    } catch (err) {
      console.log(err);
    }
  }
  const { data, status } = useQuery({
    queryKey: ["quote"],
    queryFn: fetchQuote,
  });
  console.log(data, status);

  if (status === "error") return <p>Error</p>;
  if (status === "pending") return <p>pending</p>;

  return <p>{data}</p>;
}

function App() {
  return (
    <div className="py-5 text-center">
      <QueryClientProvider client={queryClient}>
        <Quote />
      </QueryClientProvider>
    </div>
  );
}
export default App;
