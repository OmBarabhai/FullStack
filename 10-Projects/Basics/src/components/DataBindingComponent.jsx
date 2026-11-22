import { useEffect, useState } from "react";

export default function DataBindingComponent() {
  const [mars, setMars] = useState([]);
  // useEffect(() => {
  //   fetch(
  //     "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=DEMO_KEY",
  //   )
  //     .then((response) => response.json())
  //     .then((data) => {
  //       setMars(data.photos);
  //     });
  // },[]);
  useEffect(() => {
    fetch(
      "https://dummyjson.com/products",
    )
      .then((response) => response.json())
      .then((data) => 
        console.log(data.products))
  }, []);
  return (
    <div className="container">
      <h2>Mars Photos</h2>
      <table className="table table-hover">
        <thead>
          <tr>
            <th>Photo Id</th>
            <th>Camera Name</th>
            <th>Rover Name</th>
            <th>Preview</th>
          </tr>
        </thead>
        <tbody>
          {mars.map((photo) => (
            <tr key={photo.id}>
              <td>{photo.id}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

{
  /* 
      export default function DataBindingComponent() {
      var menu = [
    { Category: "Electronics", Products: ["Samsung TV", "Mobile"] },
    { Category: "Footwear", Products: ["Nike Casuals", "Jordan"] },
  ];
  var username = "John";
  return (
      <div className="container">
    <script>
      // Destructuring Array
      var values = [10,"Apple",true];
      var {id, Gravity, stock} = values;
      // if not have 
      // Destructuring Array
    </script> 


      <h2>User Details</h2>
      User Name: 
      <input type="text" value={username} />
      <br />
      Hello ! John
        
        <h2>Categories</h2>
      <ol>
        {menu.map((item) => (
          <li>
            {item.Category}
            <ul>
              {item.Products.map((product) => (
                <li>{product}</li>
              ))}
            </ul>
          </li>
        ))}
      </ol>

      <select>{
        menu.map(item =>
          <optgroup key={item.Category} label={item.Category}>
            {
              item.Products.map(product =>
                <option key={product}>
                  {product}
                </option>
              )
            }
          </optgroup>)
      }</select> 
        );
    </div>

}
      */
}
