var a = document.querySelector('#btn')
a.addEventListener ('click',clickar)
var div_msg = document.querySelector('#div-msg')
div_msg.innerHTML = `<p>Preparando a contagem......</p>` 
function clickar(){
    var inicio = document.querySelector('#inicio')
    var fim = document.querySelector('#fim')
    var passo = document.querySelector('#passo')
    var listanumero =[]
    var i = Number(inicio.value)
    var f = Number(fim.value)
    var p = Number(passo.value)

    if(i== 0 || f ==0 || p == 0){
      alert('ERRO esta faltando dados')
    }
     else if(i < f){
      for(var c= i; c <= f ; c+= p){
        listanumero.push(c)
       }

    }
    else{
      for(var c = i; c >=f; c -= p){
        listanumero.push(c)
       
    }
    
  }
  
  div_msg.innerHTML = `${listanumero}`
   


}