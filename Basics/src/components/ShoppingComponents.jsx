import { useState, useEffect } from "react";

export default function ShoppingComponents() {
  const [categories, setCategories] = useState([]);
  function LoadCategories() {
    fetch("https://fakestoreapi.com/products/categories")
      .then((res) => res.json())
      .then((data) => {
        data.unshift("All");
        setCategories(data);
      });
  }

  useEffect(() => {
    LoadCategories();
  }, []);

  return (
    <div>
      <header>
        <h1 className="bg-blue-300 text-amber-1 text-center">
          <span className="bi bi-cart"></span>Shopping Home
        </h1>
      </header>
      <section className="row">
        <nav className="col-3">
          <label>Select Category</label>
          <div>
            <select name="" id="" className="form-select">
              {categories.map((Category) => (
                <option key={Category}>{Category}</option>
              ))}
            </select>
          </div>
        </nav>
        <main className="col-9"></main>
      </section>
    </div>
  );
}
