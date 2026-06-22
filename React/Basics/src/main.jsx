import React from "react";
import ReactDOM from "react-dom/client";
// import App from "./App.jsx";
// import Counter from "./components/Counter.jsx"
// import { BrowserRouter, Routes, Route } from "react-router-dom";
// import Home from "./pages/Home";
// import Products from "./pages/Products";
import App from "./App";
import "./index.css";
ReactDOM.createRoot(document.getElementById("root")).render(
  
  <React.StrictMode>
    <App></App>
    {/* <BrowserRouter>
      <Routes>
      <Route path="/" element={<Home />}></Route>

        <Route path="/products" element={<Products />}></Route>
      <Route path="/products/:category" element={<Products />}></Route> 
      <Route path="/products/laptop" element={<Products />}></Route>
       <Route path="/products/tvs" element={<Products />}></Route>
        
      </Routes>
      </BrowserRouter> */}
    </React.StrictMode>
  
);
