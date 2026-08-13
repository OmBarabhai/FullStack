function myFilter(arr,callBack){
    const res = [];
    for(let i = 0; i < arr.length; i++){
        if(callBack(arr[i],i,arr)){
             res.push(arr[i]);
        }
    }
    return res;
}
const num = [1,2,3,4]
const ans = myFilter(num, num => (num & 1) === 0);
console.log(ans);


const result = [10, 20, 30].find(
    (value, index) => {
        console.log(index, value);
        return value > 15;
    }
);

console.log("Result:", result);