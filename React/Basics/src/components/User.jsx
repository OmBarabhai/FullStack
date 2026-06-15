import { useState } from "react";


function User() {

  function submit() {
    alert(`name: ${user.name} \nemail: ${user.email}`);
}

  const [user, setUser] = useState({
    name: "",
    email: "",
  });

  return (
    <>
      <input
        type="text"
        value={user.name}
        onChange={(ev) =>
          setUser({
            ...user,
            name: ev.target.value,
          })
        }
      />
      <input
        type="email"
        value={user.email}
        onChange={(ev) =>
          setUser({
            ...user,
            email: ev.target.value,
          })
        }
      />

      <button onClick={submit}>Submit</button>
    </>
  );
}
export default User;
