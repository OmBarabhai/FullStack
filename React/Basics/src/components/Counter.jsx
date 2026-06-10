function Counter() {   
  let count = 0;
  function increament() {
    count++;
    alert(count);
  }
  function decreament() {
    count--;
    alert(count);

  }
  return (
    <>
      <button onClick={increament}>+</button>
      {count}
      <button onClick={decreament}>-</button>
    </>
  )
}

export default Counter
