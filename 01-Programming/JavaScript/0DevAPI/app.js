console.log("DevAPI Started");

const req1 = {
       id: 20,
       method:"GET",
       url :"http",
       status : 404,
       resTime: 120
}
const req2 = {
       id: 21,
       method:"POST",
       url :"http",
       status : 200,
       resTime: 60
}
const req3 = {
        id: 22,
        method:"PUT",
        url :"http",
        status : 400,
        resTime: 200
}
const req4 = {
         id: 23,
         method:"DELETE",
         url :"https",
         status : 404,
         resTime: 90
}

const req = [req1,req2,req3,req4];
const res = req.map(({id,method,resTime}) =>{ return {id,method,resTime}; }).filter(({id}) => id >= 22);
console.log(res);

const findReq = req.find(({id}) => id == 22);
console.log(findReq);

const findReqIdx = req.findIndex(({id}) => id === 22);
console.log(findReqIdx);

const isAnyReqFailed = req.some(({status}) => status >= 400);
console.log(isAnyReqFailed);

const areAllReqSuccess = req.every(({status}) => status < 400)
console.log(areAllReqSuccess);

const totResTime = req.map(({resTime}) => resTime ).reduce((acc, currResTime) => currResTime + acc, 0);
console.log(totResTime);

const sortAcending = req.map(({resTime}) => resTime).sort((A,B) => B - A);
console.log(sortAcending);

const sortDecending = req.map(({resTime}) => resTime).sort((A,B) => A - B);
console.log(sortDecending);


const sortAcendingSpread = [...req].sort((A,B) => B.resTime - A.resTime);
console.log(sortAcendingSpread);

const sortDecendingSpread = [...req].sort((A,B) => A.resTime - B.resTime);
console.log(sortDecendingSpread);
