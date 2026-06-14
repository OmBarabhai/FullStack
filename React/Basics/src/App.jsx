import Counter from "./components/Counter.jsx";
import { useState } from "react";
function App() {
    const [user, setUser] = useState({
    name: "",
    email: "",
  });


  function submit() {
  alert(`Name:${user.name}; \nEmail:${user.email}`);
}
  return (

    <>
      <h1>Counter</h1>
      <Counter initialValue={90} />
      <br/>
      
      <h1>User </h1>
      <input
        type="text"
        placeholder="Enter Your Name"
        value={user.name}
        onChange={(event) => 
          setUser({ ...user, name: event.target.value })
        }
      />
      <input
        type="email"
        placeholder="Enter Your Email"
        value={user.email}
        onChange={(event) => 
          setUser({ ...user, email: event.target.value })
        }
      />
      <button onClick={submit}>Submit</button>
    </>
  );
}
export default App;
