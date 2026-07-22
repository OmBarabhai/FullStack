
export function Products({products}) {
  const { id, name, price, specification, warranty } = products;
  return (
    <>
      <h1 style={{ backgroundColor: "skyblue", textAlign: "center" }}>
        {name}
      </h1>
      <div style={{ backgroundColor: "lightgrey", textAlign: "center" }}>
        <p>ID: {id}</p>
        <p>Price: INR {price}</p>
        <p>Specification: {specification} </p>
        <p>Warranty: {warranty}</p>
      </div>
    </>
  );
}
