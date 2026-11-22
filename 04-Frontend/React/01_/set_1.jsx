//app.js
import "./styles.css";
import Sum from "./SumCard";
import { EmployeeCard as Employee } from "./EmployeeCard";
import ProdcutCart from "./ProductCart";
import Button from "./Button";
import Stationery from "./Stationery";
const product = {
  id: "AC1023",
  name: "Air Conditioner",
  price: 29600,
  specification: "1 Ton, 4 Star Rating",
  warranty: "5 Years Compressor Warranty",
};
const backgroundColor = "lightgreen";
const color = "darkgreen";
const borderRadius = "5px";
const padding = "10px";
const items = ["pen", "pencil", "ruler", "eraser"];
export default function App() {
  return (
    <>
      <Sum a={10} b={93} />
      <Employee firstName={"Om"} lastName={"Barabhai"} />
      <ProdcutCart items={product} />
      <Button
        backgroundColor={backgroundColor}
        color={color}
        borderRadius={borderRadius}
        padding={padding}
      />
      <Stationery heading="Stationery Items" items={items} />
    </>
  );
}

//EmployeeCard
export function EmployeeCard({ firstName, lastName }) {
  return (
    <>
      <div style={{ backgroundColor: "#32174D", padding: "70px 50px 60px" }}>
        <h1 style={{ color: "#50C878" }}>
          {firstName} {lastName}
        </h1>
        <p>
          <span style={{ color: "green" }}>Designation</span> SDE
        </p>
        <p>
          <span style={{ color: "blue" }}>Experience </span>: 0
        </p>
      </div>
    </>
  );
}

//index
import { StrictMode } from "react";
import { createRoot } from "react-dom/client";

import App from "./App";

const rootElement = document.getElementById("root");
const root = createRoot(rootElement);

root.render(
  <StrictMode>
    <App />
  </StrictMode>
);
// ProdcutCartconst
 ProductCart = ({ items }) => {
  const { name, price, specification, warranty } = items;

  return (
    <>
      <h1>{name}</h1>
      <p>{price}</p>
      <p>{specification}</p>
      <p>{warranty}</p>
    </>
  );
};
export default ProductCart;

//SumCard
const SumCard = ({ a, b }) => {
  return (
    <div style={{ backgroundColor: "#6082B6", padding: "30px 30px 30px 90px" }}>
      <h1 style={{ color: "#915F6D" }}>Sum Of two Number</h1>
      <p style={{ fontSize: "20px", color: "#349920" }}>num1 : {a}</p>
      <p style={{ fontSize: "20px", color: "#521020" }}>num2 : {b}</p>
      <p style={{ fontSize: "20px", color: "#592720" }}>sum : {a + b}</p>
    </div>
  );
};
export default SumCard;

// Button
export default function Button({
  backgroundColor,
  color,
  borderRadius,
  padding,
}) {
  return (
    <button
      style={{
        backgroundColor: backgroundColor,
        color: color,
        borderRadius: borderRadius,
        padding: padding,
      }}
    >
      start
    </button>
  );
}
// Stationery
export default function Stationery({ heading, items }) {
  return (
    <div>
      <h2>{heading}</h2>
      <ul>
        <ol>
          {items.map((item, index) => (
            <li key={index}> {item}</li>
          ))}
        </ol>
      </ul>
    </div>
  );
}
