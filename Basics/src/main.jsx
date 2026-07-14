import React from "react";
import ReactDOM from "react-dom/client";
// import App from "./App.jsx";
// import Counter from "./components/Counter.jsx"
// import { BrowserRouter, Routes, Route } from "react-router-dom";
// import Home from "./pages/Home";
// import Products from "./pages/Products";
// import App from "./App";
import "./index.css";
import '../node_modules/bootstrap/dist/css/bootstrap.css';
import '../node_modules/bootstrap-icons/font/bootstrap-icons.css';
// import NetflixIndexComponent  from './components/NetflixIndexComponent.jsx' 
// import DataBindingComponent from "./components/DataBindingComponent";
import ShoppingComponents from "./components/ShoppingComponents.jsx";
// import { NetflixRegisterComponent } from "./components/NetflixRegisterComponent";
ReactDOM.createRoot(document.getElementById("root")).render(
  
  <React.StrictMode>
    {/* <App /> */}
    {/* <NetflixIndexComponent/> */}
    {/* <DataBindingComponent/> */}
    <ShoppingComponents/>
    </React.StrictMode>
  
);
