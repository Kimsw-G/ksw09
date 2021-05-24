let pwElm = document.getElementById("pw");
let pwckElm = document.getElementById("pwck");

function tryRegist(){
    if(pwElm.value !== pwckElm.value){
        alert('비밀번호를 확인해주세요');
        return false;
    }else if(pwElm.value.length == 0){
        alert('비밀번호를 작성해주세요');
        return false
    }else if (pwElm.value.length<3){
        alert('비밀번호는 4자 이상이여야합니다');
        return false;
    }
    return true;
}