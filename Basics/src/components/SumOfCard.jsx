// const first = 4;
// const Second = 5;

export function SumOfCard({first,second}) {
  console.log(first,second);
  return (
    <div>

    <h1 style={{ color: "cornsilk", backgroundColor: "lightcoral" ,textAlign:"center"}}>
        Sum Of Two Numbers
      </h1>
      
      <div style={{backgroundColor:"lightseagreen",textAlign:"center"}}>
        <p style={{ fontSize: "39px" }}>First Number: {first}</p>
        <p style={{ fontSize: 25 }}>Second Number: {second}</p>
        <p style={{ fontSize: 20 }}>Sum: {first+second}</p>
      </div>
    </div>
  );
}
