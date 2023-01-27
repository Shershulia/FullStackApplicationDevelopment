var int =0
const tags = ["#business","#entrepreneur","#motivation",
    "#marketing","#success","#money",
    "#mindset","#inspiration",
    "#startup","#Mavrodi"]
function increase(){

    let number = document.getElementById("number-clicks");
    int++;
    if(int >=100){
        alert("Don`t be so greedy")
        int = 0;
    }
    number.textContent=int;

}
function showmessage(){
    let opacity = document.getElementById("hidenmassage");
    if (opacity.style.opacity==='0'){
        opacity.style.opacity='1';
    }else opacity.style.opacity='0';
}
window.addEventListener("load",showRandomTags(tags));
function showRandomTags(params){
    document.getElementById("firstTag").textContent=params[Math.floor(Math.random() * 10)];
    document.getElementById("secondTag").textContent=params[Math.floor(Math.random() * 10)];
    document.getElementById("thirdTag").textContent=params[Math.floor(Math.random() * 10)];

}

