import { useState } from "react";
function CreateUserId() {
  const [userData, setUser] = useState({
    fname: "",
    lname: "",
    npassword: "",
    cpassword: "",
  });
  const onSubmitCreateUser = (e) => {
    e.preventDefault();

    if (userData.npassword !== userData.cpassword) {
      alert("Password Not Same");
      return;
    }
    console.log(userData);
  };

  return (
    <div className="flex justify-center items-center min-h-screen bg-gray-100">
      <form
        onSubmit={onSubmitCreateUser}
        className="bg-white p-5 rounded-lg shadow-md w-80 space-y-3"
      >
        <h1 className="text-xl font-bold text-center">Create Account</h1>
        <input
          type="text"
          placeholder="First Name"
          value={userData.fname}
          onChange={(e) => setUser({ ...userData, fname: e.target.value })}
          className="w-full border p-2 rounded"
        />
        <input
          type="text"
          placeholder="Last Name"
          value={userData.lname}
          onChange={(e) => setUser({ ...userData, lname: e.target.value })}
          className="w-full border p-2 rounded"
        />
        <input
          type="password"
          placeholder="Password"
          value={userData.npassword}
          onChange={(e) =>
            setUser({ ...userData, npassword: e.target.value })
          }
          className="w-full border p-2 rounded"
        />
        <input
          type="password"
          placeholder="Confirm Password"
          value={userData.cpassword}
          onChange={(e) =>
            setUser({ ...userData, cpassword: e.target.value })
          }
          className="w-full border p-2 rounded"
        />
        <button className="w-full bg-green-500 text-white py-2 rounded">Submit</button>
      </form>
    </div>
  );
}
export default CreateUserId;