import Counter from "./components/Counter.jsx";

function App() {
  
  return (
  <>
    <h1>Counter</h1>
      <Counter initialValue={90} />
      <br/>
      <br/>
      <Counter initialValue={100} />
      <br/>
      <br/>
      <Counter initialValue= { 110 } />
    </>
  )
}
export default App;