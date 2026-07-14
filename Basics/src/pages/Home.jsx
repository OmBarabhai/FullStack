// import App from "../App";
import { Link } from "react-router-dom";
function Home() {
  return (
    <>
      <h1>Hello, Welcome Home</h1>
      
    <Link to={"/products"} className="underline  text-blue-480" >Go To Product</Link>
    </>    
  );
}
export default Home;