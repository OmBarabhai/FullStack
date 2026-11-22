import { useState } from "react";
function Login() {
  const [userData, setUser] = useState({
    uname: "",
    lpassword: "",
  });
  const onSubmitlogin = (e) => {
    e.preventDefault();
    console.log(userData);
  };
  return (
    <div className="flex justify-center items-center h-screen bg-gray-100">
      <form
        onSubmit={onSubmitlogin}
        className="bg-white p-6 rounded-lg shadow-md w-80 space-y-4"
      >
        <h1 className="text-2xl font-bold text-center">User Login</h1>
        <div>
          <label htmlFor="uname" className="block mb-1 font-medium">
            User Name:
          </label>
          <input
            type="text"
            id="uname"
            name="uname"
            value={userData.uname}
            onChange={(e) =>
              setUser({ ...userData, uname: e.target.value })
            }
            className="w-full border border-gray-400 p-2 rounded"
          />
        </div>
        <div>
          <label htmlFor="lpassword" className="block mb-1 font-medium">
            Password:
          </label>
          <input
            type="password"
            id="lpassword"
            name="lpassword"
            value={userData.lpassword}
            onChange={(e) =>
              setUser({ ...userData, lpassword: e.target.value })
            }
            className="w-full border border-gray-400 p-2 rounded"
          />
        </div>
        <button className="w-full bg-blue-500 text-white py-2 rounded hover:bg-blue-600"> Submit</button>
      </form>
    </div>
  );
}
export default Login;