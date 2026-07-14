import { useEffect,useRef, useState } from "react";

function Counter() {
  const [count, setCount] = useState(10);
  function increament() {
    setCount((count) => count + 1);
  }
  function decreament() {
    setCount((count) => count - 1);
  }
  useEffect(() => {
    // alert("Hello OM Here");
  }, [count]);
  const inRef = useRef(null);
  return (
    <>
      <button onClick={increament}>+</button>
      {count}
      <button onClick={decreament}>-</button>
      <br />
      <input type="UserFocus" ref={inRef} />
      <button onClick={() => inRef.current.focus()}>Focus</button>
    </>
  );
}
export default Counter;