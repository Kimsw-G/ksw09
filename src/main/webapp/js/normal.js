
var ctntElm = document.getElementById("ctnt")

function insertNormal(){
    ctntElm.value;
    var param = {
        ctnt : ctntElm.value
    }
    console.log(param.ctnt);
    const init = {
        method:'POST',
        headers:{
            'Content-Type':'application/json'
        },
        body: JSON.stringify(param)
    }
    fetch('/todo/normal',init)
    .then(res=>res.json())
    .then(mj=>{

    }); // 보내기
}
