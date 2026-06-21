// import Counter from "./components/Counter.jsx";
// import User from "./components/User.jsx";
// import { useState } from "react";

// function App() {
//     const [user, setUser] = useState({
//     name: "",
//     email: "",
//   });

//   function submit() {
//   alert(`Name:${user.name}; \nEmail:${user.email}`);
// }
//   return (

//     <>
//       <h1>Counter</h1>
//       <Counter initialValue={90} />
//       <br/>
//       <User />
//       <br />
//       <h1>User </h1>
//       <input
//         type="text"
//         placeholder="Enter Your Name"
//         value={user.name}
//         onChange={(event) =>
//           setUser({ ...user, name: event.target.value })
//         }
//       />
//       <input
//         type="email"
//         placeholder="Enter Your Email"
//         value={user.email}
//         onChange={(event) =>
//           setUser({ ...user, email: event.target.value })
//         }
//       />
//       <button onClick={submit}>Submit</button>
//     </>
//   );
// }
// export default App;
import { Link } from "react-router-dom";
function App() {
  return (
    <>
      <h1>
        Hello, Welcome To Home
        <br />
        <br />
        <Link to={"/products"} className="underline  text-blue-480">
          Go To Products
        </Link>
        {/* <Link to={"/products/mobile"} className="underline  text-blue-480">
          Go To mobile
        </Link>
        <Link to={"/products/laptop"} className="underline  text-blue-480">
          Go To laptop
        </Link>
        <Link to={"/products/tvs"} className="underline  text-blue-480">
          Go To tvs */}
        {/* </Link> */}
      </h1>
    </>
  );
}
export default App;
