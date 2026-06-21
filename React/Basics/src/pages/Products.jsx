import { Link, useParams } from "react-router-dom";
function Products() {
  const params = useParams();
  console.log(params);

  return (
    <>
      <h1>
        Hello, Welcome To Products
        {params.category && ` - ${params.category}`}
        <p>
          <Link to="/">Go To Home</Link>
        </p>
        <br />
      </h1>

      {/* <Link to="/products/mobile">Mobile</Link>
      <br />

      <Link to="/products/laptop">Laptop</Link>
      <br />

      <Link to="/products/tvs">TVs</Link> */}
    </>
  );
}

export default Products;
