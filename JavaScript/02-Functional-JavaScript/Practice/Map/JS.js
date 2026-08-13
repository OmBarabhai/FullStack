const nums = [1,2,3,4];
const double =  nums.map(num => num * 2);
console.log(double);

const nums1 = [5,,15];
const addFive = nums1.map(num => num + 5);
console.log(addFive)

const conStr= nums.map(num=>String(num));
console.log(conStr);

const sq = nums.map(num => num * num);
console.log(sq);


const users = [
    { name: "Om", age: 22 },
    { name: "Raj", age: 25 },
    { name: "Amit", age: 21 }
];

const res = users.map(({name}) => name);
console.log(res);

const products = [
    { name: "Laptop", price: 70000 },
    { name: "Mouse", price: 1000 },
    { name: "Keyboard", price: 2000 }
];

const prices = products.map(({price}) => price)
console.log(prices);

const matrix = [
    [1, 2],
    [3, 4]
];

const nest = matrix.map(arr => arr.map(num => num * 10));
console.log(nest);


const isProductsActive = [
    { name: "Laptop", price: 70000, inStock: true },
    { name: "Mouse", price: 1000, inStock: false },
    { name: "Phone", price: 30000, inStock: true }
];

const checkInStockAvail = isProductsActive.filter(({inStock}) => inStock).map(({name}) => name);
console.log(checkInStockAvail);

function myMap(arr,callBack){ // myMap(arr, callback)
    const res = []; // create result[]
    for(let i = 0;i < arr.length; i++){ // visit elements
        res.push( //push into result
            callBack(arr[i], // take returned value
            i,
            arr)
        );// callback(element, index, arr)
    }
    return res; // return result
}

/*

  callback
     ↓
  produces one value

  myMap
     ↓
  collects those values

*/
const ans = myMap(
                nums,
                num => num * 2
            );
console.log(ans);
//
//function myMap_2(arr, callBack){
//    const res = [];
//    for(let i = 0;i < arr.length; i++){
//        res.push(
//            arr[i],
//            i,
//            arr
//        )
//    }
//    return res;
//}
//
//
//const ans_2 = myMap_2(
//                nums,
//                num => num * 2
//            );
//console.log(ans_2);



